package com.nuisance.dao;

import java.sql.*;



public class AdminDao {
	public static boolean authenticate(String username,String password){
		boolean status=false;
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from admin where username=? and password=?");
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
	

}
