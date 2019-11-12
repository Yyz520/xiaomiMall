<%@page import="com.sc.bean.Item"%>
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
    
    <title>后台查看商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    
    <link rel="stylesheet" type="text/css" href="css1/common.css"/>
    <link rel="stylesheet" type="text/css" href="css1/main.css"/>
    
    <script type="text/javascript">
      //全选/反选操作     
     function checkAll(ifAll) {   
        var select = document.getElementsByName("selectFlag");  
        for(var i = 0;i<select.length;i++){  
            select[i].checked = ifAll.checked;  
        }   
    } 
     
    </script>
    
  </head>
  
  <body>
   <div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <ul class="navbar-list clearfix">
                <li><a class="on" href="backstagepage.jsp">首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li>欢迎, ${aname}</li>
                <li><a href="adminlogin.jsp">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">     
       <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <i class="icon-font"></i>网上商城管理平台
                    <ul class="sub-menu">
                        <li><a href="GoodsSelect"><i class="icon-font"></i>查看商品</a></li>
                        <li><a href="OrderManagerPage"><i class="icon-font"></i>订单详情</a></li>
                        <li><a href="CheckUsers"><i class="icon-font"></i>查看用户</a></li>
                        <li><a href="CheckAdmin"><i class="icon-font"></i>查看管理员</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="adminmain.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">查看商品信息</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="SouSuo" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="carname" id="carname" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post" action="DelServlet">
             <div class="result-title">
                <div class="result-list">
                <input type="submit" value="删除"/>
                   <a href="insertgoods.jsp"><i class="icon-font"></i>新增商品</a>
                </div>
             </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="ifAll" type="checkbox"  title="全选/反选" onClick="checkAll(this)"></th>
                            <th>商品编号</th>
                            <th>商品名称</th>
                            <th>商品种类ID号</th>
                            <th>商品制造商</th>
                            <th>商品图片</th>
                            <th>商品介绍</th>
                            <th>商品价格(会员)</th>
                            <th>商品价格(普通)</th>
                            <th>商品库存数量</th>
                            <th>商品购买数量</th>                            
                            <th>商品状态</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${requestScope.checkgoods }" var="g">
                        <tr>
                            <td class="tc"><input name="selectFlag" value="${g.itemId }" type="checkbox"></td>
                            <td align="center">${g.itemId }</td>
                            <td align="center">${g.itemName }</td>
                            <td align="center">${g.cid }</td>
                            <td align="center">${g.itemProductor }</td>
                            <td align="center">
                            <a href="GoodsDownLoad?fname=${g.itemPhoto }"></a>
                            <img src="upload/${g.itemPhoto }" width="100" height="100">
                            </td>
                            <td align="center">${g.itemIntro }</td>
                            <td align="center">${g.priceVip }</td>
                            <td align="center">${g.priceNormal }</td>
                            <td align="center">${g.itemNum }</td>
                            <td align="center">${g.itemTolNum }</td>
                            
                            <c:if test="${g.itemState==0}">
                            <td align="center">上架</td>
                            </c:if>
                             <c:if test="${g.itemState==1}">
                            <td align="center">下架</td>
                            </c:if>
                            <td>
                                <a  href="BackstageGoUpdate?itemId=${g.itemId }" class="link-update">修改</a>
                                
                            </td>
                            
                        </tr>
                        </c:forEach>
                        
                    </table>
               
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
  <!-- 分页显示 -->
  <center>
               <tr>
               	<td colspan="7" align="center">
               	  <a href="GoodsSelect?pageNum=1">首页</a>&nbsp;
               	  <a href="GoodsSelect?pageNum=${p.pageNum>1 ?(p.pageNum-1):1 }">上一页</a>&nbsp;
               	  <a href="GoodsSelect?pageNum=${p.pageNum<p.pageSum ?(p.pageNum+1):p.pageSum }">下一页</a>&nbsp;
               	  <a href="GoodsSelect?pageNum=${p.pageSum }">尾页</a>&nbsp;&nbsp;
               	  当前${requestScope.p.pageNum }/${p.pageSum }页,共${p.pageCount }条
               	</td>
               </tr>
   </center>
  </body>
</html>