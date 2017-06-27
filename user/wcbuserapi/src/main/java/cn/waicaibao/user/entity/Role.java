package cn.waicaibao.user.entity;


import cn.waicaibao.user.entity.base.BaseRole;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 * 
 * @author licl
 *
 */
public class Role extends BaseRole {
	private int hashCode = Integer.MIN_VALUE;


	public static final String ROLE_OPERATOR = "operator";//运营
	public static final String ROLE_OPERATOR_MGR = "operatorMgr";//运营总监
	public static final String ROLE_CUSTOMER = "customer";//普通用户
	public static final String ROLE_AGENT = "agent";//代理
	public static final String ROLE_ADMINISTRATOR = "administrator";//超级管理员
	public static final String ROLE_MERCHANT = "merchant";//商户
	public static final String ROLE_SHOP = "shop";//分店
	public static final String ROLE_CASHIER = "cashier";//收银员

	public static final String ROLE_STAT_COM = "statCom"; //总公司统计


	public static final String ROLE_PHONE_MER = "merphone";

	public static final String ROLE_OPERATORMGRVIC = "operatorMgrVice";//运营副总监

	public static final String ROLE_OPERATORACRA = "operatorAcrA";//运营审核专员A
	public static final String ROLE_OPERATORACRB = "operatorAcrB";//运营审核专员B

	private static List<String> crmRoles = new ArrayList<String>();

	private static List<String> merchantRoles = new ArrayList<String>();

	private static List<String> agentRoles = new ArrayList<String>();

	private static List<String> agentnewRoles = new ArrayList<String>();

	static {
		crmRoles.add(ROLE_ADMINISTRATOR);
		crmRoles.add(ROLE_OPERATOR);
		crmRoles.add(ROLE_OPERATOR_MGR);
		crmRoles.add(ROLE_PHONE_MER);
		crmRoles.add(ROLE_OPERATORMGRVIC);
		crmRoles.add(ROLE_OPERATORACRA);
		crmRoles.add(ROLE_OPERATORACRB);


		merchantRoles.add(ROLE_MERCHANT);
		merchantRoles.add(ROLE_SHOP);
		merchantRoles.add(ROLE_CASHIER);

		agentRoles.add(ROLE_AGENT);

		agentnewRoles.add(ROLE_AGENT);
	}

	/**
	 * 是否具有商户系统权限
	 * @return
	 */
	public static boolean hasMerchantPrivilege(List<Role> roles){
		if(roles == null || roles.size() == 0)
			return false;

		for (Role role:roles) {
			if(merchantRoles.contains(role.getName()))
				return true;
		}

		return false;
	}

	/**
	 * 是否具有代理系统权限
	 * @return
	 */
	public static boolean hasAgentPrivilege(List<Role> roles){
		if(roles == null || roles.size() == 0)
			return false;

		for (Role role:roles) {
			if(agentRoles.contains(role.getName()))
				return true;
		}

		return false;
	}

	public static boolean hasAgentnewPrivilege(List<Role> roles){
		if(roles == null || roles.size() == 0)
			return false;

		for (Role role:roles) {
			if(agentnewRoles.contains(role.getName()))
				return true;
		}

		return false;
	}


	/**
	 * 是否具有运营系统权限
	 * @return
	 */
	public static boolean hasCrmPrivilege(List<Role> roles){
		if(roles == null || roles.size() == 0)
			return false;

		for (Role role:roles) {
			if(crmRoles.contains(role.getName()))
				return true;
		}

		return false;
	}

	/**
	 * 是否为某一角色
	 * @param roles
	 * @return
	 */
	public static boolean hasRole(String roleName, List<Role> roles){
		if(StringUtils.isBlank(roleName) || roles == null || roles.size() == 0) {
			return false;
		}
		for (Role role:roles) {
			if(role.getName().equals(roleName)) {
				return true;
			}
		}

		return false;
	}


	// ----------------重写方法-------------------------
	@Override
	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (this.getId() == null) {
				return super.hashCode();
			}else {
				String hashStr = this.getClass().getName() + ":"
						+ this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}

		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Role)) {
			return false;
		} else {
			Role role = (Role) obj;
			if (this.getId() == null || role.getId() == null) {
				return false;
			}else {
				return (this.getId().equals(role.getId()));
			}
		}
	}
}
