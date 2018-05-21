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
import javax.persistence.ParameterMode;

public class SK_Parameter {
	private String para;
	private Object value;
	private ParameterMode mode;
	private Class<?> type;
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	public ParameterMode getMode() {
		return mode;
	}
	public void setMode(ParameterMode mode) {
		this.mode = mode;
	}
	
	public Class<?> getType() {
		return type;
	}
	public void setType(Class<?> type) {
		this.type = type;
	}
	public SK_Parameter(String para, Object value, Class<?> type, ParameterMode mode) {		
		this.para = para;
		this.value = value;
		this.type = type;
		this.mode = mode;
	}	
}
