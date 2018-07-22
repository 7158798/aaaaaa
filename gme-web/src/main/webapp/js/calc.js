// 判断正则
function checkReg(num){
	// 判断是否是整数
	var reNum=/^\d+(\.\d+)?$/;
	return reNum.test(num);
	
}

// 计算金额，四舍五入，保留两位小数
function clacPrice(price,count){
	var result = price * count;
	return result.toFixed(2);
}

// 计算数量
function clacCount(divisor,dividend){
	var result = divisor/dividend;
	return result;
}
