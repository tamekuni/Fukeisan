package jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum;

public enum Jyanto {
	RENPUHAI(0, 4), YAKUHAI(1, 2), OTHER(2, 0);

	private final int mPoint;
	private final int mIndex;

	Jyanto(int aIndex, int aPoint) {
		mIndex = aIndex;
		mPoint = aPoint;
	}

	public int toPoint() {
		return mPoint;
	}

	public int toIndex() {
		return mIndex;
	}

	static public Jyanto toJyanto(int aIndex) {
		if (aIndex == RENPUHAI.toIndex()) {
			return RENPUHAI;
		}
		if (aIndex == YAKUHAI.toIndex()) {
			return YAKUHAI;
		}
		if (aIndex == OTHER.toIndex()) {
			return OTHER;
		}
		return OTHER;
	}

}
