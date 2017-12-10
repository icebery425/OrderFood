<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
﻿<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>世联BI主页</title>
	<style>
		body {font-family: "Microsoft YaHei","iconfont"  !important;}
		@font-face {  font-family: 'Microsoft YaHei';  src: url('${ctx}/static/font/fontawesome-webfont.eot') format('eot'),url('${ctx}/static/font/fontawesome-webfont.woff2') format('woff2'),url('${ctx}/static/font/glyphicons-halflings-regular.woff2') format('woff2')}
	</style>
    <meta name="keywords" content="BI系统">
    <meta name="description" content="BI系统">

    <!--[if lt IE 8]>
    <script>
        alert('本系统已不支持IE6-8，请使用谷歌、火狐等浏览器\n或360、QQ等国产浏览器浏览本页面！');
    </script>
    <![endif]-->

    <link href="${ctx}/static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <!--<link href="${ctx}/static/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">-->
    <link rel="stylesheet" href="${ctx}/static/iconfonts/iconfont.css">
    <link href="${ctx}/static/css/animate.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/common.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.min.css?v=3.2.0" rel="stylesheet">
</head>

<!-- 菜单宏定义 -->
<#macro recursionMenu menu id=false>
    <#if menu.leaf>
        <ul class="nav nav-second-level">
	        <#list menu.children as c>
	            <li>
	                <a class="J_menuItem" <#if c.id??>id="${c.id}"</#if>
	                   href="${ctx}/${c.value?substring(1,c.value?length - 3)}"
	                   url="${ctx}/${c.value?substring(1,c.value?length - 3)}">${c.name}</a>
	                <@recursionMenu c />
	            </li>
        	</#list>
        </ul>
    </#if>
</#macro>

<body class="fixed-sidebar full-height-layout gray-bg">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation" style="position:absolute;">
            <div class="nav-close"><i class="icon iconfont times-circle" style="">&#xe68b;</i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <div style="color: #6d8292; margin-bottom: 10px;">
							    	欢迎<span style="color: #78cc40;"><#if Session["sv"]??>${Session["sv"].staff.staffname}</#if></span>来到BI系统
							</div>
                            <img alt="image" src="${ctx}/static/img/logo-color.png" style="width:150px;"/>
                        </div>
                        <div class="logo-element">
                            <img src="${ctx}/static/img/logo.jpg" alt="" style="width:44px;height:44px;">
                        </div>
                    </li>
                    <!--此处继续添加-->
					<!-- 设置菜单 -->
					
					<#list menusList as m>
		                <li>
							<a href="###">
					            <!--<i class="icon iconfont icon-mingdanshuju" style=""></i>
					            <i class="icon iconfont icon-xiaoiconzhexiantu" style="">&#xe639;</i>-->
					            <i class="<#if m.icon??>icon iconfont  ${m.icon} </#if>" style=""></i>
					            <span class="nav-label">${m.name}</span>
					            <span class="icon iconfont icon-fanhui" style="color:#999;float:right;font-size:13px;"></span>
					        </a>
		                    <@recursionMenu m />
		                </li>
		            </#list>

                </ul>
            </div>
            <div class="navbar-minimalize"></div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft">
                <i class="icon iconfont icon-houtui" style="color:#999;"></i>
                </button>
	  		
                <nav class="page-tabs J_menuTabs">
                
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="index">首页</a>
                    </div>
                </nav>
                
                <button class="roll-nav roll-right J_tabRight">
                <i class="icon iconfont icon-qianjin-copy" style="color:#999;"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    	<li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="${ctx}/syslogout" class="roll-nav roll-right J_tabExit"><i class="icon iconfont icon-close" style="color:#999;margin-right:2px;"></i>退出</a>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="home" frameborder="0" data-id="index" seamless></iframe>
            </div>
            <div class="footer">
                <div class="pull-right">&copy;2016-2017 <a href="index" target="_blank">worldunion</a>
                </div>
            </div>
        </div>
        <!--右侧部分结束-->
        <!--右侧边栏开始-->

        <iframe id="tableauIframe" class="J_iframe" name="iframe-tableau" style="display:none" src="#"></iframe>


    </div>
    

    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <script src="static/js/bootstrap.min.js?v=3.4.0"></script>
    <script src="static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="static/js/layer2.2/layer.js"></script>
	<script src="static/js/layer2.2/extend/layer.ext.js"></script>

    <!-- 自定义js -->
    <script src="static/js/hplus.min.js?v=3.2.0"></script>
    <script type="text/javascript" src="static/js/contabs.min.js"></script>


    <!-- 第三方插件 -->
    <script src="static/js/plugins/pace/pace.min.js"></script>


    <script src="${ctx}/static/js/tableau.js"></script>

    <script>

        var globalCtx = "${ctx}";

         $(function(){
            $('.nav-second-level').hide().prev('a').click(function(){
	            $('.nav-second-level').css({'height':'auto'});
                var navLevel = $(this).next('.nav-second-level');
                $(this).parent().siblings().find(".nav-second-level").not(navLevel).slideUp();
                navLevel.slideToggle(350);
            })

        })


        /*window.setTimeout(function () {
            Tableau.initMenuClickListener();
        },1000*5);*/

    </script>


</body>

</html>
