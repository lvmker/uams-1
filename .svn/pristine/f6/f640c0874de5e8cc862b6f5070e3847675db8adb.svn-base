$(function(){
	$.ajaxSettings.async = false;
	$.getJSON("sys/buildMenusFront.action",null,function msg(json){
		if(json.rows)
		{
			$.each(json.rows, function(i, n) {
				if(i<=5)
				{
					$("#nav").append("<li><a href='javascript:;' onclick='openMenu(\""+n.url+"\")'>"+n.text+"</a></li>");	
					if(n.url=='manage/ais/ais.jsp'){
						isAis = true
					}
				}
			});
		}
	});
	if(isAis){
		$("#nav").append("<li><a href='https://pan.genomics.cn/ucdisk/s/ae2euy' target='view_window' onclick=''>"+'帮助'+"</a></li>");
		$("#nav").append("<li><a href='https://pan.genomics.cn/ucdisk/s/ae2euy' target='view_window' onclick=''>"+'FAQ'+"</a></li>");
		openMenu('manage/ais/ais.jsp')
	}
	$.ajaxSettings.async = true;
	})
function openMenu(url)
{
	$("#mainFrame",document.body).attr("src",url);
}