var QQMapWX = require('../../common/qqmap-wx-jssdk.js');

var qqmapsdk;
var latitude, longitude;


Page({

  /**
   * 页面的初始数据
   */
  data: {
    globalData: {
      userInfo: null, 
      locationInfo: null
    },

    Height: 0,
    scale: 13,
    nowWhere:"",
    latitude: "",
    longitude: "",
    markers: [],
    controls: [{
      id: 1,
      iconPath: '/assests/imgs/jian.png',
      position: {
        left: 320,
        top: 100 - 50,
        width: 20,
        height: 20
      },
      clickable: true
    },
    {
      id: 2,
      iconPath: '/assests/imgs/jia.png',
      position: {
        left: 340,
        top: 100 - 50,
        width: 20,
        height: 20
      },
      clickable: true
    }
    ],
    circles: []
  },

  regionchange(e) {
    console.log(e.type)
  },
  markertap(e) {
    console.log(e.markerId)
  },
  controltap(e) {
    console.log(e.controlId)
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this;
    // 实例化API核心类
    qqmapsdk = new QQMapWX({
      key: 'TRCBZ-EO2HK-KYUJP-AHCVR-WD6V5-ZLB75'
    });
    wx.getSystemInfo({
      success: function (res) {
        //设置map高度，根据当前设备宽高满屏显示
        _this.setData({
          view: {
            Height: res.windowHeight
          }
        })
      }
    })

    wx.getLocation({
      type: 'gcj02', // 默认为 wgs84 返回 gps 坐标，gcj02 返回可用于 wx.openLocation 的坐标
      success: function (res) {

        _this.setData({
          latitude: res.latitude,
          longitude: res.longitude,
          markers: [{
            id: "1",
            latitude: res.latitude,
            longitude: res.longitude,
            width: 50,
            height: 50,
            iconPath: "/assests/imgs/my.png",
            title: _this.nowWhere

          }],
        })
        _this.showAddress(res.latitude, res.longitude);
      }

    })

  },

  //点击merkers
  markertap(e) {
    console.log(e.markerId)

    wx.showActionSheet({
      itemList: ["A"],
      success: function (res) {
        console.log(res.tapIndex)
      },
      fail: function (res) {
        console.log(res.errMsg)
      }
    })
  }, 

 
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.mapCtx = wx.createMapContext('mymap')
    this.mapCtx.getCenterLocation({
      success: function (res) {
        latitude = res.latitude;
        longitude = res.longitude;
      }
    }) //获取当前地图的中心经纬度
    this.mapCtx.includePoints({
      padding: [10],
      points: [{
        latitude: latitude,
        longitude: longitude
      }]
    })

    this.mapCtx.translateMarker({
      markerId: 0,
      autoRotate: true,
      duration: 1000,
      destination: {
        latitude: latitude,
        longitude: longitude,
      },
      animationEnd() {
        console.log('animation end')
      }
    })
  },

  // 腾讯地图逆向解析地址
  showAddress: function (latitude, longitude) {
    var that = this;
    var qqMapBaseUrl = 'http://apis.map.qq.com/ws/geocoder/v1/'; 
    var qqkey = 'TRCBZ-EO2HK-KYUJP-AHCVR-WD6V5-ZLB75';
    var qqMapApi = qqMapBaseUrl + "?location=" + latitude + ',' +
      longitude + "&key=" + qqkey + "&get_poi=1";
    wx.request({
      url: qqMapApi,
      data: {},
      method: 'GET',
      success: (res) => {
        console.log(res)
        if (res.statusCode == 200 && res.data.status == 0) {
          that.setData({
            nowWhere: res.data.result.formatted_addresses.recommend,
    			});
          console.log("### address: " + res.data.result.address);
          wx.setStorageSync('address', res.data.result.address);
        }
    	}
    })
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