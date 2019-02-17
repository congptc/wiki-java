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
		<div id="site_content_article">
			
			<!-- side bar part -->
			<jsp:include page="_sidebar.jsp"></jsp:include>
			<div id="content_article">
				<!-- insert the page content here -->
				<h1> 
					<c:if test="${message.messageType != 'SUCCESS'}">
						<a class="button" href="${pageContext.request.contextPath}/approved?id=${article.id}" >Approve</a>
					</c:if>
					<a class="button" href="${pageContext.request.contextPath}/articles-unapproved" >Back</a> 
				</h1>
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
				<h1 class="subject" >${article.subject }</h1>
				<p class="info-article">Topic: ${article.topicName}</p>
				<p class="info-article">Created by: ${article.createBy }-${article.createDate }</p>
				<c:if test="${article.updateBy != null}">
					<p class="info-article">Latest updated: ${article.updateBy}-${article.updateDate}</p>
				</c:if>
				<p>
			 		${article.content}					
				</p>
				<h1 class="bottom-line"> 
					<c:if test="${message.messageType != 'SUCCESS'}">
						<a class="button" href="${pageContext.request.contextPath}/approved?id=${article.id}" >Approve</a>
					</c:if>
					<a class="button" href="${pageContext.request.contextPath}/articles-unapproved" >Back</a> 
				</h1>
			</div>
		</div>
		
		<!-- footer part -->
		<jsp:include page="_footer.jsp"></jsp:include>
	</div>
</body>
</html>
