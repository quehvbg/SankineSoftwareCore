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

public class SK_OracleConnection extends SK_Connection {

	public SK_OracleConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Connect() {
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123oracle");
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void Close() {
		// TODO Auto-generated method stub
		super.Close();
	}

	@Override
	public void Dispose() {
		// TODO Auto-generated method stub
		super.Dispose();
	}

	@Override
	public void SetParams(String key, String value) {
		// TODO Auto-generated method stub
		super.SetParams(key, value);
	}

	@Override
	public String Description() {
		// TODO Auto-generated method stub
		return super.Description();
	}

}
