package com.nuisance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.nuisance.bean.StatusBean;

public class StatusDao {
	public static List<StatusBean> ViewStatus(int uid){
		List<StatusBean> list=new ArrayList<StatusBean>();
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from status where user_id=?");
			ps.setInt(1,uid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			StatusBean bean=new StatusBean();
				bean.setIssue_type(rs.getString("issue_type"));
				bean.setStatus(rs.getString("status"));
				bean.setConcerned_authority(rs.getString("concerned_authority"));
				bean.setUsername(rs.getString("username"));
				bean.setIssue_id(rs.getInt("issue_id"));
				bean.setUser_id(rs.getInt("user_id"));
				bean.setArea_code(rs.getInt("area_code"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static List<StatusBean> ViewAuthStatus(int area_code,String issue_type){
		List<StatusBean> list=new ArrayList<StatusBean>();
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from status where issue_type=? and area_code=?");
			ps.setString(1,issue_type);
			ps.setInt(2,area_code);

			ResultSet rs=ps.executeQuery();
			while(rs.next()){
	   StatusBean bean=new StatusBean();
				bean.setIssue_type(rs.getString("issue_type"));
				bean.setStatus(rs.getString("status"));
				bean.setUsername(rs.getString("username"));
				bean.setConcerned_authority(rs.getString("concerned_authority"));
				bean.setIssue_id(rs.getInt("issue_id"));
				bean.setUser_id(rs.getInt("user_id"));
				bean.setArea_code(rs.getInt("area_code"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static int update(StatusBean bean){
		int status=0;
		try{
			Connection con=Dbcon.getCon();
			PreparedStatement ps=con.prepareStatement("update status set status=? where issue_id=?");
			
			ps.setString(1,bean.getStatus());
			ps.setInt(2,bean.getIssue_id());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
}
