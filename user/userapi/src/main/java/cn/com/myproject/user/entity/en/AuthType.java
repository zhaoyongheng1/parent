package cn.com.myproject.user.entity.en;

/**
 * 授权类型
 * 
 * @author licl
 *
 */
public enum AuthType {
	Wechat(1) {
		public String toString() {
			return "微信";
		}
	},
	QQ(2) {
		public String toString() {
			return "QQ";
		}
	},
	SinaWeibo(3) {
		public String toString() {
			return "新浪微博";
		}
	};

	private final int val;

	AuthType(int n) {
		val = n;
	}

	public int getIntValue() {
		return val;
	}

	public static AuthType getByIntValue(int n) {
		switch (n) {
		case 1:
			return Wechat;
		case 2:
			return QQ;
		case 3:
			return SinaWeibo;
		default:
			return null;
		}
	}
}
