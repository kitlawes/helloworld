package com.tutorialspoint.test;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {
	private static final long serialVersionUID = 1L;

	public List<Author> getAuthors() {
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = getConnection();
		String stm = "Select * from authors";
		List<Author> records = new ArrayList<Author>();

		try {
			pst = con.prepareStatement(stm);
			pst.execute();
			rs = pst.getResultSet();

			while (rs.next()) {
				Author author = new Author();
				author.setId(rs.getInt(1));
				author.setName(rs.getString(2));
				records.add(author);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return records;
	}

	public Connection getConnection() {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		String url = "jdbc:postgresql://localhost/testdb";
		String user = "user1";
		String password = "user1";

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection completed.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		finally {
		}
		System.out.println("Connection: " + con);
		return con;
	}
}