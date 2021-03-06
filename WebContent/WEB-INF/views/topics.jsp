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
				<h1>List topic</h1>
				<c:forEach var="topic" items="${topics}">
					<p>
						<a href="${pageContext.request.contextPath}/topic?id=${topic.id}">
							${topic.name}
						</a>
						<p class="info-article">Created by: ${topic.createBy}-${topic.createDate}</p>
						<c:if test="${topic.updateBy != null}">
							<p class="info-article">Latest updated: ${topic.updateBy}-${topic.updateDate}</p>
						</c:if>
					</p>
				</c:forEach>

			</div>
		</div>

		<!-- footer part -->
		<jsp:include page="_footer.jsp"></jsp:include>

	</div>
</body>
</html>
