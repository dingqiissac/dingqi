<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript">
	$(function() {
		$('.input')
				.change(
						function() {
							var quantity = this.value;
							if (quantity <= 0) {
								quantity = 1;
							}
							var id = this.id
							window.location = "${pageContext.request.contextPath}/CartServlet?quantity="
									+ quantity
									+ "&method=inputQuantity&bookid=" + id + "";
						});
	});
</script>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">购物车</span>
		<%@ include file="/WEB-INF/include/user_header.jsp"%>
	</div>

	<div id="main">
		<c:choose>
			<c:when test="${not empty sessionScope.CartItemList}">
				<table>
					<tr>
						<td>图书编号</td>
						<td>商品名称</td>
						<td>数量</td>
						<td>单价</td>
						<td>金额</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${sessionScope.CartItemList.list}" var="cartitem">
						<tr>
							<td class="id">${cartitem.book.id}</td>
							<td>${cartitem.book.title}</td>

							<td><a
								href="${pageContext.request.contextPath}/CartServlet?method=reduceOne&bookid=${cartitem.book.id}"
								style="text-decoration: none; color: black">-</a> <input
								class="input" id="${cartitem.book.id}" type="text"
								style="text-align: center; width: 30px;"
								value="${cartitem.quantity}"> <a
								href="${pageContext.request.contextPath}/CartServlet?method=addOne&bookid=${cartitem.book.id}"
								style="text-decoration: none; color: black">+</a></td>

							<td>${cartitem.price}</td>
							<td>${cartitem.totalAmount}</td>
							<td><a
								href="${pageContext.request.contextPath}/CartServlet?method=deleteOne&bookid=${cartitem.book.id}">删除</a></td>
						</tr>
					</c:forEach>
				</table>
				<div class="cart_info">
					<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.CartItemList.countNumber}</span>件商品
					</span> <span class="cart_span">总金额<span class="b_price">${sessionScope.CartItemList.allAmount}</span>元
					</span> <span class="cart_span"><a
						href="${pageContext.request.contextPath}/Order?method=payBill">去结账</a></span>
				</div>
			</c:when>
			<c:otherwise>
				<p style="text-align: center; margin-top: 40px">没有订单呢，快去采购吧</p>
			</c:otherwise>
		</c:choose>




	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2018 </span>
	</div>
</body>
</html>