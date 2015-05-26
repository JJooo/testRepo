<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입성공</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/menu.jsp"/>
<h2>가입 환영합니다.</h2>
<h3>가입 시 입력하신 정보입니다.</h3>
<table border='1'  width="500px"> 
	<tr>
		<th width="100px" align="left">ID</th>
		<td>${requestScope.member.id }</td>
	</tr>
	<tr>
		<th  align="left">패스워드</th>
		<td>${requestScope.member.password}</td>
	</tr>
	<tr>
		<th align="left">이름</th>
		<td>${requestScope.member.name}</td>
	</tr>
	<tr>
		<th align="left">이메일</th>
		<td>${requestScope.member.email}</td>
	</tr>
	<tr>
		<th align="left">가입일</th>
		<td>${requestScope.member.joinDate}</td>
	</tr>
</table>
<p>
</body>
</html>