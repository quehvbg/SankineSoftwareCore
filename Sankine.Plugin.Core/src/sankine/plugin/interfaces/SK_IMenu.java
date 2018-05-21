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

import java.util.List;

import sankine.plugin.core.SK_MenuItem;

public interface SK_IMenu extends SK_IMenuItem {

	List<SK_MenuItem> getMenuItems();

	void addMenuItem(SK_MenuItem item);

}
