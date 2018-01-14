//刷新tableau 服务器session的js

var Tableau = function () {

var TABLEAU_PAGE_URL_STR = "testTableau";

var timerIsClear = false;

/**
 * 菜单点击事件监听，监听嵌入bi的tableau菜单点击，
 * 如果点击了tableau菜单，则开启定时器
 */
var initMenuClickListener =  function(){

    $("#side-menu .nav-second-level li a").click(function() {

        var url = $(this).attr("url");

        if (url.indexOf(TABLEAU_PAGE_URL_STR) > 0 && !timerIsClear) {

            timerIsClear = true;

            //点击了嵌入的tableau菜单，开启定时器
            var tableauTimer = window.setInterval(function () {

                //定时时间到，判断是否还有打开的tableau页面，
                //有：则刷新隐藏的tableau页面，保证session有效
                //没有：则关闭定时器
                if (isOpenTableauPage()) {
                    //定时时间到，判断是否还有打开的tableau页面
                    document.getElementById('tableauIframe').src = globalCtx + "/test/testTableau/views{@}_20170419{@}1/:iid=1";
                } else {
                    timerIsClear = false;
                    window.clearInterval(tableauTimer);
                }
            }, 1000 * 60 * 60 * 3);

        }

    });

};


/**
 * 判断是否有打开的tableau页面
 * 有： true
 * 没有： false
 */
function isOpenTableauPage() {
    var tabs = $(".J_menuTabs").find("a");
    var flag = false;
    $.each(tabs, function(i, item){
        var url = $(item).attr("data-id");
        //先对url进行格式化，再进行判断
        if(url.indexOf(TABLEAU_PAGE_URL_STR)>0){
            flag = true;
            return false;
        }
    })

    return flag;
}


    return {
        initMenuClickListener: initMenuClickListener
    }

}()