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
import sankine.plugin.interfaces.SK_IMenuGroup;

public class SK_MenuGroup implements SK_IMenuGroup {
	
	private String title;
	private String tooltip;
	private String tag;
	private boolean isEnable;
	private Object view;
	private List<SK_MenuItem> listMenuItem;	
	private List<SK_MenuSeparator> listMenuSeparator;
	
	public SK_MenuGroup(String title, String tooltip, String tag, boolean isEnable, Object view) {
		this.title = title;
		this.tooltip = tooltip;
		this.tag = tag;
		this.isEnable = isEnable;
		this.view = view;
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
	public List<SK_MenuSeparator> getSeparator() {
		// TODO Auto-generated method stub
		return listMenuSeparator;
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
	public void addMenuSeparator(SK_MenuSeparator space, Integer index) {
		// TODO Auto-generated method stub
		if (listMenuSeparator == null) {
			listMenuSeparator = new ArrayList<SK_MenuSeparator>();
		}
		listMenuSeparator.add(space);
	}	
}
