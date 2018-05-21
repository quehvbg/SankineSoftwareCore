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

import sankine.plugin.base.SK_BaseEntity;
import sankine.repository.data.SK_FirebirdRepository;

public class SK_ServiceProvider<T extends SK_BaseEntity> extends SK_DataProvider<T> implements SK_IServiceProvider<T> {

	public SK_ServiceProvider(SK_FirebirdRepository<T> _repository) {
		super(_repository);
	}

}
