var xValues,yValues;
$(function(){
	count();
	//setInterval('count();',1000*60*60);//5分钟刷新一次桌面统计数据
});
function count(){
	 $.ajax({
	    	async : false,
			cache : false,
			type : 'POST',
			dataType : "json",
			data:{},
			url:'sys/showDesktop.action',
	    	error:function()
	    	{
	    		 sysErrorShow('请求失败!');
	    	},
	    	success:function(data)
	    	{
	    		if(data.success==true)
			  	{
	    			var rows = data.rows;
	    			var table = $("#count-table");
	    			table.html('');
	    			var child = '<tr>';
	    			for(var i=0;i<rows.length;i++){
	    				child += '<td><div class="count-area" style="background-image:url('+basePath+'resources/desktop/'+(i+1)+'.png);">';
	    				child += '<p class="count-title">'+rows[i].title+'</p>';
	    				child += '<p class="count-content">'+rows[i].value+'</p></div></td>';
	    				if(i>0 && (i+1)%4==0){
	    					child += '</tr><tr>';
	    				}
	    			}
	    			table.append($(child));
	    			if(data.object!=""){//增加此判断是因为后台判断用户面板权限，如果无柱状图面板权限，则不加载柱状图
	    				if(data.object.barResult!=null){
    	    				xValues = data.object.barResult.xValues;
    		    			yValues = data.object.barResult.yValues;
    		    			createChartsOne("areaDiv");
	    				}
	    				if(data.object.surplusTaskBoard !=null){
	    					createChartsTwo(data.object.surplusTaskBoard,"areaDiv2");
	    				}
	    			}
			  	}
	    	}
	    });
}
function createChartsOne(targetId){
	if(!targetId){
		return;
	}
	//先设置宽度，才能用
	var targetDiv = $('#'+targetId);
	var parentDiv = targetDiv.parent();
	targetDiv.width(parentDiv.width());
	targetDiv.height("300");

	require.config({
	        paths: {
	            echarts: 'resources/echarts'
	        }
	    });
	require(
	        [
	            'echarts',
	            'echarts/chart/bar',
	            'echarts/chart/line'
	        ], 
		function(ec) {
				var myChart = ec.init(document.getElementById('areaDiv'),'dark');
				var option = {
						 title: {
						        text: '审核签发任务看板',
						    },
					    tooltip : {
					        trigger: 'axis'
					    },
					    toolbox: {
					        show : true,
					        feature : {
					            saveAsImage : {show: false}
					        }
					    },
					    calculable : true,
					    xAxis : [
					        {
					            type : 'category',
					            data : eval(xValues)
					        }
					    ],
					    yAxis : [
					        {
					            type : 'value'
					        }
					    ],
					    series : [{
							name : '审核签发任务看板',
							type : 'bar',
							itemStyle: {
				                normal: {
				                    color: function(params) {
				                        // build a color map as your need.
				                        var colorList = [
				                          '#67D8EA','#E87A7B','#9F9F9F','#A9DA7E','#50B386','#50B386',
				                          '#50B386','#50B386','#50B386','#50B386','#50B386','#50B386',
				                          '#9BCA63','#50B386','#50B386','#50B386','#50B386','#50B386',
				                          '#50B386','#50B386','#50B386'
				                        ];
				                        return colorList[params.dataIndex];
				                    },
				                    label: {
				                        show: true,
				                        position: 'top',
				                        formatter: '{c}'
				                    }
				                }
				            },
							data : eval(yValues),
							markPoint : {
								data : [{
											type : 'max',
											name : '最大值'
										}, {
											type : 'min',
											name : '最小值'
										}]
							}
						}]
					};
					                    
				myChart.setOption(option);
			});
}

function createChartsTwo(data,targetId) {
		if(!targetId){
			return;
		}
		//先设置宽度，才能用
		var targetDiv = $('#'+targetId);
		var parentDiv = targetDiv.parent();
		targetDiv.width(parentDiv.width());
		targetDiv.height("300");
	
		require.config({
	        paths: {
	            echarts: 'resources/echarts'
	        }
	    }),
		require(
		        [
		            'echarts',
		            'echarts/chart/bar',
		            'echarts/chart/line',
		            'echarts/chart/pie'
		        ], 
				function(ec) {
		        	var myChart2 = ec.init(document.getElementById('areaDiv2'));
					var d = getParameter(data);
		        	var option = {
						    title: {
						        text: '剩余任务跟踪看板',
						    },
						    tooltip : {
						    	trigger: 'axis'
						    },
						    legend: {
						        data:['> 3天','前天','昨天','今天']
						    },
						    xAxis: [
						        {
						            type : 'category',
						            data : ['待补录','错误','存疑','草稿']
						        }
						    ],
						    yAxis: [
						        {
						            type : 'value'
						        }
						    ],
						    series: [
						        {
						            name:'> 3天',
						            type:'bar',
						            data:d[0]
						        },
						        {
						            name:'前天',
						            type:'bar',
						            data:d[1]
						        },
						        {
						            name:'昨天',
						            type:'bar',
						            data:d[2]
						        },
						        {
						            name:'今天',
						            type:'bar',
						            data:d[3]
						        }
						    ]
						};
		        	myChart2.setOption(option);	
		        });
}

function getParameter(data) {
	var today, yesterday, beforeYesterday, moreThenThreeDay, defaultValue=[0,0,0,0];
	today = defaultValue;
	yesterday = defaultValue;
	beforeYesterday = defaultValue;
	moreThenThreeDay = defaultValue;
	$.each(data, function(idx, row){
		var value = [row.num11, row.num12, row.num13, row.num15];
		if (row.timeDimension == 'today') {
			today = value;
		} else if(row.timeDimension == 'yesterday') {
			yesterday = value;
		} else if(row.timeDimension == 'beforeYesterday') {
			beforeYesterday = value;
		} else if(row.timeDimension == 'moreThenThree') {
			moreThenThreeDay = value;
		};
	});
	var d = [];
	d.push(moreThenThreeDay);
	d.push(beforeYesterday);
	d.push(yesterday);
	d.push(today);
	return d;
};
