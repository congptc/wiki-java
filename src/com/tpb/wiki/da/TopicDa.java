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

import com.tpb.wiki.beans.Topic;
import com.tpb.wiki.common.Constants;
import com.tpb.wiki.common.Messages;

public class TopicDa {

	private DataSource _ds = null;

	public TopicDa(DataSource ds) {
		_ds = ds;
	}

	public Messages createTopic(Topic topic) {
		String sql = "Insert into topics(name, description,create_by,create_date) values (?,?,?,?)";
		Connection conn = null;
		try {
			conn = _ds.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setString(1, topic.getName());
			pstm.setString(2, topic.getDescription());
			pstm.setString(3, topic.getCreateBy());
			pstm.setTimestamp(4, new Timestamp(topic.getCreateDate().getTime()));

			if(pstm.executeUpdate() > 0) {
				return new Messages(Constants.MessageType.SUCCESS, "Insert success");
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

	public Messages deleteTopic(String id) {
		String sql = "Delete From topics where id= ?";
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

	public Messages updateTopic(Topic topic) {
		String sql = "Update topics "
					+ "set name = ? ,"
					+ "description = ?,"
					+ "update_by=?,"
					+ "update_date = ?"
					+ "Where id=? ";
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, topic.getName());
			pstm.setString(2, topic.getDescription());
			pstm.setString(3, topic.getUpdateBy());
			pstm.setTimestamp(4, new Timestamp(topic.getUpdateDate().getTime()));
			pstm.setInt(5, topic.getId());
			
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

	public Topic findTopicById(int topicId) {
		String sql = "Select * From topics where id= ?";
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, topicId);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String createBy = rs.getString("create_by");
				Date createDate = rs.getTimestamp("create_date");
				String updateBy = rs.getString("update_by");
				Date updateDate = rs.getTimestamp("update_date");
				Topic topic = new Topic(id, name, description,createBy,createDate, updateBy,updateDate);
				return topic;
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
	
	public List<Topic> queryTopic() {
		String sql = "Select * From topics ORDER BY name DESC";
		List<Topic> topics = new ArrayList<Topic>();
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String createBy = rs.getString("create_by");
				Date createDate = rs.getTimestamp("create_date");
				String updateBy = rs.getString("update_by");
				Date updateDate = rs.getTimestamp("update_date");
				Topic topic = new Topic(id, name, description,createBy,createDate, updateBy,updateDate);
				topics.add(topic);
			}
			return topics;

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
