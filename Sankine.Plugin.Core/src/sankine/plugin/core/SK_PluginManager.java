/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.plugin.core;

import java.util.ArrayList;
import java.util.List;

public abstract class SK_PluginManager {

	protected abstract void loadingPlugin();

	private List<SK_Menu> listMenu;

	public List<SK_Menu> getListMenu() {
		return listMenu;
	}

	public void setListMenu(List<SK_Menu> listMenu) {
		this.listMenu = listMenu;
	}

	public void addMenu(SK_Menu menu) {
		if (listMenu == null) {
			listMenu = new ArrayList<SK_Menu>();
		}
		listMenu.add(menu);
	}
}
