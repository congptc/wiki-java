package com.tpb.wiki.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tpb.wiki.beans.User;
import com.tpb.wiki.bo.ArticleBo;
import com.tpb.wiki.common.Constants;

public class ApproveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute(Constants.SESSION_USER_INFO);
		
		if(user == null || !user.getIssuperadmin().equalsIgnoreCase("y")) {
			resp.sendRedirect(req.getContextPath()+"/");
			return;
		}
		
		ArticleBo articleBo = new ArticleBo();
		articleBo.approve(req);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/articleunapproved.jsp");
		dispatcher.forward(req, resp);
	}

}
