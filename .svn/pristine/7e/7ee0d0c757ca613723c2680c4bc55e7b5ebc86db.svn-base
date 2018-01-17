function createCharts(targetId){
	if(!targetId){
		return;
	}
	//先设置宽度，才能用
	var targetDiv = $('#'+targetId);
	var parentDiv = targetDiv.parent();
	targetDiv.width(parentDiv.width());
	targetDiv.height(parentDiv.height());
	var countData = "";
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		dataType : "json",
		url : 'sys/getUserLoginCount.action',// 请求的action路径
		error : function() {// 请求失败处理函数
			sysErrorShow('请求失败!');
		},
		success : function(data) {
			if(data.success){
				countData = '['+ data.object + ']'
			}else{
				sysErrorShow('请求失败!');
			}
		}
	});
		
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
				var myChart2 = ec.init(document.getElementById('mainBar'));
				var option = {
					tooltip : {
						trigger : 'axis'
					},
					toolbox : {
						show : true,
						feature : {
							mark : {
								show : false
							},
							dataView : {
								show : false,
								readOnly : false
							},
							magicType : {
								show : true,
								type : ['line', 'bar']
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						},
						orient:'vertical'
					},
					calculable : true,
					xAxis : [{
								type : 'category',
								data : ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
							}],
					yAxis : [{
								type : 'value'
							}],
					grid:{
					    x:50,
					    y:30,
					    x2:50,
					    y2:30
					},
					series : [{
								name : '用户登录统计',
								type : 'bar',
								data : eval('(' + countData + ')'),
								markPoint : {
									data : [{
												type : 'max',
												name : '最大值'
											}, {
												type : 'min',
												name : '最小值'
											}]
								},
								markLine : {
									data : [{
												type : 'average',
												name : '平均值'
											}]
								}
							}]
				};
				myChart2.setOption(option);
			});
}