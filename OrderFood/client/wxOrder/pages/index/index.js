//index.js
//获取应用实例
const app = getApp()
var network = require('../../common/netWork.js')

Page({
  data: {
    motto: 'Hello World',
    wxcode: "",
    openid: "",
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

    
    this.getUserCode();


  },


getUserCode:function(e){
  var _that = this;
  wx.login({
    success: function (res) {
      if (res.code) {
        //发起网络请求
        //wx.request({
        //  url: 'https://www.tianqingjia.com/api/login/login',
        //  data: {
        //    code: res.code
        //  }
        //})
        _that.data.wxcode = res.code;
        console.log('wxcode = ' + res.code)
        _that.userLogin();
      } else {
        console.log('获取用户登录态失败！' + res.errMsg)
      }
    }
  });
},

userLogin:function(){
  var _that = this;
  var requestType = 0;
  //var url = "https://www.tianqingjia.com/api/order/queryBillinglist?pageIndex=1&pageSize=1";
  var url = "https://www.tianqingjia.com/api/login/login" + "?code=" + _that.data.wxcode;
  var params = {
    //code: _that.data.wxcode,
  };
  var success = null;
  var fail = null;

  network.request(requestType, url, params, 
    function (res) {
      if (res.data != undefined && res.data != undefined && !res.status) {
        console.log('userLogin request result: ', res)
        _that.data.openid = res.data.openId;
        getApp().globalData.appId = res.data.openId;
      }
    },
    function (res) {
      // toast.showToast('----');
      console.log('userLogin request failed:' + res)
    });

},

doOrder:function(e){
  var _that = this;
  var requestType = 1;
  //var url = "https://www.tianqingjia.com/api/order/queryBillinglist?pageIndex=1&pageSize=1";
  var url = "https://www.tianqingjia.com/api/order/neworder"
  var params = {
    deliveryType: 200,
    deliveryTime: "2018-1-13 12:30:30",
    totalAmount: 30.00,
    discountAmount: 2.00,
    freightAmount: 5.00,
    receivableAmount:33.00,
    msg: "test user msg",
    desc: "test user desc",
    supervisor: "张三",
    supervisorPhone: "15195998895",
    address: "深圳市南山区科技园万德莱南座401C",
    openid: _that.data.openid,
    Items: "[{skuId: 1,quantity:20},{skuId:2,quantity:3}]"
  };
  var success = null;
  var fail = null;

  network.request(requestType, url, params, success, fail);
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
    this.doOrder();
    //wx.navigateTo({
    //  url: '/pages/message/message'
    //})
  },

  mineCoupons:function(e){
    wx.navigateTo({
      url: '/pages/coupon/coupon'
    })
  }

})
