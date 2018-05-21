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

import java.util.LinkedList;

import sankine.plugin.base.SK_BaseEntity;
import sankine.plugin.base.SK_BaseResponse;

public class SK_GetAllResponse<T extends SK_BaseEntity> extends SK_BaseResponse {
	public LinkedList<T> listEntity;

	public SK_GetAllResponse() {
		listEntity = new LinkedList<T>();
	}
}
