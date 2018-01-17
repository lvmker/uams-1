;(function($, window, document,undefined){
	var LG = function(ele,opt){
		this.isFirefox = navigator.userAgent.toUpperCase().indexOf("FIREFOX") >= 0 ? true : false;
		this.$element = ele;
		this.defaults = {
				"stepScale":0.2,
				"totalScale":1,
				"stepRotate":90,
				"totalRotate":0,
		};
		this.startPoint = {x:0,y:0},
		this.translateXY = {x:0,y:0},
		this.dragging = false;
		this.options = $.extend({},this.defaults,opt);
		this.$element.css("webkitTransform","translate(0px,0px)");
	}
	LG.prototype = {
			pauseEvent : function(e){
				 if(e.stopPropagation) e.stopPropagation();
				 if(e.preventDefault) e.preventDefault();
				 e.cancelBubble=true;
				 e.returnValue=false;
				 return false;
			},
			scale : function(totalscale,that){
				var temp = that.$element[0].style.webkitTransform;
				var newTransform = '';
				if(temp){
					if(temp.indexOf('scale')>=0){
						newTransform = temp.replace(/scale\(.*\d\)/,"scale(" + totalscale + ")");
					}else{
						newTransform = temp + " " + "scale(" + totalscale + ")";
					}
				}else{
					newTransform = "scale(" + totalscale + ")";
				}
				that.$element[0].style.webkitTransform=newTransform;
			},
			scrollFunc:function(event,that) {
				var e = event || window.event;
				var value = 0;
				if (e.wheelDelta) {//IE/Opera/Chrome
					value = e.wheelDelta;
				} else if (e.detail) {//Firefox
					value = e.detail;
				} else if(e.originalEvent){
					if(e.originalEvent.wheelDelta){
						value = e.originalEvent.wheelDelta;
					}else if(e.originalEvent.detail){
						value = e.originalEvent.detail;
					}
				}
				if (that.isFirefox) {
					value = -1 * value;
				}
				value = value > 0 ? 1 : -1;
				var scaleTemp = this.options.totalScale + value * this.options.stepScale;
				if(scaleTemp<1){
					scaleTemp = 1;
					return;
				}else if(scaleTemp>5){
					scaleTemp = 5;
					return;
				}
				that.options.totalScale = scaleTemp;
				this.scale(scaleTemp,that);
			},
			render:function(){
				var that = this;
				this.$element.on('dblclick',function(event){
					var total = that.options.totalRotate + that.options.stepRotate;
					total = total>360?total%360:total;
					var temp = that.$element[0].style.webkitTransform;
					var newTransform = '';
					if(temp){
						if(temp.indexOf('rotate')>=0){
							newTransform = temp.replace(/rotate\(\d+deg\)/,"rotate(" + total + "deg)");
						}else{
							newTransform = temp + " " + "rotate(" + total + "deg)";
						}
					}else{
						newTransform = "rotate(" + total + "deg)";
					}
					that.$element[0].style.webkitTransform=newTransform;
					that.options.totalRotate = total;
				}).on('mouseout',function(event){
					event = event||window.event;
				    //获得相对于body定位的横标值；
				    x=event.clientX
				    //获得相对于body定位的纵标值；
				    y=event.clientY
				    that.dragging = false;
				}).on('mousedown',function(event){
					event = event||window.event;
				    //获得相对于body定位的横标值；
					that.startPoint.x=event.clientX
				    //获得相对于body定位的纵标值；
					that.startPoint.y=event.clientY
					that.dragging = true;
					that.pauseEvent(event);
				}).on('mouseup',function(event){
					event = event||window.event;
				    //获得相对于body定位的横标值；
				    x=event.clientX
				    //获得相对于body定位的纵标值；
				    y=event.clientY
				    that.dragging = false;
				}).on('mousemove',function(event){
					if(!that.dragging) 
						return;
				    event = event||window.event;
				    //获得相对于body定位的横标值；
				    x=event.clientX
				    //获得相对于body定位的纵标值；
				    y=event.clientY
				    var temp = that.$element[0].style.webkitTransform;
				    var dx = x - that.startPoint.x;
				    var dy = y - that.startPoint.y;
				    that.translateXY.x = that.translateXY.x+(dx/20);
				    that.translateXY.y = that.translateXY.y+(dy/20);
				    var ntemp = temp.replace(/translate\(.+px\)/,"translate("+that.translateXY.x+"px,"+that.translateXY.y+"px)");
				    that.$element[0].style.webkitTransform=ntemp;
				}).on('mousewheel',function(event){
					that.scrollFunc(event,that);
				});
				if (document.addEventListener) {
					document.addEventListener('DOMMouseScroll', function(event){
						that.scrollFunc(event,that);
					}, false);
				}
			}
	}
	$.fn.imageViewer = function(options){
		var lg = new LG(this,options);
		return lg.render();
	}
})($, window, document,undefined);