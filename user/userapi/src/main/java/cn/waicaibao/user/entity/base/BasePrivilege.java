package cn.waicaibao.user.entity.base;


import java.io.Serializable;

/**
 * 基于路径的访问权限基类
 * 
 * @author licl
 *
 */
public abstract class BasePrivilege implements Serializable {



	// ------------primary key----------------
	private Long id;

	// ---------fileds-----------

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 路径
	 */
	private String url;

	/**
	 * 权限
	 */
	private String permission;

	/**
	 * 是否有效
	 */
	private Boolean valid = true;

	/**
	 * 创建时间
	 */
	private java.util.Date createTime;

	private Integer platform;

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

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}



	@Override
	public String toString() {
		return super.toString();
	}
}
