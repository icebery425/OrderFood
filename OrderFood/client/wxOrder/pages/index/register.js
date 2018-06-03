var netWork = require('../../common/netWork.js')

Page({

  data: {
    phone: '',
    authCode: '',
    btnText: '获取验证码',
    timeOut: false,
    seconds: 60,
    hasRead: true,
    dialogHidden: false,
    checkimg: '../../../images/register_selected.png',
    tempFormId: '',
    isFromUserInfo: false,

  },

  onShow: function () {
    clickAble = true;
  },

  onLoad: function (options) {
    var isFromUserInfo = options.isFromUserInfo;

    wx.setNavigationBarTitle({
      title: '注册',
    })
    this.setData({ dialogHidden: true, isFromUserInfo: isFromUserInfo });
  },

  //submit
  formSubmit: function (e) {

    this.data.tempFormId = e.detail.formId;//13位int类型随机码
    console.log('注册formId', this.data.tempFormId);


    this.userRegister();
    

  },


  //注册
  userRegister: function () {

    if (!this.virifyPhone()) {
      return;
    }

    if (this.data.authCode == '') {
      toast.failedToast('请输入验证码')
      return;
    }

    var _this = this;
    var app = getApp();
    try {
      wx.setStorageSync('usingCar', null)
    } catch (e) { }

    if (!clickAble) {
      return;
    }
    clickAble = false;
    wx.showLoading({
      title: '正在处理',
      mask: true,
    })
    wx.login({
      success: function (res) {
        app.globalData.wxCode = res.code;
        console.log(app.globalData.wxCode);
        wx.getUserInfo({
          success: function (res) {
            app.globalData.wxUserInfo = res.userInfo;
            var params = {
              wxFormId: _this.data.tempFormId,//表单id
              wxAppCode: app.globalData.wxCode, mobile: _this.data.phone,
              code: _this.data.authCode, nickName: app.globalData.wxUserInfo.nickName, mobile: _this.data.phone,
              avatarUrl: app.globalData.wxUserInfo.avatarUrl, gender: app.globalData.wxUserInfo.gender
            };

            netWork.request(1, netWork.apilist.register, params,

              function (res) {
                wx.hideLoading()
                clickAble = true;
                app.globalData.loginUserInfo = res.data.info
                if (_this.data.isFromUserInfo) {
                  wx.navigateBack({

                  });
                  return;
                }
                wx.redirectTo({
                  url: '../usecarprocess/usecarprocess?userStatus=1',
                });

              },

              function (res) {
                wx.hideLoading()
                clickAble = true;
                toast.failedToast(res);

              })
          }
        })
      }
    })



  },

})