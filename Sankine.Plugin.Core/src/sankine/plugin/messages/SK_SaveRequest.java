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

import java.util.List;

import sankine.plugin.base.SK_BaseEntity;
import sankine.plugin.base.SK_BaseRequest;

public class SK_SaveRequest<T extends SK_BaseEntity> extends SK_BaseRequest {
	public T Entity;
	public List<T> ListEntity;
	public List<T> ListInsert;
	public List<T> ListUpdate;
	
	public SK_SaveRequest(T entity){
		Entity = entity;
	}
	public SK_SaveRequest(List<T> entities1){
		ListEntity = entities1;
	}
	
	public SK_SaveRequest(List<T> entities1,List<T> entities2){
		ListInsert = entities1;
		ListUpdate = entities2;
	}
}
