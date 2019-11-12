<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Retrieve .jsp' starting page</title>
    
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
    <script type="text/javascript">
  
  	function checkform(){
			var uname=document.myform.uname.value;
			
			var utureName=document.myform.utureName.value;
			var  reg2 = /^[\u4e00-\u9fa5]{2,4}$/;
			if(uname==0){
				alert("用户名不能为空");
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
  <!-- <center>
    <form action="Retrieve" method="post">
            请输入用户名：
            <input type="text" name="uname"><br>
  	     请输入用户真实姓名
  	     <input type="text" name="utureName"><br>
  	     <input type="submit" value="立即找回">
    
    
    </form>
    </center> -->
    <form action="Retrieve" method="post" onsubmit="return checkform()" name="myform">
<div id="content">
    <div class="login-header">
        找回密码
    </div>
    <form>
        <div class="login-input-box">
            <span class="icon icon-user"></span>
          ${empty  param.codaq ? "":"用户名或真实姓名错误！" }
            <input type="text" name="uname" placeholder="请输入用户名">
        </div>
        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="text" name="utureName" placeholder="请输入用户真实姓名">
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
        <a href="register.jsp">注册</a>
    </div>
</div>
</form>
  </body>
</html>
