package cn.com.myproject.user.entity;


import cn.com.myproject.user.entity.base.BaseNavNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 导航节点
 * 
 * @author licl
 *
 */
public class NavNode extends BaseNavNode {

	private int hashCode = Integer.MIN_VALUE;

	//子导航
	private transient List<NavNode> children = new ArrayList<NavNode>();

	public List<NavNode> getChildren() {
		return children;
	}

	public void setChildren(List<NavNode> children) {
		this.children = children;
	}
	
	public void addChild(NavNode nav){
		children.add(nav);
	}


	//----------------重写方法-------------------------
	@Override
	public int hashCode(){
		if(Integer.MIN_VALUE == this.hashCode){
			if(this.getId() == null) {
				return super.hashCode();
			}else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}

		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}

		if(!(obj instanceof NavNode)){
			return false;
		} else {
			NavNode navNode = (NavNode) obj;
			if(this.getId() == null || navNode.getId() == null) {
				return false;
			}else {
				return (this.getId().equals(navNode.getId()));
			}
		}
	}
}
