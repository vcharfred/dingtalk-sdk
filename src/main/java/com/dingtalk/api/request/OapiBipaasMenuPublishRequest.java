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

import com.dingtalk.api.response.OapiBipaasMenuPublishResponse;

/**
 * TOP DingTalk-API: dingtalk.oapi.bipaas.menu.publish request
 * 
 * @author top auto create
 * @since 1.0, 2019.07.01
 */
public class OapiBipaasMenuPublishRequest extends BaseTaobaoRequest<OapiBipaasMenuPublishResponse> {
	
	

	/** 
	* 金融云租户ID
	 */
	private String antcloudTenantId;

	public void setAntcloudTenantId(String antcloudTenantId) {
		this.antcloudTenantId = antcloudTenantId;
	}

	public String getAntcloudTenantId() {
		return this.antcloudTenantId;
	}

	public String getApiMethodName() {
		return "dingtalk.oapi.bipaas.menu.publish";
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
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<OapiBipaasMenuPublishResponse> getResponseClass() {
		return OapiBipaasMenuPublishResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(antcloudTenantId, "antcloudTenantId");
	}
	

}