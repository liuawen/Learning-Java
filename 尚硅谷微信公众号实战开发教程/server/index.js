const db = require('../db');
const theatersCrawler = require('./crawler/theatersCrawler');
const trailersCrawler = require('./crawler/trailersCrawler');
const saveTheaters = require('./save/saveTheaters');
const saveTrailers = require('./save/saveTrailers');
const uploadToQiniu = require('./qiniu');
const Theaters = require('../model/Theaters');
const Trailers = require('../model/Trailers');

(async () => {
  //连接数据库
  await db;
  //爬取数据
  // const data = await theatersCrawler();
  const data = await trailersCrawler();
  //将爬取的数据保存在数据库中
  // await saveTheaters(data);
  await saveTrailers(data);
  //上传图片到七牛中
  // await uploadToQiniu('posterKey', Theaters);
  await uploadToQiniu('coverKey', Trailers);
  await uploadToQiniu('posterKey', Trailers);
  await uploadToQiniu('videoKey', Trailers);
})()