<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap 3.3.7이하는 jQuery 1.x, 3.3.7이상으로 업그레이드 필요 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<!-- jQuery 추가 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>
.jumbotron {
	height: 400px;
	background: white;
	background-image: url('https://images.unsplash.com/photo-1543352634-a1c51d9f1fa7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80');
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
	padding-top: 120px;
	margin-top: 10px;
}

#search {
	background: gray !important;
	color: white !important;
	padding: 20px 10px;
}

.container {
	margin-bottom: 10px;
}

@import url('https://fonts.googleapis.com/css?family=Jua&display=swap');
#title {
 	font-family: 'Jua', sans-serif;
}

#navbar {
	padding-right: 20px;
}

footer {
	background: #f0f0f0;
	padding: 5px 15px 10px 15px;
}

#itemTxt {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	height: 20px;
}


</style>
</head>
<body>
<jsp:include page="/top.jsp" />
<iframe src="./board/index.html" frameborder="0" width="100%" height="500px" marginwidth="0" marginheight="0" scrolling="auto" style="border: 0px">iframe 오류!</iframe>
<jsp:include page="/bottom.jsp"/>

</body>
</html>