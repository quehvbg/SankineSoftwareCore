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

public class SK_FirebirdConnection extends SK_Connection {

	public SK_FirebirdConnection() {
		try {
			Class.forName("org.firebirdsql.jdbc.FBDriver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}

	@Override
	public void SetParams(String key, String value) {
		
	}

	@Override
	public void Connect() {
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:firebirdsql://localhost/3050:C:\\firebird\\database\\EMPLOYEE.FDB","SYSDBA","Fx4I3X");
//			
//		} catch (SQLException e) {			
//			e.printStackTrace();
//		}
	}

	@Override
	public void Close() {
		
	}

	@Override
	public void Dispose() {
		
	}

	@Override
	public String Description() {		
		return "Firebird";
	}

}
