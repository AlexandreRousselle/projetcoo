package game.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconfig {

	//
	private String url;
	private String user;
	private String psw;
	private String driver;
	
	private static DBconfig instance ;
	private Connection connect;
	
	//Constructor
	public DBconfig(){
		user ="CHERIFI";
		psw = "M1MIAGE";
		url = "jdbc:oracle:thin:@oracle.fil.univ-lille1.fr:1521:filora";
		driver = "oracle.jdbc.driver.OracleDriver";
	}
	
	public static DBconfig getInstance(){
		if (instance == null)
			instance = new DBconfig();
		return instance;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		if (connect == null){
			Class.forName(driver);
			connect = DriverManager.getConnection(url, user, psw);
		}
		return connect;
	}
	
}
