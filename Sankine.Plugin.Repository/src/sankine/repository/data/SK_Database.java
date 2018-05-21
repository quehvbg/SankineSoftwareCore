/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.repository.data;

import sankine.repository.adapter.SK_Connection;
import sankine.repository.adapter.SK_DatabaseFactory;

public class SK_Database extends SK_Connection {
	private static SK_Database instance;
	private SK_DatabaseFactory dbFactory;
	private SK_Connection dbConnection;
	
	private SK_Database() {
		dbFactory = SK_DatabaseFactory.getInstance();
		dbConnection = dbFactory.getConnection();		
	}

	public static SK_Database getInstance() {
		if (instance == null) {
			instance = new SK_Database();
		}
		return instance;
	}

	@Override
	public void Connect() {
		dbConnection.Connect();
	}

	@Override
	public void Close() {
		dbConnection.Close();
	}

	@Override
	public void Dispose() {
		dbConnection.Dispose();
	}

	@Override
	public void SetParams(String key, String value) {
		dbConnection.SetParams(key, value);
	}
}
