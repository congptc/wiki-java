<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>shadowplay_2</title>

<link rel="stylesheet" href="assets/css/style.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
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
				<form action="${pageContext.request.contextPath}/login" method="post" id="formInput">
				<div class="form_settings">
					<p>
						<span>User name</span>
						<input type="text" id="userName" name="userName">
					</p>
					<p>
						<span>Password</span>
						<input type="text" id=""password"" name="password">
					</p>
				</div>
				<h1 class="bottom-line">
					<a class="button" id="login" href="#" >Login</a>
				</h1>
				</form>
			</div>
		</div>

		<!-- footer part -->
		<jsp:include page="_footer.jsp"></jsp:include>

	</div>
</body>
</html>
