(function($){
	$.extend({
		productSelect: function (settings) {
			var productLine = settings.productLine;
			var productDirection = settings.productDirection;
			var productName = settings.productName;
			var template=settings.templateName;
			var productTypeOneArr = [];
			var productTypeTwoArr = [];
			var productTypeThrArr = [];
			var condition=settings.condition;

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
									},
									onChange:function(newValue,oldValue){
										template.combobox({
											editable:false,
											url:'sys/querySampleTemplate.action?productIds='+( (newValue=="" || newValue==null)?productTypeThrArr:newValue ),
											panelHeight:'auto',
											valueField:'tempPath',
											textField:'tempName',
											loadFilter:function(data) {
												$.each(data.rows, function(idx, row) {
													row.tempName = row.tempName+(row.tempVer?row.tempVer:'');
												});
												return data.rows;
											},
											filter:function(q, row) {
												var opts = $(this).combobox("options");
												return row[opts.textField].indexOf(q)>-1||row[opts.valueField].indexOf(q)>-1;
											},
											onSelect:function(data) {
												comboSelected(data.tempPath);
											},
											onLoadSuccess:function(data){
												var object = data[0];
												template.combobox('setValue',object.tempPath);
												comboSelected(object.tempPath);
												if(condition==''){
													sampleEntry.openCompare();
												}
											}
										});
										
										
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
							},
							onChange:function(newValue,oldValue){
								template.combobox({
									editable:false,
									url:'sys/querySampleTemplate.action?productIds='+( (newValue=="" || newValue==null)?productTypeThrArr:newValue ),
									panelHeight:'auto',
									valueField:'tempPath',
									textField:'tempName',
									loadFilter:function(data) {
										$.each(data.rows, function(idx, row) {
											row.tempName = row.tempName+(row.tempVer?row.tempVer:'');
										});
										return data.rows;
									},
									filter:function(q, row) {
										var opts = $(this).combobox("options");
										return row[opts.textField].indexOf(q)>-1||row[opts.valueField].indexOf(q)>-1;
									},
									onSelect:function(data) {
										comboSelected(data.tempPath);
									},
									onLoadSuccess:function(data){
										var object = data[0];
										template.combobox('setValue',object.tempPath);
										comboSelected(object.tempPath);
										if(condition==''){
											sampleEntry.openCompare();
										}
									}
								});
								
								
							}
						}); 
				    }
				}); 
			}
			
			if(condition==''){
				init();	
			}else{
				productLine.combobox({    
				    url:'sys/queryProductTypeByUser.action?productType.productLevel=1',    
				    valueField:'productCode',    
				    textField:'productName',
				    multiple:true,
					loadFilter:function(data){
						for(var i=0; i<data.rows.length; i++){
							productTypeTwoArr.push(data.rows[i].productCode);
						}
						return data.rows;
					}
				});
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
					}
				});
			}
			
			
		}
	});
})(jQuery);