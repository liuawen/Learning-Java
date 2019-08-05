//引入mongoose
const mongoose = require('mongoose');

module.exports = new Promise((resolve, reject) => {
  //连接数据库
  mongoose.connect('mongodb://localhost:27017/atguigu_movie', {useNewUrlParser: true});
  //绑定事件监听
  mongoose.connection.once('open', err => {
    if (!err) {
      console.log('数据库连接成功了~~');
      resolve();
    } else {
      reject('数据库连接失败：' + err);
    }
  })
})