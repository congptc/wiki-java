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
					<li class="selected"><a href="index.html">Home</a></li>
					<li><a href="examples.html">Examples</a></li>
					<li><a href="page.html">A Page</a></li>
					<li><a href="another_page.html">Another Page</a></li>
					<li><a href="contact.html">Contact Us</a></li>
				</ul>
			</div>
		</div>
		<div id="content_header"></div>
		<div id="site_content_article">
			<div class="sidebar_article">
				
				<h3>Topic</h3>
				<ul>
					<li><a href="#">Core</a></li>
					<li><a href="#">CRS</a></li>
					<li><a href="#">VMS</a></li>
					<li><a href="#">link 4</a></li>
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
			<div id="content_article">
				<!-- insert the page content here -->
				<h1> 
						<input class="btn-action" type="button" value="Save"/>
						<input class="btn-action" type="button" value="Edit"/> 
						<input class="btn-action" type="button" value="Cancel"/>  
				</h1>
				<h1 class="subject" >Article Subject</h1>
				<p class="info-article">Topic: Core / Author-Created date</p>
				<p>
			 		Article Subject 1 This template is written entirely in This template is written entirely in 
					This template is written entirely in This template is written entirely in Article Subject 1 This template is written entirely in This template is written entirely in 
					This template is written entirely in This template is written entirely in Article Subject 1 This template is written entirely in This template is written entirely in 
					This template is written entirely in This template is written entirely in Article Subject 1 This template is written entirely in This template is written entirely in 
					This template is written entirely in This template is written entirely in 
					
				</p>
				<h1 class="bottom-line"> 
						<input class="btn-action" type="button" value="Save"/>
						<input class="btn-action" type="button" value="Edit"/> 
						<input class="btn-action" type="button" value="Cancel"/>  
				</h1>
			</div>
		</div>
		<div id="content_footer"></div>
		<div id="footer">
			<p>
				<a href="index.html">Home</a> | <a href="examples.html">Examples</a>
				| <a href="page.html">A Page</a> | <a href="another_page.html">Another
					Page</a> | <a href="contact.html">Contact Us</a>
			</p>
			<p>
				Copyright &copy; shadowplay_2 | <a
					href="http://validator.w3.org/check?uri=referer">HTML5</a> | <a
					href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a
					href="http://www.html5webtemplates.co.uk">design from
					HTML5webtemplates.co.uk</a>
			</p>
		</div>
	</div>
</body>
</html>