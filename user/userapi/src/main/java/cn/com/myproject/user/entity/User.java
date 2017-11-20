package cn.com.myproject.user.entity;



import cn.com.myproject.user.entity.base.BaseUser;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;


/**
 * 用户基类
 * 
 * @author licl
 * 
 */
public class User extends BaseUser {

	private int hashCode = Integer.MIN_VALUE;

	/**
	 * 系统用户ID
	 */
	public static final long SYSTEM_ID = 1L;

	public static final String USER_RESOURCE = "user/";
	public static final String DEFAULT_PASSWORD = "123456";
	
	public static final int AVATOR_WIDTH = 200;
	public static final int AVATOR_HEIGHT = 200;

	public static String getUserResDir() {
		//FIXME appconfig
//		return Picture.getRet() + AppConfig.RESOURCE_APP_ROOT + USER_RESOURCE;
		return "";
	}

	/**
	 * 获得用户名 昵称不为空则返回昵称，否则返回用户名
	 * 
	 * @return
	 */
	public String getUserName() {
		return StringUtils.isNotBlank(getCnName()) ? getCnName() : getName();
	}



	/**
	 * 获得头像的完整路径
	 * 
	 * @return
	 */
	public String getAvatorPath() {
		//FIXME appconfig
		//return StringUtils.isNotBlank(getAvator()) ? AppConfig.DOMAIN + AppConfig.RESOURCE_APP_ROOT + getAvator() : "";
		return "";
	}

	//缓存相关
	private static String PREFIX_KEY_ADVERT = User.class.getName() + ".findById_";

	/**
	 * 数据过期时间，永久
	 */
	public static int EXPIRE_TIME = 0;

	/**
	 * 获得广告在OCS中的KEY
	 *
	 * @param userId
	 * @return
	 */
	public static String getKeyId(long userId) {
		return PREFIX_KEY_ADVERT + userId;
	}
	
	// --------查询字段-------
	private transient Long roleId;

	private transient List<Role> roles;

	/**
	 * 下线ID
	 */
	private transient Long lowerId;

	/**
	 * 分组ID
	 */
	private transient Long groupId;

    /**
     * 最小年龄
     */
    private transient Integer minAge;

    /**
     * 最大年龄
     */
    private transient Integer maxAge;


	/**
	 * 注册开始时间（正常用户）
	 */
	private transient Date startDate_;
	/**
	 * 注册结束时间（正常用户）
	 */
	private transient Date endDate_;

	/**
	 * 查询的起始位置
	 */
	private transient Integer pageNo;

	/**
	 * 查询多少行
	 */
	private transient Integer pageSize;

	public Date getEndDate_() {
		return endDate_;
	}

	public void setEndDate_(Date endDate_) {
		this.endDate_ = endDate_;
	}

	public Date getStartDate_() {
		return startDate_;
	}

	public void setStartDate_(Date startDate_) {
		this.startDate_ = startDate_;
	}

	/**
	 * 时间段的起始时间（通道广告处用）
	 * @return
	 */
	private transient Date beginDate;

	/**
	 * 时间段的末尾时间（通道广告处用）
	 * @return
	 */
	private transient Date endDate;

	/**
	 * 当天新增的用户数（总公司的数据概况处用）
	 */
	private transient Long userDay;

	/**
	 * 截止到当天的用户数（总公司的数据概况处用）
	 */
	private transient Long userSum;

	/**
	 * 是否是认证用户
	 */
	private String isCertification;

	/**
	 * 是否是付费用户
	 */
	private String isPay;

	/**
	 * 是否是vip用户
	 */
	private String isVip;

	/**
	 * 是否是注册用户
	 */
	private String isRegister;
	private String isRegister1;

	/**
	 * 地区名称
	 * @return
	 */
	private String areaName;

	/**
	 * 代理类型
	 */
	private transient Integer proxyType;

	/**
	 * 代理所代理的区
	 */
	private transient String addresses;

	/**
	 * 该代理所拥有的用户总数
	 */
	private transient Long proxyUserSum;

	/**
	 * 用户给代理贡献的钱数
	 */
	private transient Long accumulativeMoneyUser;

	/**
	 * 用户的财迷数
	 */
	private transient Long miserNumUser;


	private transient Long proxyId;

	/**
	 * 代理区域(可以为省市区任意一级  主要看代理类型)
	 */
	private transient String proxyArea;

	/**
	 * 用户所在的省名
	 */
	private transient String provinceName;

	/**
	 * 用户所在的市名
	 */
	private transient String cityName;

	/**
	 * 用户所在的县名
	 */
	private transient String countyName;

	/**
	 * 用户所在的街道名称
	 */
	private transient String streetName;


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getLowerId() {
		return lowerId;
	}

	public void setLowerId(Long lowerId) {
		this.lowerId = lowerId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getIsCertification() {
		return isCertification;
	}

	public void setIsCertification(String isCertification) {
		this.isCertification = isCertification;
	}

	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}

	public String getIsVip() {
		return isVip;
	}

	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}

	public String getIsRegister() {
		return isRegister;
	}

	public void setIsRegister(String isRegister) {
		this.isRegister = isRegister;
	}

	public String getIsRegister1() {
		return isRegister1;
	}

	public void setIsRegister1(String isRegister1) {
		this.isRegister1 = isRegister1;
	}

	public Long getUserDay() {
		return userDay;
	}

	public void setUserDay(Long userDay) {
		this.userDay = userDay;
	}

	public Long getUserSum() {
		return userSum;
	}

	public void setUserSum(Long userSum) {
		this.userSum = userSum;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getProxyType() {
		return proxyType;
	}

	public void setProxyType(Integer proxyType) {
		this.proxyType = proxyType;
	}

	public String getAddresses() {
		return addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	public Long getProxyUserSum() {
		return proxyUserSum;
	}

	public void setProxyUserSum(Long proxyUserSum) {
		this.proxyUserSum = proxyUserSum;
	}

	public Long getMiserNumUser() {
		return miserNumUser;
	}

	public void setMiserNumUser(Long miserNumUser) {
		this.miserNumUser = miserNumUser;
	}

	public Long getAccumulativeMoneyUser() {
		return accumulativeMoneyUser;
	}

	public void setAccumulativeMoneyUser(Long accumulativeMoneyUser) {
		this.accumulativeMoneyUser = accumulativeMoneyUser;
	}


	public Long getProxyId() {
		return proxyId;
	}

	public void setProxyId(Long proxyId) {
		this.proxyId = proxyId;
	}

	public String getProxyArea() {
		return proxyArea;
	}

	public void setProxyArea(String proxyArea) {
		this.proxyArea = proxyArea;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
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

		if (!(obj instanceof User)) {
			return false;
		} else {
			User user = (User) obj;
			if (this.getId() == null || user.getId() == null) {
				return false;
			}else {
				return (this.getId().equals(user.getId()));
			}
		}
	}
}
