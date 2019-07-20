<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@ include file="/WEB-INF/include/manager_header.jsp" %>
		</div>
		
		<div id="main">
			<form action="book">
						<input name="method" value="editOneBook" type="hidden"/>
						<input name="id" value="${book.getId()}" type="hidden"/>
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						
						<td><input name="book_name" type="text" value="${book.getTitle()}"/></td>
						<td><input name="book_price" type="text" value="${book.getPrice()}"/></td>
						<td><input name="book_author" type="text" value="${book.getAuthor()}"/></td>
						<td><input name="book_sales" type="text" value="${book.getSales()}"/></td>
						<td><input name="book_amount" type="text" value="${book.getStock()}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>