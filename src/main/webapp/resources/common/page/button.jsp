<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//定义校验框最长字符串的提示
	$.extend($.fn.validatebox.defaults.rules, {     
	    maxLength: {     
	        validator: function(value, param){     
	            return param[0] >= value.length;     
	        },     
	        message: '请输入最大{0}位字符.'    
	    }     
	}); 
    //自定义表格列的宽度
	var createUserWidth=90;
	var createTimeWidth=140;
	var lastModifiedWidth=120;
	var resource='${disabledResourceName}';
	resource=resource.substring(1,resource.length-1).split(",");
	$('a').each(function(){
		//获得name值
		for(var i=0;i<resource.length;i++){
			if(resource[i].trim()==$(this).attr("name"))
			{
				//设置不可用
				$(this).hide();
				break;
			}
		}
	});
	
	$('#rightClickmenu div').each(function(){
		//获得name值
		for(var i=0;i<resource.length;i++){
			if(resource[i].trim()==$(this).attr("name"))
			{
				//设置不可用
				//$(this).attr("disabled",true);
				$(this).hide();
				break;
			}
		}
	});
</script>

