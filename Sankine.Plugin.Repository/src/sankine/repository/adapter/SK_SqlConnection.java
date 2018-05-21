/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.repository.adapter;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class SK_SqlConnection extends SK_Connection {

	public SK_SqlConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	@Override
	public void SetParams(String key, String value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void Connect() {
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;instance;databaseName=MYDB","user","pass");
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void Close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Dispose() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String Description() {
		// TODO Auto-generated method stub
		return "SQLServer";
	}
}
