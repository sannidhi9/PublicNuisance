package com.nuisance.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import com.nuisance.bean.UserBean;

public class UserDao {
	public static boolean authenticate(String username,String password){
		boolean status=false;
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int InsertUser(UserBean bean){
		int status=0;
		try{
			Connection con=Dbcon.getCon();
			CallableStatement ps=con.prepareCall("{CALL CheckAge(?,?,?,?,?,?)}");
			ps.setString(1,bean.getEmail());
			ps.setInt(2,bean.getPhno());
			ps.setInt(3,bean.getAge());
			ps.setString(4,bean.getAddress());
			ps.setString(5,bean.getUsername());
			ps.setString(6,bean.getPassword());
			status=ps.executeUpdate();
			con.close();

		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<UserBean> ViewUser(){
		List<UserBean> list=new ArrayList<UserBean>();
		try{
			Connection con=Dbcon.getCon();
			CallableStatement ps=con.prepareCall("{CALL AllUser()}");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserBean bean=new UserBean();
				bean.setEmail(rs.getString("email"));
				bean.setAddress(rs.getString("address"));
				bean.setUser_id(rs.getInt("user_id"));
				bean.setPhno(rs.getInt("phno"));
				bean.setAge(rs.getInt("age"));
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static int getUid(String username,String password) {
		int uid=0;
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select user_id from user where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			uid=rs.getInt(1);
			
			con.close();
	}
		catch(Exception e){System.out.println(e);}
		
		return uid;
		
	}
	public static UserBean ViewUserId(int uid){
		UserBean bean=new UserBean();
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from user where user_id=?");
			ps.setInt(1,uid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bean.setUser_id(rs.getInt("user_id"));
				bean.setEmail(rs.getString("email"));
				bean.setAddress(rs.getString("address"));
				bean.setAge(rs.getInt("age"));
				bean.setPhno(rs.getInt("phno"));
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));

			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}

public static int update(UserBean bean){
	int status=0;
	try{
		Connection con=Dbcon.getCon();
		PreparedStatement ps=con.prepareStatement("update user set address=?,age=?,phno=?,username=?,password=? where email=?");
		ps.setString(1,bean.getAddress());
		ps.setInt(2,bean.getAge());
		
		ps.setInt(3,bean.getPhno());
		ps.setString(4,bean.getUsername());
		ps.setString(5,bean.getPassword());
		ps.setString(6,bean.getEmail());
		status=ps.executeUpdate();
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	
	return status;
}
public static int delete(int user_id){
	int status=0;
	try{
		Connection con=Dbcon.getCon();
		PreparedStatement ps=con.prepareStatement("delete from user where user_id=?");
		ps.setInt(1,user_id);
		status=ps.executeUpdate();
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	
	return status;
}
public static UserBean search(String username){
	UserBean bean=new UserBean();
	try{
		Connection con=Dbcon.getCon();
		PreparedStatement ps=con.prepareStatement("select * from user where username=?");
		ps.setString(1,username);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			bean.setUser_id(rs.getInt("user_id"));
			bean.setEmail(rs.getString("email"));
			bean.setAddress(rs.getString("address"));
			bean.setAge(rs.getInt("age"));
			bean.setPhno(rs.getInt("phno"));
			bean.setUsername(rs.getString("username"));
			bean.setPassword(rs.getString("password"));

		}
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	
	return bean;
}

}