package com.test.iot.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public interface UserDAO {
	
	HashMap<String, Object> selectUser(Connection con);
	ArrayList<HashMap<String, Object>> select(Connection con);
	
	static final String table = "user_info";
	int delete(Connection con, String key);
	int update(Connection con, ArrayList<String> user);
	int insert(Connection con,  String[] col);
	
}