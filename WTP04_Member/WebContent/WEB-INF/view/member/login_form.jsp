<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/menu.jsp"/>
<fieldset style="width:350px">
	<legend>로그인 폼</legend>   
	<c:if test="${requestScope.error_message != null}">
		<font color="red" size="2">${requestScope.error_message}</font>
	</c:if>
	
	<form action="/${initParam.rootPath }/controller" method="post">
	<input type="hidden" name="command" value="login" >
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="20" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="password" size="20"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인"/>
					<input type="reset" value="초기화"/>
				</td>
			</tr>
		</table>	
	</form>
</fieldset>
</body>
</html>