package com.tpb.wiki.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.tpb.wiki.beans.User;

public class UserDa {

	private DataSource _ds = null;

	public UserDa(DataSource ds) {
		_ds = ds;
	}

	public int createUser(User user) {
		String sql = "Insert into wk_users(id,user_name, password,status) values (wk_user_sequence.nextval,?,?,?)";
		Connection conn = null;
		try {
			conn = _ds.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getStatus());

			return pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
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

	public int deleteUser(String id) {
		String sql = "Delete From wk_users where id= ?";
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			return pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
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

	public int updateUser(User user) {
		String sql = "Update wk_users set name =?,password = ?,status=? Where id=? ";
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, user.getId());
			pstm.setString(2, user.getUserName());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getStatus());
			return pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
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

	public User findUserById(int userId) {
		String sql = "Select * From wk_users where id= ?";
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, userId);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String password = rs.getString("password");
				String status = rs.getString("status");
				User user = new User(id, userName, password, status);
				return user;
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
	
	public User findUserByUserName(String pUserName) {
		String sql = "Select * From wk_users where user_name= ?";
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pUserName);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String password = rs.getString("password");
				String status = rs.getString("status");
				User user = new User(id, userName, password, status);
				return user;
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
	
	public User findUserByUserNameAndPassword(String pUserName,String pPassword) {
		String sql = "Select * "
						+ "From wk_users "
						+ "where upper(user_name) = upper(?) "
						+ "AND upper(password) = upper(?) "
						+ "AMD status = 1";
		
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pUserName);
			pstm.setString(2, pPassword);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String password = rs.getString("password");
				String status = rs.getString("status");
				User user = new User(id, userName, password, status);
				return user;
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
	
	public List<User> queryUser() {
		String sql = "Select * From wk_users";
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstm;
		try {
			conn = _ds.getConnection();
			pstm = conn.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String password = rs.getString("password");
				String status = rs.getString("status");
				User user = new User(id, userName, password, status);
				users.add(user);
			}
			return users;

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
