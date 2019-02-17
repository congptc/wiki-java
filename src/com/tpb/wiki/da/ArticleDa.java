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
		String sql = "Insert into wk_articles(id,id_topic, subject, content, status, create_by,create_date) "
					+ "values (wk_article_sequence.nextval,?,?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = _ds.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, article.getIdTopic());
			pstm.setString(2, article.getSubject());
			pstm.setString(3, article.getContent());
			pstm.setInt(4, article.getStatus());
			pstm.setString(5, article.getCreateBy());
			pstm.setTimestamp(6, new Timestamp(article.getCreateDate().getTime()));

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
		String sql = "Delete From wk_articles where id= ?";
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
		String sql = "Update wk_articles set "
					+ "id_topic=?,"
					+ "subject =?,"
					+ "content = ?,"
					+ "status = ?,"
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
			pstm.setInt(4, article.getStatus());
			pstm.setString(5, article.getUpdateBy());
			pstm.setTimestamp(6, new Timestamp(article.getUpdateDate().getTime()));
			pstm.setInt(7, article.getId());
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
	
	public Messages approved(int id) {
		String sql = "Update wk_articles set "
					+ "status=1 "
					+ "Where id=? ";
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			if(pstm.executeUpdate() > 0) {
				return new Messages(Constants.MessageType.SUCCESS, "Approve success");
			}
			return new Messages(Constants.MessageType.ERROR,"Approve fail");

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
		String sql = "Select t.name AS topic_name,a.* From wk_articles a "
						+ "INNER JOIN wk_topics t ON  a.id_topic = t.id"
						+ " WHERE a.id= ? "
						+ " AND a.status = 1 ";
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
				String topicName = rs.getString("topic_name");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String createBy = rs.getString("create_by");
				Date createDate = rs.getTimestamp("create_date");
				String updateBy = rs.getString("update_by");
				Date updateDate = rs.getTimestamp("update_date");
				Article article = new Article(id,idTopic,topicName, subject, content,createBy, createDate, updateBy, updateDate);
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
	
	public Article findArticleUnapprovedById(int articleId) {
		String sql = "Select t.name AS topic_name,a.* From wk_articles a "
						+ "INNER JOIN wk_topics t ON  a.id_topic = t.id"
						+ " WHERE a.id= ? "
						+ " AND a.status = 0 ";
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
				String topicName = rs.getString("topic_name");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String createBy = rs.getString("create_by");
				Date createDate = rs.getTimestamp("create_date");
				String updateBy = rs.getString("update_by");
				Date updateDate = rs.getTimestamp("update_date");
				Article article = new Article(id,idTopic,topicName, subject, content,createBy, createDate, updateBy, updateDate);
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

	public List<Article> findArticleByTopic(int topicId) {
		String sql = "SELECT t.name AS topic_name,a.* From wk_articles a "
				+ " INNER JOIN wk_topics t ON a.id_topic = t.id"
				+ " WHERE a.id_topic = ? "
				+ " AND a.status = 1 ";
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
				String topicName = rs.getString("topic_name");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String createBy = rs.getString("create_by");
				Date createDate = rs.getTimestamp("create_date");
				String updateBy = rs.getString("update_by");
				Date updateDate = rs.getTimestamp("update_date");
				Article article = new Article(id,idTopic,topicName, subject, content,createBy, createDate, updateBy, updateDate);
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
	
	
	public List<Article> findArticleUnapproved() {
		String sql = "SELECT t.name AS topic_name,a.* From wk_articles a "
				+ " INNER JOIN wk_topics t ON a.id_topic = t.id"
				+ " WHERE a.status = 0 ";
		List<Article> articles = new ArrayList<Article>();
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idTopic = rs.getInt("id_topic");
				String topicName = rs.getString("topic_name");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String createBy = rs.getString("create_by");
				Date createDate = rs.getTimestamp("create_date");
				String updateBy = rs.getString("update_by");
				Date updateDate = rs.getTimestamp("update_date");
				Article article = new Article(id,idTopic,topicName, subject, content,createBy, createDate, updateBy, updateDate);
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
	
	public List<Article> findArticleBySubject(String valueSearch) {
		String sql = "SELECT t.name AS topic_name,a.* From wk_articles a "
				+ " INNER JOIN wk_topics t ON a.id_topic = t.id"
				+ " WHERE upper(a.subject) like upper('%"+valueSearch+"%') "
				+ " AND a.status = 1 ";
		List<Article> articles = new ArrayList<Article>();
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int idTopic = rs.getInt("id_topic");
				String topicName = rs.getString("topic_name");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String createBy = rs.getString("create_by");
				Date createDate = rs.getTimestamp("create_date");
				String updateBy = rs.getString("update_by");
				Date updateDate = rs.getTimestamp("update_date");
				Article article = new Article(id,idTopic,topicName, subject, content,createBy, createDate, updateBy, updateDate);
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
		String sql = "SELECT * "
				+ "FROM (Select t.name AS topic_name,a.*"
							+ "From wk_articles a "
							+ "INNER JOIN wk_topics t ON  a.id_topic = t.id "
							+ "WHERE a.status = 1 "
							+ "order by a.create_date DESC) "
				+ " WHERE  ROWNUM <=?";
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
				String topicName = rs.getString("topic_name");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String createBy = rs.getString("create_by");
				Date createDate = rs.getTimestamp("create_date");
				String updateBy = rs.getString("update_by");
				Date updateDate = rs.getTimestamp("update_date");
				Article article = new Article(id,idTopic,topicName, subject, content,createBy, createDate, updateBy, updateDate);
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
