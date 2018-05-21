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

public abstract class SK_Connection {
	public void Connect(){};
	public void Close(){};
	public void Dispose(){};
	public void SetParams(String key, String value){};
	public String Description(){
		return "Generic";
	}
}
