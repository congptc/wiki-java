package com.tpb.wiki.bo;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.catalina.connector.Request;

import com.tpb.wiki.beans.User;
import com.tpb.wiki.common.Constants;
import com.tpb.wiki.common.Messages;
import com.tpb.wiki.conn.DBCPDataSourceFactory;
import com.tpb.wiki.da.UserDa;

public class UserBo {
	
	private	UserDa _userDa = null;
	
	
	public UserBo() {
		DataSource ds = DBCPDataSourceFactory.getDataSource();
		_userDa =  new UserDa(ds);
	}
	
	public void login(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		Messages message = null;
		
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		User user = _userDa.findUserByUserNameAndPassword(userName, password);
		
		if(user == null) {
			message = new Messages(Constants.MessageType.ERROR, "User name or password wrong");
		}else {
			session.setAttribute(Constants.SESSION_USER_INFO, user);
			message = new Messages(Constants.MessageType.SUCCESS, "Login success");
		}
		
		req.setAttribute("message", message);
		req.setAttribute("User", user);
	}
	
	public void loadUserInfo(HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute(Constants.SESSION_USER_INFO);
		req.setAttribute("userInfo", user);
	}
	
	
	
}
