package com.jun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jun.dbutils.DB;
import com.jun.entity.Emplyee;

@Repository
public class EmplyeeDao {

	Connection conn=null;
	PreparedStatement psta=null;
	ResultSet rs=null;
	
	//查询所有数据
	public ArrayList<Emplyee> findAll() {
		String sql = "select * from t_emplyee";
		ArrayList<Emplyee> list = new ArrayList<Emplyee>();
		try {
			conn=DB.getConnection();
			psta=conn.prepareStatement(sql);
			rs=psta.executeQuery();
			while(rs.next()) {
				Emplyee emp = new Emplyee();
				emp.setId(rs.getInt("id"));
				emp.setEmpName(rs.getString("empName"));
				emp.setAge(rs.getInt("age"));
				emp.setSex(rs.getString("sex"));
				emp.setSimple(rs.getString("simple"));
				emp.setFace(rs.getString("face"));
				emp.setDepId(rs.getInt("depId"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DB.close(rs, psta, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//按id查
	public Emplyee findById(int id) {
		String sql = "select * from t_emplyee where id = ?";
		Emplyee emp = null;
		try {
			conn=DB.getConnection();
			psta = conn.prepareStatement(sql);
			psta.setInt(1, id);
			rs = psta.executeQuery();
			if(rs.next()) {
				emp = new Emplyee();
				emp.setId(rs.getInt("id"));
				emp.setEmpName(rs.getString("empName"));
				emp.setAge(rs.getInt("age"));
				emp.setSex(rs.getString("sex"));
				emp.setSimple(rs.getString("simple"));
				emp.setFace(rs.getString("face"));
				emp.setDepId(rs.getInt("depId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DB.close(rs, psta, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
	
	//按名字查询
	public List<Emplyee> findEmpByName(String empName){
		String sql = "select * from t_emplyee where empName like ?";
		ArrayList<Emplyee> list = new ArrayList<Emplyee>();
		try {
			conn = DB.getConnection();
			psta = conn.prepareStatement(sql);
			psta.setString(1, "%"+empName+"%");
			rs = psta.executeQuery();
			while(rs.next()) {
				Emplyee emp = new Emplyee();
				emp.setId(rs.getInt("id"));
				emp.setEmpName(rs.getString("empName"));
				emp.setAge(rs.getInt("age"));
				emp.setSex(rs.getString("sex"));
				emp.setSimple(rs.getString("simple"));
				emp.setFace(rs.getString("face"));
				emp.setDepId(rs.getInt("depId"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DB.close(rs, psta, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//修改
	public boolean update(Emplyee emp) {
		String sql = "update t_emplyee set empName=?,age=?,sex=?,simple=?,face=?,depId=? where id=?";
		boolean flag = false;
		try {
			conn=DB.getConnection();
			psta = conn.prepareStatement(sql);
			psta.setString(1, emp.getEmpName());
			psta.setInt(2, emp.getAge());
			psta.setString(3, emp.getSex());
			psta.setString(4, emp.getSimple());
			psta.setString(5, emp.getFace());
			psta.setInt(6, emp.getDepId());
			psta.setInt(7, emp.getId());
			if(psta.executeUpdate()>0) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DB.close(rs, psta, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	
	//添加
	public Integer add(Emplyee emp) {
		int flag=0;
		String sql = "insert into t_emplyee(empName,age,sex,simple,face,depId) values(?,?,?,?,?,?)";
		try {
			conn = DB.getConnection();
			psta = conn.prepareStatement(sql);
			psta.setString(1, emp.getEmpName());
			psta.setInt(2, emp.getAge());
			psta.setString(3, emp.getSex());
			psta.setString(4, emp.getSimple());
			psta.setString(5, emp.getFace());
			psta.setInt(6, emp.getDepId());
			flag = psta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DB.close(rs, psta, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	//删除
	public boolean delete(int id) {
		boolean flag = false;
		String sql = "delete from t_emplyee where id = ?";
		try {
			conn=DB.getConnection();
			psta=conn.prepareStatement(sql);
			psta.setInt(1, id);
			if(psta.executeUpdate()>0) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DB.close(rs, psta, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
}
