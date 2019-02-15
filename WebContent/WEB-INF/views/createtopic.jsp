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
			
			<!-- menu bar part -->
			<jsp:include page="_menubar.jsp"></jsp:include>

		</div>
		<div id="content_header"></div>
		<div id="site_content">

			<!-- side bar part -->
			<jsp:include page="_sidebar.jsp"></jsp:include>

			<div id="content">
				<!-- insert the page content here -->
				<h1>Create Topic</h1>
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
				<form action="${pageContext.request.contextPath}/create-topic"
					method="post" id="formInput">
					<div class="form_settings">
						<p>
							<span>Topic name *</span><input type="text" id="name" name="name"
								value="${topic.name }">
						</p>
						<p>
							<span>Description</span>
							<textarea rows="8" cols="50" id="description" name="description" >${topic.description}</textarea>
						</p>
					</div>
					<h1 class="bottom-line">
						<a class="button" id="save" href="#" >Save</a>
						<a class="button" href="${pageContext.request.contextPath}/" >Back to home</a>
					</h1>
				</form>

			</div>
		</div>
		
		<!-- footer part -->
		<jsp:include page="_footer.jsp"></jsp:include>
		<script type="text/javascript" src="assets/js/common.js"></script>
		<script type="text/javascript" src="assets/js/createtopic.js"></script> 
		
	</div>
</body>
</html>
