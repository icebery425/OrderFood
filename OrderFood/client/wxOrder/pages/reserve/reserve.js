Page({
    data: {
      address:'深圳南山高新园',
      category:[
        { "id": 1, "name": "两荤一素"},
        { "id": 2, "name": "三荤一素"},
        { "id": 3, "name": "品质套餐" },
        { "id": 4, "name": "饮料酒水" }
      ],
      sku:[
        { "id": 1, "name": "叉烧饭", "avatar":"/images/img_chas.png", "desc":"叉烧+精致小炒+时蔬+米饭" },
        { "id": 2, "name": "烧鸭饭", "avatar": "/images/img_jipai.png", "desc": "烧度+精致小炒+时蔬+米饭"},
        { "id": 3, "name": "鸡排饭", "avatar": "/images/img_shaoya.png", "desc": "叉烧+精致小炒+时蔬+米饭"},
      ]
    },

   onLoad: function () {
   },
})