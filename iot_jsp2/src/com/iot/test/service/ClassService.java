package com.iot.test.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.vo.ClassInfo;

public interface ClassService {
	
	List<ClassInfo> getClassList();
	public HashMap<String, Object> login(HttpServletRequest req);	
	public void logout(HttpServletRequest req);	
	public void signin(HttpServletRequest req);
	public String deleteUser(HttpServletRequest req);
	public String updateUser(HttpServletRequest req);

}
