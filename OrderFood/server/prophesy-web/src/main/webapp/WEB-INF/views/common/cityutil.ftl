
<style>
    .search_form_suggest {
	    border: 1px solid #ccc;
	    position: absolute;
	    top: 32px;
	    left: 0;
	    z-index: 978;
	    width: 376px;
	    padding: 5px 0px;
	    background: #fff;
	    
	}
	.tab_select {
	    height: 300px;
    	overflow-y: auto;
    	margin-top: 30px;
    	border-top: 1px solid #ccc;	
	}
	.tab_select dl {
	    padding: 5px 0;
	   	margin:5px 0 0 10px;
	}
	.tab_select dt {
	    width: 46px;
	    background: #ccc;
	    font: bold 12px/22px Tahoma, Geneva, sans-serif;
	    color: #fff;
	    text-align: center;
	    margin:0 0 10px 5px;
	    border-radius: 3px;
	}
	.tab_select dd {
	    width: 330px;
	    _width: 330px;
	}
	dd {
	    display: block;
	    -webkit-margin-start: 40px;
	}
	.tab_select dd a {
	    color: #333;
	    margin-left: 10px;
	    display: inline-block;
	}
	a:link, a:visited {
    /* color: #0fa7ff; */
	    text-decoration: none;
	    outline: none;
	    cursor: pointer;
	}
	.thRight {
	    float: right;
	}
	.clr_after{
		margin: 0;
	}
	.city_block{
		display: inline-block;
		cursor: pointer;
		margin:0 10px 0 22px;
		position:relative;
	}
	.close{
	position: absolute;
    top: 7px;
    right: 0px;
    cursor: pointer;
    font-size: 12px;
    text-align: center;
    color: #fff;
    box-sizing: border-box;
    width: 22px;
    height: 22px;
    line-height: 20px;
    border-radius: 4px;
    background: #333;
	}
	.close:hover{
		color:#fff;
	}
    </style>



<div class="form-group" style="position: relative; z-index:999">
    <label class="control-label min-w90 ta-right" style="padding-top: 0px; margin-top: -3px;">城市</label>
    <span class="chartCity">
    	<div class="city_block">
    		<input type="checkbox" value="*" class="allCity" checked/>
			<span>不限</span>
		</div>
		
    	<#if isallcity && isallcity==true>
    		<div class="city_block">
	    		<input type="checkbox" value="1"/>
	    		<span>深圳市</span>
			</div>
			<div class="city_block">
	    		<input type="checkbox" value="3"/>
	    		<span>北京市</span>
			</div>
			<div class="city_block">
	    		<input type="checkbox" value="4"/>
	    		<span>上海市</span>
			</div>
			<div class="city_block">
	    		<input type="checkbox" value="2"/>
	    		<span>广州市</span>
			</div>
			<div class="city_block">
	    		<input type="checkbox" value="8"/>
	    		<span>惠州市</span>
			</div>
		<#else>
	    	<#if citys??>
	            <#list citys as ct>
	            	<#if ct_index<5>
	            		<div class="city_block">
				    		<input type="checkbox" value="${(ct.cityid)?c}"/>
				    		<span>${ct.cityname}</span>
						</div>
	            	</#if>
	            </#list>
	        </#if>
        </#if>
	</span>
    <a href="###" class="moreCity blue"<#if (citys?size<5)>style="display:none;"</#if> >更多城市&gt;&gt;</a>
    <div class="search_form_suggest moreDiv" style="display: none;left: 177px;top: 34px; text-align: left;z-index:1000;border-radius: 5px; box-shadow: rgba(0, 0, 0, 0.172549) 0px 6px 12px;">

        <h3 style="padding-bottom:1px;"><a class="thRight close">X</a></h3>
		
		<div class="box-control" style="padding:0;">
	        <div class="thLeft thPadT5 tab_select">
	            <dl class="clrfix">
	                <dt>A-G</dt>
	                <dd class="clr_after">
	                    <#if citys??>
	                            <#list citys as ct>
	                                  <#list ["A","B","C","D","E","F","G"] as j>
	                                        <#if j= ct.firstname>
	                                        <div class="city_block">
	                                            <input type="checkbox" value="${(ct.cityid)?c}"/>
												<span>${ct.cityname}</span>
												</div>
	                                        </#if>
	                                  </#list>
	                            </#list>
	                    </#if>
	                </dd>
	            </dl>
	            <dl class="clrfix">
	                <dt>H-L</dt>
	                <dd class="clr_after">
	                    <#if citys??>
	                        <#list citys as ct>
	                            <#list ["H","I","J","K","L"] as j>
	                                <#if j= ct.firstname>
	                                    <div class="city_block">
	                                        <input type="checkbox" value="${(ct.cityid)?c}"/>
											<span>${ct.cityname}</span>
										</div>
	                                </#if>
	                            </#list>
	                        </#list>
	                    </#if>
	                </dd>
	            </dl>
	            <dl class="clrfix">
	                <dt>M-T</dt>
	                <dd class="clr_after">
	                    <#if citys??>
	                        <#list citys as ct>
	                            <#list ["M","N","O","P","Q","R","S","T"] as j>
	                                <#if j= ct.firstname>
	                                    <div class="city_block">
	                                        <input type="checkbox" value="${(ct.cityid)?c}"/>
											<span>${ct.cityname}</span>
										</div>
	                                </#if>
	                            </#list>
	                        </#list>
	                    </#if>
	                </dd>
	            </dl>
	            <dl class="clrfix">
	                <dt>W-Z</dt>
	                <dd class="clr_after">
	                    <#if citys??>
	                        <#list citys as ct>
	                            <#list ["U","V","W","X","Y","Z"] as j>
	                                <#if j= ct.firstname>
	                                    <div class="city_block">
	                                        <input type="checkbox" value="${(ct.cityid)?c}"/>
											<span>${ct.cityname}</span>
										</div>
	                                </#if>
	                            </#list>
	                        </#list>
	                    </#if>
	                </dd>
	            </dl>
	        </div>
        </div>
    </div>
</div>