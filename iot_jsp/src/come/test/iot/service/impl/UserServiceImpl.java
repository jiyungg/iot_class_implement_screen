package come.test.iot.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import come.test.iot.DBCon;
import come.test.iot.dao.UserDAO;
import come.test.iot.dao.impl.UserDAOImpl;
import come.test.iot.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDAO ud = new UserDAOImpl();

	@Override
	public ArrayList<HashMap<String, Object>> getUserList() {
		Connection con = DBCon.getCon();
		ArrayList<HashMap<String,Object>> userList = ud.selectUserList();
//	  DBCon.closeCon();
		return userList;
	}

	@Override
	public HashMap<String, Object> getUser() {
		return null;
	}

}
