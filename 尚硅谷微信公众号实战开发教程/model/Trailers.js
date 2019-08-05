//引入mongoose
const mongoose = require('mongoose');
//获取Schema
const Schema = mongoose.Schema;
//创建约束对象
const trailersSchema = new Schema({
  title: String,
  rating: Number,
  runtime: String,
  directors: String,
  casts: [String],
  image: String,
  cover: String,
  link: String,
  doubanId: {
    type: Number,
    unique: true
  },
  genre: [String],
  summary: String,
  releaseDate: String,
  posterKey: String,     //海报图片上传到七牛中，返回的key值
  coverKey: String,      //视频的封面图
  videoKey: String,      //视频
  createTime: {
    type: Date,
    default: Date.now()
  }
})
//创建模型对象
const Trailers = mongoose.model('Trailers', trailersSchema);
//暴露出去
module.exports = Trailers;