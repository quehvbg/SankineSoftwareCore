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

import java.util.Properties;

public class SK_DatabaseFactory {

	private static SK_DatabaseFactory instance;

	private SK_DatabaseFactory() {

	}

	public static SK_DatabaseFactory getInstance() {
		if (instance == null) {
			instance = new SK_DatabaseFactory();
		}
		return instance;
	}

	private String getDatabaseType() {
		Properties p = new Properties();
		try {
			p.load(ClassLoader.getSystemResourceAsStream("Connection.properties"));
			String dbConnect = p.getProperty("DbType");
			if (dbConnect.equalsIgnoreCase("Firebird") == true) {
				return "Firebird";
			} else if (dbConnect.equalsIgnoreCase("MySql") == true) {
				return "MySql";
			} else {
				return "SQL";
			}
		} catch (Exception e) {
			return null;
		}
	}

	// Factory Method

	public SK_Connection getConnection() {
		String dbType = getDatabaseType();
		if (dbType == null) {
			return new SK_SqlConnection();
		} else if (dbType.equalsIgnoreCase("Firebird")) {
			return new SK_FirebirdConnection();
		} else if (dbType.equalsIgnoreCase("MySql")) {
			return new SK_MySqlConnection();
		} else if (dbType.equalsIgnoreCase("Oracle")) {
			return new SK_OracleConnection();
		} else {
			return new SK_SqlConnection();
		}
	}
}
