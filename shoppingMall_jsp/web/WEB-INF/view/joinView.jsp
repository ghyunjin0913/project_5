<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Join</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<form method="GET" action="/shoppingMall_jsp/join" id="join-form">
			<p><b>아이디: </b><input type="text" name="userId" placeholder="id"></p>
			<p><b>비밀번호: </b><input type="password" name="userPassword" placeholder="Password"></p>
			<p><b>이름: </b><input type="text" name="userName" placeholder="이름"></p>
			<input type="submit" value="가입">
		</form>
		<c:set var="message_success" value="회원가입 성공"/>
		<c:set var="message_fail" value="회원가입 실패"/>
		<c:forEach var="join" items="${joinRes}">
			<c:if test="${join == 1}">
				<script type="text/javascript">
					alert("${message_success}");
				</script>
				<jsp:forward page="loginView.jsp" />
			</c:if>
			<c:if test="${join == 2}">
				<script type="text/javascript">
					alert("${message_fail}");
				</script>
			</c:if>
		</c:forEach>
	</body>
</html>