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
import sankine.plugin.core.SK_MenuSeparator;

public interface SK_IMenuGroup {

	String getTitle();

	String getTooltip();

	String getTag();

	boolean isEnable();

	Object getView();
	
	List<SK_MenuItem> getMenuItems();

	List<SK_MenuSeparator> getSeparator();

	void addMenuItem(SK_MenuItem item);

	void addMenuSeparator(SK_MenuSeparator space, Integer index);
}
