package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil implements ConnectionProviderDetails {
	//making the connection
			public static Connection getConnection(){
				
		        Connection con=null;  
		        try{  
		            Class.forName("com.mysql.jdbc.Driver");
		            con = DriverManager.getConnection(connUrl, uname, pwd);
		        
		        }catch(Exception e)
		        {
		        	System.out.println(e);
		        }  
		        return con;  
		
	}
	
}