// pages/list/list.js
let datas = require('../../datas/list-data');
console.log(typeof datas, datas);
Page({

  /**
   * 页面的初始数据
   */
  data: {
    datas: []
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({datas: datas.list_data});
  },

  toDetail(event) {
    console.log(event);
    let id = event.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/detail/detail?id=' + id
    })
  },

  carouselToDetail(event) {
    let id = event.target.dataset.detailid;
    wx.navigateTo({
      url: '/pages/detail/detail?id=' + id
    })
  }
})