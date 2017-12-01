//index.js
//获取应用实例
const app = getApp()

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
