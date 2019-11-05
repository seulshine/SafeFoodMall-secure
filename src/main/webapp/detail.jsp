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
.container{
	margin-bottom: 10px;
}
#navbar{
	padding-right:20px;
}
footer{
	background: #f0f0f0;
	padding: 5px 15px 10px 15px; 
}
#nut{
	margin-top: 50px;
}

#info th{
text-align: center;
	width: 80px;
}
#nutr th{
text-align: center;
	width: 100px;
}
</style>
</head>
<body>
	<jsp:include page="/top.jsp" />

	<div class="container">
		<h2 class="text-center">제품 정보</h2>
		<br><br>
		<div class="row">
			<div id="image" class="col-md-3">
			</div>
			<div class="col-md-9">
				<table id="info" class="table">
					<tr>
						<th>제품명</th>
						<td id="name"></td>
					</tr>
					<tr>
						<th>제조사</th>
						<td id="maker"></td>
					</tr>
					<tr>
						<th>원재료</th>
						<td id="material"></td>
					</tr>
					<tr>
						<th>알레르기 성분</th>
						<td id="aller"></td>
					</tr>
				</table>
				<div class="row">
					<form method="post" action="updateHistory">
						<div class="col-md-3">
							<label for="search">Quantity</label> <input type="number"
								id="count" name="count" value="" class="form-control">
								<br>
							<input type="hidden" id="code" name="code">
							<input type="hidden" id="id" name="id" value="${LoginUser.id }">
							<button id="add" type="submit" class="btn btn-default" onclick="addfood">
								<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
								추가
							</button>
						</div>
					</form>
				</div>
				<br>


			</div>
		</div>
	</div>

	<div class="container" id="nut">
		<h4>영양 정보</h4>
		<div class="row">
			<div class="col-md-6" id="donutchart" style="width: 550px; height: 500px;" ></div>
			<div class="col-md-6">
			
				<table id="nutr" class="table">
					<tr>
						<th>일일 제공량</th>
						<td id="wt"></td>
					</tr>
					<tr>
						<th>칼로리</th>
						<td id='cal'></td>
					</tr>
					<tr>
						<th>탄수화물</th>
						<td id='carbo'></td>
					</tr>
					<tr>
						<th>단백질</th>
						<td id='prot'></td>
					</tr>
					<tr>
						<th>지방</th>
						<td id='fat'></td>
					</tr>
					<tr>
						<th>당류</th>
						<td id='sugar'></td>
					</tr>
					<tr>
						<th>나트륨</th>
						<td id='na'></td>
					</tr>
					<tr>
						<th>콜레스테롤</th>
						<td id='col'></td>
					</tr>
					<tr>
						<th>포화 지방산</th>
						<td id='acid'></td>
					</tr>
					<tr>
						<th>트랜스지방</th>
						<td id='trans'></td>
					</tr>
				</table>
			</div>
		</div>
		
	</div>

	<jsp:include page="/bottom.jsp" />
	</body>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 <script type="text/javascript">
    console.log(${code});
    let wt;
  	let cal;
  	let carbo; 
 	let prot;
 	let fat;
 	let sugar;
 	let na;
 	let col;
 	let acid;
 	let trans;
    $.ajax({
		url : "/food/getFood/" + ${code},
		type : 'get',

		success : function(data) {
			console.log(data);
			wt = data.supportpereat;
		  	cal = data.calory;
		  	carbo = data.carbo; 
		 	prot = data.protein;
		 	fat = data.fat;
		 	sugar = data.sugar;
		 	na = data.natrium;
		 	col = data.chole;
		 	acid = data.fattyacid;
		 	trans = data.transfat;
		 	$("#wt").html(wt);
		      $("#cal").html(cal);
		      $("#carbo").html(carbo);
		      $("#prot").html(prot);
		      $("#fat").html(fat);
		      $("#sugar").html(sugar);
		      $("#na").html(na);
		      $("#col").html(col);
		      $("#acid").html(acid);
		      $("#trans").html(trans);
		      
		      $("#image").html($("#image").html() + '<img src="' + data.img + '" width="80%">');
		      $("#name").html(data.name);
		      $("#maker").html(data.maker);
		      $("#material").html(data.material);

		},
		error : function() {
			alert("error");
		}
	});
    
 	
 	let aller = ["대두","땅콩","우유","게","새우","참치","연어","쑥","소고기","닭고기","돼지고기","복숭아","민들레","계란흰자"];

 	google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', '영양 정보'],
          ['칼로리', parseFloat(cal)],
          ['탄수화물', parseFloat(carbo)],
          ['단백질', parseFloat(prot)],
          ['지방', parseFloat(fat)],
          ['당류', parseFloat(sugar)],
          ['나트륨', parseFloat(na)],
          ['콜레스테롤', parseFloat(col)],
          ['포화지방산', parseFloat(acid)],
          ['트랜스지방', parseFloat(trans)],
        ]);

        var options = {
          pieHole: 0.5,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        var formatter = new google.visualization.NumberFormat({pattern: '###.###'});
        formatter.format(data, 1);
        chart.draw(data, options);
      }

      
      
      let allerStr = "";
      for (var i = 0; i < aller.length; i++) {
    	  if(sessionStorage.getItem('material').match(aller[i])) {
    		  allerStr += aller[i] + ", ";
    	  }
		}
      $("#aller").html(allerStr);
      
      
		
    // 포스트에 넣어서 보낼 상품코드 설정
    let foodcode = sessionStorage.getItem('code');
    $("#code").val(foodcode);
//     console.log($("#code").val());
    </script>
</html>