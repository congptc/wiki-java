<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<html>
<head>
  <link rel="stylesheet" type="text/css" href="./assets/css/style.css"/>
  <title>shadowplay_2</title>
</head>
<body>
  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="index.html">shadow<span class="logo_colour">play_2</span></a></h1>
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
    <div id="site_content">
      <div class="sidebar">
        <!-- insert your sidebar items here -->
        <h3>Latest News</h3>
        <h5>January 1st, 2011</h5>
        <p>2011 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>
        <h5>January 1st, 2011</h5>
        <p>2011 sees the redesign of our website. Take a look around and let us know what you think.<br /><a href="#">Read more</a></p>
        <h3>Useful Links</h3>
        <ul>
          <li><a href="#">link 1</a></li>
          <li><a href="#">link 2</a></li>
          <li><a href="#">link 3</a></li>
          <li><a href="#">link 4</a></li>
        </ul>
        <h3>Search</h3>
        <form method="post" action="#" id="search_form">
          <p>
            <input class="search" type="text" name="search_field" value="Enter keywords....." />
            <input name="search" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="./assets/css/search.png" alt="Search" title="Search" />
          </p>
        </form>
      </div>
      <div id="content">
        <div class="col">
		<ul>
		  <li><a href="#">link 1 ink 1ink 1ink 1ink 1ink 1ink 1ink 1ink 1</a></li>
		  <li><a href="#">link 2 ink 1ink 1</a></li>
		  <li><a href="#">link 3 ink 1ink 1ink 1ink 1</a></li>
		  <li><a href="#">link 4 ink 1ink 1ink 1</a></li>
		</ul>
	</div>
	<div class="col">
		<ul>
		  <li><a href="#">link 1</a></li>
		  <li><a href="#">link 2</a></li>
		  <li><a href="#">link 3</a></li>
		  <li><a href="#">link 4</a></li>
		</ul>
	</div>
	<div class="col">
		<ul>
		  <li><a href="#">link 1</a></li>
		  <li><a href="#">link 2</a></li>
		  <li><a href="#">link 3</a></li>
		  <li><a href="#">link 4</a></li>
		</ul>
	</div>
	<div class="col">
		<ul>
		  <li><a href="#">link 1</a></li>
		  <li><a href="#">link 2</a></li>
		  <li><a href="#">link 3</a></li>
		  <li><a href="#">link 4</a></li>
		</ul>
	</div>
	<div class="col">
		<ul>
		  <li><a href="#">link 1</a></li>
		  <li><a href="#">link 2</a></li>
		  <li><a href="#">link 3</a></li>
		  <li><a href="#">link 4</a></li>
		</ul>
	</div>
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
      <p><a href="index.html">Home</a> | <a href="examples.html">Examples</a> | <a href="page.html">A Page</a> | <a href="another_page.html">Another Page</a> | <a href="contact.html">Contact Us</a></p>
      <p>Copyright &copy; shadowplay_2 | <a href="http://validator.w3.org/check?uri=referer">HTML5</a> | <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a href="http://www.html5webtemplates.co.uk">design from HTML5webtemplates.co.uk</a></p>
    </div>
  </div>
</body>
</html>