<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/menu.jsp"/>

<h2>회원정보 수정 폼</h2>

<form method="post" action="/${initParam.rootPath }/controller"">
<input type="hidden" name="command" value="modifyMember">
<input type="hidden" name="id" value="${sessionScope.login_info.id }">
<c:if test="${requestScope.error_message!=null }">
	<font size="2" color="red">${requestScope.error_message }</font>
</c:if>
	<table width='500'>
		<tr>
			<td>ID</td>
			<td>${sessionScope.login_info.id }</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>
				<input type="password" name="password">
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" value="${sessionScope.login_info.name }">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="email"  value="${sessionScope.login_info.email }">
			</td>
		</tr>
		<tr> 
			<td colspan="2" >
				<input type="submit" value="수정">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>