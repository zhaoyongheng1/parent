package cn.com.myproject.user.entity.base;



import cn.com.myproject.user.entity.en.RegisterType;
import cn.com.myproject.user.entity.en.Sex;
import cn.com.myproject.user.entity.en.UserState;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户基类
 * 
 * @author licl
 *
 */
public abstract class BaseUser implements Serializable {


	// ------------------- primary key --------------------------------------
	private Long id;

	// ------------------- fields --------------------------------------

	/**
	 * 账户名称
	 */
	private String name;

	/**
	 * 中文名
	 */
	private String cnName;

	/**
	 * 用户密码
	 */
	private transient String password;

	/**
	 * 密钥
	 */
	private transient String md5Key;

	/**
	 * 手机号
	 */
	private String mobilePhone;

	/**
	 * 注册时间
	 */
	private java.util.Date registerTime;

	/**
	 * 用户状态
	 */
	private UserState userState;

	/**
	 * 用户头像
	 */
	private String avator;

	/**
	 * 注册类型
	 */
	private RegisterType registerType;

	/**
	 * 性别
	 */
	private Sex sex;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 用户爱好
	 */
	private String userHobby;

	/**
	 * 用户行业
	 */
	private Long userIndustry;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 省份
	 */
	private Long provinceId;

	/**
	 * 城市
	 */
	private Long cityId;

	/**
	 * 区/市/县
	 */
	private Long countyId;

	/**
	 * 街道/小区
	 */
	private Long streetId;
	/**
	 * 用户住址信息变更时间
	 */
	private Date updateAreaTime;
	/**
	 * 识别码
	 */
	private String qrCode;

	/**
	 * 邀请码
	 */
	private Long invitationCode;

	/**
	 * 身份证号码
	 */
	private String idCardNo;

	/**
	 * 身份证图片
	 */
	private String idCardPicture;

	/**
	 * 手持身份证照
	 */
	private String idCardPersonPicture;

	public String getIdCardPersonPicture() {
		return idCardPersonPicture;
	}

	public void setIdCardPersonPicture(String idCardPersonPicture) {
		this.idCardPersonPicture = idCardPersonPicture;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getIdCardPicture() {
		return idCardPicture;
	}

	public void setIdCardPicture(String idCardPicture) {
		this.idCardPicture = idCardPicture;
	}

	public Long getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(Long invitationCode) {
		this.invitationCode = invitationCode;
	}

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

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMd5Key() {
		return md5Key;
	}

	public void setMd5Key(String md5Key) {
		this.md5Key = md5Key;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public java.util.Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(java.util.Date registerTime) {
		this.registerTime = registerTime;
	}

	public UserState getUserState() {
		return userState;
	}

	public void setUserState(UserState userState) {
		this.userState = userState;
	}

	public String getAvator() {
		return avator;
	}

	public void setAvator(String avator) {
		this.avator = avator;
	}

	public RegisterType getRegisterType() {
		return registerType;
	}

	public void setRegisterType(RegisterType registerType) {
		this.registerType = registerType;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	/**
	 * 映射：用户状态
	 */
	public Integer getUserStateValue() {
		// return getFirstWord().getIntValue();
		return (userState != null) ? userState.getIntValue() : null;
	}

	public void setUserStateValue(Integer value) {
		if (value != null)
			this.userState = UserState.getByIntValue(value);
	}

	public Integer getRegisterTypeValue() {
		return (registerType != null) ? registerType.getIntValue() : null;
	}

	public void setRegisterTypeValue(Integer value) {
		if (value != null)
			this.registerType = RegisterType.getByIntValue(value);
	}

	public Integer getSexValue() {
		return (sex != null) ? sex.getIntValue() : null;
	}

	public void setSexValue(Integer value) {
		if (value != null)
			this.sex = Sex.getByIntValue(value);
	}

	public Long getStreetId() {
		return streetId;
	}

	public void setStreetId(Long streetId) {
		this.streetId = streetId;
	}

	public String getUserHobby() {
		return userHobby;
	}

	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}

	public Long getUserIndustry() {
		return userIndustry;
	}

	public void setUserIndustry(Long userIndustry) {
		this.userIndustry = userIndustry;
	}

	public Date getUpdateAreaTime() {
		return updateAreaTime;
	}

	public void setUpdateAreaTime(Date updateAreaTime) {
		this.updateAreaTime = updateAreaTime;
	}




	@Override
	public String toString() {
		return super.toString();
	}
}
