var network = require('../../common/netWork.js')
Page({
  data: {
    orderItems:[
      { "id": 1, "name": "叉烧饭", "avatar": "/images/img_chas.png", "price": 12.00, "quantity":10, "desc": "叉烧+精致小炒+时蔬+米饭" },
      { "id": 2, "name": "烧鸭饭", "avatar": "/images/img_jipai.png", "price": 13.00, "quantity": 10,"desc": "烧度+精致小炒+时蔬+米饭" },
      { "id": 3, "name": "鸡排饭", "avatar": "/images/img_shaoya.png", "price": 14.00, "quantity": 10,"desc": "叉烧+精致小炒+时蔬+米饭" },
    ],
    totalPrice: 20.00,
  },

  onLoad: function () {
    
  },

  orderCommit: function () {
    this.doOrder();
    //wx.navigateTo({
    //  url: '/pages/index/index'
    //})

  },


  doOrder: function (typeId) {
    var _that = this;
    var requestType = 1;
    var url = "https://www.tianqingjia.com/api/order/submitOrder";
    var openID = getApp().globalData.appId;
   
    var success = null;
    var fail = null;
    var params = {
      deliveryType: '',
      deliveryTime: '',
      totalAmount: 20.00,
      discountAmount: 5.0,
      freightAmount: 0,
      receivableAmount: 0,
      msg: '加急',
      desc: '不放辣',
      supervisor: '余生',
      supervisorPhone: '15195998895',
      openid: openID,
      address: '深圳市南山区科技园6路',
      items: [
        { skuid: 1, quantity: 5 }
      ]
    };

    network.request(requestType, url, params,
      function (res) {
        if (res.data != undefined && res.data != undefined && !res.status) {
          console.log('doOrder request result: ', res)
          var list = res.data;
          
        }
      },
      function (res) {
        // toast.showToast('----');
        console.log('doOrder request failed: ' + res)
      });

  }
})