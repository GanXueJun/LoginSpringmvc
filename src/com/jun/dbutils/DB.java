package com.jun.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//数据库连接类
public class DB {

private DB(){}
	
	private static String url="jdbc:mysql://localhost:3306/gavin2";
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, "root", "123456");		
	}
	
	
	public static void close(ResultSet rs,Statement sta,Connection con) throws SQLException{
		if(rs!=null){
			rs.close();
		}
		if(sta!=null){
			sta.close();
		}
		if(con!=null){
			con.close();
		}
	}
}
