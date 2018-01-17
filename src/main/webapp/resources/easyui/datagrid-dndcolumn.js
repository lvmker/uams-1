(function($){
	/*$.extend($.fn.datagrid.defaults, {
		onBeforeDrag: function(row){},	// return false to deny drag
		onStartDrag: function(row){},
		onStopDrag: function(row){},
		onDragEnter: function(targetRow, sourceRow){},	// return false to deny drop
		onDragOver: function(targetRow, sourceRow){},	// return false to deny drop
		onDragLeave: function(targetRow, sourceRow){},
		onBeforeDrop: function(targetRow, sourceRow, point){},
		onDrop: function(targetRow, sourceRow, point){},	// point:'append','top','bottom'
	});*/
	
	$.extend($.fn.datagrid.methods, {
		enableDndColumn: function(jq){
			return jq.each(function(){
				var target = this;
				var state = $.data(this, 'datagrid');
				state.disabledRows = [];
				var dg = $(this);
				var opts = state.options;
				//console.log($(this).datagrid("getPanel"));
				//console.log($(this).datagrid('getColumnFields'));
				var cells = $(this).datagrid("getPanel").find(".datagrid-header td[field]");
				//console.log(cells);
				/*if (index != undefined){
					var trs = opts.finder.getTr(this, index);
				} else {
					var trs = opts.finder.getTr(this, 0, 'allbody');
				}*/
				cells.draggable({
					disabled: false,
					revert: true,
					cursor: 'move',
					/*proxy: function(source) {
						var p = $('<div class="tree-node-proxy tree-dnd-no" style="position:absolute;border:1px solid #ff0000"/>').appendTo('body');  
						                    p.html($(source).text());  
						                    p.hide();  
						                    return p;  
					},*/
					proxy:'clone',
					deltaX: 15,
					deltaY: 15,
					onBeforeDrag:function(e){
						//console.log(e);
						//alert($(e).attr('field'));
						if ($(this).attr('field') == 'ck' ||
							$(this).attr('field') == 'mainSampleNum'
							){return false;}
						/*if (opts.onBeforeDrag.call(target, getRow(this)) == false){return false;}
						if ($(e.target).parent().hasClass('datagrid-cell-check')){return false;}
						if (e.which != 1){return false;}
						opts.finder.getTr(target, $(this).attr('datagrid-row-index')).droppable({accept:'no-accept'});*/
					},
					onStartDrag: function() {
						/*$(this).draggable('proxy').css({
							left: -10000,
							top: -10000
						});
						var row = getRow(this);
						opts.onStartDrag.call(target, row);
						state.draggingRow = row;*/
					},
					onDrag: function(e) {
						/*var x1=e.pageX,y1=e.pageY,x2=e.data.startX,y2=e.data.startY;
						var d = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
						if (d>3){	// when drag a little distance, show the proxy object
							$(this).draggable('proxy').show();
							var tr = opts.finder.getTr(target, parseInt($(this).attr('datagrid-row-index')), 'body');
							$.extend(e.data, {
								startX: tr.offset().left,
								startY: tr.offset().top,
								offsetWidth: 0,
								offsetHeight: 0
							});
						}
						this.pageY = e.pageY;*/
					},
					onStopDrag:function(){
						/*for(var i=0; i<state.disabledRows.length; i++){
							var index = dg.datagrid('getRowIndex', state.disabledRows[i]);
							if (index >= 0){
								opts.finder.getTr(target, index).droppable('enable');
							}
						}
						state.disabledRows = [];
						var index = dg.datagrid('getRowIndex', state.draggingRow);
						dg.datagrid('enableDnd', index);
						opts.onStopDrag.call(target, state.draggingRow);*/
					}
				}).droppable({
					accept: 'td[field]',
					onDragEnter: function(e, source){
						
					},
					onDragOver: function(e, source) {
						
					},
					onDragLeave: function(e, source) {
						
					},
					onDrop: function(e, source) {
						var fromField = $(source).attr('field');  
	                    var toField = $(this).attr('field');  
						if(toField == "ck" || toField == "mainSampleNum"){
							
						}else{
	                    	setTimeout(function () {  
	                        	moveField(fromField, toField);  
	                        	$(target).datagrid();  
	                        	$(target).datagrid('columnMoving');  
	                    	}, 0);
						}
					}
				});
				function moveField(from, to) {  
	                var columns = $(target).datagrid('options').columns;  
	                var cc = columns[0];  
	                var c = _remove(from);
					console.log(cc);  
	                if (c) {  
	                    _insert(to, c);
						console.log(columns[0]);  
	                }  
	  
	                function _remove(field) {  
	                    for (var i = 0; i < cc.length; i++) {  
	                        if (cc[i].field == field) {  
	                            var c = cc[i];  
	                            cc.splice(i, 1);  
	                            return c;  
	                        }  
	                    }  
	                    return null;  
	                }  
	                function _insert(field, c) {  
	                    var newcc = [];  
	                    for (var i = 0; i < cc.length; i++) {  
	                        if (cc[i].field == field) {  
	                            newcc.push(c);  
	                        }  
	                        newcc.push(cc[i]);  
	                    }  
	                    columns[0] = newcc;  
	                }  
	            } 
			});
		}
		
	});
})(jQuery);
