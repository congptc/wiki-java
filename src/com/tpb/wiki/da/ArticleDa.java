package com.tpb.wiki.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.tpb.wiki.beans.Article;
import com.tpb.wiki.common.Messages;
import com.tpb.wiki.common.Constants;

public class ArticleDa {

	private DataSource _ds = null;

	public ArticleDa(DataSource ds) {
		_ds = ds;
	}

	public Messages createArticle(Article article) {
		String sql = "Insert into articles(id_topic, subject, content, create_by,create_date) "
					+ "values (?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = _ds.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, article.getIdTopic());
			pstm.setString(2, article.getSubject());
			pstm.setString(3, article.getContent());
			pstm.setString(4, article.getCreateBy());
			pstm.setTimestamp(5, new Timestamp(article.getCreateDate().getTime()));

			if(pstm.executeUpdate() > 0) {
				return new Messages(Constants.MessageType.SUCCESS ,"Insert success");
			}
			return new Messages(Constants.MessageType.ERROR,"Insert fail");
					
		} catch (Exception e) {
			e.printStackTrace();
			return new Messages(Constants.MessageType.ERROR,e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return new Messages(Constants.MessageType.ERROR,e.getMessage());
			}
		}
	}

	public Messages deleteArticle(String id) {
		String sql = "Delete From articles where id= ?";
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			if(pstm.executeUpdate() > 0) {
				return new Messages(Constants.MessageType.SUCCESS, "Delete success");
			}
			return new Messages(Constants.MessageType.ERROR,"Delete fail");
			
		} catch (Exception e) {
			e.printStackTrace();
			return new Messages(Constants.MessageType.ERROR,e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return new Messages(Constants.MessageType.ERROR,e.getMessage());
			}
		}
	}

	public Messages updateArticle(Article article) {
		String sql = "Update articles set "
					+ "id_topic=?,"
					+ "subject =?,"
					+ "content = ?,"
					+ "update_by=?,"
					+ "update_date=? "
					+ "Where id=? ";
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, article.getIdTopic());
			pstm.setString(2, article.getSubject());
			pstm.setString(3, article.getContent());
			pstm.setString(4, article.getUpdateBy());
			pstm.setTimestamp(5, new Timestamp(article.getUpdateDate().getTime()));
			pstm.setInt(6, article.getId());
			if(pstm.executeUpdate() > 0) {
				return new Messages(Constants.MessageType.SUCCESS, "Update success");
			}
			return new Messages(Constants.MessageType.ERROR,"Update fail");

		} catch (SQLException e) {
			e.printStackTrace();
			return new Messages(Constants.MessageType.ERROR,e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return new Messages(Constants.MessageType.ERROR,e.getMessage());
			}
		}

	}

	public Article findArticleById(int articleId) {
		String sql = "Select * From articles where id= ?";
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, articleId);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idTopic = rs.getInt("id_topic");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String createBy = rs.getString("create_by");
				Date createDate = rs.getTimestamp("create_date");
				String updateBy = rs.getString("update_by");
				Date updateDate = rs.getTimestamp("update_date");
				Article article = new Article(id,idTopic, subject, content,createBy, createDate, updateBy, updateDate);
				return article;
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Article> queryArticleByTopic(int topicId) {
		String sql = "Select * From articles where id_topic = ?";
		List<Article> articles = new ArrayList<Article>();
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, topicId);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idTopic = rs.getInt("id_topic");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String createBy = rs.getString("create_by");
				Date createDate = rs.getTimestamp("create_date");
				String updateBy = rs.getString("update_by");
				Date updateDate = rs.getTimestamp("update_date");
				Article article = new Article(id,idTopic, subject, content,createBy, createDate, updateBy, updateDate);
				articles.add(article);
			}
			return articles;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Article> getArticlesLatest(int maxRow) {
		String sql = "Select * From articles order by create_date DESC LIMIT ?";
		List<Article> articles = new ArrayList<Article>();
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, maxRow);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idTopic = rs.getInt("id_topic");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String createBy = rs.getString("create_by");
				Date createDate = rs.getTimestamp("create_date");
				String updateBy = rs.getString("update_by");
				Date updateDate = rs.getTimestamp("update_date");
				Article article = new Article(id,idTopic, subject, content,createBy, createDate, updateBy, updateDate);
				articles.add(article);
			}
			return articles;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
