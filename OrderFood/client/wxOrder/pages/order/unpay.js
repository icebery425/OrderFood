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
      orderItems: tempitem
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
      supervisorPhone: e.detail.value
    })
  }, 

  //获取用户输入的留言
  userMessageInput: function(e) {
    this.setData({
      msg: e.detail.value
    })
  },

  orderCommit: function () {

    if (this.data.supervisor == null || this.data.supervisor == '' || this.data.supervisor !== undefined) {
      wx.showToast({
        title: '请输入联系人',
        icon: 'none',
        duration: 1000
      })
      return;
    }

    if (this.data.supervisorPhone == null || this.data.supervisorPhone == '' || this.data.supervisorPhone !== undefined) {
      wx.showToast({
        title: '请输入手机号码',
        icon: 'none',
        duration: 1000
      })
      return;
    }

    if (this.data.address == null || this.data.address == '' || this.data.address !== undefined) {
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
          
        }
      },
      function (res) {
        // toast.showToast('----');
        console.log('doOrder request failed: ' + res)
      });

  }
})