$(function() {
	var indexinit = 100;
    function t(t) {
        var e = 0;
        return $(t).each(function() {
            e += $(this).outerWidth(!0)
        }),
        e
    }
    function e(e) {
    	var _parent = $(parent.document);
        var a = t($(e).prevAll()),
        i = t($(e).nextAll()),
        n = t(_parent.find(".content-tabs").children().not(".J_menuTabs")),
        s = _parent.find(".content-tabs").outerWidth(!0) - n,
        r = 0;
        var _ptcontent = _parent.find(".page-tabs-content");
        if (_ptcontent.outerWidth() < s) r = 0;
        else if (i <= s - $(e).outerWidth(!0) - $(e).next().outerWidth(!0)) {
            if (s - $(e).next().outerWidth(!0) > i) {
                r = a;
                for (var o = e; r - $(o).outerWidth() > _ptcontent.outerWidth() - s;) r -= $(o).prev().outerWidth(),
                o = $(o).prev()
            }
        } else a > s - $(e).outerWidth(!0) - $(e).prev().outerWidth(!0) && (r = a - $(e).prev().outerWidth(!0));
        _ptcontent.animate({
            marginLeft: 0 - r + "px"
        },
        "fast")
    }
    
    
	function ninner(t, a, i, _parent) {
		n = !0;
        if (void 0 == t || 0 == $.trim(t).length) return ! 1;
        if(!_parent){
        	_parent = $(parent.document);
        }
        var jmenuTabs = _parent.find(".J_menuTab");
        if (jmenuTabs.each(function() {
            return $(this).data("id") == t ? ($(this).hasClass("active") || ($(this).addClass("active").siblings(".J_menuTab").removeClass("active"), e(this), _parent.find(".J_mainContent .J_iframe").each(function() {
                return $(this).data("id") == t ? ($(this).show().siblings(".J_iframe").hide(), !1) : void 0
            })), n = !1, !1) : void 0
        }), n) {
            var s = '<a href="javascript:;" class="active J_menuTab" data-id="' + t + '">' + i + ' <i class="icon iconfont icon-iconfontguanbi2" style=""></i></a>';
            jmenuTabs.removeClass("active");
            var r = '<iframe class="J_iframe" name="iframe' + a + '" width="100%" height="100%" src="' + t + '" frameborder="0" data-id="' + t + '" seamless></iframe>';
            _parent.find(".J_mainContent").find("iframe.J_iframe").hide().parents(".J_mainContent").append(r);
            var o = {};
            _parent.find(".J_mainContent iframe:visible").load(function() {
//                layer.close(o)
            }),
            _parent.find(".J_menuTabs .page-tabs-content").append(s),
            e(_parent.find(".J_menuTab.active"))
        }
        return ! 1
	}
	/*function gw(){
//		$(".J_gridItem").unbind("click").bind("click", function(event){
		var t = $(this).attr("href"),
        a = $(this).attr("tabid") + indexinit++,
        i = $.trim($(this).attr("tabname"));
		return ninner(t, a, i);
//		})
	}*/
	function gt(){
		var t = $(this).attr("href");
		var _parent = $(parent.document);
		if(_parent.find("#content-main").length == 0){
			_parent = $(parent.parent.document);
		}
		var tt = t.indexOf("?")>0? t.substr(0, t.indexOf("?")) : t;
		var _link = _parent.find("#side-menu").find("a[href='"+tt+"']");
		if(_link.length > 0){
			_link.parents("ul:eq(0)").show().parent().addClass("active").siblings().removeClass("active");
			var a = _link.attr("data-index"), i = _link.text();
			if(!a){
				a = $(this).attr("tabid") + indexinit++;
			}
			if(!i){
				i = $.trim($(this).attr("tabname"));
			}
			return ninner(t, a, i, _parent);
		}else {
			var a = $(this).attr("tabid") + indexinit++,
	        i = $.trim($(this).attr("tabname"));
			return ninner(t, a, i, _parent);
		}
	}
	
	$(".dataTable").on("click", ".J_gridItem", gt)
	$(".J_tabItem").on("click", gt)
    
});