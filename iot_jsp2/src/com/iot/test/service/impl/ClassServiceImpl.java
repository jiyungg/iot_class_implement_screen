package com.iot.test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.iot.test.dao.ClassDAO;
import com.iot.test.dao.impl.ClassDAOImpl;
import com.iot.test.service.ClassService;
import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.UserClass;

public class ClassServiceImpl implements ClassService{
	Gson gs = new Gson();
	private ClassDAO cdao = new ClassDAOImpl();
	
	@Override
	public List<ClassInfo> getClassList() {		
		return cdao.selectClassList();
	}
	@Override
	public HashMap<String, Object> login(HttpServletRequest req) {
		UserClass uc = gs.fromJson(req.getParameter("param"), UserClass.class);		
		
		UserClass checkUc = ud.selectUser(uc.getUiId());		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("msg", "로그인에 성공하셨습니다.");
		hm.put("login", "ok");
		if(checkUc!=null) {
			if(!checkUc.getUiPwd().equals(uc.getUiPwd())) {
				hm.put("msg","비밀번호를 확인하세요.");			
				hm.put("login", "no");					
			}else {
				HttpSession hs = req.getSession();
				hs.setAttribute("user", checkUc);					
			}
			
		}else {
			hm.put("msg", "아이디를 확인하세요");	
			hm.put("login", "no");			
		}		
		return hm;			
	}

	@Override
	public ArrayList<UserClass> getUserList() {		
		return ud.selectUserList();
	}
	

	@Override
	public void logout(HttpServletRequest req) {
		HttpSession hs = req.getSession();
		hs.invalidate();		
	}

	@Override
	public void signin(HttpServletRequest req) {
		String json = req.getParameter("param");
		UserClass uc = gs.fromJson(json, UserClass.class);	
		int result = ud.insertUser(uc);
		HashMap<String, String> rm = new HashMap<String, String>();
		rm.put("result", "no");
		rm.put("msg", "회원가입에 실패했습니다.");
		if(result == 1) {
			rm.put("result", "ok");
			rm.put("msg", "회원가입에 성공하셨습니다.");	
			HttpSession hs = req.getSession();
			hs.setAttribute("user", uc);	
		}		
		req.setAttribute("resStr", gs.toJson(rm));		
	}

	@Override
	public String deleteUser(HttpServletRequest req) {
		int uiNo = Integer.parseInt(req.getParameter("uiNo"));
		UserClass uc = new UserClass();
		uc.setUiNo(uiNo);
		int result = ud.updateUser(uc);
		Map<String,String> rm = new HashMap<String, String>();
		rm.put("result", "no");
		rm.put("msg", "삭제가 실패하였습니다.");
		if(result==1) {
	    	rm.put("result", "ok");
	    	rm.put("msg", "삭제 성공!!");  
	    }
	    return gs.toJson(rm); 
	}
	
	
	@Override
	public String updateUser(HttpServletRequest req) {
		String param = req.getParameter("param"); 
		UserClass uc = gs.fromJson(param, UserClass.class);
		int result = ud.updateUser(uc);
		Map<String,String> rm = new HashMap<String, String>();
		rm.put("result", "no");
		rm.put("msg", "수정에 실패하였습니다.");
		if(result==1) {
	    	rm.put("result", "ok");
	    	rm.put("msg", "수정 성공!!");  
	    }
	    return gs.toJson(rm); 
	 
	}
	
	
	

}
