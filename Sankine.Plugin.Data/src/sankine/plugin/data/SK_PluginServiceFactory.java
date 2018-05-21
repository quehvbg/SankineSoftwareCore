/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.plugin.data;

import java.util.Collection;
import java.util.List;

import sankine.plugin.base.SK_BaseEntity;
import sankine.plugin.messages.SK_GetAllRequest;
import sankine.plugin.messages.SK_GetAllResponse;
import sankine.plugin.messages.SK_GetRequest;
import sankine.plugin.messages.SK_GetResponse;
import sankine.plugin.messages.SK_SaveAllRequest;
import sankine.plugin.messages.SK_SaveRequest;
import sankine.plugin.messages.SK_SaveResponse;
import sankine.repository.interfaces.SK_Specification;

public abstract class SK_PluginServiceFactory<T extends SK_BaseEntity> {

	protected SK_PluginService<T> service;

	public SK_PluginService<T> getService() {
		return service;
	}

	public void setService(SK_PluginService<T> service) {
		this.service = service;
	}

	public SK_GetAllResponse<T> GetAllEntity(SK_GetAllRequest<T> request) {
		return service.GetAllEntity(request);
	}

	public SK_GetResponse<T> GetEntity(SK_GetRequest<T> request) {
		return service.GetEntity(request);
	}

	public SK_SaveResponse<T> SaveEntity(SK_SaveRequest<T> request) {
		return service.SaveEntity(request);
	}

	public SK_SaveResponse<T> SaveAllEntity(SK_SaveAllRequest<T> request) {
		return service.SaveAllEntity(request);
	}

	public void remove(T entity) {
		service.remove(entity);
	}

	public void removeAll(SK_Specification specification) {
		service.removeAll(specification);
	}

	public void removeAll() {
		service.removeAll();
	}

	public void removeAll(Collection<T> entities) {		
		service.removeAll(entities);
	}
	public List<T> query(SK_Specification specification) {
		return service.query(specification);
	}
}
