package com.tpb.wiki.utils;

public class BuildHtml {
	public String category(String cateName) {
		return String.format("<h1>%s</h1></hr></br>", cateName);
	}
	
	public String article(String link,String articleName) {
		return String.format("<a href='%s'>%s</a></br>", link,articleName);
	}
}
