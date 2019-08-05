// pages/index/index.js
Page({ // 注册当前页面

  /**
   * 页面的初始数据
   */
  data: {
		userInfo: {}
  },

	handleParent(){
		console.log('父元素');
		// 跳转页面
		wx.switchTab({
			url: '/pages/list/list',
			success(){
				console.log('跳转成功');
			}
		})
	},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
		console.log('页面加载完毕');
		console.log(this)
		// 开启定时器，发送ajax请求
		// 获取登录用户信息
		wx.getUserInfo({
			success: (data) => {
				console.log(data);
				this.setData({userInfo: data.userInfo});
			}
		})
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
		console.log('页面初始化渲染完毕');
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
		console.log('页面显示完毕');
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
		console.log('页面隐藏毕');
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})