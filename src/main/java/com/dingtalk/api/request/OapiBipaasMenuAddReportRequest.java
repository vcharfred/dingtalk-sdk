package com.dingtalk.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;
import java.util.List;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.dingtalk.api.DingTalkConstants;
import com.taobao.api.Constants;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.internal.util.TaobaoUtils;

import com.dingtalk.api.response.OapiBipaasMenuAddReportResponse;

/**
 * TOP DingTalk-API: dingtalk.oapi.bipaas.menu.add_report request
 * 
 * @author top auto create
 * @since 1.0, 2019.07.01
 */
public class OapiBipaasMenuAddReportRequest extends BaseTaobaoRequest<OapiBipaasMenuAddReportResponse> {
	
	

	/** 
	* 金融云租户ID信息
	 */
	private String antcloudTenantId;

	/** 
	* 智能参谋菜单ID
	 */
	private Long menuId;

	/** 
	* 报表ID列表
	 */
	private String reportIds;

	public void setAntcloudTenantId(String antcloudTenantId) {
		this.antcloudTenantId = antcloudTenantId;
	}

	public String getAntcloudTenantId() {
		return this.antcloudTenantId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getMenuId() {
		return this.menuId;
	}

	public void setReportIds(String reportIds) {
		this.reportIds = reportIds;
	}

	public String getReportIds() {
		return this.reportIds;
	}

	public String getApiMethodName() {
		return "dingtalk.oapi.bipaas.menu.add_report";
	}

	private String topResponseType = Constants.RESPONSE_TYPE_DINGTALK_OAPI;

     public String getTopResponseType() {
        return this.topResponseType;
     }

     public void setTopResponseType(String topResponseType) {
        this.topResponseType = topResponseType;
     }

     public String getTopApiCallType() {
        return DingTalkConstants.CALL_TYPE_OAPI;
     }

     private String topHttpMethod = DingTalkConstants.HTTP_METHOD_POST;

     public String getTopHttpMethod() {
     	return this.topHttpMethod;
     }

     public void setTopHttpMethod(String topHttpMethod) {
        this.topHttpMethod = topHttpMethod;
     }

     public void setHttpMethod(String httpMethod) {
         this.setTopHttpMethod(httpMethod);
     }

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("antcloud_tenant_id", this.antcloudTenantId);
		txtParams.put("menu_id", this.menuId);
		txtParams.put("report_ids", this.reportIds);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<OapiBipaasMenuAddReportResponse> getResponseClass() {
		return OapiBipaasMenuAddReportResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(antcloudTenantId, "antcloudTenantId");
		RequestCheckUtils.checkNotEmpty(menuId, "menuId");
		RequestCheckUtils.checkNotEmpty(reportIds, "reportIds");
		RequestCheckUtils.checkMaxListSize(reportIds, 20, "reportIds");
	}
	

}