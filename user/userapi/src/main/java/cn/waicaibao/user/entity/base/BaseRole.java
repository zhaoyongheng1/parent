package cn.waicaibao.user.entity.base;

import cn.waicaibao.user.entity.User;

import java.io.Serializable;

/**
 * 角色基类
 * 
 * @author licl
 *
 */
public abstract class BaseRole implements Serializable {

	// ------------primary key----------------
	private Long id;

	// ---------fileds-----------

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 页面显示标签
	 */
	private String label;

	/**
	 * 是否有效
	 */
	private Boolean valid = true;

	private Integer platform;

	// ------------------- collections --------------------------------------
	/**
	 * 包含的用户
	 */
	private java.util.List<User> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public java.util.List<User> getUsers() {
		return users;
	}

	public void setUsers(java.util.List<User> users) {
		this.users = users;
	}



	@Override
	public String toString() {
		return super.toString();
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
}
