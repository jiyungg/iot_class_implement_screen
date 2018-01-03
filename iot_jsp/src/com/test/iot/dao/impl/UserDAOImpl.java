package com.test.iot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;

import com.test.iot.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	
	

	@Override
	public ArrayList<HashMap<String, Object>> select(Connection con) {

		ArrayList<HashMap<String, Object>> al = new ArrayList<HashMap<String, Object>>();

		ResultSet rs = null;
		PreparedStatement ps = null; // 선언만 하면 안되고 항상 초기화를 시켜야 되는가?

		String sql = "select * from " + table;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();

			while (rs.next()) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				for (int i = 1; i <= count; i++) {
					String colname = rsmd.getColumnName(i);
					Object coldata = rs.getString(colname);
					hm.put(colname, coldata);
				}
				al.add(hm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;

	}

	public int delete(Connection con, String key) {
		String sql = "delete from " + table + " where uino =?";

		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, key);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public int update(Connection con, ArrayList<String> al) {

		String sql = "update " + table + " set uiage=? where uino =?";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, al.get(0));
			ps.setString(2, al.get(1));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int insert(Connection con, String[] col) {
		
		
		
		String sql = "insert into " + table + "(uiname,uiage,uiid,uipwd,address,cino) values(";
		
		for(int i = 0; i < col.length; i++) {
			if(i == col.length-1) {
				sql+= col[i] + ")";
			}else {
				sql+= col[i] + ",";}
			
		}
		
		PreparedStatement ps = null;
		int result = 0;
		try {
			
			ps = con.prepareStatement(sql);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public HashMap<String, Object> selectUser(Connection con) {

		return null;
	}

}