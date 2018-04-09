var network = require('../../common/netWork.js')

Page({
    data: {
      address:'深圳南山高新园',
      reduceIcon:"/images/dianc_list_ic_reduce.png",
      addIcon: "/images/dianc_list_ic_plus.png",
      cartIcon: "/images/ic_shop.png",
      totalPrice: 120,
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
     this.getSkuTypeList();
   },

   /**
    * 生命周期函数--监听页面显示
    */
   onShow: function () {

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

   orderCommit:function(){
     wx.navigateTo({
       url: '/pages/order/unpay'
     })

   },

   chooseAddress:function(){
     wx.navigateTo({
       url: '/pages/map/location'
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
     var skuid = event.currentTarget.dataset.pi;
     var len = _that.data.orderitem.length;
     if (len <= 0){
       _that.data.orderitem.push({ skuid: skuid, quantity:1});
     }else{
       var isFound = false;
       for (var i = 0; i++; i < len){
         var item = _that.data.orderitem[i];
         if (item.skuid==skuid){
           item.quantity++;
           isFound = true;
           break;
         }
       }
       if (isFound){
         _that.data.orderitem.push({ skuid: skuid, quantity: 1 });
       }
     }
   },

   reduceOnclick: function (event) {
     var _that = this;
     var skuid = event.currentTarget.dataset.pi;
     var len = _that.data.orderitem.length;
     if (len <= 0) {
       return;
     }

    var isFound = false;
    for (var i = 0; i++; i < len) {
      var item = _that.data.orderitem[i];
      if (item.skuid == skuid) {
        item.quantity--;
        isFound = true;
        break;
      }
    }
     
   }
})