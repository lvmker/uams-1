var panelList;// 全部panel信息
var loginUserRolesId;
var nocache = new Date().getTime();
// 初始化桌面顺序
function initdesktopPanelByOrder(callback) {
	$.getJSON("sys/queryUserDesktopOrder.action?nocache=" + nocache, null,
		function msg(json) {
			if(json)
			{
				var desktopConfig = eval(json.orderData);
				var orderDateStr = json.orderData;
				loginUserRolesId = json.rolesId;
				$("#userPanelId").val(json.userPanelId);
				var orderDateStrs = orderDateStr.split(",");
				$("#orderDataLenght").val(orderDateStrs.length);
				var tableInfo = $('#dropTable td');
				
				var height = ($(window.parent.document).contents().find("#mainPanleTab").height()-84)/2;
				var width = 0;
				if(orderDateStrs.length > 4){
					width = ($(window.parent.document).contents().find("#mainPanleTab").width()-55)/2;
				}else{
					width = ($(window.parent.document).contents().find("#mainPanleTab").width()-40)/2;
				}
				
				var panel = $('#pd_noticePanel');
				var dragButt = $(tableInfo[0]).find('.dragObjButt');
				var dragObj = panel.parent().parent();
				panel.panel('resize', {
					width : width,
					height: height
				});						
				dragButt.before(dragObj);
				
				for (var i = 0; i < desktopConfig.length; i++) {
					var column = tableInfo[i];
					
					var columnData = desktopConfig[i];
					if (!columnData) {
						continue;
					}
					
					for (var j = 0; j < columnData.length; j++) {
						if(columnData[j] == 'pd_noticePanel') {
							continue;
						}
						var panel = $('#' + columnData[j]);
						var dragButt = $(column).find('.dragObjButt');
						var dragObj = panel.parent().parent();
						panel.panel('resize', {
							width : width,
							height: height
						});						
						dragButt.before(dragObj);
					}
				}
				if (typeof callback == 'function') {			
					callback();
				}
			}
		});
}

// 设置面板标题
function setPanelTitle() {
	getPanelList(function() {
		for (var i = 0; i < panelList.length; i++) {
			var domId = panelList[i].portalCode;
			if(domId == 'pd_noticePanel'){
				continue;
			}
			var panel = $('#' + domId);
			if (panel.length > 0) {
				// 设置标题
				panel.panel('setTitle', panelList[i].portalName);
			}
		}
		$("#pd_noticePanel").panel('setTitle', '系统公告');
	});
}

//获取用户保存的portal_order
function getPanelList(callback) {
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		dataType : "json",
		data : {
			"userDesktop.rolesId" : loginUserRolesId
		},
		url : 'sys/queryUserDesktopByRole.action?nocache=' + nocache,// 请求的action路径
		error : function() {// 请求失败处理函数
			sysErrorShow('请求失败!');
		},
		success : function(data) {
			panelList = "";
			panelList = data.rows
			if (typeof callback == 'function') {
				callback();
			}
		}
	});
}

function initEvent() {
	$('#recycleBin .easyui-panel').each(function() {
		var panel = $(this);
		panel.panel({
			// close事件
			onClose : function() {
				$('#recycleBin').append(panel.parents('.dragObj'));
			}
		});
	});
}

// 保存桌面顺序
function saveDesktopOrder() {
	var desktopConfig = [];
	$('#dropTable .easyui-panel').each(
		function() {
			var panelId = this.id;
			var tdIndex = $(this).parents('td').index();
			var configColumn = desktopConfig[tdIndex];
			// 判断是否数组
			if (typeof configColumn != 'object'
					|| typeof configColumn.length != 'number') {
				configColumn = [ panelId ];
			} else {
				configColumn.push(panelId);
			}
			desktopConfig[tdIndex] = configColumn;
		});

	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		dataType : "json",
		data : {
			"userDesktop.userPanelId" : $("#userPanelId").val(),
			"userDesktop.orderData" : JSON.stringify(desktopConfig)
		},
		url : 'sys/saveUserDesktopOrder.action',// 请求的action路径
		error : function() {// 请求失败处理函数
			sysErrorShow('请求失败!');
		},
		success : function(data) {
			// 未返回任何消息表示添加成功
			var message = data.msg || "保存成功!";
			sysMsgShow(message);
		}
	});
}

function initToolbar(){
	jQuery("#toolbar").hover(function(){
		if(isLeft=="left"){ 
			jQuery(this).stop().animate({"left":"0"});
		}else{
			jQuery(this).stop().animate({"right":"0"});
		}
	},function(){
		if(isIn){
			if(isLeft=="left"){
				jQuery(this).stop().animate({"left":"-67"});
			}else{
				jQuery(this).stop().animate({"right":"-67"});
			}
		}
	});
}

function initCharts() {
	createCharts("mainBar");
}
//绘制添加面板的checkBox
function openPanel() {
	var callback = function() {
		var desktopConfigObj = {};
		$('#dropTable .easyui-panel').each(function() {
			desktopConfigObj[this.id] = true;
		});
		var html = "<table width='100%' border='0' style='margin-left: 10px;margin-top: 5px;'><tr>";
		var i = 0;
		$.each(panelList, function(index, item) {
				if (i != 0 && i % 3 == 0) {
					html += "</tr><tr>";
				}
				var isChecked = desktopConfigObj[item.portalCode];
				var disable = '', checked = '';
				if (isChecked > 0) {
					disable = 'disabled="disabled"';
					checked = 'checked="checked"';
				}
				html += "<td width='140'><input type='checkbox' name='checkpanel' value='"
						+ item.portalCode
						+ "' "
						+ disable
						+ checked
						+ " />" + item.portalName + "</td>";
				i++;
			});
		if (i % 3 == 1) {
			html += "<td></td><td></td>";
		} else if (i % 3 == 2) {
			html += "<td></td>";
		}
		html += "</tr></table>";
		$('#openPanelDiv').html(html);
		$('#openPanel').dialog("open");
	}
	if (!panelList) {
		getPanelList(callback);
	} else {
		callback();
	}
}

//点击“添加”触发  打开添加面板
function initAddPanel() {
	$('#openPanel').dialog({
		title : '添加面板',
		modal : true,
		minimizable : false,
		maximizable : false,
		 buttons: [{
            text: '确定',
            iconCls: 'icon-ok',
            handler: savePanel
        }]
	});
	$('#openPanel').window('move', {
		top : 20
	});
	$('#openPanel').window('close');
}

//点击添加面板的“确定” 触发
function savePanel() {
	var userSelected = $('#openPanel input:checked[disabled!="disabled"]');
	userSelected.each(function() {
		var panel = $('#' + this.value);
		var dragObjButt = $('#dropTable td:first .dragObjButt');
		var height = ($(window.parent.document).contents().find("#mainPanleTab").height()-84)/2;
		var width = ($(window.parent.document).contents().find("#mainPanleTab").width()-40)/2;		
		var dragObj = panel.parents(".dragObj");				
		panel.panel('resize', {
			width : width,
			height: height
		});		
		dragObjButt.before(dragObj);
		panel.panel('open');
	});
	initCharts();
	$('#openPanel').window('close');
}

// 页面加载
$(document).ready(function() {
	// 事件
	initEvent();
	// init面板位置
	initdesktopPanelByOrder(function() {
		// init添加模块面板
		initAddPanel();
		// 设置标题
		setPanelTitle();
		// initChar最后实例化echar，让其他东西准备好，否则可能报错
		initCharts();
		$('#openPanel').dialog("close");
	});
	
	// 实现拖拉
	$('.dragObj').each(function() {
		var thisJqObj = $(this);
		var dragZone = thisJqObj.find('.panel-title').css({
			'margin-right' : '20px'
		});
		thisJqObj.draggable({
			proxy : 'clone',
			revert : true,
			cursor : 'move',
			handle : dragZone,// 可拖拉区域
			onStartDrag : function() {
				$(this).draggable('options').cursor = 'not-allowed';
				$(this).draggable('proxy').addClass('proxyTranslucent');
	
			},
			onStopDrag : function() {
				$(this).draggable('options').cursor = 'move';
			}
	
		});
	});

	// dragObjButt为末尾元素，永远在最后，以便拖拉至本列末尾
	$('.dragObj,.dragObjButt').droppable({
		accept : '.dragObj',
		onDragEnter : function(e, source) {
			$(source).draggable('options').cursor = 'auto';
		},
		onDragOver : function(e, source) {
			$('#indicator').css({
				display : 'block',
				left : $(this).offset().left - 5,
				top : $(this).offset().top - 10
			});
		},
		onDragLeave : function(e, source) {
			$(source).draggable('options').cursor = 'not-allowed';
			$('#indicator').hide();
		},
		onDrop : function(e, source) {
			// 同步宽度
			$(source).find('.easyui-panel').panel('resize', {
				width : $(this).width()				
			});
			// 加入到被放置的元素之前（同级）
			$(this).before(source);
			// 隐藏位置提示
			$('#indicator').hide();
		}
	});

});