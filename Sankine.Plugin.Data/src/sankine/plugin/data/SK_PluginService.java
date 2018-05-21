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
import sankine.repository.data.SK_FirebirdRepository;
import sankine.repository.interfaces.SK_Specification;

public class SK_PluginService<T extends SK_BaseEntity> implements SK_IDataProvider<T> {

	public SK_ServiceProvider<T> provider;

	public SK_PluginService(Class<T> type) {
		this.provider = new SK_ServiceProvider<T>(new SK_FirebirdRepository<T>(type));
	}

	@Override
	public SK_GetAllResponse<T> GetAllEntity(SK_GetAllRequest<T> request) {
		return provider.GetAllEntity(request);
	}

	@Override
	public SK_GetAllResponse<T> GetAllRangeEntity(int[] range) {
		return provider.GetAllRangeEntity(range);
	}
	
	@Override
	public SK_GetResponse<T> GetEntity(SK_GetRequest<T> request) {
		return provider.GetEntity(request);
	}

	@Override
	public SK_SaveResponse<T> SaveEntity(SK_SaveRequest<T> request) {
		return provider.SaveEntity(request);
	}

	@Override
	public SK_SaveResponse<T> SaveAllEntity(SK_SaveAllRequest<T> request) {
		return provider.SaveAllEntity(request);
	}

	@Override
	public void remove(T entity) {
		provider.remove(entity);
	}

	@Override
	public void removeAll(SK_Specification specification) {
		provider.removeAll(specification);
	}

	@Override
	public void removeAll() {
		provider.removeAll();
	}

	@Override
	public List<T> query(SK_Specification specification) {
		return provider.query(specification);
	}

	@Override
	public void removeAll(Collection<T> entities) {
		provider.removeAll(entities);
	}

	@Override
	public List<Object[]> executeProcedure(SK_Specification para) {
		return provider.executeProcedure(para);
	}

	@Override
	public String runProcedure(SK_Specification para) {
		return provider.runProcedure(para);
	}	
}
