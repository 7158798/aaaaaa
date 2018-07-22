
var myChart = echarts.init(document.getElementById('main'));


// 指定图表的配置项和数据

// 解析分钟线数据
function splitDataWithHours(rawData) {
	var categoryData = [];
	var values = [];
	var volumns = [];
	var kpj = [];
	var spj = [];
	var zdj = [];
	var zgj = [];
	for(var i = 0; i < rawData.length; i++) {
		categoryData.push(getFormatDateWithHours(rawData[i].splice(0, 1)[0]));
		values.push(rawData[i]);
		volumns.push(rawData[i][4]);
		kpj.push(rawData[i][0]);
		spj.push(rawData[i][1]);
		zdj.push(rawData[i][2]);
		zgj.push(rawData[i][3]);
	}
	return {
		categoryData: categoryData,
		values: values,
		volumns: volumns,
		kpj: kpj,
		spj: spj,
		zdj: zdj,
		zgj: zgj,
	};
}



//解析小时及以上数据
function splitData(rawData) {
	var categoryData = [];
	var values = [];
	var volumns = [];
	var kpj = [];
	var spj = [];
	var zdj = [];
	var zgj = [];
	for(var i = 0; i < rawData.length; i++) {
		categoryData.push(getFormatDate(rawData[i].splice(0, 1)[0]));
		values.push(rawData[i]);
		volumns.push(rawData[i][4]);
		kpj.push(rawData[i][0]);
		spj.push(rawData[i][1]);
		zdj.push(rawData[i][2]);
		zgj.push(rawData[i][3]);
	}
	return {
		categoryData: categoryData,
		values: values,
		volumns: volumns,
		kpj: kpj,
		spj: spj,
		zdj: zdj,
		zgj: zgj,
	};
}



function calculateMA(dayCount, data) {
	var result = [];
	for(var i = 0, len = data.values.length; i < len; i++) {
		if(i < dayCount) {
			result.push('-');
			continue;
		}
		var sum = 0;
		for(var j = 0; j < dayCount; j++) {
			sum += data.values[i - j][1];
		}
		result.push(+(sum / dayCount).toFixed(3));
	}
	return result;
}

// 改变k线选中的样式
function cancleKlineStyle(){
	$("#klineStyle").children().attr("style","");
}

//分钟线
function sf(type){
	cancleKlineStyle();
	if (type==1) {
		$("#klineStyle").children().eq(0).attr("style","color: #41b2ce;");
	}
	if (type==5) {
		$("#klineStyle").children().eq(1).attr("style","color: #41b2ce;");
	}
	if (type==15) {
		$("#klineStyle").children().eq(2).attr("style","color: #41b2ce;");
	}
	if (type==30) {
		$("#klineStyle").children().eq(3).attr("style","color: #41b2ce;");
	}
	
	if(type == 1)
	{ 
		fzm(type+"min");
	}
	else
	{ 
		kline(type+"min");
	}
	
}

//小时线
function xs(type){
	cancleKlineStyle();
	if (type==1) {
		$("#klineStyle").children().eq(4).attr("style","color: #41b2ce;");
	}
	if (type==4) {
		$("#klineStyle").children().eq(5).attr("style","color: #41b2ce;");
	}
	kline(type+"hour");
}

//日线
function day(type){
	cancleKlineStyle();
	if (type==1) {
		$("#klineStyle").children().eq(6).attr("style","color: #41b2ce;");
	}
	kline(type+"day");
}

//周线
function week(type){
	cancleKlineStyle();
	if (type==1) {
		$("#klineStyle").children().eq(7).attr("style","color: #41b2ce;");
	}
	kline(type+"week");
}

//月线
function month(type){
	cancleKlineStyle();
	if (type==1) {
		$("#klineStyle").children().eq(8).attr("style","color: #41b2ce;");
	}
	kline(type+"month");
}



// 获取k线数据
function kline(type) {
	var url = "http://192.168.136.1:8080/gme-web/api/v1/kline/kline.json";
	var symbol = $("#pairSymbol").text();
	$.get(url,{symbol:symbol,type:type}, function(rawData) {

		var data;
		if (type.indexOf("min") > -1) {
			data = splitDataWithHours(eval(rawData.data));
		}else {
			data = splitData(eval(rawData.data));
		}

		myChart.setOption(option = {
			backgroundColor: '',
			animation: false,
			legend: {
				bottom: 10,
				left: 'center',
				data: ['Dow-Jones index', 'MA5', 'MA10', 'MA20', 'MA30']
			},
			tooltip: {
				trigger: 'axis',
				axisPointer: {
					type: 'cross'
				},
				backgroundColor: 'rgba(245, 245, 245, 0.8)',
				borderWidth: 1,
				borderColor: '#ccc',
				padding: 10,
				textStyle: {
					color: '#000'
				},
				position: function(pt) {
					return [pt[0] - 200, '10%'];
				},
				//extraCssText: 'width: 180px'
			},
			axisPointer: {
				link: {
					xAxisIndex: 'all'
				},
				label: {
					backgroundColor: '#777'
				}
			},
			//			toolbox: {
			//				feature: {
			//					dataZoom: {
			//						yAxisIndex: false
			//					},
			//					brush: {
			//						type: ['lineX', 'clear']
			//					}
			//				}
			//			},
			//			brush: {
			//				xAxisIndex: 'all',
			//				brushLink: 'all',
			//				outOfBrush: {
			//					colorAlpha: 0.1
			//				}
			//			},
			grid: [{
					left: '2%',
					right: '5%',
					height: '60%'
				},
				{
					left: '2%',
					right: '5%',
					top: "70%",
					bottom: '20%',
					height: '25%'

				}
			],
			xAxis: [{
					type: 'category',
					data: data.categoryData,
					scale: true,
					axisLabel: {
						show: true,
						textStyle: {
							color: '#666'
						}
					},
					boundaryGap: false,
					axisLine: {
						onZero: false
					},
					splitLine: {
						show: false
					},
					splitNumber: 20,
					min: 'dataMin',
					max: 'dataMax',
					axisPointer: {
						z: 100
					}
				},
				{
					type: 'category',
					gridIndex: 1,
					data: data.categoryData,
					scale: true,
					boundaryGap: false,
					axisLine: {
						onZero: false
					},
					axisTick: {
						show: false
					},
					splitLine: {
						show: false
					},
					axisLabel: {
						show: false
					},
					splitNumber: 20,
					min: 'dataMin',
					max: 'dataMax',
					axisPointer: {
						label: {
							formatter: function(params) {
								var seriesValue = (params.seriesData[0] || {}).value;
								return params.value +
									(seriesValue != null ?
										'\n' + echarts.format.addCommas(seriesValue) :
										''
									);
							}
						}
					}
				}
			],
			yAxis: [{
					scale: true,
					position: 'right',
					splitArea: {
						show: false
					},
					splitLine: {
						show: false
					},
					axisLabel: {
						show: true,
						textStyle: {
							color: '#666'
						}
					},
				},
				{
					scale: true,
					gridIndex: 1,
					splitNumber: 2,
					axisLabel: {
						show: false
					},
					axisLine: {
						show: false
					},
					axisTick: {
						show: false
					},
					splitLine: {
						show: false
					}, //去除网格线
					splitArea: {
						show: false
					} //去除网格区域

				}
			],
			dataZoom: [{
				type: 'inside',
				xAxisIndex: [0, 1],
				start: 98,
				end: 100
			}],
			series: [{
					name: '开盘价',
					symbol: "none", //Echart 去掉折线上面的小圆点: 只需要加上symbol: "none"即可
					type: 'candlestick',
					data: data.values,
					itemStyle: {
						normal: {
							color: '#03c087',
							color0: '#ef5252',
							borderColor: null,
							borderColor0: null
						}
					},
					tooltip: {
						formatter: function(param) {
							param = param[0];
							return [
								'Date: ' + param.name + '<hr size=1 style="margin: 3px 0">',
								'Open: ' + param.data[0] + '<br/>',
								'Close: ' + param.data[1] + '<br/>',
								'Lowest: ' + param.data[2] + '<br/>',
								'Highest: ' + param.data[3] + '<br/>'
							].join('');
						}
					}
				}, {
					name: '收盘价',
					type: 'line',
					symbol: "none", //Echart 去掉折线上面的小圆点: 只需要加上symbol: "none"即可
					data: data.spj,
					smooth: true,
					lineStyle: {
						normal: {
							opacity: 0
						}
					}
				},
				{
					name: '最低价',
					type: 'line',
					symbol: "none", //Echart 去掉折线上面的小圆点: 只需要加上symbol: "none"即可
					data: data.zdj,
					smooth: true,
					lineStyle: {
						normal: {
							opacity: 0
						}
					}
				},
				{
					name: '最高价',
					type: 'line',
					symbol: "none", //Echart 去掉折线上面的小圆点: 只需要加上symbol: "none"即可
					data: data.zgj,
					smooth: true,
					lineStyle: {
						normal: {
							opacity: 0
						}
					}
				}, {
					name: 'MAD3',
					type: 'line',
					symbol: "none", //Echart 去掉折线上面的小圆点: 只需要加上symbol: "none"即可
					data: calculateMA(3, data),
					smooth: true,
					itemStyle: {
						normal: {
							color: '#d67dbb',
							lineStyle: {
								width: 1, //线的粗细
								color: '#d67dbb' //线的颜色
							}
						}
					},
				},
				{
					name: 'MAD7',
					type: 'line',
					symbol: "none", //Echart 去掉折线上面的小圆点: 只需要加上symbol: "none"即可
					data: calculateMA(7, data),
					smooth: true,
					itemStyle: {
						normal: {
							color: '#8bd696',
							lineStyle: {
								width: 1, //线的粗细
								color: '#8bd696' //线的颜色
							}
						}
					},
				},
				{
					name: 'MAD10',
					type: 'line',
					symbol: "none", //Echart 去掉折线上面的小圆点: 只需要加上symbol: "none"即可
					data: calculateMA(10, data),
					smooth: true,
					itemStyle: {
						normal: {
							color: '#aec9e7',
							lineStyle: {
								width: 1, //线的粗细
								color: '#aec9e7' //线的颜色
							}
						}
					},
				},
				{
					name: 'MAD30',
					type: 'line',
					symbol: "none", //Echart 去掉折线上面的小圆点: 只需要加上symbol: "none"即可
					data: calculateMA(30, data),
					smooth: true,
					itemStyle: {
						normal: {
							color: '#c8abe0 ',
							lineStyle: {
								width: 1, //线的粗细
								color: '#c8abe0' //线的颜色
							}
						}
					},
				},
				{
					name: '交易总金额',
					type: 'bar',
					xAxisIndex: 1,
					yAxisIndex: 1,
					data: data.volumns,
					itemStyle: {
						normal: {
							color: function(params) {
								var colorList = ['rgba(108,182,108, 0.9)', 'rgba(255,111,116, 0.9)'];
								var i = data.volumns.indexOf(params.data);
								if(data.kpj[i] > data.spj[i]) {
									return colorList[1];
								} else {
									return colorList[0];
								}
							}
						}
					}
				}
			]
		}, true);
	});
	// 使用刚指定的配置项和数据显示图表。
}




function fzm(type) {
	var url = "http://192.168.136.1:8080/gme-web/api/v1/kline/kline.json";
	var symbol = $("#pairSymbol").text();
	$.get(url,{symbol:symbol,type:type}, function(rawData) {
		
		
		var data = splitDataWithHours(eval(rawData.data));
 
		myChart.setOption(option = {
			backgroundColor: '',
			animation: false,
			legend: {
				bottom: 10,
				left: 'center',
				data: ['DETA', 'KPJ', 'JYL']
			},
			tooltip: {
				trigger: 'axis',

				axisPointer: {
					type: 'cross'
				},
				backgroundColor: 'rgba(15, 15, 15, 0.8)',
				borderWidth: 1,
				borderColor: '#000',
				padding: 6,
				textStyle: {
					color: '#fff'
				},
				position: function(pt) {
					return [pt[0] - 200, '10%'];
				},
				extraCssText: 'width: 170px'
			},
			axisPointer: {
				link: {
					xAxisIndex: 'all'
				},
				label: {
					backgroundColor: '#777'
				}
			},
			//			toolbox: {
			//				feature: {
			//					dataZoom: {
			//						yAxisIndex: false
			//					},
			//					brush: {
			//						type: ['lineX', 'clear']
			//					}
			//				}
			//			},
			//			brush: {
			//				xAxisIndex: 'all',
			//				brushLink: 'all',
			//				outOfBrush: {
			//					colorAlpha: 0.1
			//				}
			//			},
			grid: [{
					left: '4%',
					right: '5%',
					height: '60%'
				},
				{
					left: '4%',
					right: '5%',
					top: '70%',
					bottom: '20%',
					height: '25%'
				}
			],
			xAxis: [{
					type: 'category',
					data: data.categoryData,
					scale: true,
					axisLabel: {
						show: true,
						textStyle: {
							color: '#666'
						}
					},
					boundaryGap: false,
					axisLine: {
						onZero: false
					},

					splitLine: {
						show: false
					}, //去除网格线
					splitArea: {
						show: false
					}, //去除网格区域
					splitNumber: 20,
					min: 'dataMin',
					max: 'dataMax',
					axisPointer: {
						z: 100
					}
				},
				{
					type: 'category',
					gridIndex: 1,
					data: data.categoryData,
					scale: true,
					boundaryGap: false,
					axisLine: {
						onZero: false
					},
					axisTick: {
						show: false
					},
					axisLabel: {
						show: false
					},
					splitLine: {
						show: false
					}, //去除网格线
					splitArea: {
						show: false
					}, //去除网格区域
					splitNumber: 20,
					min: 'dataMin',
					max: 'dataMax',
					axisPointer: {
						label: {
							formatter: function(params) {
								var seriesValue = (params.seriesData[0] || {}).value;
								return params.value +
									(seriesValue != null ?
										'\n' + echarts.format.addCommas(seriesValue) :
										''
									);
							}
						}
					}
				}
			],
			yAxis: [{
					scale: true,
					position: 'right',
					splitLine: {
						show: false
					}, //去除网格线
					splitArea: {
						show: false
					}, //去除网格区域
					axisLabel: {

						show: true,
						textStyle: {
							color: '#666'
						}
					},
				},
				{
					scale: true,
					gridIndex: 1,
					splitNumber: 2,
					axisLabel: {
						show: false
					},
					axisLine: {
						show: false
					},
					axisTick: {
						show: false
					},
					splitLine: {
						show: false
					}
				}
			],
			dataZoom: [{
				type: 'inside',
				xAxisIndex: [0, 1],
				start: 98,
				end: 100
			}],
			series: [{
					name: '当前市场价',
					type: 'line',
					symbol: "none", //Echart 去掉折线上面的小圆点: 只需要加上symbol: "none"即可
					data: data.kpj,
					smooth: true,
					itemStyle: {
						normal: {
							color: '#9076b5',
							lineStyle: {
								color: '#9076b5'
							}
						}
					},
					areaStyle: {
						color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
							offset: 0,
							color: 'rgba(181, 181, 181, 0.6)'
						}, {
							offset: 1,
							color: 'rgba(181, 181, 181, 0.1)'
						}])
					}
				},
				{
					name: '交易总额',
					type: 'bar',
					xAxisIndex: 1,
					yAxisIndex: 1,
					Maxheight: 10,
					data: data.volumns,
					itemStyle: {
						normal: {
							color: function(params) {
								var colorList = ['rgba(108,182,108, 0.9)', 'rgba(255,111,116, 0.9)'];
								var i = data.volumns.indexOf(params.data);
								if(data.kpj[i] > data.spj[i]) {
									return colorList[1];
								} else {
									return colorList[0];
								}
								//下面柱形图算法在这里。
							}
						}
					}
				}
			]
		}, true);

	});
}
// 使用刚指定的配置项和数据显示图表。
fzm("1min");

// 深度图
function sdt() {
	
	$.get('js/sdt.json', function(rawData) {
		var dom = document.getElementById("container");
		var myChart = echarts.init(dom);
		var app = {};
		option = null;
		app.title = '坐标轴刻度与标签对齐';
		var data = sdtt(rawData);

		option = {
			tooltip: {
				trigger: 'axis',
				axisPointer: { // 坐标轴指示器，坐标轴触发有效
					type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid: {
				left: '3%',
				right: '4%',
				bottom: '3%',
				containLabel: true
			},
			xAxis: [{
				name:'价格',
				type: 'category',
				data: data.jiage,
				axisTick: {
					alignWithLabel: true
				},

			}],
			yAxis: [{
				type: 'value',
				splitLine: {
					show: false
				}, //去除网格线
				splitArea: {
					show: false
				}, //去除网格区域
			}],
			series: [{
				name: '累计',
				type: 'bar',
				barWidth: '100%',
				data: data.shuliang,
				itemStyle: {
					//通常情况下：
					normal: {　　　　　　　　　　　　
						color: function(params) {
							var colorList = ['#e5f9f3', '#fdf0ec'];
							var i = data.shuliang.indexOf(params.data);
							if (data.jiage[i]<data.pdz) {
								return colorList[0];
							} else{
								return colorList[1];
							}
								
							
						}
					}
				},
			}]
		};;
		if(option && typeof option === "object") {
			myChart.setOption(option, true);
		}
	})
}
sdt();

function sdtt(rawData) {
	var jiage = [];
	var shuliang = [];
	var pdz = rawData[0][0];
	for(var i = 1; i < rawData.length; i++) {
		jiage.push(rawData[i][0]);
		shuliang.push(rawData[i][1]);
	}
	return {
		pdz:pdz,
		jiage: jiage,
		shuliang: shuliang
	};
}