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
import com.dingtalk.api.response.OapiWorkrecordAddResponse;

/**
 * TOP DingTalk-API: dingtalk.oapi.workrecord.add request
 * 
 * @author top auto create
 * @since 1.0, 2019.07.01
 */
public class OapiWorkrecordAddRequest extends BaseTaobaoRequest<OapiWorkrecordAddResponse> {
	
	

	/** 
	* 待办时间。Unix时间戳
	 */
	private Long createTime;

	/** 
	* 表单列表
	 */
	private String formItemList;

	/** 
	* manager7078
	 */
	private String originatorUserId;

	/** 
	* 待办来源名称
	 */
	private String sourceName;

	/** 
	* 标题
	 */
	private String title;

	/** 
	* 待办跳转url
	 */
	private String url;

	/** 
	* 用户id
	 */
	private String userid;

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getCreateTime() {
		return this.createTime;
	}

	public void setFormItemList(String formItemList) {
		this.formItemList = formItemList;
	}

	public void setFormItemList(List<FormItemVo> formItemList) {
		this.formItemList = new JSONWriter(false,false,true).write(formItemList);
	}

	public String getFormItemList() {
		return this.formItemList;
	}

	public void setOriginatorUserId(String originatorUserId) {
		this.originatorUserId = originatorUserId;
	}

	public String getOriginatorUserId() {
		return this.originatorUserId;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceName() {
		return this.sourceName;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return this.userid;
	}

	public String getApiMethodName() {
		return "dingtalk.oapi.workrecord.add";
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
		txtParams.put("create_time", this.createTime);
		txtParams.put("formItemList", this.formItemList);
		txtParams.put("originator_user_id", this.originatorUserId);
		txtParams.put("source_name", this.sourceName);
		txtParams.put("title", this.title);
		txtParams.put("url", this.url);
		txtParams.put("userid", this.userid);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<OapiWorkrecordAddResponse> getResponseClass() {
		return OapiWorkrecordAddResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(createTime, "createTime");
		RequestCheckUtils.checkObjectMaxListSize(formItemList, 50, "formItemList");
		RequestCheckUtils.checkNotEmpty(title, "title");
		RequestCheckUtils.checkNotEmpty(url, "url");
		RequestCheckUtils.checkNotEmpty(userid, "userid");
	}
	
	/**
	 * 表单列表
	 *
	 * @author top auto create
	 * @since 1.0, null
	 */
	public static class FormItemVo extends TaobaoObject {
		private static final long serialVersionUID = 6726737445347222699L;
		/**
		 * 内容
		 */
		@ApiField("content")
		private String content;
		/**
		 * 标题
		 */
		@ApiField("title")
		private String title;
	
		public String getContent() {
			return this.content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getTitle() {
			return this.title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	}
	

}