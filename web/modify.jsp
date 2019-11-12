<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	<style>
        #content{
            background-color: rgba(255, 255, 255, 0.95);
            width: 420px;
            height: 300px;
            border: 1px solid #000000;
            border-radius: 6px;
            padding: 10px;
            margin-top: 15%;
            margin-left: auto;
            margin-right: auto;
            display: block;
        }

        .login-header{
            width: 100%;
            height: 48px;
            margin-bottom: 20px;
            text-align: center;
            border-bottom: 1px solid #dcdcdc;
        }

        .login-input-box{
            margin-top: 12px;
            width: 100%;
            margin-left: auto;
            margin-right: auto;
            display: inline-block;
        }

        .login-input-box input{
            width: 340px;
            height: 32px;
            margin-left: 18px;
            border: 1px solid #dcdcdc;
            border-radius: 4px;
            padding-left: 42px;
        }

        .login-input-box input:hover{
            border: 1px solid #ff7d0a;
        }

        .login-input-box input:after{
            border: 1px solid #ff7d0a;
        }

        .login-input-box .icon{
            width: 24px;
            height: 24px;
            margin: 6px 4px 6px 24px;
            background-color: #ff7d0a;
            display: inline-block;
            position: absolute;
            border-right: 1px solid #dcdcdc;
        }

        .login-input-box .icon.icon-user{
            background: url("https://static.easyicon.net/preview/106/1068661.gif");
        }

        .login-input-box .icon.icon-password{
            background: url("../assets/images/password.png");
        }

        .remember-box{
            width: auto;
            height: auto;
            margin-left: 18px;
            margin-top: 12px;
            font-size: 12px;
            color: #6a6765;
        }

        .login-button-box{
            margin-top: 12px;
            width: 100%;
            margin-left: auto;
            margin-right: auto;
            display: inline-block;
        }

        .login-button-box button{
            background-color: #ff7d0a;
            color: #ffffff;
            font-size: 16px;
            width: 386px;
            height: 40px;
            margin-left: 18px;
            border: 1px solid #ff7d0a;
            border-radius: 4px;
        }

        .login-button-box button:hover{
            background-color: #ee7204;
        }

        .login-button-box button:active{
            background-color: #ee7204;
        }

        .logon-box{
            margin-top: 20px;
            text-align: center;
        }

        .logon-box a{
            margin: 30px;
            color: #4a4744;
            font-size: 13px;
            text-decoration: none;
        }

        .logon-box a:hover{
            color: #ff7d0a;
        }

        .logon-box a:active{
            color: #ee7204;
        }
    </style>

  </head>
  <script type="text/javascript">
  function checkform(){
  		var upassword=document.myform.upassword.value;
		var upassword1=document.myform.upassword1.value
  
  			if(upassword==0){
				alert("密码不能为空");
				return false;
			}else{
				var reg1=/^[\w]{6,12}$/;
			if(!reg1.test(upassword)){
				alert("密码由6-12位数字和字母组成!");
				return false;
				}
			}if(upassword1!=upassword){
				alert("两次密码不一致");
				return false;
				}
  
  } 
   
  
  
  
  </script>
  
  <body>
  <form action="Modify" method="post" onsubmit="return checkform()" name="myform">
  <%-- <input type="hidden" name="uname" value="${sessionScope.uname }">
  	请输入新的密码：
    	<input type="text" name="upassword"><br>
   	 请确认两次密码一致
   	 	<input type="text" name="upassword1"><br>
    	<input type="submit" value="确定"> --%>
    	<div id="content">
    <div class="login-header">
        找回密码
    </div>
    <form>
        <div class="login-input-box">
            <span class="icon icon-user"></span>
            <input type="hidden" name="uname" value="${sessionScope.uname }">
            <input type="password" name="upassword" placeholder="请输入要求改的密码">
        </div>
        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" name="upassword1" placeholder="请确认要修改的密码">
        </div>
    </form>
    <div class="remember-box">
        <label>
           <!--  <input type="checkbox">&nbsp;Remember Me -->
        </label>
    </div>
    <div class="login-button-box">
        <!-- <button>ç»å½</button> -->
       <button> <input type="submit" value="立即找回"></button>
    </div>
    <div class="logon-box">
        <a href="login.jsp">登录</a>
        <a href="register">注册</a>
    </div>
</div>
    </form>
  </body>
</html>
