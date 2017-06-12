package cn.waicaibao.user.entity.base;




import cn.waicaibao.user.entity.en.AuthType;

import java.io.Serializable;
import java.util.Date;

/**
 * 第三方授权
 *
 * @author licl
 *
 */
public abstract class BaseThirdPartyAuth implements Serializable {


	// ------------------- primary key --------------------------------------
	private Long id;

	// ------------------- fields --------------------------------------

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * openId
	 */
	private String openId;

	/**
	 * unionId
	 */
	private String unionId;

	/**
	 * 授权类型
	 */
	private AuthType authType;

	/**
	 * 时间
	 */
	private Date createTime;

	//-----------------------set、get------------------------//
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public AuthType getAuthType() {
		return authType;
	}

	public void setAuthType(AuthType authType) {
		this.authType = authType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 映射：用户状态
	 */
	public Integer getAuthTypeValue() {
		return (authType != null) ? authType.getIntValue() : null;
	}

	public void setAuthTypeValue(Integer value) {
		if (value != null)
			this.authType = AuthType.getByIntValue(value);
	}



	@Override
	public String toString() {
		return super.toString();
	}
}
