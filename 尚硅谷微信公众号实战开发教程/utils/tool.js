/*
  工具函数包
 */
//引入xml2js，将xml数据转化成js对象
const {parseString} = require('xml2js');
//引入fs模块
const {writeFile, readFile} = require('fs');
//引入path模块
const {resolve} = require('path');

module.exports = {
  getUserDataAsync (req) {
    
    return new Promise((resolve, reject) => {
      let xmlData = '';
      req
        .on('data', data => {
          //当流式数据传递过来时，会触发当前事件，会将数据注入到回调函数中
          // console.log(data.toString());
          //读取的数据是buffer，需要将其转化成字符串
          xmlData += data.toString();
        })
        .on('end', () => {
          console.log('end');
          //当数据接受完毕时，会触发当前
          resolve(xmlData);
        })
    })
  },
  parseXMLAsync (xmlData) {
    return new Promise((resolve, reject) => {
      parseString(xmlData, {trim: true}, (err, data) => {
        if (!err) {
          resolve(data);
        } else {
          reject('parseXMLAsync方法出了问题:' + err);
        }
      })
    })
  },
  formatMessage (jsData) {
    let message = {};
    //获取xml对象
    jsData = jsData.xml;
    //判断数据是否是一个对象
    if (typeof jsData === 'object') {
      //遍历对象
      for (let key in jsData) {
        //获取属性值
        let value = jsData[key];
        //过滤掉空的数据
        if (Array.isArray(value) && value.length > 0) {
          //将合法的数据复制到message对象上
          message[key] = value[0];
        }
      }
    
    }
    
    return message;
  },
  writeFileAsync (data, fileName) {
    //将对象转化json字符串
    data = JSON.stringify(data);
    const filePath = resolve(__dirname, fileName);
    return new Promise((resolve, reject) => {
      writeFile(filePath, data, err => {
        if (!err) {
          console.log('文件保存成功~');
          resolve();
        } else {
          reject('writeFileAsync方法出了问题：' + err);
        }
      })
    })
  },
  readFileAsync (fileName) {
    const filePath = resolve(__dirname, fileName);
    return new Promise((resolve, reject) => {
      readFile(filePath, (err, data) => {
        if (!err) {
          console.log('文件读取成功~');
          //将json字符串转化js对象
          data = JSON.parse(data);
          resolve(data);
        } else {
          reject('readFileAsync方法出了问题：' + err);
        }
      })
    })
  }
}