package com.tpb.wiki.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.tpb.wiki.beans.Article;
import com.tpb.wiki.beans.Topic;
import com.tpb.wiki.bo.ArticleBo;
import com.tpb.wiki.conn.DBCPDataSourceFactory;
import com.tpb.wiki.da.ArticleDa;
import com.tpb.wiki.da.TopicDa;

public class ArticleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArticleBo articleBo = new ArticleBo();
		articleBo.findArticleById(req);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/article.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
