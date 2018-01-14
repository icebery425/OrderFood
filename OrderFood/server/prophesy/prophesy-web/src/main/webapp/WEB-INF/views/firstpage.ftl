<#include "*/layout/template.ftl"/>
<#macro title>世联BI主页</#macro>
<#macro head>
	<style>
		.w100{
			width:75px !important;
		}
	</style>
</#macro>

<#macro body>
<div class="show-welcome" style="display:none;"></div>
<div class="fixed-sidebar full-height-layout white-bg">




	</div>
	</#macro>
	
<#macro footer>

<script src="${ctx}/static/js/plugins/cityutil.js"></script>
<script src="${ctx}/static/js/module/plugins/macarons.js"></script>
<script src="${ctx}/static/js/index.js"></script>
<script>
	seajs.config({
        base: "${ctx}/static/js/module/",
        alias: {
            'echarts': 'plugins/echarts-all.js',
            'macarons': 'plugins/macarons.js',
            'shine': 'plugins/shine.js'
        }
    })

    $(document).ready(function () {

	    
	    
	    Index.init();
    	
    	if($(".wrapper").length==0){
    		$('.show-welcome').show();
    	}

		

	});

</script>
</#macro>
