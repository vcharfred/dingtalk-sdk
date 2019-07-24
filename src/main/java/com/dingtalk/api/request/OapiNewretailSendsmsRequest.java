package com.dingtalk.api.request;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.util.RequestCheckUtils;
import com.taobao.api.TaobaoObject;
import java.util.Map;
import java.util.List;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.dingtalk.api.DingTalkConstants;
import com.taobao.api.Constants;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.internal.util.TaobaoUtils;
import com.taobao.api.internal.util.json.JSONWriter;
import com.dingtalk.api.response.OapiNewretailSendsmsResponse;

/**
 * TOP DingTalk-API: dingtalk.oapi.newretail.sendsms request
 * 
 * @author top auto create
 * @since 1.0, 2019.07.01
 */
public class OapiNewretailSendsmsRequest extends BaseTaobaoRequest<OapiNewretailSendsmsResponse> {
	
	

	/** 
	* 短信接受者信息
	 */
	private String smsmodule;

	public void setSmsmodule(String smsmodule) {
		this.smsmodule = smsmodule;
	}

	public void setSmsmodule(List<SmsModel> smsmodule) {
		this.smsmodule = new JSONWriter(false,false,true).write(smsmodule);
	}

	public String getSmsmodule() {
		return this.smsmodule;
	}

	public String getApiMethodName() {
		return "dingtalk.oapi.newretail.sendsms";
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
		txtParams.put("smsmodule", this.smsmodule);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<OapiNewretailSendsmsResponse> getResponseClass() {
		return OapiNewretailSendsmsResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkObjectMaxListSize(smsmodule, 20, "smsmodule");
	}
	
	/**
	 * 短信接受者信息
	 *
	 * @author top auto create
	 * @since 1.0, null
	 */
	public static class SmsModel extends TaobaoObject {
		private static final long serialVersionUID = 5138385743167999765L;
		/**
		 * 品牌名
		 */
		@ApiField("brandname")
		private String brandname;
		/**
		 * 员工id
		 */
		@ApiField("userid")
		private String userid;
		/**
		 * 员工nick
		 */
		@ApiField("username")
		private String username;
	
		public String getBrandname() {
			return this.brandname;
		}
		public void setBrandname(String brandname) {
			this.brandname = brandname;
		}
		public String getUserid() {
			return this.userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return this.username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
	}
	

}