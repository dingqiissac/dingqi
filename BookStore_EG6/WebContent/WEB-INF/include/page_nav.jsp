<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div class="scott">
	<c:if test="${requestScope.page.pageNumber>1}">
		<a href="${param.url}&pageNumber=${requestScope.page.pageNumber-1}"> &lt; </a>
	</c:if>
	
	<c:forEach begin="1" end="${requestScope.page.totalPages}" var="index">
		<c:choose>
			<c:when test="${requestScope.page.pageNumber==index}">
				<span class="current">${index}</span>
			</c:when>
			
			<c:otherwise>
				<a href="${param.url}&pageNumber=${index}">${index}</a>
			</c:otherwise>
		</c:choose>	
		
	</c:forEach>
	
	<c:if test="${requestScope.page.pageNumber < requestScope.page.totalPages }">
		<a href="${param.url}&pageNumber=${requestScope.page.pageNumber +1}"> &gt; </a>
	</c:if>
	
共${requestScope.page.totalPages}页，${requestScope.page.totalRecodes}条记录 到第<input
	value="${requestScope.page.pageNumber}" name="pn" id="pn_input" />页 <input
	id="sendBtn" type="button" value="确定">
</div>

<script type="text/javascript">
  $('#sendBtn').click(function(){
	  var va = $('#pn_input').val();
	  window.location = "${param.url}&pageNumber="+va+""
  });


</script>