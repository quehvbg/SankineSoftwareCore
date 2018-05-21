/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.plugin.messages;

import sankine.plugin.base.SK_BaseEntity;
import sankine.plugin.base.SK_BaseRequest;


public class SK_GetRequest<T extends SK_BaseEntity> extends SK_BaseRequest {
	public T Entity;

	public SK_GetRequest(){
		
	}
	
	public SK_GetRequest(T sK_Entity) {
		Entity = sK_Entity;
	}	
}
