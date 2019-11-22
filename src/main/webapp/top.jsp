<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:url value="/" var="ctx"></c:url>

<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
				<form class="form-signin" action="login.do" method="post">
					<div class="modal-body">
						<h2 class="form-signin-heading">Log in</h2>
						<label for="id" class="sr-only">아이디</label> 
						<input type="text" name="id" id="id" class="form-control" placeholder="아이디" required="" autofocus=""> 
						<label for="pw" class="sr-only">비밀번호</label>
						<input type="password" name="password" id="password" class="form-control" placeholder="비밀번호" required="">
					</div>
					<div class="modal-footer">
						<input type="submit" value="login">
					</div>
				</form>
			</div>
			</div>
		</div>
	</div>
	<nav class="navbar">
		<div class="container">
			<div id="navbar" class="navbar-collapse collapse navbar-inverse" aria-expanded="false" style="height: 1px;">
				<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${empty LoginUser}">
						<li id="Loginout"><button type="button" class="btn btn-link" data-toggle="modal" data-target="#myModal">Log in</button></li>
						<li id="sign"><button type="button" class="btn btn-link" onclick="location.href='signup.jsp'">sign up</button></li>
					</c:when>
					<c:otherwise>
						<li id="Loginout">
						<button type="button" class="btn btn-link" name="logout" onclick="location.href='logout.do'">Log out</button></li>
						<li id="sign"><button type="button" class="btn btn-link" onclick="location.href='modify.jsp'">modify</button></li>
						<li id="cart"><button type="button" class="btn btn-link"  onclick="location.href='cart.jsp'">cart</button></li>
					</c:otherwise>
				</c:choose>
				</ul>
			</div>
		</div>
		
		<div class="container">
			<div class="navbar-header">
				<img alt="ssafy" src="http://edu.ssafy.com/asset/images/header-logo.jpg" onclick="location.href='main.jsp'">
			</div>
			<div id="navbar" class="navbar-collapse collapse"
				aria-expanded="false" style="height: 1px;">
				<ul class="nav navbar-nav">
					<li class="active"><a href='board.jsp'>공지사항</a></li>
					<li><a href="#">상품 정보</a></li>
					<li><a href="#">베스트 섭취 정보</a></li>
					<li><a href="#">내 섭취 정보</a></li>
					<li><a href="#">예상 섭취 정보</a></li>
				</ul>
				<form class="navbar-form navbar-right" action="search.do" method="post">
					<input type="text" name="word" class="form-control" placeholder="Search...">
				</form>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
<script>
<c:if test="${!empty msg }">	
	alert("${msg}");
	<c:remove var="msg"/>
</c:if>

</script>