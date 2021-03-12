package org.comstudy21.myweb.user.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.myweb.common.JDBCUtil;
import org.comstudy21.myweb.user.UserService;
import org.comstudy21.myweb.user.UserVO;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO implements UserService {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// ID, PASSWORD, NAME, ROLE
	private final String USER_INSERT = "insert into users(ID,PASSWORD, NAME,ROLE) values(?,?,?,?)";
	private final String USER_UPDATE = "update users set PASSWORD=?, NAME=?, ROLE=? where ID=?";
	private final String USER_DELETE = "delete from users where ID=?";
	private final String USER_GET = "select * from users where ID=?";
	private final String USER_LIST = "select * from users order by ID desc";

	@Override
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC로 insertUser() 기능 처리");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}

	@Override
	public void updateUser(UserVO vo) {
		System.out.println("===> updateUser() 기능 처리");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getPassword());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getRole());
			stmt.setString(4, vo.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}

	@Override
	public void deleteUser(UserVO vo) {
		System.out.println("===> deleteUser() 기능 처리");
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, vo.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

	}

	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("===> getUser() 기능 처리");
		UserVO user = null;
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return user;
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> getUserList() 기능 처리");
		List<UserVO> userList = new ArrayList<UserVO>();
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			if (rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));

				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

		return userList;
	}
}