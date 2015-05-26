<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<a href='/${initParam.rootPath }/index.jsp'>메인페이지</a>&nbsp;&nbsp;
<c:choose>
	<c:when test="${sessionScope.login_info == null }">
		<a href='/${initParam.rootPath }/controller?command=link&href=/member/join_form.jsp'>회원가입</a>&nbsp;&nbsp;
		<a href="/${initParam.rootPath }/controller?command=link&href=/member/login_form.jsp">로그인</a>&nbsp;&nbsp;
	</c:when>
	<c:otherwise>
		<a href='/${initParam.rootPath }/controller?command=logout'>로그아웃</a>&nbsp;&nbsp;
		<a href="/${initParam.rootPath }/controller?command=getMemberInfo">본인정보조회</a>&nbsp;&nbsp;
		<a href="/${initParam.rootPath }/controller?command=modifyForm">회원정보 수정</a>&nbsp;&nbsp;
		<a href="/${initParam.rootPath }/controller?command=removeMember">회원 탈퇴</a>&nbsp;&nbsp;
	</c:otherwise>
</c:choose>
<a href="/${initParam.rootPath }/controller?command=memberList">전체 회원정보 조회</a>&nbsp;&nbsp;
<a href="/${initParam.rootPath }/controller?command=memberListPaging">전체 회원정보 조회-Paging</a>&nbsp;&nbsp;
<hr width="700" align="left" noshade="noshade">
