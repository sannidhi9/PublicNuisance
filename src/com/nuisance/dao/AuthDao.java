package com.nuisance.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nuisance.bean.AuthorityBean;


import java.util.List;
import java.util.ArrayList;


public class AuthDao {
	public static boolean authenticate(String username,String password){
		boolean status=false;
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from authority where username=? and password=?");
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
	public static int InsertAuthority(AuthorityBean bean){
		int status=0;
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("insert into authority(`authority_type`,`authority_name`,`email`,`office_address`,`phoneno`,`username`,`password`,`area_code`) VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1,bean.getAuthority_type());
			ps.setString(2,bean.getAuthority_name());
			ps.setString(3,bean.getEmail());
			ps.setString(4,bean.getOffice_address());
			ps.setInt(5,bean.getPhoneno());
			ps.setString(6,bean.getUsername());
			ps.setString(7,bean.getPassword());
			ps.setInt(8,bean.getArea_code());

			status=ps.executeUpdate();
			con.close();

		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<AuthorityBean> ViewAuthority(){
		List<AuthorityBean> list=new ArrayList<AuthorityBean>();
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from authority");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				AuthorityBean bean=new AuthorityBean();
				bean.setAuthority_type(rs.getString("authority_type"));
				bean.setAuthority_name(rs.getString("authority_name"));
				bean.setEmail(rs.getString("email"));
				bean.setOffice_address(rs.getString("office_address"));
				bean.setAuthority_id(rs.getInt("authority_id"));
				bean.setPhoneno(rs.getInt("phoneno"));
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				bean.setArea_code(rs.getInt("area_code"));

				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static int getAid(String username,String password) {
		int aid=0;
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select authority_id from authority where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			aid=rs.getInt(1);
			
			con.close();
	}
		catch(Exception e){System.out.println(e);}
		
		return aid;
		
	}
	public static AuthorityBean ViewAuthId(int aid){
		AuthorityBean bean=new AuthorityBean();
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from authority where authority_id=?");
			ps.setInt(1,aid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bean.setAuthority_type(rs.getString("authority_type"));
				bean.setEmail(rs.getString("email"));
				bean.setOffice_address(rs.getString("office_address"));
				bean.setAuthority_name(rs.getString("authority_name"));
				bean.setAuthority_id(rs.getInt("authority_id"));
				bean.setPhoneno(rs.getInt("phoneno"));
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				bean.setArea_code(rs.getInt("area_code"));

			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}

public static int update(AuthorityBean bean){
	int status=0;
	try{
		Connection con=Dbcon.getCon();
		PreparedStatement ps=con.prepareStatement("update authority set authority_type=?,authority_name=?,office_address=?,phoneno=?,username=?,password=?,area_code=? where email=?");
		ps.setString(1,bean.getAuthority_type());
		ps.setString(2,bean.getAuthority_name());
		
		ps.setString(3,bean.getOffice_address());
		ps.setInt(4,bean.getPhoneno());
		ps.setString(5,bean.getUsername());
		ps.setString(6,bean.getPassword());
		ps.setInt(7,bean.getArea_code());
		ps.setString(8,bean.getEmail());
		status=ps.executeUpdate();
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	
	return status;
}
public static int delete(int authority_id){
	int status=0;
	try{
		Connection con=Dbcon.getCon();
		PreparedStatement ps=con.prepareStatement("delete from authority where authority_id=?");
		ps.setInt(1,authority_id);
		status=ps.executeUpdate();
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	
	return status;
}
public static AuthorityBean search(int area_code,String authority_type){
	AuthorityBean bean=new AuthorityBean();
	try{
		Connection con=Dbcon.getCon();
		PreparedStatement ps=con.prepareStatement("select * from authority where area_code=? and authority_type=?");
		ps.setInt(1,area_code);
		ps.setString(2,authority_type);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			bean.setAuthority_type(rs.getString("authority_type"));
			bean.setEmail(rs.getString("email"));
			bean.setOffice_address(rs.getString("office_address"));
			bean.setAuthority_name(rs.getString("authority_name"));
			bean.setAuthority_id(rs.getInt("authority_id"));
			bean.setPhoneno(rs.getInt("phoneno"));
			bean.setUsername(rs.getString("username"));
			bean.setPassword(rs.getString("password"));
			bean.setArea_code(rs.getInt("area_code"));

		}
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	
	return bean;
}
}
