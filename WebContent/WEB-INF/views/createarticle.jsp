<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>shadowplay_2</title>

<!-- Include external CSS. -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.css">

<!-- Include Editor style. -->
<link href="assets/froala/css/froala_editor.pkgd.min.css" rel="stylesheet" type="text/css" />
<link href="assets/froala/css/froala_style.min.css" rel="stylesheet" type="text/css" />


<link rel="stylesheet" href="assets/css/style.css">

<!-- Include external JS libs. -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/mode/xml/xml.min.js"></script>
<script type="text/javascript" src="assets/froala/js/froala_editor.pkgd.min.js"></script>
<script type="text/javascript" src="assets/froala/js/plugins/image.min.js"></script> 


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
					<li class="btnMenu selected"><a href="${pageContext.request.contextPath}/create-article">Create Article</a></li>
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
				<h1>Create Article</h1>
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
				<form action="${pageContext.request.contextPath}/create-article"
					method="post" id="formInput">
					<div class="form_settings">
						<p>
							<span>Topic name *</span>
							<select id="idTopic" name="idTopic">
								<c:forEach var="topic" items="${topics}">
									<c:choose> 
										<c:when test="${topic.id == article.idTopic}">
											<option value="${topic.id}" selected="selected">${topic.name}</option>
										</c:when>
										<c:otherwise>
											<option value="${topic.id}">${topic.name}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</p>
						<p>
							<span>Subject *</span>
							<input  id="subject" style="width: 700px" type="text" name="subject" value="${article.subject}">
						</p>
						<div style="margin-bottom: 20px">
							<p>
								<span>Content *</span>
							</p>
						</div>
						<textarea name="content" id="content">${article.content}</textarea>
					</div>
					<h1 class="bottom-line">
						<a class="button" id="save" href="#" >Update</a>
						<a class="button" href="${pageContext.request.contextPath}/" >Back to home</a>
					</h1>
				</form>
			</div>
		</div>

		<!-- side bar part -->
		<jsp:include page="_footer.jsp"></jsp:include>

	</div>


	<script type="text/javascript">
	$(function() {
			$('#content').froalaEditor({
				imageUploadURL : '${pageContext.request.contextPath}/upload-image',
				height : 300
			});
	
			$('#content').on('froalaEditor.image.removed', function(e, editor, $img) {
				$.ajax({
					// Request method.
					method : 'POST',
	
					// Request URL.
					url : '${pageContext.request.contextPath}/delete-image',
	
					// Request params.
					data : {
						src : $img.attr('src')
					}
				}).done(function(data) {
					console.log('Image was deleted');
				}).fail(function(err) {
					console.log('Image delete problem: ' + JSON.stringify(err));
				})
			});
		})
	</script>
	<script type="text/javascript" src="assets/js/createarticle.js"></script> 
</body>
</html>
