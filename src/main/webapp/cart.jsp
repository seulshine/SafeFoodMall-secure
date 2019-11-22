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


	<div id="table">
		<table>
			<tr style="vertical-align: top">
				<td style="text-align: center">
					<h2>Shopping Cart</h2>
					<form action='<c:url value="/shop/updateCartQuantities.do"/>'
						method="post">
						<table id="cart">
							<tr bgcolor="#cccccc">
								<th>상품코드</th>
								<th>상품이름</th>
								<th>주문수량</th>
								<th>상품가격</th>
								<th>전체가격</th>
								<th>&nbsp;</th>
							</tr>

							<c:if test="${empty carts}">
								<tr>
									<td colspan="8"><b>Your cart is empty.</b></td>
								</tr>
							</c:if>

							<c:forEach var="cartItem" items="${carts}">
								<tr bgcolor="blue">
									<td><b> <a
											href='<c:url value="/shop/viewItem.do">
                  <c:param name="itemId" value="${cartItem.item.itemId}"/></c:url>'>
												<c:out value="${cartItem.code}" />
										</a></b></td>
									<td><c:out value="${cartItem.name}" /></td>
									<td><c:out value="${cartItem.qty}" /> <c:out
											value="${cartItem.price}" /> <c:out
											value="${cartItem.qty * cartItem.price}" />
									<td style="text-align: center"><input type="text" size="3"
										name='<c:out value="${cartItem.item.itemId}"/>'
										value='<c:out value="${cartItem.quantity}"/>' /></td>

									<td><a href='removeFromCart'>삭제</a></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="7" align="right"><b>Sub Total: <fmt:formatNumber
											value="${cart.totalNumber}" pattern="$#,##0.00" /></b><br>
								<br> <input type="text" name="update" /></td>
								<td>&nbsp;</td>
							</tr>
						</table>

					</form>
				</td>
			</tr>
		</table>
	</div>

	<jsp:include page="/bottom.jsp" />
</body>

</html>