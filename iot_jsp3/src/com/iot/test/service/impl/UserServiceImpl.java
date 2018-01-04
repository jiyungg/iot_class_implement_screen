package com.iot.test.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.iot.test.service.UserService;
import com.iot.test.vo.UserClass;

public class UserServiceImpl implements UserService {
	private Gson gs = new Gson();

	@Override
	public HashMap<String, Object> login(HttpServletRequest req) {
		UserClass uc = gs.fromJson(req.getParameter("param"), UserClass.class);    //여기서 다 null을 넣어줌. 자동으로 (id값인가? test로 바꿔주는거 몇개 빼고)
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("msg",  "오 로그인 성공하셨네요~");
		hm.put("login", "ok");
		
		if(uc.getUiId().equals("test")) {
			if(!uc.getUiPwd().equals("test")) {
				hm.put("msg", "비밀번호를 확인하세요");
				hm.put("login", "no");
			} else {
				HttpSession hs = req.getSession();
				hs.setAttribute("user",uc);
				
			}
		}else {
			hm.put("msg", "아이디를 확인하세요");
			hm.put("login", "no");
		}
		return hm;
	}

	@Override
	public void logout(HttpServletRequest req) {
		HttpSession hs = req.getSession();
	      hs.invalidate();		
	}
}
