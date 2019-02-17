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
import com.tpb.wiki.utils.ProcessEditorHtmlUtil;

@MultipartConfig
public class DeleteImgCreateModeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public DeleteImgCreateModeServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		ProcessEditorHtmlUtil pehu = new ProcessEditorHtmlUtil();
		
		String src = req.getParameter("src");
		String fileName = src.substring(src.lastIndexOf("/"), src.length());
		ServletContext context = getServletContext();
		String fullPathImg = context.getRealPath("/assets/article_img/" + fileName);
		pehu.deleteFile(fullPathImg);
		String jsonResponseData = new Gson().toJson("Success");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(jsonResponseData);
	}
	
	

}
