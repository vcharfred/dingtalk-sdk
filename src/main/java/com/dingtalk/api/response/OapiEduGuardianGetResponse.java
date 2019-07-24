package com.dingtalk.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.TaobaoObject;

import com.taobao.api.TaobaoResponse;

/**
 * TOP DingTalk-API: dingtalk.oapi.edu.guardian.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class OapiEduGuardianGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 5379268839311616688L;

	/** 
	 * 错误码
	 */
	@ApiField("errcode")
	private Long errcode;

	/** 
	 * 错误信息
	 */
	@ApiField("errmsg")
	private String errmsg;

	/** 
	 * result
	 */
	@ApiField("result")
	private GuardianRespone result;

	/** 
	 * 成功状态
	 */
	@ApiField("success")
	private Boolean success;


	public void setErrcode(Long errcode) {
		this.errcode = errcode;
	}
	public Long getErrcode( ) {
		return this.errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getErrmsg( ) {
		return this.errmsg;
	}

	public void setResult(GuardianRespone result) {
		this.result = result;
	}
	public GuardianRespone getResult( ) {
		return this.result;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Boolean getSuccess( ) {
		return this.success;
	}

	public boolean isSuccess() {
        return getErrcode() == null || getErrcode().equals(0L);
    }
	
	/**
	 * result
	 *
	 * @author top auto create
	 * @since 1.0, null
	 */
	public static class GuardianRespone extends TaobaoObject {
		private static final long serialVersionUID = 4763287882284414685L;
		/**
		 * 家长ID
		 */
		@ApiField("guardian_userid")
		private String guardianUserid;
		/**
		 * 关系名称
		 */
		@ApiField("nick")
		private String nick;
		/**
		 * 关系类型（M妈妈，D爸爸，O其他）
		 */
		@ApiField("relation")
		private String relation;
		/**
		 * 学生ID
		 */
		@ApiField("student_userid")
		private String studentUserid;
	
		public String getGuardianUserid() {
			return this.guardianUserid;
		}
		public void setGuardianUserid(String guardianUserid) {
			this.guardianUserid = guardianUserid;
		}
		public String getNick() {
			return this.nick;
		}
		public void setNick(String nick) {
			this.nick = nick;
		}
		public String getRelation() {
			return this.relation;
		}
		public void setRelation(String relation) {
			this.relation = relation;
		}
		public String getStudentUserid() {
			return this.studentUserid;
		}
		public void setStudentUserid(String studentUserid) {
			this.studentUserid = studentUserid;
		}
	}
	


}
