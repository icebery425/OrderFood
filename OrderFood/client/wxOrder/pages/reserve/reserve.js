var network = require('../../common/netWork.js')
var QQMapWX = require('../../common/qqmap-wx-jssdk.js');

var qqmapsdk;

Page({
    data: {
      address:'深圳南山高新园',
      latitude:0,
      longitude:0,
      reduceIcon:"/images/dianc_list_ic_reduce.png",
      addIcon: "/images/dianc_list_ic_plus.png",
      cartIcon: "/images/ic_shop.png",
      totalPrice: 0,
      selectName: "三荤一素",
      category:[
        { "id": 1, "name": "两荤一素"},
        { "id": 2, "name": "三荤一素"},
        { "id": 3, "name": "品质套餐" },
        { "id": 4, "name": "饮料酒水" }
      ],
      categoryList:[],
      skuList:[],
      orderitem:[],
      sku:[
        { "id": 1, "name": "叉烧饭", "avatar":"/images/img_chas.png", "price":12.00, "desc":"叉烧+精致小炒+时蔬+米饭" },
        { "id": 2, "name": "烧鸭饭", "avatar": "/images/img_jipai.png", "price": 13.00, "desc": "烧度+精致小炒+时蔬+米饭"},
        { "id": 3, "name": "鸡排饭", "avatar": "/images/img_shaoya.png", "price": 14.00, "desc": "叉烧+精致小炒+时蔬+米饭"},
      ]
    },

  /**
   * 生命周期函数--监听页面加载
   */
   onLoad: function () {
     var _this = this;

     this.getSkuTypeList();

     wx.getLocation({
       type: 'gcj02', // 默认为 wgs84 返回 gps 坐标，gcj02 返回可用于 wx.openLocation 的坐标
       success: function (res) {

         _this.setData({
           latitude: res.latitude,
           longitude: res.longitude,
         })
         _this.showAddress(res.latitude, res.longitude);
       }

     })
   },

   /**
    * 生命周期函数--监听页面显示
    */
   onShow: function () {
     var _that = this;
     try {
       var value = wx.getStorageSync('address')
       _that.setData({
         address: value
       })
       if (value) {
         // Do something with return value
       }
     } catch (e) {
       // Do something when catch error
     }


   },

   categoryChoose: function (event){
     var _that = this;
     var item = event.currentTarget.dataset.pi;
     console.log("用户点击分类：", item.typename);
     _that.setData({
       selectName: item.typename
     })

     this.getSkuList(item.skutypeid);
   },

   chooseAddress:function(){
     wx.navigateTo({
       url: '/pages/map/location'
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
             address: res.data.result.address,
           });
           console.log("### address: " + res.data.result.address);
           wx.setStorageSync('address', res.data.result.address);
         }
       }
     })
   },

   getSkuTypeList: function () {
     var _that = this;
     var requestType = 0;
     var url = "https://www.tianqingjia.com/api/home/typelist";
     var params = {
       
     };
     var success = null;
     var fail = null;

     network.request(requestType, url, params,
       function (res) {
         console.log('getSkuTypeList request result: ', res)
         if (res.data != undefined && res.data != undefined && !res.status) {
           //console.log('getSkuTypeList request result: ', res)
           var list = res.data;
              _that.setData({
              categoryList: list,
           })

           if (list != undefined && list.length > 0)
           {
             _that.setData({
               selectName: list[0].typename
             })

             _that.getSkuList(list[0].skutypeid);
           }
         }else{
           
         }
       },
       function () {
         // toast.showToast('----');
         console.log('getSkuTypeList request failed')
       });

   },

   getSkuList: function (typeId) {
     var _that = this;
     var requestType = 0;
     var url = "https://www.tianqingjia.com/api/home/skulist" + "?skuTypeId=" + typeId;
     var params = {
       //code: _that.data.wxcode,
     };
     var success = null;
     var fail = null;

     network.request(requestType, url, params,
       function (res) {
         if (res.data != undefined && res.data != undefined && !res.status) {
           console.log('getSkuList request result: ', res)
           var list = res.data;
           _that.setData({
             skuList: list,
           })
         }
       },
       function () {
         // toast.showToast('----');
         console.log('getSkuList request failed')
       });

   },

   addOnclick: function (event){
     var _that = this;
     var _addPrice = 0;
     var skuid = event.currentTarget.dataset.pi;
     var len = _that.data.skuList.length;
     if (len <= 0){
       return;
     }else{
       for (var i = 0; i < len; i++){
         var item = _that.data.skuList[i];
         if (item.skuid==skuid){
           if (item.quantity == undefined) {
             item.quantity = 0;
           }

           item.quantity++;
           _addPrice = (item.skuprice);
           this.setData({
             skuList: _that.data.skuList,
             totalPrice: (_that.data.totalPrice + _addPrice)
           })
           break;
         }
       }

     }
   },

   reduceOnclick: function (event) {
     var _that = this;
     var skuid = event.currentTarget.dataset.pi;
     var len = _that.data.skuList.length;
     if (len <= 0) {
       return;
     }

    var reducePrice = 0;
    var isFound = false;
    for (var i = 0; i < len; i++) {
      var item = _that.data.skuList[i];
      if (item.skuid == skuid) {
        if (item.quantity == undefined){
          item.quantity = 0;
        }
        if (item.quantity <= 0){
          break;
        }
        item.quantity--;
        reducePrice = (item.skuprice);
        this.setData({
          skuList: _that.data.skuList,
          totalPrice: (_that.data.totalPrice - reducePrice)
        })
        break;
      }
    }
     
   },


  orderCommitExt: function () {
     var _that = this;
     var skulen = _that.data.skuList.length;
     if (skulen <= 0){
       reutrn;
     }

     var hasSku = false;
     for (var i = 0; i < skulen; i++) {
       var item = _that.data.skuList[i];
       if (item.quantity != undefined && item.quantity > 0) {
         hasSku = true;
         _that.data.orderitem.push({skuid: item.skuid, quantity:item.quantity});
       }
     }
    if (!hasSku){
      return;
    }
    
    console.log("items count: " + _that.data.orderitem.length);
    var tempItem = _that.data.orderitem;
     wx.navigateTo({
       url: '/pages/order/unpay?items=' + tempItem,
     })

   },

  orderCommit: function () {
    var _that = this;
    var skulen = _that.data.skuList.length;
    if (skulen <= 0) {
      reutrn;
    }

    var hasSku = false;
    for (var i = 0; i < skulen; i++) {
      var item = _that.data.skuList[i];
      if (item.quantity != undefined && item.quantity > 0) {
        hasSku = true;
        _that.data.orderitem.push(item);
      }
    }
    if (!hasSku) {
      return;
    }

    console.log("items count: " + _that.data.orderitem.length);
    let str = JSON.stringify(_that.data.orderitem);;
    wx.navigateTo({
      url: '/pages/order/unpay?address=' + _that.data.address + '&items=' + str,
    })


  },
})