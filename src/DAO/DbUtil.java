package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	static Connection conn=null;
	public static Connection getConnection(){
	
		try{			 
			Class.forName("org.sqlite.JDBC");
		    conn = DriverManager.getConnection("jdbc:sqlite:\\C:/Users/Administrator/workspace/Guitar2.0/inventory.db");
	       }catch(ClassNotFoundException e){			
		}		// 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
