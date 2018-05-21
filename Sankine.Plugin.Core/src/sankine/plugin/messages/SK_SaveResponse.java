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
import sankine.plugin.base.SK_BaseResponse;

public class SK_SaveResponse<T extends SK_BaseEntity> extends SK_BaseResponse{
	public T Entity;
}
