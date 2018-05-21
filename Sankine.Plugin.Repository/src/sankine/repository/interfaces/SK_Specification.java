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

import java.util.List;

public class SK_Specification {
	public String SqlQuery;
	public List<SK_Parameter> listPara;
	public SK_Parameter onePara;
	
	public SK_Specification(String query){
		this.SqlQuery = query;
	}

	public SK_Specification(String sqlQuery, SK_Parameter para) {	
		SqlQuery = sqlQuery;
		onePara = para;
	}
	public SK_Specification(String sqlQuery, List<SK_Parameter> list) {		
		SqlQuery = sqlQuery;
		this.listPara = list;
	}
		
}
