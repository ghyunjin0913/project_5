<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>입구</title>
	</head>
	<body>
		<h2>안녕하세요.쇼핑몰입니다.^^</h2>
		<form method="GET" action="/shoppingMall_jsp/login" id="login-form">
			<p><b>id: </b><input type="text" name="userId" placeholder="id"></p>
			<p><b>pw: </b><input type="password" name="userPassword" placeholder="Password"></p>
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onClick="location.href='/shoppingMall_jsp/join';">
		</form>
		<c:set var="message_success" value="로그인 성공"/>
		<c:set var="message_black" value="권한이 없는 사용자입니다."/>
		<c:set var="message_fail" value="로그인 실패"/>
		<c:forEach var="login" items="${loginRes}">
			<c:if test="${login == 1}">
				<script type="text/javascript">
					alert("${message_success}");
				</script>
				<jsp:forward page="/product" />
			</c:if>
			<c:if test="${login == 2}">
				<script type="text/javascript">
					alert("${message_black}");
				</script>
			</c:if>
			<c:if test="${login == 3}">
				<script type="text/javascript">
					alert("${message_fail}");
				</script>
			</c:if>
		</c:forEach>
	</body>
</html>