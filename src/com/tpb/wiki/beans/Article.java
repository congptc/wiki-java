package com.tpb.wiki.beans;

import java.util.Date;

public class Article {
	private int id;
	private int idTopic;
	private String topicName;
	private String subject;
	private String content;
	private int status;	
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	
	
	
	
	public Article(int id, int idTopic, String subject, String content, int status, String createBy,
			Date createDate, String updateBy, Date updateDate) {
		super();
		this.id = id;
		this.idTopic = idTopic;
		this.subject = subject;
		this.content = content;
		this.status = status;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}

	public Article(int id, int idTopic,String topicName, String subject, String content, String createBy, Date createDate,
			String updateBy, Date updateDate) {
		super();
		this.id = id;
		this.idTopic = idTopic;
		this.topicName = topicName;
		this.subject = subject;
		this.content = content;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTopic() {
		return idTopic;
	}
	public void setIdTopic(int idTopic) {
		this.idTopic = idTopic;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	

}
