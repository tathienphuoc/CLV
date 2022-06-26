/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : MoneyMgmtDAOSearchLaneCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2022.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2022.06.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.clv.doutraining.moneymgmt.intergration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author phuoc
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MoneyMgmtDAOSearchLaneCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search lane code
	  * </pre>
	  */
	public MoneyMgmtDAOSearchLaneCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.clv.doutraining.moneymgmt.intergration").append("\n"); 
		query.append("FileName : MoneyMgmtDAOSearchLaneCodeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("select " ).append("\n"); 
		query.append("	distinct(rlane_cd) " ).append("\n"); 
		query.append("from joo_carrier" ).append("\n"); 
		query.append("where jo_crr_cd IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${partnerCodes}) " ).append("\n"); 
		query.append("		#if($velocityCount < $partnerCodes.size()) " ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append(" 		#else '$key' " ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}