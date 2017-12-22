                                                                                                                                                                                                                                                                             package come.test.iot.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import come.test.iot.DBCon;
import come.test.iot.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	@Override
	public ArrayList<HashMap<String, Object>> selectUserList() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<HashMap<String,Object>> userList = new ArrayList<HashMap<String, Object>>();
	    String sql = "select * from user_info";
	    try {
			ps = DBCon.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				HashMap<String,Object> hm = new HashMap<String,Object>();
				hm.put("uino", rs.getString("uino"));
				hm.put("uiname", rs.getString("uiname"));
				hm.put("uiage", rs.getString("uiage"));
				hm.put("uiid", rs.getString("uiid"));
				hm.put("uipwd", rs.getString("uipwd"));
				hm.put("address", rs.getString("address"));
				hm.put("uiregdate", rs.getString("uiregdate"));
				hm.put("cino", rs.getString("cino"));
				userList.add(hm);
	          // 얘의 생명주기는 25 라인에서 34까지.
		 // while의 역할 : 밑으로 내리고, 있는지 없는지 판단해서 밑에서 리턴해주기.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public HashMap<String, Object> selectUser() {
		return null;
	}

}
                                                                                                                                                                     