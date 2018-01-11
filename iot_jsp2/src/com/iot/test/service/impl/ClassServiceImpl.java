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
	public String deleteClass(HttpServletRequest req) {
		int ciNo = Integer.parseInt(req.getParameter("ciNo"));
		ClassInfo ci=new ClassInfo();
		ci.setCiNo(ciNo);
		int result = cdao.updateClass(ci);
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
	public String updateClass(HttpServletRequest req) {
		String param = req.getParameter("param"); 
		ClassInfo ci=gs.fromJson(param, ClassInfo.class);
		int result = cdao.updateClass(ci);
		Map<String,String> rm = new HashMap<String, String>();
		rm.put("result", "no");
		rm.put("msg", "수정에 실패하였습니다.");
		if(result==1) {
	    	rm.put("result", "ok");
	    	rm.put("msg", "수정 성공!!");  
	    }
	    return gs.toJson(rm); 
	 
	}
	@Override
	public String openClass(HttpServletRequest req) {
		String param=req.getParameter("param");
		ClassInfo ci=gs.fromJson(param, ClassInfo.class);
		int result = cdao.openClass(ci);
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
