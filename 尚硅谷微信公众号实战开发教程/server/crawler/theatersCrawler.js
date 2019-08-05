const puppeteer = require('puppeteer');

//爬取热门电影信息
const url = 'https://movie.douban.com/cinema/nowplaying/beijing/';

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
  
  let result = await page.evaluate(() => {
    //对加载好的页面进行dom操作
    //所有爬取的数据数组
    let result = [];
    //获取所有热门电影的li
    const $list = $('#nowplaying>.mod-bd>.lists>.list-item');
    //只取8条数据
    for (let i = 0; i < 8; i++) {
      const liDom = $list[i];
      //电影标题
      let title = $(liDom).data('title');
      //电影评分
      let rating = $(liDom).data('score');
      //电影片长
      let runtime = $(liDom).data('duration');
      //导演
      let directors = $(liDom).data('director');
      //主演
      let casts = $(liDom).data('actors');
      //豆瓣id
      let doubanId = $(liDom).data('subject');
      //电影的详情页网址
      let href = $(liDom).find('.poster>a').attr('href');
      //电影海报图
      let image = $(liDom).find('.poster>a>img').attr('src');
      
      
      result.push({
        title,
        rating,
        runtime,
        directors,
        casts,
        href,
        image,
        doubanId
      })
    }
    
    //将爬取的数据返回出去
    return result;
  })
  
  console.log(result);
  
  //遍历爬取到的8条数据
  for (let i = 0; i < result.length; i++) {
    //获取条目信息
    let item = result[i];
    //获取电影详情页面的网址
    let url = item.href;
    
    //跳转到电影详情页
    await page.goto(url, {
      waitUntil: 'networkidle2'  //等待网络空闲时，在跳转加载页面
    });
  
    //爬取其他数据
    let itemResult = await page.evaluate(() => {
      let genre = [];
      //类型
      const $genre = $('[property="v:genre"]');
  
      for (let j = 0; j < $genre.length; j++) {
        genre.push($genre[j].innerText);
      }
      
      //简介
      const summary = $('[property="v:summary"]').html().replace(/\s+/g, '');
      
      //上映日期
      const releaseDate = $('[property="v:initialReleaseDate"]')[0].innerText;
      
      //给单个对象添加两个属性
      return {
        genre,
        summary,
        releaseDate
      }
      
    })
  
    // console.log(itemResult);
    //在最后给当前对象添加三个属性
    //在evaluate函数中没办法读取到服务器中的变量
    item.genre = itemResult.genre;
    item.summary = itemResult.summary;
    item.releaseDate = itemResult.releaseDate;
    
  }
  
  console.log(result);
  
  //5. 关闭浏览器
  await browser.close();
  
  //最终会将数据全部返回出去
  return result;
}

function timeout() {
  return new Promise(resolve => setTimeout(resolve, 2000))
}