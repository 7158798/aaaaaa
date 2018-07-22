/*bbOrders页面里面的box里面的拖动条js*/

$.fn.RangeSlider = function(cfg) {
	this.sliderCfg = {
		min: cfg && !isNaN(parseFloat(cfg.min)) ? Number(cfg.min) : null,
		max: cfg && !isNaN(parseFloat(cfg.max)) ? Number(cfg.max) : null,
		step: cfg && Number(cfg.step) ? cfg.step : 1,
		callback: cfg && cfg.callback ? cfg.callback : null
	};

	var $input = $(this);
	var min = this.sliderCfg.min;
	var max = this.sliderCfg.max;
	var step = this.sliderCfg.step;
	var callback = this.sliderCfg.callback;

	$input.attr('min', min)
		.attr('max', max)
		.attr('step', step);

	$input.bind("input", function(e) {
		$input.attr('value', this.value);
		$input.css('background-size', this.value + '% 100%');
		/*this.value  百分比的値*/
		if($.isFunction(callback)) {
			callback(this);
		};

		if (this.id != "sellline") {
			lichange1(this.value);
		}else{
			lichange2(this.value);
		}
	});
};


var change = function($input) {

}

$('.line2input1').RangeSlider({min: 0,max: 100,step: 0.01,callback: change});
$('.line2input2').RangeSlider({min: 0,max: 100,step: 0.01,callback: change});

/*li变色开始*/
function lichange1(shuzhi) {
	if ($("body").attr("class")!="dark-body") {
		if(shuzhi > 1 && shuzhi < 25) {
			if($(".line2 li:nth-child(2)").css('background') != '#03c382') {
				$(".line2 li:nth-child(1)").css({'background': '#03c382'});
			}
			$(".line2 li:nth-child(2)").css({'background': '#f0f3f5'});
			$(".line2 li:nth-child(3)").css({'background': '#f0f3f5'});
			$(".line2 li:nth-child(4)").css({'background': '#f0f3f5'});
		} else if(shuzhi >= 25 && shuzhi < 50) {
			if($(".line2 li:nth-child(3)").css('background') != '#03c382') {		
				$(".line2 li:nth-child(2)").css({'background': '#03c382'});
				$(".line2 li:nth-child(1)").css({'background': '#03c382'});
			} 
				$(".line2 li:nth-child(3)").css({'background': '#f0f3f5'});
				$(".line2 li:nth-child(4)").css({'background': '#f0f3f5'});
		} else if(shuzhi >= 50 && shuzhi < 75) {
			if($(".line2 li:nth-child(4)").css('background') != '#03c382') {
				$(".line2 li:nth-child(3)").css({'background': '#03c382'});
				$(".line2 li:nth-child(2)").css({'background': '#03c382'});
				$(".line2 li:nth-child(1)").css({'background': '#03c382'});
			} 
				$(".line2 li:nth-child(4)").css({'background': '#f0f3f5'});
		} else if(shuzhi >= 75 && shuzhi < 100) {
			$(".line2 li:nth-child(4)").css({'background': '#03c382'});
			$(".line2 li:nth-child(3)").css({'background': '#03c382'});
			$(".line2 li:nth-child(2)").css({'background': '#03c382'});
			$(".line2 li:nth-child(1)").css({'background': '#03c382'});
		}
	} else{
		if(shuzhi > 1 && shuzhi < 25) {
			if($(".line2 li:nth-child(2)").css('background') != '#027d58') {
				$(".line2 li:nth-child(1)").css({'background': '#027d58'});
			}
			$(".line2 li:nth-child(2)").css({'background': '#222f47'});
			$(".line2 li:nth-child(3)").css({'background': '#222f47'});
			$(".line2 li:nth-child(4)").css({'background': '#222f47'});
		} else if(shuzhi >= 25 && shuzhi < 50) {
			if($(".line2 li:nth-child(3)").css('background') != '#027d58') {		
				$(".line2 li:nth-child(2)").css({'background': '#027d58'});
				$(".line2 li:nth-child(1)").css({'background': '#027d58'});
			} 
				$(".line2 li:nth-child(3)").css({'background': '#222f47'});
				$(".line2 li:nth-child(4)").css({'background': '#222f47'});
		} else if(shuzhi >= 50 && shuzhi < 75) {
			if($(".line2 li:nth-child(4)").css('background') != '#027d58') {
				$(".line2 li:nth-child(3)").css({'background': '#027d58'});
				$(".line2 li:nth-child(2)").css({'background': '#027d58'});
				$(".line2 li:nth-child(1)").css({'background': '#027d58'});
			} 
				$(".line2 li:nth-child(4)").css({'background': '#222f47'});
		} else if(shuzhi >= 75 && shuzhi < 100) {
			$(".line2 li:nth-child(4)").css({'background': '#027d58'});
			$(".line2 li:nth-child(3)").css({'background': '#027d58'});
			$(".line2 li:nth-child(2)").css({'background': '#027d58'});
			$(".line2 li:nth-child(1)").css({'background': '#027d58'});
		}
	}
}

function lichange2(shuzhi2){
	if ($("body").attr("class")!="dark-body") {
		if(shuzhi2 > 1 && shuzhi2 < 25) {
			if($(".line21 li:nth-child(2)").css('background') != '#fd6777') {
				$(".line21 li:nth-child(1)").css({'background': '#fd6777'});
			}
			$(".line21 li:nth-child(2)").css({'background': '#f0f3f5'});
			$(".line21 li:nth-child(3)").css({'background': '#f0f3f5'});
			$(".line21 li:nth-child(4)").css({'background': '#f0f3f5'});
		} else if(shuzhi2 >= 25 && shuzhi2 < 50) {
			if($(".line21 li:nth-child(3)").css('background') != '#fd6777') {		
				$(".line21 li:nth-child(2)").css({'background': '#fd6777'});
				$(".line21 li:nth-child(1)").css({'background': '#fd6777'});
			} 
				$(".line21 li:nth-child(3)").css({'background': '#f0f3f5'});
				$(".line21 li:nth-child(4)").css({'background': '#f0f3f5'});
		} else if(shuzhi2 >= 50 && shuzhi2 < 75) {
			if($(".line21 li:nth-child(4)").css('background') != '#fd6777') {
				$(".line21 li:nth-child(3)").css({'background': '#fd6777'});
				$(".line21 li:nth-child(2)").css({'background': '#fd6777'});
				$(".line21 li:nth-child(1)").css({'background': '#fd6777'});
			} 
				$(".line21 li:nth-child(4)").css({'background': '#f0f3f5'});
		} else if(shuzhi2 >= 75 && shuzhi2 < 100) {
			$(".line21 li:nth-child(4)").css({'background': '#fd6777'});
			$(".line21 li:nth-child(3)").css({'background': '#fd6777'});
			$(".line21 li:nth-child(2)").css({'background': '#fd6777'});
			$(".line21 li:nth-child(1)").css({'background': '#fd6777'});
		}
	} else{
		if(shuzhi2 > 1 && shuzhi2 < 25) {
			if($(".line21 li:nth-child(2)").css('background') != '#bd3242') {
				$(".line21 li:nth-child(1)").css({'background': '#bd3242'});
			}
			$(".line21 li:nth-child(2)").css({'background': '#222f47'});
			$(".line21 li:nth-child(3)").css({'background': '#222f47'});
			$(".line21 li:nth-child(4)").css({'background': '#222f47'});
		} else if(shuzhi2 >= 25 && shuzhi2 < 50) {
			if($(".line21 li:nth-child(3)").css('background') != '#bd3242') {		
				$(".line21 li:nth-child(2)").css({'background': '#bd3242'});
				$(".line21 li:nth-child(1)").css({'background': '#bd3242'});
			} 
				$(".line21 li:nth-child(3)").css({'background': '#222f47'});
				$(".line21 li:nth-child(4)").css({'background': '#222f47'});
		} else if(shuzhi2 >= 50 && shuzhi2 < 75) {
			if($(".line21 li:nth-child(4)").css('background') != '#bd3242') {
				$(".line21 li:nth-child(3)").css({'background': '#bd3242'});
				$(".line21 li:nth-child(2)").css({'background': '#bd3242'});
				$(".line21 li:nth-child(1)").css({'background': '#bd3242'});
			} 
				$(".line21 li:nth-child(4)").css({'background': '#222f47'});
		} else if(shuzhi2 >= 75 && shuzhi2 < 100) {
			$(".line21 li:nth-child(4)").css({'background': '#bd3242'});
			$(".line21 li:nth-child(3)").css({'background': '#bd3242'});
			$(".line21 li:nth-child(2)").css({'background': '#bd3242'});
			$(".line21 li:nth-child(1)").css({'background': '#bd3242'});
		}
	}
}

/*li变色结束*/

//进度条数值变化
function jdtbh(id) {
	switch(id) {
		case "1":
			if($("#mmtt2").val() != "" && $("#mmtt2").val() != "0" && $("#mmtt1").val() != "" && $("#mmtt1").val() != "0") {
				var m1 = ($("#mmtt1").val()) / ($("#mmtt2").val()); //计算百分比值
				lichange1(m1 * 100);
				$(".line2input1").css('background-size',(m1 * 100)+'% 100%'); 
				$(".line2input1").val(m1 * 100).slider("refresh"); //移动进度条	
			}
			break;
		case "2":
			if($("#mmtt2").val() != "" && $("#mmtt2").val() != "0" && $("#mmtt1").val() != "" && $("#mmtt1").val() != "0") {
				var m1 = ($("#mmtt1").val()) / ($("#mmtt2").val()); //计算百分比值

				lichange1(m1 * 100);
				$(".line2input1").css('background-size',(m1 * 100)+'% 100%'); 
				$(".line2input1").val(m1 * 100).slider("refresh"); //移动进度条	

			}
			break;
		case "3":
			if($("#mmtt3").val() != "" && $("#mmtt3").val() != "0" && $("#mmtt4").val() != "" && $("#mmtt4").val() != "0") {
				var m1 = ($("#mmtt3").val()) / ($("#mmtt4").val()); //计算百分比值
                lichange2(m1 * 100);
				$(".line232").css('background-size',(m1 * 100)+'% 100%'); 
				$(".line232").val(m1 * 100).slider("refresh"); //移动进度条
		
			}
			break;
		case "4":
			if($("#mmtt3").val() != "" && $("#mmtt3").val() != "0" && $("#mmtt4").val() != "" && $("#mmtt4").val() != "0") {
				var m1 = ($("#mmtt3").val()) / ($("#mmtt4").val()); //计算百分比值

				lichange2(m1 * 100);
				$(".line232").css('background-size',(m1 * 100)+'% 100%'); 
				$(".line232").val(m1 * 100).slider("refresh"); //移动进度条

			}
			break;
	}
}

