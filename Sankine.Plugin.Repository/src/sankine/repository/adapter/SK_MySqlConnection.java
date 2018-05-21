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

public class SK_MySqlConnection extends SK_Connection {
	
	public SK_MySqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	@Override
	public void SetParams(String key, String value) {
		
	}
	
	@Override
	public void Connect() {
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien","root","123456");
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
		return "MySql";
	}
}
