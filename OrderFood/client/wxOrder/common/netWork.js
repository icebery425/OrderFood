var toast = require('../utils/toastUtil.js')
var gToken = "";
var hasReload = false;
/*
 * requestType ： 0 get请求 1post请求
 * url：请求路径
 * paramsData：请求参数(对象)
 * success:请求成功回调方法
 * fail：失败回调方法
 */
function request(requestType, url, paramsData, success, fail) {

  var timestamp = Date.parse(new Date());

  var tempToken = "12345678";
  console.log("token: " + tempToken);
  wx.request({

    url: url,
    data: paramsData,
    method: requestType == 0 ? 'GET' : 'POST',

    header: {
      //'content-type': 'application/x-www-form-urlencoded',
      'content-type': 'application/json',
      'token': tempToken,
    },
    success: function (res) {
      console.log("wx.request success res: ", res);

      if (res.statusCode == 200) {
        if (res.data.status) {
          return typeof fail == "function" && fail(res.errMsg);
        } else {
          return typeof success == "function" && success(res.data);
        }
      } else if (res.statusCode == 401) {
        console.log('401==')
        if (hasReload) {
          console.log('===重复调用401退出====');
          //登录失败进入注册界面
          wx.navigateTo({
            url: '/pages/usecar/registration/register',
          })

        } else {
          console.log('===尝试再次登录====');
          wx.login({
            success: function (res) {
              getApp().globalData.wxCode = res.code;
              console.log('重新获得wxcode==' + getApp().globalData.wxCode);
              wx.getUserInfo({
                success: function (res) {
                  getApp().globalData.wxUserInfo = res.userInfo;
                  var params = {
                    //wxFormId: _this.data.tempFormId,
                    wxAppCode: getApp().globalData.wxCode, 
                    nickName: getApp().globalData.wxUserInfo.nickName,
                    avatarUrl: getApp().globalData.wxUserInfo.avatarUrl, 
                    gender: getApp().globalData.wxUserInfo.gender
                  };

                  request(0, baseUrl + 'user/login.json', params, function (res) {
                    hasReload = false;
                    wx.hideLoading();
                    if (!res.status) {//用户禁用或失败
                      console.log('==用户禁用或失败')
                      try {
                        wx.setStorageSync('notRefreshIndex', false)
                      } catch (e) {
                      }
                      wx.showModal({
                        content: res.data.info.msg,
                        confirmText: '确定',
                        confirmColor: '#27B5EE',
                        showCancel: false,
                        success: function () {
                          wx.reLaunch({
                            url: '/pages/usecar/mainindex/index',
                          })
                        }
                      })
                    }else{
                      if (res.data.info.token == undefined) {//用户未注册
                        console.log('==用户未注册')
                        if (getApp().globalData.loginUserInfo.token == null){
                          if (url == baseUrl+'user/info.json'){
                            wx.redirectTo({
                              url: '/pages/usecar/registration/register',
                            })
                            return;
                          }
                          wx.navigateTo({
                            url: '/pages/usecar/registration/register',
                          })
                        }else{
                          getApp().globalData.loginUserInfo = [];
                          return typeof fail == "function" && fail(res);
                        }
                        
                       
                      } else {//登录成功
                        console.log('==登录成功')
                        getApp().globalData.loginUserInfo = res.data.info;
                        //登录成功则 重新调用提示401的接口刷新界面
                        request(requestType, url, paramsData, success, fail);
                      }
                    }


                  }, function (res) {
                    console.log('登录失败fail');
                    //登录失败进入注册界面
                    wx.hideLoading();
                    hasReload = false;
                    try {
                      wx.setStorageSync('notRefreshIndex', false)
                    } catch (e) {
                    }
                    wx.showModal({
                      content: res.err_code_msg,
                      confirmText: '确定',
                      confirmColor: '#27B5EE',
                      showCancel:false,
                      success: function () {
                        wx.reLaunch({
                          url: '/pages/usecar/mainindex/index',
                        })
                      }
                    })


                  });

                }
              })
            }
          })

        }
        hasReload = true;


      } else {
        return typeof fail == "function" && fail("网络出错");
      }
    },
    fail: function (res) {
      wx.hideNavigationBarLoading();
      console.log("wx.request fail res.errMsg: ",res.errMsg);
      console.log("wx.request fail res: ",res);

      var errmsg = res.errMsg.indexOf("request:fail");
      if (errmsg == 0) {
        toast.failedToast('网络异常！')
        return;
      }

      return typeof fail == "function" && fail(res.errMsg);
    }

  })
};



/*
 * 文件上传接口
 * filename: 上传文件名
 * fileurl
 * success:请求成功回调方法
 * fail：失败回调方法
 */
function upload(filename, fileurl, success, fail) {
  wx.showNavigationBarLoading();
  var tempToken = getApp().globalData.loginUserInfo.token;
  console.log("token: " + tempToken);
  wx.uploadFile({
    url: upLoadBaseUrl+"/teeke/upload",
    filePath: fileurl,
    name: 'upload',
    header: {
      'token': tempToken,
    },
    success: function (res) {
      wx.hideNavigationBarLoading();
      console.log("upload succeed:", res);
      var data = JSON.parse(res.data);
      return typeof success == "function" && success(data);
    },
    fail: function (res) {
      wx.hideNavigationBarLoading();
      console.log("upload failed:" + res.errMsg);
      return typeof fail == "function" && fail(res.errMsg);
    }

  })
};



//OK的
const baseUrl = 'https://car.10eke.com/member/api/';
const payUrl = 'https://car.10eke.com/unionpay/';

const upLoadBaseUrl = 'https://img.10eke.com';
const imgBaseUrl = 'https://img.10eke.com';


//公共网络请求方法、接口
module.exports = {
  request: request,
  upload: upload,
  apilist: {
    baseUrl: baseUrl,
    payUrl: payUrl,
    imgBaseUrl: imgBaseUrl,
    verifiCode: baseUrl + 'base/sendVerifyCode.json',// 发送验证码
    login: baseUrl + 'user/login.json',//登录
    register: baseUrl + 'user/register1.json',//注册，手机号码
    userInfo: baseUrl + "user/info.json",    //获取个人信息
    saveUseInfo: baseUrl + "user.json",   //个人信息保存


    /*支付相关*/
    unifiedOrder: payUrl + "uppay/unifiedOrder.json", //获取预支付参数
    getPayStatus: payUrl + 'uppay/query.json',//查询支付结果（微信和余额支付）

    homeurl: baseUrl + 'home/index.json',
    dicountList: baseUrl + 'coupon/pagelist.json',//优惠券列表
    loginOut: baseUrl + 'user/logout.json',//注销

  }
}