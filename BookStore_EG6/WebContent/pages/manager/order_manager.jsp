<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
			<%@ include file="/WEB-INF/include/manager_header.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>订单编号</td>
				<td>日期</td>
				<td>数量</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货 状态</td>
				<td>用户ID</td>
				<td>用户姓名</td>
				<td>用户邮箱</td>
				
			</tr>
			<c:forEach items="${requestScope.orderAndUser}" var="orderAndUser">
				<tr>
				<td>${orderAndUser.id}</td>
				<td>${orderAndUser.createTime}</td>
				<td>${orderAndUser.totalCount}</td>
				<td>${orderAndUser.totalAmount}</td>
				<td><a href="#">查看详情</a></td>
				<c:choose>
					<c:when test="${orderAndUser.state==0}">
						<td>
						<div>未发货</div>
						<div><a href="${pageContext.request.contextPath}/OrderAndUserServlet?method=stateDelivery&order=${orderAndUser.id}">点击发货</a></div>
						</td>
					</c:when>
					<c:when test="${orderAndUser.state==1}">
						<td>已发货 等待用户签收</td>
					</c:when>
					<c:when test="${orderAndUser.state==2}">
						<td>交易完毕</td>
					</c:when>
				</c:choose>
				
				<td>${orderAndUser.name}</td>
				<td>${orderAndUser.userId}</td>
				<td>${orderAndUser.email}</td>
			</tr>	
			</c:forEach>		
			
		</table>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>