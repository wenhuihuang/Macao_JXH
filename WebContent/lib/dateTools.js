//JSON转为Date型    串入JSON 的Time字段即可 
function json2TimeStamp(currentDate){
	
	if(currentDate==null||currentDate==""){
		return null;
	}
	
	var  milliseconds = currentDate.time;
	
	var datetime = new Date();
	datetime.setTime(milliseconds);

	var year=datetime.getFullYear();

	//月份重0开始，所以要加1，当小于10月时，为了显示2位的月份，所以补0

	var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
	var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
	var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
	
	//return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
	return year + "-" + month + "-" + date;

}


//字符串转日期型
function tranStrToDate(str){
	if(str==null||str==""){
		return null;
	}
	return new  Date(Date.parse(str.replace(/-/g,   "/"))); 
}


//日期转字符串
function tranDateToStr(datetime){
	if(datetime==null||datetime==""){
		
		return null;
	}
	
	var year=datetime.getFullYear();

	//月份重0开始，所以要加1，当小于10月时，为了显示2位的月份，所以补0

	var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
	var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
	var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
	//+" "+hour+":"+minute+":"+second;
	return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
	
}