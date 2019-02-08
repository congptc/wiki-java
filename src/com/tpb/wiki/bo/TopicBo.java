package com.tpb.wiki.bo;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;

import com.tpb.wiki.beans.Article;
import com.tpb.wiki.beans.Topic;
import com.tpb.wiki.common.Constants;
import com.tpb.wiki.common.Messages;
import com.tpb.wiki.conn.DBCPDataSourceFactory;
import com.tpb.wiki.da.ArticleDa;
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

		req.setAttribute("message", message);
	}

	public void updateTopic(HttpServletRequest req) {

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

		req.setAttribute("message", message);
	}

	public void getTopicById(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		Topic topic = _topicDa.findTopicById(id);
		req.setAttribute("topic", topic);
	}

	public boolean isBlank(Topic topic) {
		if (!StringUtils.isNotBlank(topic.getName())) {
			return true;
		}
		return false;
	}
}
