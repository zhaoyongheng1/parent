package cn.com.myproject.user.entity.en;

/**
 * 注册类型
 * 
 * @author licl
 *
 */
public enum RegisterType {
	Normal(1) {
		public String toString() {
			return "自主注册";
		}
	},
	Invitation(4) {
		public String toString() {
			return "推荐注册";
		}
	},
	Creation(7) {
		public String toString() {
			return "人为创建";
		}
	};

	private final int val;

	RegisterType(int n) {
		val = n;
	}

	public int getIntValue() {
		return val;
	}

	public static RegisterType getByIntValue(int n) {
		switch (n) {
		case 1:
			return Normal;
		case 4:
			return Invitation;
		case 7:
			return Creation;
		default:
			return null;
		}
	}
}
