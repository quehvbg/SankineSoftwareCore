/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.repository.data;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import sankine.plugin.base.SK_BaseEntity;
import sankine.repository.interfaces.SK_IRepositoryAsync;

public abstract class SK_InMemoryRepository<T extends SK_BaseEntity> implements SK_IRepositoryAsync<T> {

	private Set<T> entities = new HashSet<>();

	@Override
	public Set<T> get() {
		return Collections.unmodifiableSet(entities);
	}

	@Override
	public void persist(T entity) {
		entities.add(entity);
	}

	@Override
	public void remove(T entity) {
		entities.remove(entity);
	}
}
