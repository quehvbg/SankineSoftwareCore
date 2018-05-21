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
import sankine.plugin.core.SK_MenuGroup;
import sankine.plugin.core.SK_MenuSeparator;

public interface SK_IMenuItem {

	List<SK_MenuGroup> getMenuGroups();

	String getTitle();

	String getTooltip();

	String getTag();

	boolean isEnable();

	Object getView();
			
	String getPluginName();
	
	void addMenuGroup(SK_MenuGroup group);

	List<SK_MenuSeparator> getMenuSeparator();

	void addMenuSeparator(SK_MenuSeparator space);
}
