<%@page import="com.sc.dao.UserDao"%>
<%@page import="com.sc.bean.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
		<title>我的个人中心</title>
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<link rel="stylesheet" type="text/css" href="css/login.style.css">
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
			var utel=document.myform.utel.value;
			var upassword=document.myform.upassword.value;
			var uemail=document.myform.uemail.value;
			var uidentity=document.myform.uidentity.value;
			var uaddress=document.myform.uaddress.value;
			if(uname.length==0){
			alert("用户名不能为空");
			return false;
		} else{            
                var yanz=/^[a-zA-Z\u4e00-\u9fa5]+$/;
                if(!yanz.test(uname)){
                    alert("用户名必须是汉字或字母");
                    return false;
            }
		}
		
}		
		</script>
		
		
		
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li>&nbsp;手机商城&nbsp;</li>
						<li>|</li>
						<li>&nbsp;MIUI&nbsp;</li>
						<li>|</li>
						<li>&nbsp;游戏&nbsp;</li>
						<li>|</li>
						<li>&nbsp;多看阅读&nbsp;</li>
						<li>|</li>
						<li>&nbsp;云服务&nbsp;</li>
						<li>|</li>
						<li>&nbsp;金融&nbsp;</li>
						<li>|</li>
						<li>&nbsp;问题反馈&nbsp;</li>
						<li>|</li>
						<li>&nbsp;Select Region&nbsp;</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="DingDan">我的订单</a></div>
					<div class="fr">
						<ul>
							<c:if test="${empty sessionScope.self.uname }">
							<li><a href="login.jsp">登录</a></li>
							<li>|</li>
							<li><a href="register.jsp">注册</a></li>
							<li>|</li>
						</c:if>
						<c:if test="${not empty sessionScope.self.uname }">
							<li>欢迎,${sessionScope.self.uname }&nbsp;&nbsp;</li>
							<li>|</li>
							<li><a href="Logout">退出</a></li>
							<li>|</li>
							<li><a href="main.jsp">首页</a></li>
							<li>|</li>
						</c:if>	
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li>我的订单</li>
					<li>意外保</li>
					<li>团购订单</li>
					<li>评价晒单</li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li style="color:#ff6700;font-weight:bold;">我的个人中心</li>
					<li>消息通知</li>
					<li>优惠券</li>
					<li>收货地址</li>
				</ul>
			</div>
		</div>
		
		<div class="rtcont fr">
			<div class="grzlbt ml40">我的资料</div>
			<div class="subgrzl ml40"><span>用户名</span><span>&nbsp;${sessionScope.self.uname }</span></div>
			<div class="subgrzl ml40"><span>手机号</span><span>&nbsp;${sessionScope.self.utel }</span></div>
		 	<div class="subgrzl ml40"><span>密码</span><span>&nbsp; <input type="password" value="${sessionScope.self.upassword }"  readonly="readonly" style="border-width: 0; "></span></div> 
			 
			 
			 <div class="subgrzl ml40"><span>电子邮箱</span><span>&nbsp;${sessionScope.self.uemail }</span></div>
			<div class="subgrzl ml40"><span>姓名</span><span>&nbsp;${sessionScope.self.utureName }</span></div>
			<div class="subgrzl ml40"><span>收货地址</span><span>&nbsp;${sessionScope.self.uaddress }</span></div>
			 <div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;<a href="individual.jsp"><input type="button" value="编辑个人信息" ></a></div> 
			
			
			 
		</div>
		<div class="clear"></div>
		</div>
	</div>
<!-- self_info -->
		
		<footer class="mt20 center">			
			<div class="mt20">手机商城|多宝聊|多看书城|路由器|视频电话|手机天猫店|手机淘宝直营店|手机网盟|中国移动|隐私政策|Select Region</div>
			<div>@234.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-****-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>
	</body>
</html>
