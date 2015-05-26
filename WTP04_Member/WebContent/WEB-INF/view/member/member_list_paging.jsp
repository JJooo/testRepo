<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>

<script type="text/javascript" src="/MemberManagerFC/script/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#tbody tr").on("click", function(){
		$("#tbody tr").css("background-color", "white");
		$(this).css("background-color", "silver");
	});
});
</script>

<style type="text/css">
table {
	width:700px;
    border-collapse: collapse;
}
table, td{
    border: 1px solid black;
}
td{
	padding: 5px;
}
thead{
	background-color: gray;
	color:white;
}
#paging a{
	cursor: pointer;
	text-decoration: none;
	color: black;
}
#paging{
	font-size: 19px;
}
#tbody{
	cursor: pointer;
}
</style>

</head>
<body>
<jsp:include page="/WEB-INF/view/menu.jsp"/>

<h2>회원목록</h2> 	
<c:if test="${fn:length(requestScope.member_list) != 0 }"><!-- 회원정보가 있으면 -->
	<table width="700" border='1'>
		<thead id="thead">
			<tr>
				<td>ID</td>
				<td>Password</td>
				<td>이름</td>
				<td>이메일</td>
				<td>가입일자</td>
			</tr>
		</thead>
		<tbody id="tbody">
			<c:forEach items="${requestScope.member_list }" var="member">
				<tr>
					<td>${member.id }</td>
					<td>${member.password}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td>${member.joinDate}</td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
	
	<p id="paging">
		<!-- 이전 페이지 그룹 으로 넘어가기 -->
		<c:choose>
			<c:when test="${requestScope.pb.previousPageGroup }">
				<a href="/${initParam.rootPath }/controller?command=memberListPaging&page="${requestScope.pb.startPageOfPageGroup-1}>◁</a>
			</c:when>
				<c:otherwise>◁</c:otherwise>
		</c:choose>
		
		<!-- 현재 페이지만 링크 걸리지 않도록, 나머지 페이지들은 링크 걸림 -->
		<c:forEach var="" begin="" end="">
			<c:choose>
				<c:when test="">
					<a href="">링크 걸린 Page Number</a>
				</c:when>
				<c:otherwise>
					<font color="red">링크 안걸린 현재 Page Number</font>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<!-- 다음 페이지 그룹 으로 넘어가기 -->
		<c:choose>
			<c:when test="">
				<a href="">▷</a>
			</c:when>
			<c:otherwise>▷</c:otherwise>
		</c:choose>
	</p>
</c:if>
</body>
</html>