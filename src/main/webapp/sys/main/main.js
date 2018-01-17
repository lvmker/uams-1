$(function(){
	tabClose();
	tabCloseEven();
	InitLeftMenu();
})
//初始化左侧
var _menus=new Array();
function InitLeftMenu() {
	//获取菜单
	$.ajaxSettings.async = false;
	$.getJSON("sys/buildMenus.action",null,function msg(json){
		//将json字符串转为对象
		if(json.success=='false')
		{
			return false;
		}
		_menus=jQuery.parseJSON(json.msg);
		var tmp='';
		if(_menus)
		{
			$.each(_menus.children, function(i, n) {//$.each 遍历_menu中的元素
				var menulist ='<ul class="easyui-tree" lines="false" id="ttttt'+i+'">';
				menulist += '</ul>';
				$('#aa').accordion('add', {
		            title: n.text,
		            content: menulist,
		            iconCls: 'icon ' + n.iconCls
		        });
		        $('#ttttt'+i).tree({data:n.children});
		    });
		}
	});
	$.ajaxSettings.async = true;
	$('.easyui-accordion li a').click(function(){//当单击菜单某个选项时，在右边出现对用的内容
		var tabTitle = $(this).children('.nav').text();//获取超链里span中的内容作为新打开tab的标题
		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");//获取超链接属性中ref中的内容
		addTab(tabTitle,url,'icon '+menuid);//增加tab
		$('.easyui-accordion li div').removeClass("tree-node-selected2");
		$(this).parent().parent().addClass("tree-node-selected2");
	});
	//选中第一个
	var panels = $('#aa').accordion('panels');
	if(panels[0])
	{
		var t = panels[0].panel('options').title;
    	$('#aa').accordion('select', t);
	}
}

function addTab(subtitle,url,icon){
	var tmp=new Date().getTime();//ID
	if(!$('#tabs').tabs('exists',subtitle)){
		$('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(tmp,url),
			closable:true,
			icon:icon
		});
	}else{
		$('#tabs').tabs('select',subtitle);
		$('#mm-tabupdate').click();
	}
	loadProgress(tmp);
	setTimeout("showPage('"+tmp+"')",1000);//2S之后隐藏遮罩
	tabClose();
}

function loadProgress(tmp)
{
	$('#'+tmp+'content').removeClass('fullwidth');  
	$('#'+tmp+'content').removeClass('fullwidth').delay(100).queue(function(next){
		$(this).addClass('fullwidth');
        next();
	});
	
}
function showPage(tmp)
{
	$('#'+tmp).hide();
}

function createFrame(tmp,url)
{
	var s = '<div id="'+tmp+'" style="position:absolute;left:0;top:0;width:100%;height:100%;background:#ccc;filter:alpha(opacity=40);opacity: 0.40;">' +
	'<div id="'+tmp+'content" style="position:fixed;width:100%;height:10px;margin:0px auto;"><span class="expand"></span></div>' +
	'<div style="position:fixed;top:50%;left:50%;margin-left:0px;margin-top:-62px"><image src="resources/images/loading.gif"/></div></div>'
	+'<iframe id="adslxp" scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	})
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#tabs').tabs('select',subtitle);
		return false;
	});
}
//绑定右键菜单事件
function tabCloseEven()
{
	//刷新
	$('#mm-tabupdate').click(function(){
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url)
		{
			$('#tabs').tabs('update',{
				tab:currTab,
				options:{
					content:createFrame(url)
				}
			})
		}
	})
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	})
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			if(t!='我的桌面')
			{
				$('#tabs').tabs('close',t);
			}
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			msgShow('系统提示','后面没有啦~~','error');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			if(t!='我的桌面')
			{
				$('#tabs').tabs('close',t);
			}
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			msgShow('系统提示','前面没有啦~~','error');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			if(t!='我的桌面')
			{
				$('#tabs').tabs('close',t);
			}
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

function addOpenPanel(){
	$(window.parent.document).contents().find("#mainFrame")[0].contentWindow.openPanel();
}
function saveDesktop(){
	$(window.parent.document).contents().find("#mainFrame")[0].contentWindow.saveDesktopOrder();
}
function showMsg(title,msg){
    $.messager.show({
        title:title,
        msg:msg,
        showType:'fade',
        timeout:10000,//10S
        width:500,
	    height:350,
        style:{
            right:'',
            bottom:''
        }
    });
}

//时间
function Clock() {
	var date = new Date();
	this.year = date.getFullYear();
	this.month = date.getMonth() + 1;
	this.date = date.getDate();
	this.day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[date.getDay()];
	this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
	this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
	this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

	this.toString = function() {
		return "" + this.year + "年" + this.month + "月" + this.date + "日 " + this.hour + ":" + this.minute + ":" + this.second + " " + this.day; 
	};
	
	this.toSimpleDate = function() {
		return this.year + "-" + this.month + "-" + this.date;
	};
	
	this.toDetailDate = function() {
		return this.year + "-" + this.month + "-" + this.date + " " + this.hour + ":" + this.minute + ":" + this.second;
	};
	
	this.display = function(ele) {
		var clock = new Clock();
		ele.innerHTML = clock.toString();
		window.setTimeout(function() {clock.display(ele);}, 1000);
	};
}
