package com.sds.icto.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sds.icto.guestbook.vo.Guestbook;

@Repository
public class GuestbookDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");

		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "webdb", "webdb");

		return conn;
	}

	public void insert(Guestbook g) {

		Connection conn;
		try {
			conn = getConnection();
			String sql = "insert into guestbook values(guestbook_seq.nextval, ?, ?, ?, sysdate)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, g.getName());
			ps.setString(2, g.getPassword());
			ps.setString(3, g.getMessage());

			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("저장성공");
			}

			if (ps != null) {
				ps.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	public void delete(int id, String password) {
		Connection conn;
		try {
			conn = getConnection();

			String sql = "delete from guestbook where no = ? and password = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, password);

			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println("삭제성공");
			}

			if (ps != null) {
				ps.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Guestbook> fetchList() {
		List<Guestbook> list = new ArrayList<Guestbook>();

		Connection conn;
		try {
			conn = getConnection();
			String sql = "select * from guestbook";

			Statement s = conn.prepareStatement(sql);

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Guestbook g = new Guestbook(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(g);
			}

			if (rs != null) {
				rs.close();
			}

			if (s != null) {
				s.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
