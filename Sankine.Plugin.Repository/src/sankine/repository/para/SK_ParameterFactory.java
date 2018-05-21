/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.repository.para;

import java.util.Properties;

public class SK_ParameterFactory {

	private static SK_ParameterFactory paraInstance;

	protected SK_ParameterFactory() {

	}

	public static SK_ParameterFactory getInstance() {
		if (paraInstance == null) {
			paraInstance = new SK_ParameterFactory();
		}
		return paraInstance;
	}

	public boolean isEmailApplication() {
		Properties p = new Properties();
		try {
			p.load(ClassLoader.getSystemResourceAsStream("SK_Parameter.properties"));
			String fileLog = p.getProperty("SK_EmailParameter");
			if (fileLog.equalsIgnoreCase("ON") == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// Factory Method
	public SK_Parameter getTypeApplication() {
		if (isEmailApplication()) {
			return new SK_EmailParameter();
		} else {
			return new SK_FacebookParameter();
		}
	}
}
