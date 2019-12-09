package com.nuisance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.nuisance.bean.IssueBean;

public class IssueDao {
	public static int InsertIssue(IssueBean bean){
		int status=0;
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("insert into issues(`issue_type`,`issue_description`,`issue_location`,`report_date`,`user_id`,`area_code`) VALUES(?,?,?,?,?,?)");
			ps.setString(1,bean.getIssue_type());
			ps.setString(2,bean.getIssue_description());
			ps.setString(3,bean.getIssue_location());
			ps.setDate(4,bean.getReport_date());
			ps.setInt(5,bean.getUser_id());
			ps.setInt(6,bean.getArea_code());

			status=ps.executeUpdate();
			con.close();

		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	public static List<IssueBean> ViewIssue(){
		List<IssueBean> list=new ArrayList<IssueBean>();
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from issues");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				IssueBean bean=new IssueBean();
				bean.setIssue_type(rs.getString("issue_type"));
				bean.setIssue_description(rs.getString("issue_description"));
				bean.setIssue_location(rs.getString("issue_location"));
				bean.setReport_date(rs.getDate("report_date"));
				bean.setIssue_id(rs.getInt("issue_id"));
				bean.setUser_id(rs.getInt("user_id"));
				bean.setArea_code(rs.getInt("area_code"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static List<IssueBean> ViewUserIssue(int uid){
		List<IssueBean> list=new ArrayList<IssueBean>();
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from issues where user_id=?");
			ps.setInt(1,uid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				IssueBean bean=new IssueBean();
				bean.setIssue_type(rs.getString("issue_type"));
				bean.setIssue_description(rs.getString("issue_description"));
				bean.setIssue_location(rs.getString("issue_location"));
				bean.setReport_date(rs.getDate("report_date"));
				bean.setIssue_id(rs.getInt("issue_id"));
				bean.setUser_id(rs.getInt("user_id"));
				bean.setArea_code(rs.getInt("area_code"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static int update(IssueBean bean,int issue_id){
		int status=0;
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("update issues set issue_type=?,issue_description=?,issue_location=?,report_date=?,area_code=? where issue_id=?");
			ps.setString(1,bean.getIssue_type());
			ps.setString(2,bean.getIssue_description());
			ps.setString(3,bean.getIssue_location());
			ps.setDate(4,bean.getReport_date());
			ps.setInt(5,bean.getArea_code());
			ps.setInt(6,issue_id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static IssueBean search(int area_code,String issue_type){
		IssueBean bean=new IssueBean();
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from issues where area_code=? and issue_type=?");
			ps.setInt(1,area_code);
			ps.setString(2,issue_type);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bean.setIssue_type(rs.getString("issue_type"));
				bean.setIssue_description(rs.getString("issue_description"));
				bean.setIssue_location(rs.getString("issue_location"));
				bean.setReport_date(rs.getDate("report_date"));
				bean.setIssue_id(rs.getInt("issue_id"));
				bean.setUser_id(rs.getInt("user_id"));
				bean.setArea_code(rs.getInt("area_code"));

			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	public static int delete(int issue_id){
		int status=0;
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("delete from issues where issue_id=?");
			ps.setInt(1,issue_id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<IssueBean> ViewAuthIssue(int area_code,String authority_type){
		List<IssueBean> list=new ArrayList<IssueBean>();
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from issues where area_code=? and issue_type=?");
			ps.setInt(1,area_code);
			ps.setString(2,authority_type);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				IssueBean bean=new IssueBean();
				bean.setIssue_type(rs.getString("issue_type"));
				bean.setIssue_description(rs.getString("issue_description"));
				bean.setIssue_location(rs.getString("issue_location"));
				bean.setReport_date(rs.getDate("report_date"));
				bean.setIssue_id(rs.getInt("issue_id"));
				bean.setUser_id(rs.getInt("user_id"));
				bean.setArea_code(rs.getInt("area_code"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
}
