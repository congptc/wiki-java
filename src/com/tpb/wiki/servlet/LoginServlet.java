package com.tpb.wiki.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpb.wiki.bo.UserBo;
import com.tpb.wiki.common.Constants;
import com.tpb.wiki.common.Messages;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	
	public LoginServlet() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBo userBo = new UserBo();
		userBo.login(req);
		Messages message = (Messages)req.getAttribute("message");
		
		if(message.getMessageType().equals(Constants.MessageType.ERROR)) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath()+"/");
		}
		
	}
	
}
