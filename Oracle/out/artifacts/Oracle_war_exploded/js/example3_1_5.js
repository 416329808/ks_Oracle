function checkform(){  //验证表单数据有效性方法
  if(form1.hym.value==""){
	alert("姓名不能为空");
	form1.hym.focus(); //设置焦点
	return false;
  }

  var tel1=/^1[3|4|5|7|8][0-9]\d{8}$/ ;  //定义正则表达式
  var str=document.form1.dh.value;  //document.可以省略
  if(!tel1.test(str))   //正则测试
  {
	alert("手机号码输入错误");
	form1.dh.focus();
	return false;
  }

  var reg=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/; 
  var str=document.form1.yx.value;
  if(!reg.test(str)){
	alert("邮箱格式不对,请重新输入");
	form1.yx.focus();
	return false;
  }
 /*
 if(form1.qq.value==""){
	alert("qq不能为空");
	form1.qq.focus();
	return false;
 }
 if(form1.dz.value==""){
	alert("地址不能为空");
	form1.dz.focus();
	return false;
 }*/
}
