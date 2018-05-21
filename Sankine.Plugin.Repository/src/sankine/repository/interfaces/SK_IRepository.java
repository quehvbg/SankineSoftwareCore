/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.repository.interfaces;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import sankine.plugin.base.SK_BaseEntity;

public interface SK_IRepository<T extends SK_BaseEntity> {

	default Optional<T> get(UUID id) {
		return get().stream().filter(entity -> entity.getId().equals(id)).findAny();
	}

	default Set<T> get(Predicate<T> predicate) {
		return get().stream().filter(predicate).collect(Collectors.toSet());
	}

	default Set<T> getRange(int[] range) {
		return get().stream().collect(Collectors.toSet());
	}
	
	Set<T> get();

	void persist(T entity);

	@SuppressWarnings("unchecked")
	default void persist(T... entities) {
		persist(Arrays.asList(entities));
	}

	default void persist(Collection<T> entities) {
		entities.forEach(this::persist);
	}

	void remove(T entity);

	@SuppressWarnings("unchecked")
	default void remove(T... entities) {
		remove(Arrays.asList(entities));
	}

	default void remove(Collection<T> entities) {
		entities.forEach(this::remove);
	}

	default void remove(UUID id) {
		remove(entity -> entity.getId().equals(id)); // predicate to match the
														// id
	}

	default void remove(Predicate<T> predicate) {
		get(predicate).forEach(this::remove);
	}

	void removeAll(SK_Specification specification);
	
	void removeAll();
	
	List<T> query(SK_Specification specification);
	
	List<Object[]> executeProcedure(SK_Specification specification);
	
	String runProcedure(SK_Specification specification);
}
