var network = require('../../common/netWork.js')

Page({
  data: {
    orderItems:[],
    totalPrice: 0,
    supervisor:"",
    supervisorPhone:"",
    address:"",
    discountAmount:"",
    freightAmount:"",
    receivableAmount:"",
    msg:"",
    items:[],

  },

  onLoad: function (option) {
    let tempitem = JSON.parse(option.items);
    
    var _that = this;
    var skulen = tempitem.length;
    if (skulen <= 0) {
      reutrn;
    }

    for (var i = 0; i < skulen; i++) {
      var item = tempitem[i];
      if (item.quantity != undefined && item.quantity > 0) {
        _that.data.totalPrice += (item.skuprice * item.quantity);
        _that.data.items.push({ skuid: item.skuid, quantity: item.quantity });
      }
    }

    this.setData({
      orderItems: tempitem,
      totalPrice: _that.data.totalPrice,
      address:option.address
    })

  },

  //获取用户输入的用户名
  userNameInput: function (e) {
    var name = e.detail.value;
    

    this.setData({
      supervisor: name
    })
  },

  //获取用户输入的联系方式 
  userMobileInput: function (e) {
    var mobile = e.detail.value;
    

    this.setData({
      supervisorPhone: e.detail.value
    })
  },

  //获取用户输入的地址 
  userAddressInput: function (e) {
    var address = e.detail.value;


    this.setData({
      address: e.detail.value
    })
  }, 

  //获取用户输入的留言
  userMessageInput: function(e) {
    this.setData({
      msg: e.detail.value
    })
  },

  orderCommit: function () {

    if (this.data.supervisor == null || this.data.supervisor == '' || this.data.supervisor == undefined) {
      wx.showToast({
        title: '请输入联系人',
        icon: 'none',
        duration: 1000
      })
      return;
    }

    if (this.data.supervisorPhone == null || this.data.supervisorPhone == '' || this.data.supervisorPhone == undefined) {
      wx.showToast({
        title: '请输入手机号码',
        icon: 'none',
        duration: 1000
      })
      return;
    }

    if (this.data.address == null || this.data.address == '' || this.data.address == undefined) {
      wx.showToast({
        title: '请输入地址',
        icon: 'none',
        duration: 1000
      })
      return;
    }

    this.doOrder();

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
      storeId:1,
      msg: _that.data.msg,
      desc: '',
      supervisor: _that.data.supervisor,
      supervisorPhone: _that.data.supervisorPhone,
      openid: openID,
      address: _that.data.address,
      items: _that.data.items
    };

    network.request(requestType, url, params,
      function (res) {
        if (res.data != undefined && res.data != undefined && !res.status) {
          console.log('doOrder request result: ', res)
          var list = res.data;
          
          var payparam = res.data;
          if (payparam !== null) {    
            console.log('appid'+res.data.appId + 
                '\n timeStamp: ' + res.data.timeStamp + 
                '\n nonceStr: ' + res.data.nonceStr +
                '\n package:' + res.data.package +
                '\n signType: ' +res.data.signType +
              '\n paySign: ' + res.data.paySign);

            wx.requestPayment({
              'timeStamp': res.data.timeStamp + '',
              'nonceStr': res.data.nonceStr,
              'package': res.data.package,
              'signType': 'MD5',
              'paySign': res.data.paySign,
              'success': function (res) {
                  console.log("###### pay succeed #######");
                  //searchPayResult(succee, fail);
                  //dealTimeOut();
              },

              'fail': function (res) {
                console.log("###### pay failed #######");
                console.log(res);
                //fail(res);
              }
            })

          }
        }
      },
      function (res) {
        // toast.showToast('----');
        console.log('doOrder request failed: ' + res)
      });

  },

//微信、余额支付结果查询
searchPayResult:function (succee, fail) {

    gT1 = setInterval(function () {
      var params = {
        orderNumber: gOrderId,
      };

      wx.showLoading({
        title: '支付状态查询',
      })
      netWork.request(0, netWork.apilist.getPayStatus, params,
        function (res) {
          console.log('支付结果', res);
          wx.hideLoading();
          if (res.status) {
            console.log("查询支付结果成功");
            if (res.data.info.return_code == true) {

              succee('支付成功');

            } else if (paystatus == 'REFUND') {

              fail('转入退款');

            } else if (paystatus == 'NOTPAY') {

              fail('未支付');

            } else if (paystatus == 'CLOSED') {

              fail('已关闭');

            } else if (paystatus == 'REVOKED') {

              fail('已撤销');

            } else if (paystatus == 'USERPAYING') {

              console.log('用户支付中...');

            } else if (paystatus == 'PAYERROR') {

              fail('支付失败');

            } else if (paystatus == 'OTHOR') {

              fail('支付异常');
            }
            clearTimeOut();

          } else {

            fail('查询支付结果失败');
            clearTimeOut();
          }
        },
        function () {
          fail('查询支付结果失败');
          wx.hideLoading();
          clearTimeOut();
        })
    }, 2000)
  }


  
})