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
				<h1>Latest Article</h1>
				<c:forEach var="article" items="${articles}">
					<p>
						<a href="${pageContext.request.contextPath}/article?id=${article.id}">
							${article.subject}
						</a>
						<p class="info-article">Topic:${article.topicName}</p>
						<p class="info-article">${article.createBy}-${article.createDate}</p>
					</p>
				</c:forEach>

			</div>
		</div>

		<!-- footer part -->
		<jsp:include page="_footer.jsp"></jsp:include>

	</div>
</body>
</html>
