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

import sankine.plugin.base.SK_BaseEntity;

public class SK_MySqlRepository<T extends SK_BaseEntity> extends SK_AbstractRepository<T> {

	public SK_MySqlRepository(Class<T> type) {
		super(type);		
	}

}
