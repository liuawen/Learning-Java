/*
  验证服务器有效性的模块
 */

//引入sha1模块
const sha1 = require('sha1');
//引入config模块
const config = require('../config');
//引入tool模块
const {getUserDataAsync, parseXMLAsync, formatMessage} = require('../utils/tool');
//引入template模块
const template = require('./template');
//引入reply模块
const reply = require('./reply');

module.exports = () => {
  
  return async (req, res, next) => {
    //微信服务器提交的参数
    const {signature, echostr, timestamp, nonce} = req.query;
    const {token} = config;
  
    const sha1Str = sha1([timestamp, nonce, token].sort().join(''));
    
    /*
      微信服务器会发送两种类型的消息给开发者服务器
        1. GET请求
          - 验证服务器的有效性
        2. POST请求
          - 微信服务器会将用户发送的数据以POST请求的方式转发到开发者服务器上
     */
    if (req.method === 'GET') {
      if (sha1Str === signature) {
        // 如果一样，说明消息来自于微信服务器，返回echostr给微信服务器
        res.send(echostr);
      } else {
        // 如果不一样，说明不是微信服务器发送的消息，返回error
        res.end('error');
      }
    } else if (req.method === 'POST') {
      //微信服务器会将用户发送的数据以POST请求的方式转发到开发者服务器上
      //验证消息来自于微信服务器
      if (sha1Str !== signature) {
        //说明消息不是微信服务器
        res.end('error');
      }
      // console.log(req.query);
      /*
      { signature: '81ac17269e5e918e977fa5c91f2a863145c5032a',
        timestamp: '1535703917',
        nonce: '1998798155',
        openid: 'oAsoR1iP-_D3LZIwNCnK8BFotmJc' }  //用户的微信id
       */
      //接受请求体中的数据，流式数据
      const xmlData = await getUserDataAsync(req);
      // console.log(xmlData);
      /*
      <xml>
      <ToUserName><![CDATA[gh_4fe7faab4d6c]]></ToUserName>   // 开发者的id
      <FromUserName><![CDATA[oAsoR1iP-_D3LZIwNCnK8BFotmJc]]></FromUserName>  // 用户openid
      <CreateTime>1535704703</CreateTime>  // 发送的时间戳
      <MsgType><![CDATA[text]]></MsgType>  // 发送消息类型
      <Content><![CDATA[789]]></Content>   // 发送内容
      <MsgId>6595801476125116782</MsgId>   // 消息id 微信服务器会默认保存3天用户发送的数据，通过此id三天内就能找到消息数据，三天后就被销毁
      </xml>
       */
      
      //将xml数据解析为js对象
      const jsData = await parseXMLAsync(xmlData);
      // console.log(jsData);
      /*
      { xml:
       { ToUserName: [ 'gh_4fe7faab4d6c' ],
         FromUserName: [ 'oAsoR1iP-_D3LZIwNCnK8BFotmJc' ],
         CreateTime: [ '1535705176' ],
         MsgType: [ 'text' ],
         Content: [ '111' ],
         MsgId: [ '6595803507644647874' ] } }
       */
      
      //格式化数据
      const message = formatMessage(jsData);
      // console.log(message);
      /*
      { ToUserName: 'gh_4fe7faab4d6c',
      FromUserName: 'oAsoR1iP-_D3LZIwNCnK8BFotmJc',
      CreateTime: '1535705946',
      MsgType: 'text',
      Content: '123123',
      MsgId: '6595806814769465978' }
       */
      
      //简单的自动回复，回复文本内容
      /*
      一旦遇到以下情况，微信都会在公众号会话中，向用户下发系统提示“该公众号暂时无法提供服务，请稍后再试”：
          1、开发者在5秒内未回复任何内容
          2、开发者回复了异常数据，比如JSON数据、字符串、xml数据中有多余的空格*****等
       */
      //将reply函数改装成了async函数，此时返回值就变成了promise对象
      //所以必须用await才能拿到最终的返回值
      console.log(message);
      const options = await reply(message);
      console.log(options);
      //最终回复用户的消息
      const replyMessage = template(options);
      console.log(replyMessage);
      
      //返回响应给微信服务器
      res.send(replyMessage);
      
      /*//如果开发者服务器没有返回响应给微信服务器，微信服务器会发送三次请求过来
      res.end('');*/
    
    } else {
      res.end('error');
    }
  
  }
  
}