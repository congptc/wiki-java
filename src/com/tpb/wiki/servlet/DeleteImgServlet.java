package com.tpb.wiki.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		List<String> pathImgsWillBeDelete = (List<String>) session.getAttribute("pathImgsWillBeDelete");
		
		String src = req.getParameter("src");
		String fileName = src.substring(src.lastIndexOf("/"), src.length());
		ServletContext context = getServletContext();
		String fullPathImg = context.getRealPath("/assets/article_img/" + fileName);
		if(pathImgsWillBeDelete != null) {
			pathImgsWillBeDelete.add(fullPathImg);
		}
		String jsonResponseData = new Gson().toJson("Success");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(jsonResponseData);
	}
	
	

}
