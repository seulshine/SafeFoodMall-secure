<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세정보</title>
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
@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);

.container {
	margin-bottom: 10px;
}

#navbar {
	padding-right: 20px;
}

footer {
	background: #f0f0f0;
	padding: 5px 15px 10px 15px;
}

#nut {
	margin-top: 50px;
}

#info th {
	text-align: center;
	width: 80px;
}

#nutr th {
	text-align: center;
	width: 100px;
}

#table {
	align-items: center;
	margin-left: 380px;
}
</style>
</head>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script>
	let id = "${LoginUser.id }";
	let carts = {};
	$.ajax({
		url : "/safefoodvue/cart/" + id,
		type : 'get',

		success : function(data) {
			carts = data;
			console.log(carts);
		},
		error : function() {
			alert("error");
		}
	});
</script>
<body>
	<jsp:include page="/top.jsp" />



	<jsp:include page="/bottom.jsp" />
</body>

</html>