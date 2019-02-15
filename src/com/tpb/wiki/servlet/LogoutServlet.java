package com.tpb.wiki.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tpb.wiki.bo.UserBo;
import com.tpb.wiki.common.Constants;
import com.tpb.wiki.common.Messages;

public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set Session userInfo to null
		HttpSession session = req.getSession();
		session.setAttribute(Constants.SESSION_USER_INFO, null);
		resp.sendRedirect(req.getContextPath() + "/login");
	}
	

}
