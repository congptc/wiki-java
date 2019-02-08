package com.tpb.wiki.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

@MultipartConfig
public class DeleteImgServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteImgServlet() {
		super();
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		  String src = req.getParameter("src");
		  String fileName = src.substring(src.lastIndexOf("/"),src.length());
		  ServletContext context = getServletContext();
		  String fullPath = context.getRealPath("/assets/article_img/"+fileName);
		  File deleteFile = new File(fullPath);
	        try {
	        	// check if the file  present or not
	        	if( deleteFile.exists() )
	        	deleteFile.delete() ;
	        } catch (Exception e) {
	            e.printStackTrace();
	            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            return;
	        }
	        String jsonResponseData = new Gson().toJson("Success");
	        resp.setContentType("application/json");
	        resp.setCharacterEncoding("UTF-8");
	        resp.getWriter().write(jsonResponseData);
	}

}
