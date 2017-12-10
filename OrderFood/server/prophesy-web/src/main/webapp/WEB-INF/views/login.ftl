<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8">
	
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>世联BI登录</title>
    <meta name="keywords" content="经营分析系统">
    <meta name="description" content="经营分析系统">

    <link href="${ctx}/static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="${ctx}/static/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">

    <link href="${ctx}/static/css/animate.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/style.min.css?v=3.2.0" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/static/iconfonts/iconfont.css">
    <link rel="stylesheet" href="${ctx}/static/css/mystyle.css">
<!--<script>if(window.top !== window.self){ window.top.location = window.location;}</script>-->
	<script src="${ctx}/static/js/jquery-2.1.1.min.js"></script>
	<script src="${ctx}/static/js/plugins/lizi/jquery.particleground.min.js"></script>
</head>

<body id="particles">
    <div class="middle-box loginscreen animated bounceInDown">
        <img src="static/img/logo.png" alt="">
        
        
        
        <div class="box">
            <form class="m-t" role="form" action="${ctx}/login" method="post" onsubmit="return validate()"><!--action="index.html"-->
                <div class="form-group login-control">
                    <i class="iconfont icon-account"></i>
                    <input type="text" name="username" class="form-control" placeholder="工号/帐号" required="">
                </div>
                <p class="errtip1" style="width:100%;display:none;padding:8px;color:#d9534f;border-radius: 4px;margin-top:-20px;"></p>
                <div class="form-group login-control">
                    <i class="iconfont icon-mima"></i>
                    <input type="password" name="password" class="form-control" placeholder="密&nbsp;&nbsp;码" required="">
                </div>
                <p class="errtip2" style="width:100%;display:none;padding:8px;color:#d9534f;border-radius: 4px;margin-top:-20px;"></p>
                <div class="form-group login-control">
                    <label class="checkbox-inline">
                        <input type="checkbox" style="position: absolute;margin-left:-20px;margin-top:3px;padding-left:0\9\0;" id="inlineCheckbox1" value="option1"> 记住密码
                    </label>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登&nbsp;&nbsp;录</button>
                <#if shiroLoginFailure?has_content>
					<div id="loginInfo" class="alert alert-danger ">
						<button class="close" data-close="alert"></button>
						<span>  ${shiroLoginFailure} </span>
					</div>
				</#if>
            </form>
        </div>
    </div>
	<p class="Right">版权所有©2016版深圳世联行地产顾问股份有限公司</p>
    <!-- /.modal -->
    <div class="modal" id="loading" tabindex="-1">

    </div>

    <!--loading-->
    <div class="sk-spinner sk-spinner-fading-circle" style="position:absolute;z-index:2041;top:50%;left:50%;transform:translate(-50%,-100%);display:none;">
        <div class="sk-circle1 sk-circle"></div>
        <div class="sk-circle2 sk-circle"></div>
        <div class="sk-circle3 sk-circle"></div>
        <div class="sk-circle4 sk-circle"></div>
        <div class="sk-circle5 sk-circle"></div>
        <div class="sk-circle6 sk-circle"></div>
        <div class="sk-circle7 sk-circle"></div>
        <div class="sk-circle8 sk-circle"></div>
        <div class="sk-circle9 sk-circle"></div>
        <div class="sk-circle10 sk-circle"></div>
        <div class="sk-circle11 sk-circle"></div>
        <div class="sk-circle12 sk-circle"></div>
    </div>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js?v=3.4.0"></script>
    <script>
    	var content = '${ctx}';
        $(function(){
       		$('#particles').particleground({
			    dotColor: '#08324b',
			    lineColor: '#08324b'
			  });
            var regUser = /^\d{7}$/;
            var regPassword = /^\w{6,20}$/;
            /*获取焦点判断*/
            $('input').focus(function(){
                if($(this).val() == ''){
                    $(this).closest('div').next('p').hide();
                }
            })
            /*失焦判断*/
            $('input').each(function(){
                $(this).blur(function(){
                    if($(this).val() == ''){
                        $(this).closest('div').next('p').hide();
                    }
                })
            })
            /*输入中判断*/
            $('input:text').keyup(function(){
            	/*
                if(!regUser.test($(this).val())){
                    $('.errtip1').show().text('请输入正确的帐号！');
                    return false;
                }else{
                    $('.errtip1').hide();
                }
                */
            })
            $('input:password').keyup(function(){
            /*
                if(!regPassword.test($(this).val())){
                    $('.errtip2').show().text('请输入正确的密码！');
                    return false;
                }else{
                    $('.errtip2').hide();
                }
            */
            
            })
        });
        
        function validate(){
 			/*对输入框判断*/
 			if(!$(':text').val()){
 				$(".errtip1").show().text('请输入正确的帐号！');
 				return false;
 			}
 			if(!$(':password').val()){
 				$(".errtip2").show().text('请输入正确的密码！');
 				return false;
 			}
            /*
            if(!regUser.test($(':text').val())){
                $('.errtip1').show().text('请输入正确的帐号！');
                return false;
            }
            if(!regPassword.test($(':password').val())){
                $('.errtip2').show().text('请输入正确的密码！');
                return false;
            }
            */
		  	/* 蒙层...*/
            $("#loading").modal({
                /*防止点击遮罩隐藏*/
                backdrop:'static',
                /*防止esc遮罩隐藏*/
                keyboard:false
            });
            /* loading...*/
            $('.sk-spinner').show();
	    	return true;
    	}
    </script>

</body>

</html>