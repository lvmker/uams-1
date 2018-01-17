(function($){
	$.extend({
		dateSelect: function (settings) {
			var startDate = settings.startDate;
			var endDate = settings.endDate;
			var init = function(){
				startDate.datebox({
				    onSelect: function(date){
				    	var endD = endDate.datebox('getValue');
				    	var end = 0;
				    	if(endD==null||endD==undefined||endD.length==0){
				    		;
				    	}else{
				    		end = Date.parse(endD);
				    		var startD = startDate.datebox('getValue');
					    	var start = Date.parse(startD);
					    	if(start>end){
					    		startDate.datebox('setValue','');
					    		sysMsgShow("开始日期大于结束日期!");
					    	}
				    	}
				    }
				});
				endDate.datebox({
				    onSelect: function(date){
				    	var startD = startDate.datebox('getValue');
				    	var start = 0;
				    	if(startD==null||startD==undefined||startD.length==0){
				    		;
				    	}else{
				    		start = Date.parse(startD);
				    		var endD = endDate.datebox('getValue');
					    	var end = Date.parse(endD);
					    	if(start>end){
					    		endDate.datebox('setValue','');
					    		sysMsgShow("开始日期大于结束日期!");
					    	}
				    	}
				    }
				});
			}
			init();
		}
	});
})(jQuery);