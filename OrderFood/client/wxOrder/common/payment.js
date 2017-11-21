var toast = require('../utils/toastUtil.js')
var netWork = require('../common/netWork.js')
var constant = require('../common/constant.js')

var gOrderId = -1;
var searchPaydepositCount = 1;
var searchRechargeCount = 1;
var gPayParam = null;
var gMchOptKey = "81f0add3-4d8c-4944-b3ae-fdfa436d9bdf";

var gT1 = null; //重复执行查询操作
var gT2 = null; //设置查询超时30S

var searchType = 1;

const PAY_STATUS_UNPAY = 100; //未付款
const PAY_STATUS_PAYING = 500; //付款中
const PAY_STATUS_PROCESSING = 600; //处理中
const PAY_STATUS_SUCCEED = 900; //已付款
const PAY_STATUS_FAILED = 920; //支付失败


/*
 * 支付入口
 * searchType:查询方案 1微信余额 2押金 3充值
 * paytype:  支付类型, 1.微信支付; 2. 余额支付
 * orderId:  支付订单编号
 * billType: 订单类型   PAYORDER(订单支付)  CHARGEORDER(创建充值单)
 * skuName:  支付商品描述
 * amount:　 支付金额
 * pwd:      支付密码（仅余额支付使用）
 * success:  支付成功回调方法
 * fail：    支付失败回调方法
 */
function wxpay(tsearchType, paytype, orderId, billType, skuName, amount, pwd, entityId, succee, fail) {
  wx.showNavigationBarLoading();

  var param;
  searchType = tsearchType
  wxpay = orderId;
  gOrderId = orderId;
  console.log("wxpay订单编号" + wxpay);
  if (paytype == 1) {
    param = prepareWxPayParam(orderId, billType, ' ', skuName, amount, entityId);
    wxUnifiedOrder(param, succee, fail);
  } else if (paytype == 2) {
    prepareBalancePayParam(orderId, pwd, succee, fail);
  } else {
    fail("支付类型出错")
  }
};

/*
 * 准备微信支付参数
 * paytype: 上传文件名
 * orderId: 
 * success:请求成功回调方法
 * fail：失败回调方法
 */
function prepareWxPayParam(orderId32, billType, storeId, skuName, price, entityId) {
  var app = getApp();
  var tempArr = [], res;
  if (orderId32 !== "") {
    tempArr.push("{");
    tempArr.push("billNumber:" + "\"" + orderId32 + "\"");
    tempArr.push(",sourceSys:" + "\"API\"");
    tempArr.push(",describe:" + "\"" + skuName + "\"");
    tempArr.push(",billType:" + "\"" + billType + "\"");
    tempArr.push(",amount:" + price);
    tempArr.push(",invokeType:" + "\"" + "JSAPI" + "\"");
    tempArr.push(",thirdPartyType:" + "\"" + "WEIXIN" + "\"");
    tempArr.push(",attach:" + "\"" + "entityId:" + entityId + "\"");
    tempArr.push(",openid:" + "\"" + app.globalData.loginUserInfo.openId + "\"");
    console.log('payment ' + constant.loginKeys.openId);
    tempArr.push(",payType:" + "\"WEIXIN\"");
    tempArr.push(",mchOptKey:" + "\"" + gMchOptKey + "\"");
    tempArr.push(",noncestr:" + "\"" + randomWord(false, 6) + "\"");

    //tempArr.push(",storeId:" + "\"" + storeId + "\"");

    tempArr.push("}");
    res = tempArr.join('');
  }

  return res;
}


/*
 * 准备余额支付参数
 * paytype: 上传文件名
 * orderId: 支付订单
 * success:请求成功回调方法
 * fail：失败回调方法
 */
function prepareBalancePayParam(orderid, pwd, success, fail) {
  var params = {
    orderId: orderid,
    password2: pwd,
  };

  netWork.request(1, netWork.apilist.getBalanceParam, params,
    function (res) {
      if (res.status) {
        console.log("获取余额支付参数成功");
        var payparam = res.data.info.payParam;
        if (payparam !== null && payparam !== undefined) {
          gPayParam = payparam;
          balanceUnifiedOrder(gPayParam, success, fail);
        } else {

          fail(res);
        }
      }
    },
    function (res) {
      fail(res);
    })
}

/*
 * 准备余额支付
 * params: 支付参数
 * succee: 支付成功回调
 * fail: 支付失败回调 
 */
function balanceUnifiedOrder(params, succee, fail) {
  var params = {
    args: params,
  };

  netWork.request(1, netWork.apilist.unifiedOrder, params,
    function (res) {

      succee(res);


    },
    function (res) {
      fail(res);
      // if (res.err_code_msg != null) {

      //   toast.showToast(res.err_code_msg);

      // } 
      
      // else if (res.code != null) {

      //   if (res.code == 'ACCOUNT_NOT_ENOUGH') {

      //     toast.showToast('用户余额不足');

      //   } else if (res.code == 'ACCOUNT_NOT_INIT') {

      //     toast.showToast('余额帐号未开通');

      //   } else if (res.code == 'ACCOUNT_CASHFLOW_CREATEERROR') {

      //     toast.showToast('创建余额记录失败');
      //   }

      // } else {
      //   toast.showToast('余额支付失败');
      // }

    })
}

/*
 * 获取微信预支付信息,准备支付
 * params: 支付参数
 * succee: 支付成功回调
 * fail: 支付失败回调
 */
function wxUnifiedOrder(params, succee, fail) {
  var params = {
    args: params,
  };

  netWork.request(1, netWork.apilist.unifiedOrder, params,
    function (res) {
      if (res.status) {
        console.log("获取预支付参数成功");
        var payparam = res.data.info.prepay_id;
        if (payparam !== null) {
          gPayParam = payparam;
          var prepayId = parsePayInfo(payparam);
          console.log('timeStamp: ' + prepayId.timeStamp 
          + '  nonceStr: ' + prepayId.nonceStr + 
          '   signType: ' + 'MD5  ' + 'package: ' + prepayId.package + ' paySign: ' + prepayId.sign);

          wx.requestPayment({
            'appId': "wx90a5707a5694de7c",
            'timeStamp': prepayId.timeStamp + '',
            'nonceStr': prepayId.nonceStr,
            'package': prepayId.package,
            'signType': 'MD5',
            'paySign': prepayId.sign,
            'success': function (res) {

              if (searchType == 1) {

                searchPayResult(succee, fail);

              } else if (searchType == 2) {
                //押金
                searchPaydepositResult(succee, fail);
                // succee('押金充值完成');
              } else if (searchType == 3) {
                //充值
                searchRechargeResult(succee, fail);
                // succee('充值完成');
              }

              dealTimeOut();

            },

            'fail': function (res) {
              console.log(res);
              fail(res);
            }
          })

        } else {
          
          fail(res);
        }
      }
    },
    function (res) {
      fail(res);
      
    })
}

//微信、余额支付结果查询
function searchPayResult(succee, fail) {

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

//充值结果查询
function searchRechargeResult(succee, fail) {
  var count = searchRechargeCount;
  gT1 = setInterval(function () {
    var params = {
      number: gOrderId,
    };

    netWork.request(0, netWork.apilist.searchRechargeResult, params,
      function (res) {

        if (res.status) {

          if (res.data.info.status == true) {

            succee('充值结果查询成功');
            clearTimeOut();

            
          } else {
            // fail('充值结果查询失败');
            searchRechargeCount = count + 1;
            if (gT1 == 30) {
              fail('充值结果查询失败');
              wx.hideLoading();
              wx.hideNavigationBarLoading();
              clearTimeOut();
            }
          }
        }
      },
      function () {
        fail('充值结果查询失败');
        clearTimeOut();
      })

  }, 2000)
}

//押金结果查询
function searchPaydepositResult(succee, fail) {

  wx.showLoading({
    title: '正在支付...',
  })

  var count = searchPaydepositCount;

  gT1 = setInterval(function () {
    var params = {
      number: gOrderId,
      count:count,
    };

    netWork.request(0, netWork.apilist.searchPaydepResult, params,
      function (res) {

        if (res.status) {

          if (res.data.info.status == true) {

            succee('押金结果查询成功');
            clearTimeOut();

          } else {
            searchPaydepositCount=count+1;

            if (gT1 == 30){
              fail('押金结果查询失败');
              wx.hideLoading();
              wx.hideNavigationBarLoading();
              clearTimeOut();
            }

          }
        }
      },
      function () {
        fail('押金结果查询失败');
        clearTimeOut();
      })

  }, 2000)

}

function dealTimeOut() {

  gT2 = setTimeout(function () {

    clearTimeOut();

  }, 30000);
}


function clearTimeOut() {
  clearInterval(gT1);
  clearTimeout(gT2);
  toast.hideProgressToast();
}

/*
 * 解析从后台获取到的预支付参数,用于调用微信支付
 * 
 */
function parsePayInfo(prepayId) {
  var data;
  if (prepayId != "") {
    data = JSON.parse(prepayId);
  }

  return data;
}



/*
** randomWord 产生任意长度随机字母数字组合
** randomFlag-是否任意长度 min-任意长度最小位[固定位数] max-任意长度最大位
** 
*/
function randomWord(randomFlag, min, max) {
  var str = "",
    range = min,
    arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];

  // 随机产生
  if (randomFlag) {
    range = Math.round(Math.random() * (max - min)) + min;
  }
  var pos = 0;
  for (var i = 0; i < range; i++) {
    pos = Math.round(Math.random() * (arr.length - 1));
    str += arr[pos];
  }
  return str;
}


module.exports = {
  wxpay: wxpay,
  randomWord: randomWord,
}