<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<!-- header part -->
	<jsp:include page="_header.jsp"></jsp:include>
</head>
<body>
	<div id="main">
		<div id="header">
			<!-- logo part -->
			<jsp:include page="_logo.jsp"></jsp:include>
			
		</div>
		<div id="site_content">
			<div id="content" style="padding-left: 200px">
				<h1>Login</h1>
				<div id="messageFrame">
					<c:choose>
						<c:when test="${message.messageType == 'SUCCESS'}">
							<i style="color: green">${message.content}</i>
						</c:when>
						<c:when test="${message.messageType == 'ERROR'}">
							<i style="color: red">${message.content}</i>
						</c:when>
					</c:choose>
				</div>
				<form action="${pageContext.request.contextPath}/login" method="post" id="formInput">
				<div class="form_settings">
					<p>
						<span>User name</span>
						<input type="text" id="userName" name="userName">
					</p>
					<p>
						<span>Password</span>
						<input type="password" id="password" name="password">
					</p>
				</div>
				</form>
				<h1 class="bottom-line">
					<a class="button" id="login" href="#" >Login</a>
				</h1>
			</div>
		</div>

		<!-- footer part -->
		<jsp:include page="_footer.jsp"></jsp:include>
		<script type="text/javascript" src="assets/js/common.js"></script>
		<script type="text/javascript" src="assets/js/login.js"></script> 
	</div>
</body>
</html>
