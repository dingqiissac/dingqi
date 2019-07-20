<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="../../static/img/logo.gif"> <span
			class="wel_word">我的订单</span>
		<%@ include file="/WEB-INF/include/user_header.jsp" %>
	</div>

	<div id="main">

		<table>
			<tr>
				<td>订单编号</td>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:forEach items="${requestScope.orderlist}" var="orderlist">
				<tr>
				<td>${orderlist.id}</td>
				<td>${orderlist.createTime}</td>
				<td>${orderlist.totalAmount}</td>
				<c:choose>
					<c:when test="${orderlist.state==0}">
					<td>未发货</td>
					</c:when>
					<c:when test="${orderlist.state==1}">
					<td>
					<div>已发货</div>
					<div><a href="${pageContext.request.contextPath}/Order?method=stateDeliveryClint&order=${orderlist.id}">已收到</a></div>
					</td>
					</c:when>
					<c:when test="${orderlist.state==2}">
					<td>交易完毕</td>
					</c:when>
				</c:choose>
				
				<td><a href="#">查看详情</a></td>
			</tr>
			</c:forEach>
			

			
		</table>


	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2018 </span>
	</div>
</body>
</html>