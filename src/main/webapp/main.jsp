<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품정보</title>
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
	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<div id="title">
				<h1>
					WHAT WE <strong>PROVIDE</strong>
				</h1>
				<hr>
				<p>건강한 삶을 위한 먹거리 프로젝트</p>
			</div>
		</div>
	</div>
	<div class="container" id="search">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<div>
					<label for="condition">검색 조건</label> 
					<select id="type" class="form-control">
						<option>상품명</option>
						<option>재료</option>
						<option>제조사</option>
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<form>
					<div class="form-group">
						<label for="search">검색 단어</label> <input id="input" type="text"
							class="form-control">
					</div>
				</form>
			</div>
			<div class="col-md-1">
				<br>
				<button id="keywordGet" type="button" class="btn btn-info" >검색</button>
			</div>
			<div class="col-md-2 ">
				<div>
					<label for="sort">정렬</label> 
					<select id="sort" class="form-control">
						<option>상품명</option>
						<option>칼로리</option>
					</select>
				</div>
			</div>
			<div class="col-md-2">
				<div>
					<label for="order">순서</label> 
					<select id="order" class="form-control">
						<option>정순</option>
						<option>역순</option>
					</select>
				</div>
			</div>
			<div class="col-md-1">
				<br>
				<button id="sortbtn" type="button" class="btn btn-info" >정렬</button>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>

	<jsp:include page="/bottom.jsp" />
</body>
<script>

	let foods = {};
	$.ajax({
		url : "/food/getAllFoods",
		type : 'get',

		success : function(data) {
			foods = data;
			console.log(foods);
		},
		error : function() {
			alert("error");
		}
	});
	
	$.ajax({
		url : "res/FoodNutritionInfo.json",
		dataType : "json",
		success : function(data) {
			for (var i = 0; i < foods.length; i++) {
				foods[i].nutr = data.response.body.items.item[i];
			}
		},
		error : function() {
			alert("error");
		}
	});

	
	$("#sortbtn").on("click", function() {
		let $sort = $('#sort').val();
		let $order = $('#order').val();
		
		// select sort
		if ($sort == "상품명") {
			if ($order == "정순") {
				for (var i = 0; i < result.length; i++) {
					for (var j = i + 1; j < result.length; j++) {
						if (result[i].name > result[j].name) {
							let temp = result[i];
							result[i] = result[j];
							result[j] = temp;
						}
					}
				}
			} else if ($order == "역순") {
				for (var i = 0; i < result.length; i++) {
					for (var j = i + 1; j < result.length; j++) {
						if (result[i].name < result[j].name) {
							let temp = result[i];
							result[i] = result[j];
							result[j] = temp;
						}
					}
				}
			}
		}
		
		// quick sort
		else if ($sort == "칼로리"){
				quickSort(0, result.length-1, $order);
		}
		
		console.log("칼로리 출력")
		$("#getList").html("");
		result.forEach(function(elt, index) {
			console.log(elt.name + " : " + 	elt.nutr.NUTR_CONT1)
			showProduct(elt, index);
		})
	})
	
	function quickSort(l, r, order) {
		if (l >= r) {
			return;
		} 
		let x = result[r].nutr.NUTR_CONT1 * 1.0;
		let i = l - 1;

		if (order == "정순"){
			for (var j = l; j < r; j++) {
				if (result[j].nutr.NUTR_CONT1 * 1.0 <= x) {
					i++;
					let temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		} else if (order == "역순"){
			for (var j = l; j < r; j++) {
				if (result[j].nutr.NUTR_CONT1 * 1.0 >= x) {
					i++;
					let temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}
		let temp = result[i + 1];
		result[i + 1] = result[r];
		result[r] = temp;
		let s = i + 1;
		
		quickSort(l, s - 1, order);
		quickSort(s + 1, r, order);
	}

	let result = [];
	$("#keywordGet").on("click", function() {
		$("#getList").html("");
		let $name = $('#input').val();
		let $type = $('#type').val();
		console.log($type + " : " + $name)
		result = [];
		foods.forEach(function(elt, index) {
			console.log(index + 1 + " " + elt.name)
			if ($type == "상품명") {
				if (elt.name.match($name)) {
					result.push(elt);
				}
			} else if ($type === "재료") {
				if (elt.material.match($name)) {
					result.push(elt);
				}
			} else if ($type == "제조사") {
				if (elt.maker == $name) {
					result.push(elt);
				}
			}
		})
		console.log(result)
		result.forEach(function(elt, index) {
			showProduct(elt, index);
		})
	})

	$('#input').keypress(function(e) {
		if (e.which == 13) {
			$('#keywordGet').click();
			return false;
		}
	});

	function goDetail(index) {
		result.forEach(function(elt, idx) {
			if (idx == index) {
				
				sessionStorage.setItem('code', elt.code);
				sessionStorage.setItem('name', elt.name);
				sessionStorage.setItem('maker', elt.maker);
				sessionStorage.setItem('material', elt.material);
				sessionStorage.setItem('img', elt.img);
				sessionStorage.setItem('SERVING_WT', elt.nutr.SERVING_WT);
				sessionStorage.setItem('NUTR_CONT1', elt.nutr.NUTR_CONT1);
				sessionStorage.setItem('NUTR_CONT2', elt.nutr.NUTR_CONT2);
				sessionStorage.setItem('NUTR_CONT3', elt.nutr.NUTR_CONT3);
				sessionStorage.setItem('NUTR_CONT4', elt.nutr.NUTR_CONT4);
				sessionStorage.setItem('NUTR_CONT5', elt.nutr.NUTR_CONT5);
				sessionStorage.setItem('NUTR_CONT6', elt.nutr.NUTR_CONT6);
				sessionStorage.setItem('NUTR_CONT7', elt.nutr.NUTR_CONT7);
				sessionStorage.setItem('NUTR_CONT8', elt.nutr.NUTR_CONT8);
				sessionStorage.setItem('NUTR_CONT9', elt.nutr.NUTR_CONT9);
			}
		});
	}
// 	console.log(result);

	function showProduct(elt, index) {
		console.log(elt.img);
		$("#getList").html(
				$("#getList").html()
						+ '<div id="item'+ index +'" class="row"></div><hr>');
		$("#item" + index).html(
				$("#item" + index).html()
						+ '<div id="itemImg'+ index +'" class="col-md-3">');
		$("#itemImg" + index).html(
				$("#itemImg" + index).html() + '<img src="' +elt.img
						+ '"  width="50%">');
		$("#item" + index).html(
				$("#item" + index).html()
						+ '<div id="itemTxt'+ index +'" class="col-md-9">');
		$("#itemTxt" + index).html(
				$("#itemTxt" + index).html() + '<h2>' + elt.name + '</h2>');
		let maText = elt.material;
		if (elt.material.length >= 100)
			maText = elt.material.substr(0, 100) + ' ...';
		$("#itemTxt" + index).html(
				$("#itemTxt" + index).html() + '<p>' + maText + '<p>');
		$("#itemTxt" + index)
				.html(
						$("#itemTxt" + index).html()
								+ '<p><a class="btn btn-info" href="http://localhost:8080/detail.jsp" role="submit" onclick="goDetail('
								+ index + ');">Viewdetails&raquo;</a></p>');

	}
</script>
</html>