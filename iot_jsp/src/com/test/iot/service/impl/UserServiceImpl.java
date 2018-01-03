package com.test.iot.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.UserDAO;
import com.test.iot.dao.impl.UserDAOImpl;
import com.test.iot.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO ud = new UserDAOImpl();

	

	@Override
	public ArrayList<HashMap<String, Object>> selectUserInfo() {
		Connection con = DBCon.getCon();
		ArrayList<HashMap<String, Object>> userList = ud.select(con);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
		return userList;
	}

	 public int insertUser(String[] info) {
	
	 Connection con = DBCon.getCon();
	 int result = 0;
	 
	 result = ud.insert(con,info);
	 try {
	 con.commit();
	 con.close();
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 con = null;
	 return result;
	 }

	public int deleteUser(String key) {

		Connection con = DBCon.getCon();
		int result = 0;

		result = ud.delete(con, key);
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
		return result;
	}

	public int updateUser(ArrayList<String> user) {

		Connection con = DBCon.getCon();
		int result = 0;
	
		result = ud.update(con, user);
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
		return result;
	}

	@Override
	public HashMap<String, Object> getUser() {

		return null;
	}

}