/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.plugin.base;

import java.util.Objects;
import java.util.UUID;

public abstract class SK_BaseEntity extends SK_ObjectState {
	
	private UUID id;

	public void setId(UUID paraId){
		this.id = paraId;
	}
	
	public UUID getId() {
		return this.id;
	}

	public SK_BaseEntity() {			
	}

	public UUID defaultGuid(){
		return new UUID( 0L , 0L );
	}
	
	public UUID generateUUID(){
		return UUID.randomUUID();
	}
	
	public boolean isGuidEmpty(){
		return this.id.toString().equals(new UUID( 0L , 0L ).toString());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		SK_BaseEntity identity = (SK_BaseEntity) obj;
		return Objects.equals(id, identity.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[id=" + id.toString().substring(0, 8) + "...]";
	}

}
