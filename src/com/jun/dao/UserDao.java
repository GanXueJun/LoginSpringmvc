package com.jun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.jun.dbutils.DB;

//@Repository用于声明它是dao层
@Repository
public class UserDao {
	Connection conn=null;
	PreparedStatement psta=null;
	ResultSet rs=null;
	
	public int Login(String username,String password) {
		String sql = "select * from t_user where username='"+username+"' and password='"+password+"'";
		try {
			conn=DB.getConnection();
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();
			//如果能够next就表明有数据行查询出来
			if(rs.next()) {
				//有数据行查出来再查密码是否正确
				if(password.equals(rs.getString("password"))) {
					return 1;
				}
			}
			return 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DB.close(rs, psta, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	
	//用户注册
	public int Regist(String username,String password) {
		String sql = "insert into t_user(username,password) values(?,?)";
		int flag = 0;
		try {
			conn = DB.getConnection();
			psta = conn.prepareStatement(sql);
			//设置传进来的参数
			psta.setString(1, username);
			psta.setString(2, password);
			//是否受影响
			flag = psta.executeUpdate();
			System.out.println(flag);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DB.close(rs, psta, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
