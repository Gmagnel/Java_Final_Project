import java.sql.*;
import javax.swing.*;
public class DbConnection {

public static Connection dbconnection() {
	
	try {
		
		Class.forName("org.sqlite.JDBC");
		
		Connection conn = DriverManager.getConnection("jdbc:sqlite:student.db");
		
		
		//JOptionPane.showMessageDialog(null, "Database connected successfully");
		return conn;
		
	}catch(Exception e) {
	
		JOptionPane.showMessageDialog(null, e);
		return null;
	}
	
}
	
	
	
}
