<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품페이지</title>
		<p><a href="/shoppingMall_jsp/logout">로그아웃</a></p>
	</head>
	<body>
		<h2>상품리스트</h2>
		<form method="GET" action="/shoppingMall_jsp/product" id="product-form">
			<input type="text" placeholder="검색할 항목 입력" name="search"/>
			<input type="submit" value="검색"/>
		</form>
		<table border="1">
			<thead><tr>
	        	<th style='border-left: none;'>상품번호</th>
	        	<th>상품명</th>
	        	<th style='border-right: none;'>가격</th>
	    	</tr></thead>
	    		<c:set var= "search" value="${searchList}" />
	    		<c:if test="${search != null}">
		    		<c:forEach var="searchList" items="${searchList}">
				    	<tr><td>${searchList.pno}</td>
					   	<td>${searchList.pname}</td>
					    <td>${searchList.price}</td></tr>
				    </c:forEach>
			    </c:if>
			    <c:if test="${search == null}">
			    	<c:forEach var="productList" items="${productList}">
				    	<tr><td>${productList.pno}</td>
					   	<td>${productList.pname}</td>
					    <td>${productList.price}</td></tr>
				    </c:forEach>
			    </c:if>
	    </table>
	</body>
</html>