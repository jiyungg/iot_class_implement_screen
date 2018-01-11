package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.common.DBCon;
import com.iot.test.dao.ClassDAO;
import com.iot.test.utiles.DBUtil;
import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.UserClass;

public class ClassDAOImpl implements ClassDAO{

	@Override
	public List<ClassInfo> selectClassList() {
		List<ClassInfo> classList = new ArrayList<ClassInfo>();				
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			con = DBCon.getCon();
			String sql = "select * from class_info";
			ps = con.prepareStatement(sql);			
			rs = ps.executeQuery();			
			while(rs.next()) {				
				ClassInfo ci = new ClassInfo();				
				ci.setCiDesc(rs.getString("cidesc"));
				ci.setCiName(rs.getString("ciname"));
				ci.setCiNo(rs.getInt("cino"));							
				classList.add(ci);				
			}		
		}catch(Exception e) {
			e.printStackTrace();		
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}			
		}			
		return classList;
	}
	@Override
	public ClassInfo selectClass(int uiNo) {	
		return null;
	}
	
	@Override
	public ClassInfo selectClass(String cino) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			con = DBCon.getCon();//sql 쿼리문 변경해야됨
			String sql = "select * from class_info where cino=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, cino);
			rs = ps.executeQuery();			
			while(rs.next()) {
				ClassInfo ci = new ClassInfo();
				ci.setCiDesc(rs.getString("ciDesc"));
				ci.setCiName(rs.getString("ciName"));
				ci.setCiNo(rs.getInt("ciNo"));
				return ci;				
			}		
		}catch(Exception e) {
			e.printStackTrace();		
		}finally {
			
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
//					DBUtil.closeAll(rs, ps, con);
				}
			}			
		}			
		return null;
	}

	@Override
	public int openClass(ClassInfo ci) {
		Connection con = null;
		PreparedStatement ps = null;						
		try {
			con = DBCon.getCon();
			String sql = "update user_info(ciname, cidesc) values(?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, ci.getCiName());
			ps.setString(2, ci.getCiDesc());
			
			return ps.executeUpdate();			
			
		}catch(Exception e) {
			e.printStackTrace();		
		}finally {
			DBUtil.close(ps);
			DBUtil.close(con);
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}			
		}	
		
		return 0;
	}

	@Override
	public int updateClass(ClassInfo ci) {
		Connection con = null;
		PreparedStatement ps = null;						
		try {
			con = DBCon.getCon();
			String sql = "update class_info " +
			             "set ciName=?, ciDsec=? where ciNo=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ci.getCiName());
			ps.setString(2, ci.getCiDesc());
			ps.setInt(3, ci.getCiNo());
			return ps.executeUpdate();	
			
		}catch(Exception e) {
			e.printStackTrace();		
		}finally {
			DBUtil.closeAll(null,ps,con);
		}
		return 0;
	}

	@Override
	public int deleteClass(ClassInfo ci) {
		Connection con = null;
		PreparedStatement ps = null;						
		try {
			con = DBCon.getCon();
			String sql = "delete from class_info where ciNo=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ci.getCiNo());
			return ps.executeUpdate();						
		}catch(Exception e) {
			e.printStackTrace();		
		}finally {
			DBUtil.closeAll(null,ps,con);
		}
		return 0;
	}
}
