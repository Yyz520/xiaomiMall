<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>登陆</title>
	<link rel="stylesheet" href="./css/base.css">
	<script type="text/javascript"
    src="<%=basePath %>js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<div class="cp">
		<div class="cp_form">
			<form action="Login" method="post">
				<div class="cp_title"> 你还不是我们的用户？<a href="register.jsp">立即注册吧！</a></div>
				<div class="login_main center">
				   <!--  <div class="username" > -->${empty  param.code ? "":"验证码错误！" }<!-- </div> -->
				    
  
				     <!--  <div class="username" > -->${empty  param.coda ? "":"用户名或密码输入错误请重新输入！" } 
				    </center>
					<div class="username">用户名:&nbsp;<input class="shurukuang" type="text" name="uname" placeholder="请输入你的用户名"></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password" name="upassword" placeholder="请输入你的密码"></div>
					<div class="username username_last">
						验证码:&nbsp;&nbsp;&nbsp;
						<!-- <input type="text" class="ewm" placeholder="请输入验证码" name="uyan">
						
						<img src="./image/ewm.png" alt="验证码"> -->
						<input type="text" name="code" id="code" style="width: 80px;height: 30px" />
						<a href="javascript:;" onclick="changeImg()"><img id="imgObj" alt="验证码"
            				src="${pageContext.request.contextPath}/getCode"></a><br/>
						<input type="hidden" name="utel">
						<input type="hidden" name="uemail"> 
						<input type="hidden" name="utureName">
						<input type="hidden" name="uaddress">
					</div>
					<div class="findpassword">
						<a href="retrieve .jsp">找回密码</a>
					</div>
					<div class="login_submit">
						<input class="submit" type="submit" name="submit" value="立即登录">
					</div>
					<div>   </div>
					<div>  </div>
				</div>
			</form>
		</div>
	</div>
	<div>
		
	</div>
</body>
	<script type="text/javascript">
    $(function() {

    });

    function changeImg() {        
        var imgSrc = $("#imgObj");    
        var src = imgSrc.attr("src");        
        imgSrc.attr("src", chgUrl(src));
    }
    
    
    // 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        url = url.substring(0, 20);
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }

</script>
	
</html>