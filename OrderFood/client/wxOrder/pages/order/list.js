// pages/order/list.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    orderItems: [
      { "id": 1, 
        "time":"2017-12-05 12:30:00", 
        "number":"NR000345",
        "status":200, 
        "paidAmout":120.00,
        "skus":[{"name": "叉烧饭", 
                  "avatar": "/images/img_chas.png", 
                  "price": 12.00, 
                  "quantity": 10,         
                  "desc": "叉烧+精致小炒+时蔬+米饭" 
                  }]
      }
    ],
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