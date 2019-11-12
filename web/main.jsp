<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<title>手机商城</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<script type="text/javascript">
		function checkform(){
			var sousuo=document.myform.sousuo.value;
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
					<div class="gouwuche fr"><a href="gouwuche.jsp">购物车</a></div>
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
						</c:if>	
						<c:choose>
						<c:when test="${empty sessionScope.self.uname}">
							<li><a href="login.jsp" onclick="return window.confirm('登陆才能查看个人订单，是否登陆？');">&nbsp;&nbsp;个人订单&nbsp;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="DingDan">&nbsp;&nbsp;个人订单&nbsp;</a></li>
						</c:otherwise>
						</c:choose>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="main.jsp"><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="ItemSelect1?cid=1">小米手机</a></li>
					<li><a href="ItemSelect1?cid=2">华为手机</a></li>
					<li><a href="ItemSelect1?cid=3">vivo手机</a></li>
					<li><a href="ItemSelect1?cid=4">OPPO手机</a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="Sousuo" method="post" onsubmit="return checkform()" name="myform">
					<div class="text fl">
						<input type="text" class="shuru" name="sousuo" placeholder="输入相关信息">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->

	<!-- start banner_y -->
		<div class="banner_y center">
			<div class="nav">				
				<ul>
					<li>
						<a href="">手机</a>
						<a href="">电话卡</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="./xiangqing.html" target="_blank">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/5c_80.png" alt=""></div>
											<span class="fl">小米手机5c</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xmNOTE2-80.jpg" alt=""></div>
											<span class="fl">小米Note 2</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米MIX</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米5s</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5Splus.jpg" alt=""></div>
											<span class="fl">小米5s Plus</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>								
							</div>
							<div class="ctn fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5-80.jpg" alt=""></div>
											<span class="fl">小米手机5</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmn4x80.png" alt=""></div>
											<span class="fl">红米Note 4X</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmnote4-80.jpg" alt=""></div>
											<span class="fl">红米Note-4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4x_80.png" alt=""></div>
											<span class="fl">红米4x</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4-80.jpg" alt=""></div>
											<span class="fl">红米4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4A-80.jpg" alt=""></div>
											<span class="fl">红米4A</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="right fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/compare.jpg" alt=""></div>
											<span class="fl">对比手机</span>
											<div class="clear"></div>
										</a>
									</div>
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/mimobile.jpg" alt=""></div>
											<span class="fl">小米移动&nbsp;电话卡</span>
											<div class="clear"></div>
										</a>
									</div>
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</li>
					<li>
						<a href="">笔记本</a>
						<a href="">平板</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/5c_80.png" alt=""></div>
											<span class="fl">小米手机5c</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xmNOTE2-80.jpg" alt=""></div>
											<span class="fl">小米Note 2</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米MIX</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米5s</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5Splus.jpg" alt=""></div>
											<span class="fl">小米5s Plus</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>								
							</div>
							<div class="ctn fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5-80.jpg" alt=""></div>
											<span class="fl">小米手机5</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmn4x80.png" alt=""></div>
											<span class="fl">红米Note 4X</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmnote4-80.jpg" alt=""></div>
											<span class="fl">红米Note-4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4x_80.png" alt=""></div>
											<span class="fl">红米4x</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4-80.jpg" alt=""></div>
											<span class="fl">红米4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4A-80.jpg" alt=""></div>
											<span class="fl">红米4A</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
							</div>
							
							<div class="clear"></div>
						</div>
					</li>
					<li>
						<a href="">电视</a>
						<a href="">盒子</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/5c_80.png" alt=""></div>
											<span class="fl">小米手机5c</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xmNOTE2-80.jpg" alt=""></div>
											<span class="fl">小米Note 2</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米MIX</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米5s</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5Splus.jpg" alt=""></div>
											<span class="fl">小米5s Plus</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>								
							</div>
							<div class="ctn fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5-80.jpg" alt=""></div>
											<span class="fl">小米手机5</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmn4x80.png" alt=""></div>
											<span class="fl">红米Note 4X</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmnote4-80.jpg" alt=""></div>
											<span class="fl">红米Note-4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4x_80.png" alt=""></div>
											<span class="fl">红米4x</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4-80.jpg" alt=""></div>
											<span class="fl">红米4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4A-80.jpg" alt=""></div>
											<span class="fl">红米4A</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="right fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/compare.jpg" alt=""></div>
											<span class="fl">对比手机</span>
											<div class="clear"></div>
										</a>
									</div>
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/mimobile.jpg" alt=""></div>
											<span class="fl">小米移动&nbsp;电话卡</span>
											<div class="clear"></div>
										</a>
									</div>
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</li>
					<li>
						<a href="">路由器</a>
						<a href="">智能硬件</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/5c_80.png" alt=""></div>
											<span class="fl">小米手机5c</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xmNOTE2-80.jpg" alt=""></div>
											<span class="fl">小米Note 2</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米MIX</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米5s</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5Splus.jpg" alt=""></div>
											<span class="fl">小米5s Plus</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>								
							</div>
							<div class="ctn fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5-80.jpg" alt=""></div>
											<span class="fl">小米手机5</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmn4x80.png" alt=""></div>
											<span class="fl">红米Note 4X</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmnote4-80.jpg" alt=""></div>
											<span class="fl">红米Note-4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4x_80.png" alt=""></div>
											<span class="fl">红米4x</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4-80.jpg" alt=""></div>
											<span class="fl">红米4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4A-80.jpg" alt=""></div>
											<span class="fl">红米4A</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="right fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/compare.jpg" alt=""></div>
											<span class="fl">对比手机</span>
											<div class="clear"></div>
										</a>
									</div>
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/mimobile.jpg" alt=""></div>
											<span class="fl">小米移动&nbsp;电话卡</span>
											<div class="clear"></div>
										</a>
									</div>
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</li>
					<li>
						<a href="">移动电源</a>
						<a href="">电池</a>
						<a href="">插线板</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/5c_80.png" alt=""></div>
											<span class="fl">小米手机5c</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xmNOTE2-80.jpg" alt=""></div>
											<span class="fl">小米Note 2</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米MIX</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米5s</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5Splus.jpg" alt=""></div>
											<span class="fl">小米5s Plus</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>								
							</div>
							<div class="ctn fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5-80.jpg" alt=""></div>
											<span class="fl">小米手机5</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmn4x80.png" alt=""></div>
											<span class="fl">红米Note 4X</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmnote4-80.jpg" alt=""></div>
											<span class="fl">红米Note-4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4x_80.png" alt=""></div>
											<span class="fl">红米4x</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4-80.jpg" alt=""></div>
											<span class="fl">红米4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4A-80.jpg" alt=""></div>
											<span class="fl">红米4A</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="right fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/compare.jpg" alt=""></div>
											<span class="fl">对比手机</span>
											<div class="clear"></div>
										</a>
									</div>
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/mimobile.jpg" alt=""></div>
											<span class="fl">小米移动&nbsp;电话卡</span>
											<div class="clear"></div>
										</a>
									</div>
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</li>
					<li>
						<a href="">耳机</a>
						<a href="">音箱</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/5c_80.png" alt=""></div>
											<span class="fl">小米手机5c</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xmNOTE2-80.jpg" alt=""></div>
											<span class="fl">小米Note 2</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米MIX</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米5s</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5Splus.jpg" alt=""></div>
											<span class="fl">小米5s Plus</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="ctn fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5-80.jpg" alt=""></div>
											<span class="fl">小米手机5</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmn4x80.png" alt=""></div>
											<span class="fl">红米Note 4X</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hmnote4-80.jpg" alt=""></div>
											<span class="fl">红米Note-4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4x_80.png" alt=""></div>
											<span class="fl">红米4x</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4-80.jpg" alt=""></div>
											<span class="fl">红米4</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/hm4A-80.jpg" alt=""></div>
											<span class="fl">红米4A</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="right fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/compare.jpg" alt=""></div>
											<span class="fl">对比手机</span>
											<div class="clear"></div>
										</a>
									</div>
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/mimobile.jpg" alt=""></div>
											<span class="fl">小米移动&nbsp;电话卡</span>
											<div class="clear"></div>
										</a>
									</div>
									<!-- <div class="xuangou_right fr"><a href="">选购</a></div> -->
									<div class="clear"></div>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</li>
					<li>
						<a href="">保护套</a>
						<a href="">贴膜</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/5c_80.png" alt=""></div>
											<span class="fl">小米手机5c</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xmNOTE2-80.jpg" alt=""></div>
											<span class="fl">小米Note 2</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米MIX</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米5s</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5Splus.jpg" alt=""></div>
											<span class="fl">小米5s Plus</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>								
							</div>							
							<div class="clear"></div>
						</div>
					</li>
					<li>
						<a href="">线材</a>
						<a href="">支架</a>
						<a href="">储存卡</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/5c_80.png" alt=""></div>
											<span class="fl">小米手机5c</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xmNOTE2-80.jpg" alt=""></div>
											<span class="fl">小米Note 2</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米MIX</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米5s</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5Splus.jpg" alt=""></div>
											<span class="fl">小米5s Plus</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>			
							</div>
							<div class="clear"></div>
						</div>
					</li>
					<li>
						<a href="">箱包</a>
						<a href="">服饰</a>
						<a href="">鞋</a>
						<a href="">眼镜</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/5c_80.png" alt=""></div>
											<span class="fl">小米手机5c</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xmNOTE2-80.jpg" alt=""></div>
											<span class="fl">小米Note 2</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米MIX</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米5s</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5Splus.jpg" alt=""></div>
											<span class="fl">小米5s Plus</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>								
							</div>							
							<div class="clear"></div>
						</div>
					</li>
					<li>
						<a href="">米兔</a>
						<a href="">生活周边</a>
						<div class="pop">
							<div class="left fl">
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm6_80.png" alt=""></div>
											<span class="fl">小米6</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/5c_80.png" alt=""></div>
											<span class="fl">小米手机5c</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xmNOTE2-80.jpg" alt=""></div>
											<span class="fl">小米Note 2</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米MIX</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/MIX-80.jpg" alt=""></div>
											<span class="fl">小米5s</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>
								<div>
									<div class="xuangou_left fl">
										<a href="">
											<div class="img fl"><img src="./image/xm5Splus.jpg" alt=""></div>
											<span class="fl">小米5s Plus</span>
											<div class="clear"></div>
										</a>
									</div>
									<div class="xuangou_right fr"><a href="">选购</a></div>
									<div class="clear"></div>
								</div>								
							</div>							
							<div class="clear"></div>
						</div>
					</li>
				</ul>
			</div>
		
		</div>	
		
		<footer class="mt20 center">			
			<div class="mt20">手机商城|MIUI|多看书城|视频电话|手机天猫店|手机淘宝直营店|手机网盟|手机移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>
	</body>
</html>