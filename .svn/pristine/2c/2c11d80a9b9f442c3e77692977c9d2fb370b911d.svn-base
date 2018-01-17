(function($){
	$.extend({
		citySelect: function (settings, defaultCountry,defaultProvince,defaultCity,defaultCounty,defaultTown) {
			if (typeof(settings) == 'undefined') {
				return;
			}
			var searchCountry;
			var searchProvince;
			var searchCity;
			var searchArea;
			var searchCountryside;
			if (settings instanceof Array && settings.length == 5) {
				searchCountry = settings[0];
				searchProvince = settings[1];
				searchCity = settings[2];
				searchArea = settings[3];
				searchCountryside = settings[4];
			} else {
				searchCountry = settings.searchCountry;
				searchProvince = settings.searchProvince;
				searchCity = settings.searchCity;
				searchArea = settings.searchArea;
				searchCountryside = settings.searchCountryside;
			}
			var init = function(){
				//国家
				var minWidth = 100;
				searchCountry.combobox({    
				    url:'sys/queryNextClassArea.action',    
				    valueField:'areaCode',    
				    textField:'areaName',
				    editable:true,
				    panelWidth:searchCountry.width() < minWidth ? minWidth : null,
				    onBeforeLoad: function(param){
						param.arearank = 1;
					},
				    onChange:function(newValue,oldValue){
				    	if (newValue != ""){
				    		//省
				    		//选择省清除后面checkbox数据
				    		searchCity.combobox('loadData',[]);
				    		searchArea.combobox('loadData',[]);
				    		searchCountryside.combobox('loadData',[]);
				    		searchCity.combobox('setValue','');
				    		searchArea.combobox('setValue','');
				    		searchCountryside.combobox('setValue','');
				    		//设置省
				    		searchProvince.combobox({    
							    url:'sys/queryNextClassArea.action',    
							    valueField:'areaCode',    
							    textField:'areaName',
							    editable:true,
							    panelWidth:searchProvince.width() < minWidth ? minWidth : null,
							    onBeforeLoad: function(param){
									param.areacode = newValue;
							    	param.arearank = 2;
								},
								onLoadSuccess:function(param) {
									if (defaultProvince) {
										searchProvince.combobox('setValue',defaultProvince);
									}
								},
							    onChange:function(newValue,oldValue){
							    	if (newValue != ""){
							    		//市
							    		//选择市清除后面checkbox数据
							    		searchArea.combobox('loadData',[]);
							    		searchCountryside.combobox('loadData',[]);
							    		searchArea.combobox('setValue','');
							    		searchCountryside.combobox('setValue','');
							    		//设置市
							    		searchCity.combobox({    
										    url:'sys/queryNextClassArea.action',    
										    valueField:'areaCode',    
										    textField:'areaName',
										    editable:true,
										    panelWidth:searchCity.width() < minWidth ? minWidth : null,
										    onBeforeLoad: function(param){
												param.areacode = newValue;
										    	param.arearank = 3;
											},
											onLoadSuccess:function(param) {
												if (defaultCity) {
													searchCity.combobox('setValue',defaultCity);
												}
											},
										    onChange:function(newValue,oldValue){
										    	if (newValue != ""){
										    		//县
										    		//选择县清除后面checkbox数据
										    		searchCountryside.combobox('loadData',[]);
										    		searchCountryside.combobox('setValue','');
										    		//设置县
										    		searchArea.combobox({    
													    url:'sys/queryNextClassArea.action',    
													    valueField:'areaCode',    
													    textField:'areaName',
													    editable:true,
													    panelWidth:searchArea.width() < minWidth ? minWidth : null,
													    onBeforeLoad: function(param){
															param.areacode = newValue;
													    	param.arearank = 4;
														},
														onLoadSuccess:function(param) {
															if (defaultCounty) {
																searchArea.combobox('setValue',defaultCounty);
															}
														},
													    onChange:function(newValue,oldValue){
													    	if (newValue != ""){
													    		//乡
													    		searchCountryside.combobox({    
																    url:'sys/queryNextClassArea.action',    
																    valueField:'areaCode',    
																    textField:'areaName',
																    panelWidth:searchCountryside.width() < minWidth ? minWidth : null,
																    editable:true,
																    onBeforeLoad: function(param){
																		param.areacode = newValue;
																    	param.arearank = 5;
																	},
																	onLoadSuccess:function(param) {
																		if (defaultTown) {
																			searchCountryside.combobox('setValue',defaultTown);
																		}
																	},
																}); 
													    	}
													    }
													}); 
										    	}
										    }
										}); 
							    	}
							    }
							}); 
				    	}
				    },
				    onLoadSuccess: function(){
				    	if (defaultCountry) {
					    	searchCountry.combobox('setValue',defaultCountry);
				    	}
					}
				}); 
			}
			init();
		}
	});
})(jQuery);