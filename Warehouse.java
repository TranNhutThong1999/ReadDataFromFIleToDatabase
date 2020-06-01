package com.thong.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Warehouse {
	public Connection getConnection() throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/warehouse";
		String name = "root";
		String pw = "0985153812";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			// System.out.println("thanh cong");
			return DriverManager.getConnection(url, name, pw);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;

	}

	public void insertData(User user) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement("insert into data(name,maleOrfemal,age,address,asset) values(?,?,?,?,?)");
			statement.setString(1, user.getName());
			statement.setString(2, user.getMaleOrFemal());
			statement.setInt(3, user.getAge());
			statement.setString(4, user.getAddress());
			statement.setBigDecimal(5, user.getAsset());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e1) {
			if (connection != null) {
				try {
					connection.rollback();
					System.out.println("khong thanh cong");
				} catch (SQLException e11) {
					e11.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Warehouse w = new Warehouse();
		BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream("D:\\Top20nguoigiaunhatvietnam.txt")));
		br.readLine();
		String line="";
		while((line=br.readLine())!=null) {
			String[] list = line.split("[\t]+");
			String d =list[5].replace(",", ".");
			User user = new User(list[1], list[2], Integer.valueOf(list[3]), list[4],  new BigDecimal(d));
			System.out.println(user.toString());
			w.insertData(user);
		//break;
		}
		
		
	}
}
