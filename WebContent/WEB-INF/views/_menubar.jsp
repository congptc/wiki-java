<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="menubar">
	<ul id="menu">
		<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
		<li class="btnMenu selected"><a href="${pageContext.request.contextPath}/">Home</a></li>
		<li class="btnMenu"><a href="${pageContext.request.contextPath}/topics">Topics</a></li>
		<li class="btnMenu"><a href="${pageContext.request.contextPath}/create-topic">Create Topic</a></li>
		<li class="btnMenu"><a href="${pageContext.request.contextPath}/create-article">Create Article</a></li>
		<li class="btnMenu"><a href="#">Contact Us</a></li>
	</ul>
</div>
<div style="text-align: right;margin-right: 5px">
	<i style="margin-right: 10px;font-weight: bold;">Hello ${userInfo.userName}</i>
	<a class="button" href="${pageContext.request.contextPath}/logout" >Logout</a>
</div>
<script>
//Get the container element
var btnContainer = document.getElementById("menubar");

// Get all buttons with class="btn" inside the container
var btns = btnContainer.getElementsByClassName("btnMenu");

//Process find the which menu selected
var link = window.location.href;
var urlOfTagA,linkAction=  "";
var urlOnLink = link.substr(link.lastIndexOf('/')+1,link.length);

// Loop through the buttons and add the active class to the current/clicked button
for (var i = 0; i < btns.length; i++) {
  urlOfTagA = btns[i].children.item(0).getAttribute("href");
  linkAction = urlOfTagA.substr(urlOfTagA.lastIndexOf('/')+1,urlOfTagA.length);
  
  if(urlOnLink === linkAction){
    var current = document.getElementsByClassName("selected");
    current[0].className = current[0].className.replace(" selected", "");
    btns[i].className += " selected";
  }
}
</script>
