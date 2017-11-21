
//同步存储
function setStorage(tKey,tValue){
  wx.setStorage({
    key: tKey,
    data: tValue,
  })
}

//同步取值
function getStorage(tKey){
  var _value;
  wx.getStorage({
    key: tKey,
    success: function(res) {
      _value = res.data;
    },

  })
  return _value;
}

//同步删除存储值
function removeStorage(tKey){
  wx.removeStorage({
    key: tKey,
    success: function(res) {},
  })
}

//异步存储
function setStorageSync(tKey,tValue){
  try {
    wx.setStorageSync(tKey, tValue)
  } catch (e) {
    console.log('异步存储'+tKey+':'+tValue+'异常');
  }
}

//异步取值..



//异步删除
function removeStorageSync(tKey){
  try {
    wx.removeStorageSync(tKey)
  } catch (e) {
    console.log('异步删除'+tKey+'异常');
  }
}

//同步清理本地缓存
function removeLocalStorage(){
  wx.clearStorage();
}

//异步清理本地缓存
function removeLocalStorageSync(){
  wx.clearStorageSync();
}

module.exports = {
  setStorage: setStorage,
  getStorage: getStorage,
  removeStorage: removeStorage,
  setStorageSync: setStorageSync,
  removeStorageSync: removeStorageSync,
  removeLocalStorage: removeLocalStorage,
  removeLocalStorageSync: removeLocalStorageSync,
}