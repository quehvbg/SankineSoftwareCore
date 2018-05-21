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
import sankine.plugin.interfaces.SK_IPluginService;
import sankine.repository.interfaces.SK_Specification;

public interface SK_IDataProvider<T extends SK_BaseEntity> extends SK_IPluginService<T> {

	void remove(T entity);

	void removeAll(SK_Specification specification);

	void removeAll();

	void removeAll(Collection<T> entities);

	List<T> query(SK_Specification specification);

	List<Object[]> executeProcedure(SK_Specification specification);

	String runProcedure(SK_Specification specification);
}
