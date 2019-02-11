package com.tpb.wiki.bo;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;

import com.tpb.wiki.beans.Topic;
import com.tpb.wiki.common.Constants;
import com.tpb.wiki.common.Messages;
import com.tpb.wiki.conn.DBCPDataSourceFactory;
import com.tpb.wiki.da.TopicDa;

public class TopicBo {

	private TopicDa _topicDa = null;

	public TopicBo() {
		DataSource ds = DBCPDataSourceFactory.getDataSource();
		_topicDa = new TopicDa(ds);
	}

	public void loadTopic(HttpServletRequest req) {

		List<Topic> topics = _topicDa.queryTopic();
		req.setAttribute("topics", topics);
	}

	public void createTopic(HttpServletRequest req) {

		String name = (String) req.getParameter("name");
		String desc = (String) req.getParameter("description");
		String createBy = "System";
		Date createDate = new Date();
		Topic topic = new Topic(0, name, desc, createBy, createDate, null, null);
		Messages message;
		if (isBlank(topic)) {
			message = new Messages(Constants.MessageType.ERROR, "Fields (*) cannot be left blank");
		} else {
			message = _topicDa.createTopic(topic);
		}

		if(message.getMessageType().equals(Constants.MessageType.ERROR)) {
			req.setAttribute("topic", topic);
		}else {
			req.setAttribute("topic", null);
		}
		
		req.setAttribute("message", message);
	}

	public void updateTopic(HttpServletRequest req) {

		HttpSession session = req.getSession();
		
		String name = (String) req.getParameter("name");
		String desc = (String) req.getParameter("description");
		String updateBy = "System";
		Date updateDate = new Date();
		Topic topic = new Topic(0, name, desc, null, null, updateBy, updateDate);
		Messages message;
		if (isBlank(topic)) {
			message = new Messages(Constants.MessageType.ERROR, "Fields (*) cannot be left blank");
		} else {
			message = _topicDa.updateTopic(topic);
		}
		
		session.setAttribute("afterUpdateTopic", topic);
		session.setAttribute("message", message);

		req.setAttribute("message", message);
	}

	public void getTopicById(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Messages message = null;
		Topic topic = null;
		
		if(session.getAttribute("afterUpdateTopic") == null) {
			int id = Integer.parseInt(req.getParameter("id"));
			topic = _topicDa.findTopicById(id);
			session.setAttribute("beforeUpdateTopic", topic);
		}else {
			topic = (Topic)session.getAttribute("afterUpdateTopic");
			message = (Messages)session.getAttribute("message");
			session.setAttribute("afterUpdateTopic", null);
			session.setAttribute("message", null);
		}
		
		req.setAttribute("message", message);
		req.setAttribute("topic", topic);
		
	}

	public boolean isBlank(Topic topic) {
		if (!StringUtils.isNotBlank(topic.getName())) {
			return true;
		}
		return false;
	}
}
