// pages/coupon/coupon.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    couponItems: [
      { "id": 1, "amount": 12, "uptime": "2017/11/30", "downtime":"2017/12/30", "desc": "限中午使用" },
      { "id": 1, "amount": 12, "uptime": "2017/11/30", "downtime": "2017/12/30", "desc": "限晚上使用" },
      { "id": 1, "amount": 12, "uptime": "2017/11/30", "downtime": "2017/12/30", "desc": "限中午使用" },
    ],
    leftAvatar: "/images/card_bg.png",
    statusAvatar:"/images/card_yishiy.png"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
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