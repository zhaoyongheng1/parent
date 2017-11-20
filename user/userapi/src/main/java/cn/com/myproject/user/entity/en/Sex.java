package cn.com.myproject.user.entity.en;

/**
 * 性别
 * 
 * @author licl
 *
 */
public enum Sex {
	Male(1) {
		public String toString() {
			return "男";
		}
	},
	Female(4) {
		public String toString() {
			return "女";
		}
	};

	private final int val;

	Sex(int n) {
		val = n;
	}

	public int getIntValue() {
		return val;
	}

	public static Sex getByIntValue(int n) {
		switch (n) {
		case 1:
			return Male;
		case 4:
			return Female;
		default:
			return null;
		}
	}
}
