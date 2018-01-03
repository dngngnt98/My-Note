<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h1>지점 등록</h1>
<form action="add.do" method="POST" enctype="multipart/form-data">
이름:<input type='text' name='name' ><br>
전화:<input type='text' name='tel' ><br>
주소:<input type='text' name='addr' ><br>
지역:<input type='text' name='area' ><br>
점주번호:<input type='text' name='bmno' ><br>
인사말:<input type='text' name='intro' ><br>
사진1:<input type='file' name='photo'><br>
<button>등록</button>
</form>

</body>
</html>