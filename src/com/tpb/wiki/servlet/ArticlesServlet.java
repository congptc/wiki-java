package com.tpb.wiki.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpb.wiki.bo.ArticleBo;

public class ArticlesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArticleBo articleBo = new ArticleBo();
		articleBo.getArticlesByTopic(req);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/articles.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
