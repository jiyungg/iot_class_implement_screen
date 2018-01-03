package com.test.iot.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.iot.dao.UserDAO;
import com.test.iot.service.UserService;
import com.test.iot.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	UserService us = new UserServiceImpl(); // 왜 인터페이스의 데이터타입으로 해야하는가

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);

	}

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);

		System.out.println("UserDAO.table : " + UserDAO.table);// UserDAO.table : user_info
		System.out.println("cmd : " + cmd);// cmd : list
		System.out.println(uri); // /user/list

		if (cmd.equals("list")) {
			req.setAttribute("list", us.selectUserInfo());
		}

		else if (cmd.equals("view")) {
			us.getUser();
		}

		else if (cmd.equals("insertok")) {
			String[] arr  = {
			req.getParameter("uiname"),
			req.getParameter("uiage"),
			req.getParameter("uiid"),
			req.getParameter("uipwd"),
			req.getParameter("address"),
			req.getParameter("cino"),
			};
			
			
			us.insertUser(arr);
			req.setAttribute("list", us.selectUserInfo());
		}

		else if (cmd.equals("deleteok")) {

			us.deleteUser(req.getParameter("uino"));
			req.setAttribute("list", us.selectUserInfo());
		}

		else if (cmd.equals("updateok")) {
			ArrayList<String> al = new ArrayList<String>();

			al.add(req.getParameter("uiage"));
			al.add(req.getParameter("uino"));
			us.updateUser(al);
			req.setAttribute("list", us.selectUserInfo());

		} else {
			cmd = "/common/error";
		}

		uri = "/WEB-INF/view" + uri + ".jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);

	}
}