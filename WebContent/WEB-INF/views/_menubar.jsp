<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="menubar">
	<ul id="menu">
		<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
		<li class="btnMenu selected"><a href="${pageContext.request.contextPath}/">Home</a></li>
		<li class="btnMenu"><a href="${pageContext.request.contextPath}/topics">Topics</a></li>
		<li class="btnMenu"><a href="${pageContext.request.contextPath}/create-article">Create Article</a></li>
		<li class="btnMenu"><a href="#">Contact Us</a></li>
	</ul>
</div>

<script>
//Get the container element
var btnContainer = document.getElementById("menubar");

// Get all buttons with class="btn" inside the container
var btns = btnContainer.getElementsByClassName("btnMenu");

// Loop through the buttons and add the active class to the current/clicked button
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function() {
    var current = document.getElementsByClassName("selected");
    current[0].className = current[0].className.replace(" selected", "");
    this.className += " selected";
  });
}
</script>
