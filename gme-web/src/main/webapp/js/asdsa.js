var myChart = echarts.init(document.getElementById('main'));
// 指定图表的配置项和数据

function splitData(rawData) {
	var categoryData = [];
	var values = [];
	var volumns = [];
	var kpj = [];
	var spj = [];
	var zdj = [];
	var zgj = [];
	for(var i = 0; i < rawData.length; i++) {
		categoryData.push(rawData[i].splice(0, 1)[0]);
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
//平均值

function sf() {

	$.get('js/data.json', function(rawData) {

		 var data = splitData(rawData);

    myChart.setOption(option = {
        backgroundColor: '#fff',
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
            position: function (pos, params, el, elRect, size) {
                var obj = {top: 10};
                obj[['left', 'right'][+(pos[0] < size.viewSize[0] / 2)]] = 30;
                return obj;
            }
            // extraCssText: 'width: 170px'
        },
        axisPointer: {
            link: {xAxisIndex: 'all'},
            label: {
                backgroundColor: '#777'
            }
        },
        toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: false
                },
                brush: {
                    type: ['lineX', 'clear']
                }
            }
        },
        brush: {
            xAxisIndex: 'all',
            brushLink: 'all',
            outOfBrush: {
                colorAlpha: 0.1
            }
        },
        visualMap: {
            show: false,
            seriesIndex: 5,
            dimension: 2,
            pieces: [{
                value: 1,
                color: downColor
            }, {
                value: -1,
                color: upColor
            }]
        },
        grid: [
            {
                left: '10%',
                right: '8%',
                height: '50%'
            },
            {
                left: '10%',
                right: '8%',
                top: '63%',
                height: '16%'
            }
        ],
        xAxis: [
            {
                type: 'category',
                data: data.categoryData,
                scale: true,
                boundaryGap : false,
                axisLine: {onZero: false},
                splitLine: {show: false},
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
                boundaryGap : false,
                axisLine: {onZero: false},
                axisTick: {show: false},
                splitLine: {show: false},
                axisLabel: {show: false},
                splitNumber: 20,
                min: 'dataMin',
                max: 'dataMax'
                // axisPointer: {
                //     label: {
                //         formatter: function (params) {
                //             var seriesValue = (params.seriesData[0] || {}).value;
                //             return params.value
                //             + (seriesValue != null
                //                 ? '\n' + echarts.format.addCommas(seriesValue)
                //                 : ''
                //             );
                //         }
                //     }
                // }
            }
        ],
        yAxis: [
            {
                scale: true,
                splitArea: {
                    show: true
                }
            },
            {
                scale: true,
                gridIndex: 1,
                splitNumber: 2,
                axisLabel: {show: false},
                axisLine: {show: false},
                axisTick: {show: false},
                splitLine: {show: false}
            }
        ],
        dataZoom: [
            {
                type: 'inside',
                xAxisIndex: [0, 1],
                start: 98,
                end: 100
            },
            {
                show: true,
                xAxisIndex: [0, 1],
                type: 'slider',
                top: '85%',
                start: 98,
                end: 100
            }
        ],
        series: [
            {
                name: 'Dow-Jones index',
                type: 'candlestick',
                data: data.values,
                itemStyle: {
                    normal: {
                        color: upColor,
                        color0: downColor,
                        borderColor: null,
                        borderColor0: null
                    }
                },
                tooltip: {
                    formatter: function (param) {
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
            },
            {
                name: 'MA5',
                type: 'line',
                data: calculateMA(5, data),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA10',
                type: 'line',
                data: calculateMA(10, data),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA20',
                type: 'line',
                data: calculateMA(20, data),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'MA30',
                type: 'line',
                data: calculateMA(30, data),
                smooth: true,
                lineStyle: {
                    normal: {opacity: 0.5}
                }
            },
            {
                name: 'Volume',
                type: 'bar',
                xAxisIndex: 1,
                yAxisIndex: 1,
                data: data.volumes
            }
        ]
    }, true);
	});
	// 使用刚指定的配置项和数据显示图表。
}

function fzm() {

	$.get('js/fz.json', function(rawData) {

		var data = splitData(rawData);

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
				position: function(pos, params, el, elRect, size) {
					var obj = {
						top: 10
					};
					obj[['left', 'right'][+(pos[0] < size.viewSize[0] / 2)]] = 30;
					return obj;
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
					left: '2%',
					right: '5%',
					height: '50%'
				},
				{
					left: '2%',
					right: '5%',
					top:'70%',
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
						show: true
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
//					splitLine: {
//						show: false
//					}, //去除网格线
//					splitArea: {
//						show: false
//					}, //去除网格区域
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
						show: true
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
								var colorList = ['rgba(98, 200, 98, 0.5)', 'rgba(253, 67, 67, 0.5)'];
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
	setTimeout("fzm()",2000);
}
// 使用刚指定的配置项和数据显示图表。
fzm();

$(".tb a").click(function(){
	
	$(this).addClass("action").siblings().removeClass('action');
	
})
