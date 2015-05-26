<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입폼</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/menu.jsp"/>
<h2>가입양식</h2>
<form method="post" action="/${initParam.rootPath }/controller" >
<input type="hidden" name="command" value="joinMember">
<c:if test="${requestScope.error_message!=null }">
	<font size="2" color="red">${requestScope.error_message }</font>
</c:if>
	<table width='500'>
		<tr>
			<td>ID</td>
			<td>
				<input type="text" name="id">
			</td>
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
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="email">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="가입">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>