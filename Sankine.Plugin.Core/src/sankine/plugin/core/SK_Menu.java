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
import sankine.plugin.interfaces.SK_IMenu;

public class SK_Menu implements SK_IMenu {

	private String title;
	private String tooltip;
	private String tag;
	private boolean isEnable;
	private Object view;
	private String pluginName;
	private List<SK_MenuItem> listMenuItem;		
	private List<SK_MenuGroup> listMenuGroup;
	private List<SK_MenuSeparator> listMenuSeparator;
	
	public SK_Menu(String title, String tooltip, String tag, boolean isEnable, Object view, String pluginName) {
		this.title = title;
		this.tooltip = tooltip;
		this.isEnable = isEnable;
		this.view = view;
		this.pluginName = pluginName;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	@Override
	public String getTooltip() {
		// TODO Auto-generated method stub
		return tooltip;
	}

	@Override
	public String getTag() {
		// TODO Auto-generated method stub
		return tag;
	}

	@Override
	public boolean isEnable() {
		// TODO Auto-generated method stub
		return isEnable;
	}

	@Override
	public Object getView() {
		// TODO Auto-generated method stub
		return view;
	}

	@Override
	public List<SK_MenuItem> getMenuItems() {
		// TODO Auto-generated method stub
		return listMenuItem;
	}


	@Override
	public void addMenuItem(SK_MenuItem item) {
		// TODO Auto-generated method stub
		if (listMenuItem == null) {
			listMenuItem = new ArrayList<SK_MenuItem>();
		}
		listMenuItem.add(item);
	}


	

	@Override
	public List<SK_MenuGroup> getMenuGroups() {
		// TODO Auto-generated method stub
		return listMenuGroup;
	}

	@Override
	public void addMenuGroup(SK_MenuGroup group) {
		// TODO Auto-generated method stub
		if (listMenuGroup == null) {
			listMenuGroup = new ArrayList<SK_MenuGroup>();
		}
		listMenuGroup.add(group);
	}

	@Override
	public List<SK_MenuSeparator> getMenuSeparator() {
		// TODO Auto-generated method stub
		return listMenuSeparator;
	}
	
	@Override
	public void addMenuSeparator(SK_MenuSeparator space) {
		// TODO Auto-generated method stub
		if (listMenuSeparator == null) {
			listMenuSeparator = new ArrayList<SK_MenuSeparator>();
		}
		listMenuSeparator.add(space);
	}

	@Override
	public String getPluginName() {
		// TODO Auto-generated method stub
		return pluginName;
	}
}
