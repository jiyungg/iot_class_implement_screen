package come.test.iot.servlet;                                                                                                                                                                             

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import come.test.iot.service.UserService;
import come.test.iot.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	UserService us = new UserServiceImpl(); 
	public String getCommand(String uri) {
		int idx = uri.lastIndexOf("/");
		if(idx!=-1) {
			return uri.substring(idx+1);
		}
		return "";
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doProcess(req,res);
	}
		
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		{
		doProcess(req,res);
	}
//		req.setCharacterEncoding("utf-8");
//		res.setCharacterEncoding("utf-8");
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.println("야야야야~");
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
        String uri = req.getRequestURI();
        String cmd = getCommand(uri);
        System.out.println("cmd : " + cmd);
        if(cmd.equals("list")) { 
        	req.setAttribute("list", us.getUserList());
        }else if(cmd.equals("view")) {
//        	us.getUser();
        }else {
        	cmd = "/common/error";
        }
        uri = "/WEB-INF/view" + uri + ".jsp"; // = cmd = cmd+jsp와 같은말
        RequestDispatcher rd = req.getRequestDispatcher(uri);
        //이 경로로 jsp를 보내는거에요. 
        rd.forward(req, res);
        //여기로...
				
			}
}
