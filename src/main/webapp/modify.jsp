<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
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

.panel-heading {
	padding: 1px 15px;
}

button {
	margin-right: 15px;
}
</style>
</head>
<body>
	<jsp:include page="/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form action="update.do" method="post">
					<h2>
						<strong>회원 정보 수정</strong>
					</h2>
					<br> 
					<label for="id"><b>아이디 *</b></label> 
					<input type="text" name="id" id="id" class="form-control" 
						value="${LoginUser.id }" required autofocus="" readonly="readonly"> <br> 
<%-- 					value="${member.password }" --%>
					
					<label for="pw"><b>비밀번호 *</b></label> 
					<input type="password" name="pw" id="pw" class="form-control" value="${LoginUser.password }" required="" autofocus=""> <br>
					
					<label for="name"><b>이름 *</b></label> 
					<input type="text" name="name" id="name" class="form-control" value="${LoginUser.name }" required="" autofocus=""> <br> 
					
					<label for="addr"><b>주소*</b></label> 
					<input type="text" name="addr" id="addr" class="form-control" value="${LoginUser.address }" required autofocus=""> <br> 
					
					<label for="tel"><b>전화번호 *</b></label> 
					<input type="text" name="tel" id="tel" class="form-control" value="${LoginUser.phone }">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h5>Check!</h5>
						</div>
						<div class="panel-body">
							<input type="checkbox" name="aller" value="bean" > 대두 <input
								type="checkbox" name="aller" value="peanut"> 땅콩 <input
								type="checkbox" name="aller" value="milk"> 우유 <input
								type="checkbox" name="aller" value="crab"> 게 <input
								type="checkbox" name="aller" value="shrimp"> 새우 <input
								type="checkbox" name="aller" value="tuna"> 참치 <input
								type="checkbox" name="aller" value="salmon"> 연어 <input
								type="checkbox" name="aller" value="vege"> 쑥<br> <input
								type="checkbox" name="aller" value="beef"> 소고기 <input
								type="checkbox" name="aller" value="chic"> 닭고기 <input
								type="checkbox" name="aller" value="pork"> 돼지고기 <input
								type="checkbox" name="aller" value="peach"> 복숭아 <input
								type="checkbox" name="aller" value="flower"> 민들레 <input
								type="checkbox" name="aller" value="egg"> 계란흰자

						</div>


					</div>
					<br>
					<button type="submit" class="btn btn-primary">수정</button>
					<button type="button" class="btn btn-danger" onclick="location.href='delete.do'">삭제</button>
					<br>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="/bottom.jsp" />
</body>
<script>
let aller = "${LoginUser.allergy }";
let allers = aller.split(',');
let childs = $('.panel-body').children('input');

for(let i =0; i < allers.length; i++){
	let box = allers[i];
	for (let c of childs) {
		if (c.value == box){
			$(c).attr("checked", 'checked');
		}
	}
}
</script>
</html>


