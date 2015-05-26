<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/menu.jsp"/>
<h1>회원관리</h1>
<c:choose>
	<c:when test="${sessionScope.login_info == null }">
		본인정보 조회, 정보수정, 탈퇴를 하려면 로그인을 먼저하세요.
	</c:when>
	<c:otherwise>
		${sessionScope.login_info.name }님 환영합니다.
	</c:otherwise>
</c:choose>
</body>
</html>