<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/menu.jsp"/>
 
실행 도중 오류가 발생했습니다.<br>
<c:if test="${not empty requestScope.error_message }">
	오류 내용 ${requestScope.error_message }
</c:if>
<p>
	<a href='/${initParam.rootPath }/index.jsp'>메인페이지로 이동</a>
</p>
</body>
</html>