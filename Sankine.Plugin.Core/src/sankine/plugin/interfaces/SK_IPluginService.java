/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.plugin.interfaces;

import sankine.plugin.base.SK_BaseEntity;
import sankine.plugin.messages.SK_GetAllRequest;
import sankine.plugin.messages.SK_GetAllResponse;
import sankine.plugin.messages.SK_GetRequest;
import sankine.plugin.messages.SK_GetResponse;
import sankine.plugin.messages.SK_SaveAllRequest;
import sankine.plugin.messages.SK_SaveRequest;
import sankine.plugin.messages.SK_SaveResponse;

public interface SK_IPluginService<T extends SK_BaseEntity> {
	SK_GetAllResponse<T> GetAllEntity(SK_GetAllRequest<T> request);
	SK_GetAllResponse<T> GetAllRangeEntity(int[] range);
	SK_GetResponse<T> GetEntity(SK_GetRequest<T> request);
	SK_SaveResponse<T> SaveEntity(SK_SaveRequest<T> request);
	SK_SaveResponse<T> SaveAllEntity(SK_SaveAllRequest<T> request);		
}
