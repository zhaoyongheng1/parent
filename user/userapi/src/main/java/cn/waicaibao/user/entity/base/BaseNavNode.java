package cn.waicaibao.user.entity.base;


import java.io.Serializable;

/**
 * 此类包含关联到数据表xt_nav_node的数据。
 * 不要修改此类，因为它会被重写（overwritten），除非同这个类相关联的配置文件发生了修改。
 * 
 * @author nvoyager
 *
 */
public abstract class BaseNavNode implements Serializable {
	

	
	// ------------------- primary key --------------------------------------
	private Long id;
	
	// ------------------- fields --------------------------------------
	
	/**
	 * 导航名称
	 */
	private String name;
	
	/**
	 * 页面显示标签
	 */
	private String label;
	
	/**
	 * 内容链接
	 */
	private String contentUrl;
	
	/**
	 * 父节点ID
	 */
	private Long parentNodeId;
	
	/**
	 * 查看权限
	 */
	private String viewPermission;
	
	/**
	 * 优先级
	 */
	private Integer priority = 1000;


	private Integer platform;

	/**
	 * 设置ID
	 * @return
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 获取ID
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获得导航显示名称
	 * @return
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * 设置导航显示名称
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 获得内容页链接
	 * @return
	 */
	public String getContentUrl() {
		return contentUrl;
	}
	/**
	 * 设置内容页链接
	 * @param contentUrl
	 */
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	
	public Long getParentNodeId() {
		return parentNodeId;
	}

	public void setParentNodeId(Long parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	public String getViewPermission() {
		return viewPermission;
	}
	public void setViewPermission(String viewPermission) {
		this.viewPermission = viewPermission;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}


	
	@Override
	public String toString(){
		return super.toString();
	}
}
