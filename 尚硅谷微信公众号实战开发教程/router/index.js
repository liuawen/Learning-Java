//引入express模块
const express = require('express');
//引入sha1模块
const sha1 = require('sha1');
//引入reply模块
const reply = require('../reply');
//引入wechat模块
const Wechat = require('../wechat/wechat');
//引入config模块
const {url} = require('../config');
//引入Theaters
const Theaters = require('../model/Theaters');
const Trailers = require('../model/Trailers');
const Danmus = require('../model/Danmus');
//获取Router
const Router = express.Router;
//创建路由器对象
const router = new Router();

//创建实例对象
const wechatApi = new Wechat();
//搜索页面路由
router.get('/search', async (req, res) => {
  /*
    生成js-sdk使用的签名：
      1. 组合参与签名的四个参数：jsapi_ticket（临时票据）、noncestr（随机字符串）、timestamp（时间戳）、url（当前服务器地址）
      2. 将其进行字典序排序，以'&'拼接在一起
      3. 进行sha1加密，最终生成signature
   */
  //获取随机字符串
  const noncestr = Math.random().toString().split('.')[1];
  //获取时间戳
  const timestamp = Date.now();
  //获取票据
  const {ticket} = await wechatApi.fetchTicket();
  
  // 1. 组合参与签名的四个参数：jsapi_ticket（临时票据）、noncestr（随机字符串）、timestamp（时间戳）、url（当前服务器地址）
  const arr = [
    `jsapi_ticket=${ticket}`,
    `noncestr=${noncestr}`,
    `timestamp=${timestamp}`,
    `url=${url}/search`
  ]
  
  // 2. 将其进行字典序排序，以'&'拼接在一起
  const str = arr.sort().join('&');
  console.log(str);  //xxx=xxx&xxx=xxx&xxx=xxx
  
  // 3. 进行sha1加密，最终生成signature
  const signature = sha1(str);
  
  //渲染页面，将渲染好的页面返回给用户
  res.render('search', {
    signature,
    noncestr,
    timestamp
  });
})
//详情页面路由
router.get('/detail/:id', async (req, res) => {
  //获取占位符id的值
  const {id} = req.params;
  //判断id值是否存在
  if (id) {
    //去数据库中找到对应id值得所有数据
    const data = await Theaters.findOne({doubanId: id}, {_id: 0, __v: 0, createTime: 0, doubanId: 0});
    console.log(data);
    //渲染到页面上
    res.render('detail', {data});
  } else {
    res.end('error');
  }
  
})
//预告片页面路由
router.get('/movie', async (req, res) => {
  //去数据库中找所有预告片电影数据
  const data = await Trailers.find({}, {_id: 0, __v: 0, cover: 0, link: 0, image: 0});
  console.log(data);
  //渲染到页面上
  res.render('movie', {data, url});
})
//加载弹幕的路由
router.get('/v3', async (req, res) => {
  //获取用户发送来的请求参数
  const {id} = req.query;
  //去数据库中查找相应的电影弹幕信息
  const data = await Danmus.find({doubanId: id});
  
  //返回给用户的数据
  let resData = [];
  
  data.forEach(item => {
    resData.push([item.time, item.type, item.color, item.author, item.text])
  })
  
  //返回响应
  res.send({code: 0, data: resData});
  
})
//接受用户弹幕的路由
router.post('/v3', async (req, res) => {
  /*
    弹幕信息是以流式数据发送过来的
    接受的数据是一个buffer，需要调用toString转换成字符串
   */
  //获取请求参数
  const {id, author, time, text, color, type} = await new Promise(resolve => {
    let body = '';
    req
      .on('data', data => {
        body += data.toString();
      })
      .on('end', () => {
        //将json字符串转化成js对象
        resolve(JSON.parse(body)); // {"id":"demo","author":"DIYgod","time":0,"text":"的撒打算","color":16777215,"type":0}
      })
  })
  //保存到数据库中
  await Danmus.create({
    doubanId: id,
    author,
    time,
    text,
    color,
    type
  })
  
  //返回响应
  res.send({code: 0, data: {}});
  
})

//接受处理所有消息
router.use(reply());

//暴露出去
module.exports = router;