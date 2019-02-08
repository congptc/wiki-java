<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>shadowplay_2</title>

<link rel="stylesheet" href="assets/css/style.css">

</head>
<body>
	<div id="main">
		<div id="header">
			<div id="logo">
				<div id="logo_text">
					<!-- class="logo_colour", allows you to change the colour of the text -->
					<h1>
						<a href="index.html">shadow<span class="logo_colour">play_2</span></a>
					</h1>
					<h2>Simple. Contemporary. Website Template.</h2>
				</div>
			</div>
			
			<div id="menubar">
				<ul id="menu">
					<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
					<li class="btnMenu"><a href="${pageContext.request.contextPath}/home">Home</a></li>
					<li class="btnMenu selected"><a href="${pageContext.request.contextPath}/create-topic">Create Topic</a></li>
					<li class="btnMenu"><a href="${pageContext.request.contextPath}/create-article">Create Article</a></li>
					<li class="btnMenu"><a href="#">Contact Us</a></li>
				</ul>
			</div>

		</div>
		<div id="content_header"></div>
		<div id="site_content">

			<!-- side bar part -->
			<jsp:include page="_sidebar.jsp"></jsp:include>

			<div id="content">
				<!-- insert the page content here -->
				<h1>Create Topic</h1>
				<c:choose>
					<c:when test="${message.messageType == 'SUCCESS'}">
						<i style="color: green">${message.content}</i>	
					</c:when>
					<c:when test="${message.messageType == 'ERROR'}">
						<i style="color: red">${message.content}</i>
					</c:when>
				</c:choose>
				
				<form action="${pageContext.request.contextPath}/create-topic"
					method="post">
					<div class="form_settings">
						<p>
							<span>Topic name *</span><input type="text" name="name"
								value="${topic.name }">
						</p>
						<p>
							<span>Description</span>
							<textarea rows="8" cols="50" name="description"
								value="${topic.description }"></textarea>
						</p>
					</div>
					<h1 class="bottom-line">
						<input class="btn-action" type="submit" value="Save" /> <input
							class="btn-action" type="button" value="Cancel" />
					</h1>
				</form>

			</div>
		</div>
		
		<!-- footer part -->
		<jsp:include page="_footer.jsp"></jsp:include>
		
		<script type="text/javascript" src="assets/js/common.js"></script> 
	</div>
</body>
</html>
