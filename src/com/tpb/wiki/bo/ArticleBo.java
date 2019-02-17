package com.tpb.wiki.bo;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;

import com.tpb.wiki.beans.Article;
import com.tpb.wiki.beans.User;
import com.tpb.wiki.common.Constants;
import com.tpb.wiki.common.Messages;
import com.tpb.wiki.conn.DBCPDataSourceFactory;
import com.tpb.wiki.da.ArticleDa;
import com.tpb.wiki.utils.ProcessEditorHtmlUtil;

public class ArticleBo {

	private ArticleDa _articleDa = null;
	private ProcessEditorHtmlUtil pegu = new ProcessEditorHtmlUtil();

	public ArticleBo() {
		DataSource ds = DBCPDataSourceFactory.getDataSource();
		_articleDa = new ArticleDa(ds);
	}

	public void createArticle(HttpServletRequest req) {
		HttpSession session = req.getSession();
		User userInfo = (User) session.getAttribute(Constants.SESSION_USER_INFO);
		int idTopic = Integer.parseInt(req.getParameter("idTopic"));
		String subject = (String) req.getParameter("subject");
		String content = (String) req.getParameter("content");

		String createBy = userInfo.getUserName();
		Date createDate = new Date();
		Messages message;

		Article article = new Article(0, idTopic, subject, content, 0, createBy, createDate, null, null);

		if (isBlank(article)) {
			message = new Messages(Constants.MessageType.ERROR, "Fields (*) cannot be left blank");
		} else {
			message = _articleDa.createArticle(article);
		}

		if (message.getMessageType().equals(Constants.MessageType.ERROR)) {
			req.setAttribute("article", article);
		} else {
			req.setAttribute("article", null);
		}
		req.setAttribute("message", message);
	}

	public void updateArticle(HttpServletRequest req) {

		HttpSession session = req.getSession();
		User userInfo = (User) session.getAttribute(Constants.SESSION_USER_INFO);
		// Get list path image will be delete
		@SuppressWarnings("unchecked")
		List<String> pathImgsWillBeDelete = (List<String>) session.getAttribute("pathImgsWillBeDelete");

		int id = Integer.parseInt(req.getParameter("id"));
		int idTopic = Integer.parseInt(req.getParameter("idTopic"));
		String subject = (String) req.getParameter("subject");
		String content = (String) req.getParameter("content");
		int status = 0;
		String updateBy = userInfo.getUserName();
		Date updateDate = new Date();
		Messages message;

		Article article = new Article(id, idTopic, subject, content, status, null, null, updateBy, updateDate);

		if (isBlank(article)) {
			message = new Messages(Constants.MessageType.ERROR, "Fields (*) cannot be left blank");

		} else {
			message = _articleDa.updateArticle(article);
		}

		if (message.getMessageType() != Constants.MessageType.ERROR && pathImgsWillBeDelete != null) {
			pegu.deleteFile(pathImgsWillBeDelete);
		}
		session.setAttribute("afterUpdateArticle", article);
		session.setAttribute("message", message);

	}

	public void findArticleById(HttpServletRequest req) {

		HttpSession session = req.getSession();
		Messages message = null;

		// Set NULL for session "pathImgsWillBeDelete" to clear data in session
		session.setAttribute("pathImgsWillBeDelete", null);

		Article article = null;
		if (session.getAttribute("afterUpdateArticle") == null) {
			int id = Integer.parseInt(req.getParameter("id"));
			article = _articleDa.findArticleById(id);
			session.setAttribute("beforeUpdateArticle", article);
		} else {
			article = (Article) session.getAttribute("afterUpdateArticle");
			message = (Messages) session.getAttribute("message");
			session.setAttribute("afterUpdateArticle", null);
			session.setAttribute("message", null);
		}

		req.setAttribute("message", message);
		req.setAttribute("article", article);

	}

	public void findArticleUnapprovedById(HttpServletRequest req) {
		Article article = null;
		HttpSession session = req.getSession();
		int id = Integer.parseInt(req.getParameter("id"));
		article = _articleDa.findArticleUnapprovedById(id);
		session.setAttribute("beforeApproved", article);
		req.setAttribute("article", article);
		
	}
	
	public void approve(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		HttpSession session = req.getSession();
		Messages message = _articleDa.approved(id);
		Article article = (Article)session.getAttribute("beforeApproved");
		req.setAttribute("message", message);
		req.setAttribute("article", article);
	}

	public void getArticleLatest(HttpServletRequest req) {
		List<Article> articles = _articleDa.getArticlesLatest(10);
		req.setAttribute("articles", articles);
	}

	public void getArticlesByTopic(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		List<Article> articles = _articleDa.findArticleByTopic(id);
		req.setAttribute("articles", articles);
	}

	public void getArticlesUnapproved(HttpServletRequest req) {
		List<Article> articles = _articleDa.findArticleUnapproved();
		req.setAttribute("articles", articles);
	}

	public void getArticlesBySubject(HttpServletRequest req) {
		String valueSearch = (String) req.getParameter("search_field");
		List<Article> articles = _articleDa.findArticleBySubject(valueSearch);
		req.setAttribute("searchValue", valueSearch);
		req.setAttribute("articles", articles);
	}

	public boolean isBlank(Article article) {
		if (!StringUtils.isNotBlank(article.getSubject()) || !StringUtils.isNotBlank(article.getContent())) {
			return true;
		}
		return false;
	}
}
