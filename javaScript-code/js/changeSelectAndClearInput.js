/*
 * 原生js实现下拉框改变时清空备注栏
 * 当下拉框的值从111111变为111111之外的值时，清空对应的Input
 */

// 页面onload时获取初期化时的oldValue
window.onload = getFirstValue();

var oldValue;
// 获取下拉框选中的项目的value
function getFirstValue(){
	var obj = window.document.getElementById(objId);
	for (i=0;i<obj.length;i++){
		if(obj[i].selected==true){
			oldValue = obj[i].value;
		}
	}
}
// 判断oldValue，并清空Input，之后取改变之后的值用来进行下一次判断
function changeValue(){
	var obj = window.document.getElementById(objId);
	var objInput = window.document.getElementById(inputId);
	
	if(oldValue == '111111'){
		objInput.value = "";
	}
	
	for (i=0;i<obj.length;i++){
		if(obj[i].selected==true){
			oldValue = obj[i].value;
		}
	}
}
