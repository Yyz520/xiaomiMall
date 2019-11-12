<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="./css/login.css">
		<script type="text/javascript">
		function checkform(){
			var uname=document.myform.uname.value;
			var upassword=document.myform.upassword.value;
			var rupassword=document.myform.rupassword.value
			var utureName=document.myform.utureName.value;
			var  reg2 = /^[\u4e00-\u9fa5]{2,4}$/;
			if(uname==0){
				alert("用户名不能为空");
				return false;
			}if(upassword==0){
				alert("密码不能为空");
				return false;
			}else{
				var reg1=/^[\w]{6,12}$/;
			if(!reg1.test(upassword)){
				alert("密码由6-12位数字和字母组成!");
				return false;
				}
			}if(rupassword!=upassword){
				alert("两次密码不一致");
				return false;
			}if(!( /^[\u0391-\uFFE5]+$/.test(utureName))){
				alert("真实姓名格式不正确，请重新输入");
				return false;
			}else{
			if(utureName==0){
			alert("用户名不能为空");
			return false;
				}
			}
	
		}
		
		</script>


	</head>
	<body>
		<form  method="post" action="Register" onsubmit="return checkform()" name="myform">
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl" >欢迎来到注册页面</div>
					<div class="right fr"><a href="main.jsp">手机商城</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				
				<div class="regist_main center">
				<center>
				    <div class="username" >${empty  param.b ? "":"用户名已存在" }</div></center>
					<div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text" name="uname" placeholder="请输入你的用户名" /><span>用户名不能为空</span></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="upassword" placeholder="请输入你的密码" value="${requestScope.upassword }"/><span>密码由6-12位数字和字母组成！</span></div>
					
					<div class="username">确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="rupassword" placeholder="请确认你的密码" value="${requestScope.upassword }"/><span>两次密码要输入一致哦</span></div>
					<div class="username">真实姓名：<input class="shurukuang" type="text" name="utureName" placeholder="请输入真实姓名"  value="${requestScope.utureName }"/><span>请输入真实姓名,必须为中文汉字</span></div>

				</div>
				<div class="regist_submit">
					<input class="submit" type="submit" name="submit" value="立即注册" >
				</div>
				
			</div>
		</div>
		</form>
	</body>
</html>
