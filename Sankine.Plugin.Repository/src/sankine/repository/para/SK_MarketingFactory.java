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

public class SK_MarketingFactory extends SK_ParameterFactory {

	private static SK_MarketingFactory instance;

	public SK_MarketingFactory() {
		super();
	}

	public static SK_MarketingFactory getInstance() {
		if (instance == null) {
			instance = new SK_MarketingFactory();
		}
		return instance;
	}
	
	// Factory Method
	public SK_Parameter getTypeApplication() {
		return new SK_MarketingParameter();
	}

}
