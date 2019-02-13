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
	<form method="post" action="#" id="search_form">
		<p>
			<input class="search" type="text" name="search_field"
				value="Enter keywords....."> <input name="search"
				type="image" style="border: 0; margin: 0 0 -9px 5px;"
				src="assets/css/search.png" alt="Search" title="Search">
		</p>
	</form>
</div>