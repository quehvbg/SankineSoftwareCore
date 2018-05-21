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
import java.util.LinkedList;
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

public class SK_DataProvider<T extends SK_BaseEntity> implements SK_IDataProvider<T> {

	public SK_FirebirdRepository<T> _repository;

	public SK_DataProvider(SK_FirebirdRepository<T> _repository) {
		this._repository = _repository;
	}

	@Override
	public SK_GetAllResponse<T> GetAllEntity(SK_GetAllRequest<T> request) {
		SK_GetAllResponse<T> response = new SK_GetAllResponse<T>();
		try {
			response.listEntity = new LinkedList<T>(_repository.get());
			response.Success = true;
			return response;
		} catch (Exception ex) {			
			response.Success = false;
			response.Description = ex.getMessage();
			return response;
		}
	}

	@Override
	public SK_GetAllResponse<T> GetAllRangeEntity(int[] range) {
		SK_GetAllResponse<T> response = new SK_GetAllResponse<T>();
		try {
			response.listEntity = new LinkedList<T>(_repository.getRange(range));
			response.Success = true;
			return response;
		} catch (Exception ex) {
			response.Success = false;
			response.Description = ex.getMessage();
			return response;
		}
	}
	
	@Override
	public SK_GetResponse<T> GetEntity(SK_GetRequest<T> request) {
		SK_GetResponse<T> response = new SK_GetResponse<T>();
		try {
			//response.Entity = (T) _repository.get(request.Entity.getId()).map(Stream::of).orElseGet(Stream::empty);
			response.Entity =  _repository.get(request.Entity.getId()).get();
			response.Success = true;
			return response;
		} catch (Exception ex) {
			response.Success = false;
			response.Description = ex.getMessage();
			return response;
		}
	}

	@Override
	public SK_SaveResponse<T> SaveEntity(SK_SaveRequest<T> request) {
		SK_SaveResponse<T> response = new SK_SaveResponse<T>();
		try {
			switch (request.Transaction) {
			case Insert:
			case Update:
				_repository.persist(request.Entity);
				break;
			case Delete:
				_repository.remove(request.Entity);
			default:
				_repository.persist(request.Entity);
				break;
			}
			response.Success = true;
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			response.Success = false;
			response.Description = ex.getMessage();
			return response;
		}
	}

	@Override
	public SK_SaveResponse<T> SaveAllEntity(SK_SaveAllRequest<T> request) {
		SK_SaveResponse<T> response = new SK_SaveResponse<T>();
		try {
			switch (request.Transaction) {
			case Insert:
			case Update:
				_repository.persist(request.ListEntties);
				break;
			case Delete:
				_repository.remove(request.ListEntties);
			default:
				_repository.persist(request.ListEntties);
				break;
			}
			response.Success = true;
			return response;
		} catch (Exception ex) {
			System.out.println(ex);
			response.Success = false;
			response.Description = ex.getMessage();
			return response;
		}
	}

	@Override
	public void remove(T entity) {
		_repository.remove(entity);
	}

	@Override
	public void removeAll(SK_Specification specification) {
		_repository.removeAll(specification);
	}

	@Override
	public void removeAll() {
		_repository.removeAll();
	}

	@Override
	public void removeAll(Collection<T> entities) {
		_repository.remove(entities);
	}
	
	@Override
	public List<T> query(SK_Specification para) {
		return _repository.query(para);
	}

	@Override
	public List<Object[]> executeProcedure(SK_Specification para) {
		return _repository.executeProcedure(para);
	}

	@Override
	public String runProcedure(SK_Specification para) {
		return _repository.runProcedure(para);
	}	
}
