package com.test.iot.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserService {
	
	HashMap<String, Object> getUser();

	ArrayList<HashMap<String, Object>> selectUserInfo();
	int insertUser(String[] info);
	int deleteUser(String str);
	int updateUser(ArrayList<String> user);
	
}