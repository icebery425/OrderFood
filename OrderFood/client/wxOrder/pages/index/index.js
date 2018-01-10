//index.js
//获取应用实例
const app = getApp()
var network = require('../../common/netWork.js')

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),

    mode: "scaleToFill",
    arr: [],
    indicatorDots: true,
    autoplay: true,
    interval: 2000,
    duration: 1000,

    arrow: '/images/ic_choose.png',
    openTime: '09:30-20:30'
  },

  onLoad: function () {
    var array = this.data.arr
    for (let i = 1; i < 4; i++) {
      array.push("/images/" + i + ".png")
    }
    this.setData({ arr: array })

    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }

    var requestType = 0;
    //var url = "https://www.tianqingjia.com/api/order/queryBillinglist?pageIndex=1&pageSize=1";
    var url = "https://www.tianqingjia.com/api/login/login"
    var params = {
      code:"123455"
    };
    var success = null;
    var fail = null;
    
    //network.request(requestType, url, params, success, fail);

    this.getUserCode();


  },


getUserCode:function(e){
  wx.login({
    success: function (res) {
      if (res.code) {
        //发起网络请求
        wx.request({
          url: 'https://www.tianqingjia.com/api/login/login',
          data: {
            code: res.code
          }
        })
      } else {
        console.log('获取用户登录态失败！' + res.errMsg)
      }
    }
  });
},


  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },

  reserveCommit: function (e) {
    //TODO
    var _that = this;
    wx.navigateTo({
      url: '/pages/reserve/reserve'
    })

  },

  mineOrders:function(e){
    wx.navigateTo({
      url: '/pages/order/list'
    })
  },


  mineMessages:function(e){
    wx.navigateTo({
      url: '/pages/message/message'
    })
  },

  mineCoupons:function(e){
    wx.navigateTo({
      url: '/pages/coupon/coupon'
    })
  }

})
