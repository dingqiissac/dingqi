<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/WEB-INF/include/base.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#priceBtn").click(function() {
			var min = $("#min").val();
			var max = $("#max").val();
			min = Number(min);
			max = Number(max);

			if (isNaN(min) || isNaN(max)) {
				alert("請輸入正確的數字");
				return false;
			}

			if ((!isNaN(max) || !isNaN(min)) && min > max) {
				alert("請輸入正確的區間");
				return false;
			}

			if (min < 0 || max < 0) {
				alert("請輸入正確的正數");
				return false;
			}
		});
		
		$(".book_add2").click(function(){
			var id = this.id;
			var min = $("#min").val();
			var max = $("#max").val();
			
			window.location = "${pageContext.request.contextPath}"
			+"/CartServlet?method=addBook2Cart"
			+"&min="+min+""
			 +"&max="+max+""
			+"&pageNumber="+${requestScope.page.pageNumber}+""
			+"&bookid="+ id +""; 
			
			
		});
		
	});
</script>
</head>
<body>
	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">网上书城</span>
			<%@ include file="/WEB-INF/include/user_header.jsp" %>
	</div>
	

	<div id="main">
		<c:choose>
			<c:when test="${empty reuqestScope.page.data}">
				<div id="book">
					<form action="${pageContext.request.contextPath}/index"
						method="post">
						<div class="book_cond">
							价格：<input id="min" type="text" name="min" value="${param.min}">
							元 - <input id="max" type="text" name="max" value="${param.max}">
							元
							<button id="priceBtn" type="submit">查询</button>
						</div>
					</form>

					<div style="text-align: center">
						<span>您的购物车中有3件商品</span>
						<div>
							您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
						</div>
					</div>
					<c:forEach items="${requestScope.page.data}" var="book">
						<div class="b_list">
							<div class="img_div">
								<img class="book_img" alt="" src="${book.imgPath}" />
							</div>
							<div class="book_info">
								<div class="book_name">
									<span class="sp1">书名:</span> <span class="sp2">${book.title}</span>
								</div>
								<div class="book_author">
									<span class="sp1">作者:</span> <span class="sp2">${book.author}</span>
								</div>
								<div class="book_price">
									<span class="sp1">价格:</span> <span class="sp2">${book.price}</span>
								</div>
								<div class="book_sales">
									<span class="sp1">销量:</span> <span class="sp2">${book.sales}</span>
								</div>
								<div class="book_amount">
									<span class="sp1">库存:</span> <span class="sp2">${book.stock}</span>
								</div>
								<div class="book_add">
									<button id="${book.id} "class="book_add2">加入购物车</button>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:when>

			<c:otherwise>
				<h3 style="text-align: center; color: red; margin-top: 100px">没有图书</h3>
			</c:otherwise>
		</c:choose>


	</div>

	<jsp:include page="/WEB-INF/include/page_nav.jsp">
		<jsp:param
			value="index?method=findPage&min=${param.min}&max=${param.max}"
			name="url" />
	</jsp:include>




	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2018 </span>
	</div>
</body>
</html>