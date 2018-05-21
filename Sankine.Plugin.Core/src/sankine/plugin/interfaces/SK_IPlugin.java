/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.plugin.interfaces;

import sankine.plugin.core.SK_Menu;

public interface SK_IPlugin {
	String pluginName();
	String pluginId();
	SK_Menu pluginMenu();	
	void Initialize();
}
