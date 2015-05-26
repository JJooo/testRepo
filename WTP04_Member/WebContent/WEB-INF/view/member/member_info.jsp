<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/menu.jsp"/>

<h2>회원 정보</h2>
<table border='1'  width="500px"> 
	<tr>
		<th width="100px" align="left">ID</th>
		<td>${sessionScope.login_info.id }</td>
	</tr>
	<tr>
		<th  align="left">패스워드</th>
		<td>${sessionScope.login_info.password}</td>
	</tr>
	<tr>
		<th align="left">이름</th>
		<td>${sessionScope.login_info.name}</td>
	</tr>
	<tr>
		<th align="left">이메일</th>
		<td>${sessionScope.login_info.email}</td>
	</tr>
	<tr>
		<th align="left">가입일자</th>
		<td>${sessionScope.login_info.joinDate}</td>
	</tr>
</table>
<p>
<a href="/${initParam.rootPath }/controller?command=modifyForm">회원정보 수정</a>
<a href="/${initParam.rootPath }/controller?command=removeMember">회원 탈퇴</a>
</p>
</body>
</html>