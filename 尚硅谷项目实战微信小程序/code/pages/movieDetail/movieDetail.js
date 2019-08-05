// pages/movieDetail/movieDetail.js

let appDatas = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    movie: {}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options);
    this.setData({
      movie: appDatas.data.movies[options.id]
    })
  },
})