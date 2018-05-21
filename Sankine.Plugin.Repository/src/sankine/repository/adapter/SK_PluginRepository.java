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

import java.util.ArrayList;
import java.util.List;

public class SK_PluginRepository {

	private static SK_PluginRepository instance;
	private List<Object> listEntity;

	private SK_PluginRepository() {

	}

	public static SK_PluginRepository getInstance() {
		if (instance == null) {
			instance = new SK_PluginRepository();
		}
		return instance;
	}

	public List<Object> getListEntity() {
		return listEntity;
	}

	public void setListEntity(List<Object> listEntity) {
		this.listEntity = listEntity;
	}

	public void addEntity(Object entity) {
		if (listEntity == null) {
			listEntity = new ArrayList<Object>();
		}
		listEntity.add(entity);
	}
	
}
