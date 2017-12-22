package come.test.iot;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DBCon {
	private static Connection conn;
	public static Connection getCon() {
		if(DBCon.conn == null) {
			
			Context initContext;
			try {
				initContext = new InitialContext();
				Context envContext = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource)envContext.lookup("jdbc/IOT");
			//	System.out.println(ds);
				DBCon.conn = ds.getConnection();
			} catch (NamingException | SQLException e) {
				//네이밍익셉션 왜쓰냐면 lookup() 에 넣어야할 이름을 잘못 썼을 때, 익셉션을 방지하려고. 
				e.printStackTrace();
			}
		}
		return DBCon.conn;
		//연결해주는 애 하나, 내보내주는 애(return) 하나. 를 만들어준거빈다. 
	}

	public static void closecon() {
		
	}
	
}
