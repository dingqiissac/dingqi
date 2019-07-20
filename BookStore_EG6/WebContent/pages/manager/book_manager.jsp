<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	 $(function() {
		
	 	$(".book").click(function(){
			return confirm("确定要删除嘛");
		}); 
	});
	
	
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@ include file="/WEB-INF/include/manager_header.jsp" %>
	</div>
	
	<div id="main">
		<div>
			<a href="pages/manager/book_edit.jsp">添加图书</a>
		</div>
		<table>
			<tr>
				<td>编号</td>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.data}"  var="book">
			<tr>
				<td class="bname">${book.id}</td>
				<td class="bname">${book.getTitle()}</td>
				<td>${book.getPrice()}</td>
				<td>${book.getAuthor()}</td>
				<td>${book.getSales()}</td>
				<td>${book.getStock()}</td>
				<td><a href="book?method=getOneBook&id=${book.getId()}">修改</a></td>
				<td><a class="book" href="book?method=deleteOneBook&id=${book.getId()}">删除</a></td>
			</tr>	
			</c:forEach>		
				
		</table>
		<%-- <%@ include file="/WEB-INF/include/page_nav.jsp" %> --%>
		<jsp:include page="/WEB-INF/include/page_nav.jsp">
		    <jsp:param value="book?method=findPage" name="url"/>
		</jsp:include>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>