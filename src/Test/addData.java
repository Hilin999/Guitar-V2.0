package Test;
import java.sql.*;
public class addData {
	 public static void main(String[] args) throws Exception {
		    Class.forName("org.sqlite.JDBC");
		    Connection conn =
		      DriverManager.getConnection("jdbc:sqlite:test.db");
		    Statement stat = conn.createStatement();
		    stat.executeUpdate("drop table if exists inventory;");
		    stat.executeUpdate("create table inventory(serialNumber,price,builder,type,numStrings,topWood,backWood);");
		    PreparedStatement prep = conn.prepareStatement(
		      "insert into inventory values (?,?,?,?,?,?,?);");

		    prep.setString(1, "001");
		    prep.setString(2, "2000元");
		    prep.setString(3, "MakerA");
		    prep.setString(4, "FolkGuitar");
		    prep.setString(5, "6");
		    prep.setString(6, "wood");
		    prep.setString(7, "wood");
		    prep.addBatch();
		    
		    prep.setString(1, "002");
		    prep.setString(2, "2800元");
		    prep.setString(3, "MakerB");
		    prep.setString(4, "FolkGuitar");
		    prep.setString(5, "6");
		    prep.setString(6, "wood");
		    prep.setString(7, "wood");
		    prep.addBatch();
		    
	
		    
		    conn.setAutoCommit(false);
		    prep.executeBatch();
		    conn.setAutoCommit(true);
		    System.out.println("成功添加数据！");
	 }
}
