(function($){
	$.extend({
		productSelect: function (settings) {
			var productLine = settings.productLine;
			var productDirection = settings.productDirection;
			var productName = settings.productName;
			
			var productTypeOneArr = [];
			var productTypeTwoArr = [];
			var productTypeThrArr = [];
			var init = function(){
				//产品线
				productLine.combobox({    
				    url:'sys/queryProductTypeByUser.action?productType.productLevel=1',    
				    valueField:'productCode',    
				    textField:'productName',
				    multiple:true,
				    loadFilter:function(data){
				    	for(var i=0; i<data.rows.length; i++){
				    		productTypeOneArr.push(data.rows[i].productCode);
						}
						return data.rows;
					},
					onLoadSuccess:function(){
						productDirection.combobox({
							editable:true,
							multiple:true,
							panelHeight:'150',
							url:'sys/queryProductTypeByUser.action?productType.productLevel=2&productType.productTypeOneId='+productTypeOneArr.join(","),
							loadFilter:function(data){
								for(var i=0; i<data.rows.length; i++){
									productTypeTwoArr.push(data.rows[i].productCode);
								}
								return data.rows;
							},
							onLoadSuccess:function(){
								productName.combobox({
									editable:true,
									multiple:true,
									panelHeight:'150',
									url:'sys/queryProductTypeByUser.action?productType.productLevel=3&productType.productTypeTwoId='+productTypeTwoArr.join(","),
									loadFilter:function(data){
										return data.rows;
									}
								});
							}
						});
					},
				    onChange:function(newValue,oldValue){
			    		//产品方向
			    		//选择产品线清除后面checkbox数据
			    		var tmp = {"rows":[]};
			    		productName.combobox('loadData',tmp);
			    		productName.combobox('setValues','');
			    		//设置产品方向
			    		productDirection.combobox({    
						    url:'sys/queryProductTypeByUser.action?productType.productLevel=2&productType.productTypeOneId='+ ((newValue=="" || newValue==null)?productTypeOneArr:newValue),    
						    valueField:'productCode',    
						    textField:'productName',
						    multiple:true,
						    loadFilter:function(data){
								return data.rows;
							},
						    onBeforeLoad: function(param){
								param.productOrSortId = newValue;
							},
						    onChange:function(newValue,oldValue){
					    		//产品名称
					    		productName.combobox({    
					    			url:'sys/queryProductTypeByUser.action?productType.productLevel=3&productType.productTypeTwoId='+( (newValue=="" || newValue==null)?productTypeTwoArr:newValue ) ,
					    			valueField:'productCode',    
							    	textField:'productName',
							    	multiple:true,
							    	loadFilter:function(data){
										return data.rows;
									},
								    onBeforeLoad: function(param){
										param.productOrSortId = newValue;
									}
								}); 
						    }
						}); 
				    }
				});
				productDirection.combobox({    
				    onChange:function(newValue,oldValue){
			    		//产品名称
			    		productName.combobox({    
			    			url:'sys/queryProductTypeByUser.action?productType.productLevel=3&productType.productTypeTwoId='+( (newValue=="" || newValue==null)?productTypeTwoArr:newValue ),
			    			valueField:'productCode',    
					    	textField:'productName',
					    	multiple:true,
					    	loadFilter:function(data){
								return data.rows;
							},
						    onBeforeLoad: function(param){
								param.productOrSortId = newValue;
							}
						}); 
				    }
				}); 
			}
			init();
		}
	});
})(jQuery);