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
			<!-- logo part -->
			<jsp:include page="_logo.jsp"></jsp:include>
			 
			<!-- menu bar part -->
			<jsp:include page="_menubar.jsp"></jsp:include>
			 
		</div>
		<div id="content_header"></div>
		<div id="site_content_article">
			
			<!-- side bar part -->
			<jsp:include page="_sidebar.jsp"></jsp:include>
			
			<div id="content_article">
				<!-- insert the page content here -->
				<h1> 
						<a class="button" href="${pageContext.request.contextPath}/create-topic" >New</a> 
						<a class="button" href="${pageContext.request.contextPath}/update-topic?id=${topic.id}" >Edit</a> 
						<a class="button" href="${pageContext.request.contextPath}" >Back to home</a> 
				</h1>
				<p>
			 		 Topic name : ${topic.name}					
				</p>
				<p>
			 		Description : ${topic.description}					
				</p>
				<h1 class="bottom-line"> 
						<a class="button" href="${pageContext.request.contextPath}/create-topic" >New</a> 
						<a class="button" href="${pageContext.request.contextPath}/update-topic?id=${topic.id}" >Edit</a> 
						<a class="button" href="${pageContext.request.contextPath}" >Back to home</a>   
				</h1>
			</div>
		</div>
		
		<!-- footer part -->
		<jsp:include page="_footer.jsp"></jsp:include>
	</div>
</body>
</html>
