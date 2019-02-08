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
					<li class="btnMenu"><a href="${pageContext.request.contextPath}/create-topic">Create Topic</a></li>
					<li class="btnMenu"><a href="${pageContext.request.contextPath}/create-article">Create Article</a></li>
					<li class="btnMenu"><a href="#">Contact Us</a></li>
				</ul>
			</div>
			 
		</div>
		<div id="content_header"></div>
		<div id="site_content_article">
			
			<!-- side bar part -->
			<jsp:include page="_sidebar.jsp"></jsp:include>
			
			<div id="content_article">
				<!-- insert the page content here -->
				<h1> 
						<a class="button" href="${pageContext.request.contextPath}/create-article" >New</a> 
						<a class="button" href="${pageContext.request.contextPath}/update-article?id=${article.id}" >Edit</a> 
						<a class="button" href="${pageContext.request.contextPath}" >Back to home</a> 
				</h1>
				<h1 class="subject" >${article.subject }</h1>
				<p class="info-article">Topic:  / ${article.createBy }-${article.createDate }</p>
				<p>
			 		${article.content}					
				</p>
				<h1 class="bottom-line"> 
						<a class="button" href="${pageContext.request.contextPath}/create-article" >New</a> 
						<a class="button" href="${pageContext.request.contextPath}/update-article?id=${article.id}" >Edit</a> 
						<a class="button" href="${pageContext.request.contextPath}" >Back to home</a>   
				</h1>
			</div>
		</div>
		
		<!-- footer part -->
		<jsp:include page="_footer.jsp"></jsp:include>
	</div>
</body>
</html>
