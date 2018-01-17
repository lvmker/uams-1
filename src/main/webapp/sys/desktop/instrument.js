function instrument(){
	require.config({
	        paths: {
	            echarts: 'resources/echarts'
	        }
	    });
	require(
	        [
	            'echarts',
	            'echarts/chart/bar',
	            'echarts/chart/line',
	            'echarts/chart/gauge'
	        ], 
		function(ec) {
				var myChart2 = ec.init(document.getElementById('instrumentDiv'));
				var option = {
    tooltip : {
        formatter: "{a} <br/>{c} {b}"
    },
    series : [
        {
            name:'今日已完成',
            type:'gauge',
            z: 3,
            min:0,
            max:800,
            splitNumber:20,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: [[0.2, '#ff4500'],[0.6, '#48b'],[1, '#228b22']], 
                    width: 10
                }
            },
            axisTick: {            // 坐标轴小标记
                length :15,        // 属性length控制线长
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: {           // 分隔线
                length :20,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto'
                }
            },
            title : {
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'bolder',
                    fontSize: 20,
                    fontStyle: 'italic'
                }
            },
            detail : {
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'bolder'
                }
            },
            data:[{value: 40, name: '份'}]
        },
        {
            name:'剩余',
            type:'gauge',
            center : ['18%', '55%'],    // 默认全局居中
            radius : '50%',
            min:0,
            max:10,
            endAngle:45,
            splitNumber:10,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                   color: [[0.2, '#ff4500'],[0.5, '#48b'],[1, '#228b22']],   
                  width: 8
                }
            },
            axisTick: {            // 坐标轴小标记
                length :12,        // 属性length控制线长
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: {           // 分隔线
                length :20,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto'
                }
            },
            pointer: {
                width:5
            },
            title : {
                offsetCenter: [0, '-30%']       // x, y，单位px
            },
            detail : {
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'bolder'
                }
            },
            data:[{value: 1.5, name: '百份'}]
        },
        {
            name:'存疑率',
            type:'gauge',
            center : ['80%', '50%'],    // 默认全局居中
            radius : '50%',
            min:0,
            max:2,
            startAngle:135,
            endAngle:45,
            splitNumber:2,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: [[0.2, '#228b22'],[0.8, '#48b'],[1, '#ff4500']], 
                    width: 8
                }
            },
            axisTick: {            // 坐标轴小标记
                splitNumber:5,
                length :10,        // 属性length控制线长
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            axisLabel: {
                formatter:function(v){
                    switch (v + '') {
                        case '0' : return '低';
                        case '1' : return '存疑率';
                        case '2' : return '高';
                    }
                }
            },
            splitLine: {           // 分隔线
                length :15,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto'
                }
            },
            pointer: {
                width:2
            },
            title : {
                show: false
            },
            detail : {
                show: false
            },
            data:[{value: 0.5, name: 'gas'}]
        },
        {
            name:'错误率',
            type:'gauge',
            center : ['80%', '50%'],    // 默认全局居中
            radius : '50%',
            min:0,
            max:2,
            startAngle:315,
            endAngle:225,
            splitNumber:2,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: [[0.2, '#ff4500'],[0.8, '#48b'],[1, '#228b22']], 
                    width: 8
                }
            },
            axisTick: {            // 坐标轴小标记
                show: false
            },
            axisLabel: {
                formatter:function(v){
                    switch (v + '') {
                        case '0' : return '高';
                        case '1' : return '错误率';
                        case '2' : return '低';
                    }
                }
            },
            splitLine: {           // 分隔线
                length :15,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto'
                }
            },
            pointer: {
                width:2
            },
            title : {
                show: false
            },
            detail : {
                show: false
            },
            data:[{value: 0.5, name: 'gas'}]
        }
    ]
};
myChart2.setOption(option);	
			});
}
function instrument2(){
	require.config({
	        paths: {
	            echarts: 'resources/echarts'
	        }
	    });
	require(
	        [
	            'echarts',
	            'echarts/chart/bar',
	            'echarts/chart/line',
	            'echarts/chart/pie'
	        ], 
		function(ec) {
				var myChart2 = ec.init(document.getElementById('instrumentDiv2'));
				var dataStyle = {
				    normal: {
				        label: {show:false},
				        labelLine: {show:false}
				    }
				};
				var placeHolderStyle = {
				    normal : {
				        color: 'rgba(0,0,0,0)',
				        label: {show:false},
				        labelLine: {show:false}
				    },
				    emphasis : {
				        color: 'rgba(0,0,0,0)'
				    }
				};
var option = {
    title: {
        text: '录入情况',
        x: 'center',
        y: 'center',
        itemGap: 20,
        textStyle : {
            color : 'rgba(30,144,255,0.8)',
            fontFamily : '微软雅黑',
            fontSize : 35,
            fontWeight : 'bolder'
        }
    },
    tooltip : {
        show: true,
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : document.getElementById('instrumentDiv2').offsetWidth / 2,
        y : 70,
        itemGap:12,
        data:['已录入121份样品','54份存疑','5份错误','3份草稿']
    },
    series : [
        {
            name:'1',
            type:'pie',
            clockWise:false,
            radius : [125, 150],
            itemStyle : dataStyle,
            data:[
                {
                    value:121,
                    name:'已录入121份样品'
                },
                {
                    value:32,
                    name:'invisible',
                    itemStyle : placeHolderStyle
                }
            ]
        },
        {
            name:'2',
            type:'pie',
            clockWise:false,
            radius : [100, 125],
            itemStyle : dataStyle,
            data:[
                {
                    value:29, 
                    name:'54份存疑'
                },
                {
                    value:71,
                    name:'invisible',
                    itemStyle : placeHolderStyle
                }
            ]
        },
        {
            name:'3',
            type:'pie',
            clockWise:false,
            radius : [75, 100],
            itemStyle : dataStyle,
            data:[
                {
                    value:5, 
                    name:'5份错误'
                },
                {
                    value:97,
                    name:'invisible',
                    itemStyle : placeHolderStyle
                }
            ]
        },
        {
            name:'4',
            type:'pie',
            clockWise:false,
            radius : [50, 75],
            itemStyle : dataStyle,
            data:[
                {
                    value:3, 
                    name:'3份草稿'
                },
                {
                    value:97,
                    name:'invisible',
                    itemStyle : placeHolderStyle
                }
            ]
        }
    ]
};
myChart2.setOption(option);	
			});
}
var instrument3MyChar3 = null;
var instrument3 = {
	run: function(data) {
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
		        	instrument3MyChar3 = ec.init(document.getElementById('instrumentDiv3'));
					var d = instrument3.getParameter(data);
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
		        	instrument3MyChar3.setOption(option);	
		        });
	},
	getParameter: function(data) {
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
			}
		});
		var d = [];
		d.push(moreThenThreeDay);
		d.push(beforeYesterday);
		d.push(yesterday);
		d.push(today);
		return d;
	},
	refresh: function(data) {
		if (!instrument3MyChar3) {
			return false;
		}
		var option = instrument3MyChar3.getOption();
		var d = this.getParameter(data);
		option.series[0].data = d[0];
		option.series[1].data = d[1];
		option.series[2].data = d[2];
		option.series[3].data = d[3];
	}
}
