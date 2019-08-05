const puppeteer = require('puppeteer');

//爬取热门电影信息
const url = 'https://movie.douban.com/coming';

module.exports = async () => {
  //1. 打开浏览器
  const browser = await puppeteer.launch({
    args: ['--no-sandbox'],
    // headless: false    //以无头浏览器的形式打开浏览器，没有界面显示，在后台运行的
  });
  //2. 创建tab标签页
  const page = await browser.newPage();
  //3. 跳转到指定网址
  await page.goto(url, {
    waitUntil: 'networkidle2'  //等待网络空闲时，在跳转加载页面
  });
  //4. 等待网址加载完成，开始爬取数据
  //开启延时器，延时2秒钟在开始爬取数据
  await timeout();
  // 一、爬取所有预告片详情页面网址
  let result = await page.evaluate(() => {
    //对加载好的页面进行dom操作
    //所有爬取的数据数组
    let result = [];
    //获取所有即将上映电影
    const $trs = $('.coming_list tbody tr');
    // $($('.coming_list tbody tr')[0]).find('td').last().html()
    for (let i = 0; i < $trs.length; i++) {
      const trDom = $trs[i];
      //获取想看的人数
      let num = parseInt($(trDom).find('td').last().html());
      //判断num的大小
      if (num > 100) {
        //想看人数大于100，电影才较好
        //电影详情页面
        let href = $(trDom).find('a').attr('href');
  
        result.push(href);
      }
      
    }
    
    //将爬取的数据返回出去
    return result;
  })
  
  console.log(result);
  
  //所有电影数据的数组
  let moviesData = [];
  
  //二、爬取主要的电影数据
  //遍历爬取到的数据
  for (let i = 0; i < result.length; i++) {
    //获取电影详情页面的网址
    let url = result[i];
    
    //跳转到电影详情页
    await page.goto(url, {
      waitUntil: 'networkidle2'  //等待网络空闲时，在跳转加载页面
    });
    
    //爬取其他数据
    let itemResult = await page.evaluate(() => {
      //预告片电影的网址
      const href = $('.related-pic-video').attr('href');
      if (!href) {
        return false;
      }
      //标题
      let title =  $('[property="v:itemreviewed"]').html();
      //导演
      let directors =  $('[rel="v:directedBy"]').html();
      //海报图
      let image =  $('[rel="v:image"]').attr('src');
      //豆瓣id
      let doubanId = $('.a_show_login.lnk-sharing').attr('share-id');
      //演员
      let casts =  [];
      let $star = $('[rel="v:starring"]');
      let length = $star.length > 3 ? 3 : $star.length;
      for (var j = 0; j < length; j++) {
        casts.push($star[j].innerText);
      }
      //类型
      let genre = [];
      const $genre = $('[property="v:genre"]');
      
      for (let j = 0; j < $genre.length; j++) {
        genre.push($genre[j].innerText);
      }
      //简介
      const summary = $('[property="v:summary"]').html().replace(/\s+/g, '');
      //上映日期
      const releaseDate = $('[property="v:initialReleaseDate"]')[0].innerText;
      //片长
      const runtime = $('[property="v:runtime"]').html();
      //评分
      const rating = $('[property="v:average"]').html();
      //电影封面图片
      const cover = $('.related-pic-video').css('background-image').split('"')[1].split('?')[0];
      
      
      //给单个对象添加两个属性
      return {
        title,
        directors,
        casts,
        genre,
        image,
        summary,
        releaseDate,
        doubanId,
        runtime,
        rating,
        href,
        cover
      }
      
    })
  
    console.log(itemResult);
    //只有数据是对象时，才添加到数组中
    if (itemResult) {
      moviesData.push(itemResult);
    }
  }
  
  console.log(moviesData);
  
  //三、预告片电影链接
  for (let i = 0; i < moviesData.length; i++) {
    let item = moviesData[i];
    
    let url = item.href;
  
    //跳转到电影详情页
    await page.goto(url, {
      waitUntil: 'networkidle2'  //等待网络空闲时，在跳转加载页面
    });
  
    //爬取其他数据
    item.link = await page.evaluate(() => {
      
      //电影链接
      let link = $('video>source').attr('src')
    
      return link
    
    })
    
  }
  
  console.log(moviesData);
  
  //5. 关闭浏览器
  await browser.close();
  
  //最终会将数据全部返回出去
  return moviesData;
}

function timeout() {
  return new Promise(resolve => setTimeout(resolve, 2000))
}