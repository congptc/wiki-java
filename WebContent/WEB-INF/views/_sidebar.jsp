<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
	
<div class="sidebar">

	<h3>Topic</h3>
	<ul>
	<c:forEach var="topic" items="${topics}">
		<li><a href="${pageContext.request.contextPath}/articles?id=${topic.id}">${topic.name}</a></li>
	</c:forEach>
	</ul>
	<h3>Search</h3>
	<form method="GET" action="${pageContext.request.contextPath}/search" id="search_form">
		<p>
			<input class="search" type="text" name="search_field" id="search_field"
				value="Enter keywords....."> 
				<input name="search" id="search" type="button" value="Search" class="button" alt="Search" title="Search">
		</p>
	</form>
</div>
<script type="text/javascript" src="assets/js/search.js"></script>