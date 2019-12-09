package com.nuisance.dao;

import java.sql.*;

public class Dbcon {
	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nuisance?useSSL=true", "root", "");
			
		}catch(Exception e){System.out.println(e);}
		return con;

}
}
