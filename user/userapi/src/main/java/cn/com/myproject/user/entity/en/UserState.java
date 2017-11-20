package cn.com.myproject.user.entity.en;

/**
 * 用户状态
 * 
 * @author licl
 *
 */
public enum UserState {
	Normal(1) {
		public String toString() {
			return "正常";
		}
	},
	Invalid(4) {
		public String toString() {
			return "无效";
		}
	},
	New(7) {
		public String toString() {
			return "新注册";
		}
	},
	Infoing(10) {
		public String toString() {
			return "信息待完善";
		}
	},
	BankCard(13) {
		public String toString() {
			return "待绑定银行卡";
		}
	},
	PayPwd(16) {
		public String toString() {
			return "待设置支付密码";
		}
	};

	private final int val;

	UserState(int n) {
		val = n;
	}

	public int getIntValue() {
		return val;
	}

	public static UserState getByIntValue(int n) {
		switch (n) {
		case 1:
			return Normal;
		case 4:
			return Invalid;
		case 7:
			return New;
		case 10:
			return Infoing;
		case 13:
			return BankCard;
		case 16:
			return PayPwd;
		default:
			return null;
		}
	}
}
