<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>지점 등록</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/assets/css/main.css" />

<!-- Favicon and touch icons -->
<link rel="icon"
	href="${pageContext.servletContext.contextPath}/ico/home_iot.png">
</head>
<body>
<h1>지점 정보</h1>
<form action='update.do' method='POST' enctype='multipart/form-data'>
번호:<input type='text' name='no' value='${branch.no}' readonly><br>
이름:<input type='text' name='name' value='${branch.name}'><br>
전화:<input type='text' name='tel' value='${branch.tel}'><br>
주소:<input type='text' name='addr' value='${branch.addr}'><br>
지역:<input type='text' name='area' value='${branch.area}'><br>
점주번호:<input type='text' name='bmno' value='${branch.bmno}'><br>
점주이름:<input type='text' name='bmname' value='${branch.bmname}'><br>
인사말:<input type='text' name='intro' value='${branch.intro}'><br>
사진1:<input type='file' name='photo'><br>
<p></p>
<div>
<c:forEach items='${branch.photoList}' var='path'>
<img class='photo1' src='../download/${path}'>
</c:forEach>
</div>
<button>변경</button>
<button type='button' onclick='doDelete()'>삭제</button>
<button type='button' onclick='doList()'>목록</button>
</form>
<script>
function doDelete() {
  location.href = 'delete.do?no=${branch.no}'
}
function doList() {
  location.href = 'list2.do'

}
</script>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
    