package jp.gr.java_conf.tamekuni.fukeisan.public_enum;

public enum Machi {
	RYANMEN(0, 0, "両面待ち"), SHABO(1, 0, "シャボ待ち"), KANCHAN(2, 2, "嵌張待ち"), PENCHAN(
			3, 2, "辺張待ち"), TANKI(4, 2, "単騎待ち"), NA(5, 0, "");

	private final int mIndex;
	private final int mPoint;
	private final String mString;

	Machi(int aIndex, int aPoint, String aString) {
		mIndex = aIndex;
		mPoint = aPoint;
		mString = aString;
	}

	public int toIndex() {
		return mIndex;
	}

	public int toPoint() {
		return mPoint;
	}

	@Override
	public String toString() {
		return mString;
	}

	static public Machi toMachi(int aIndex) {
		if (aIndex == RYANMEN.toIndex()) {
			return RYANMEN;
		}
		if (aIndex == SHABO.toIndex()) {
			return SHABO;
		}
		if (aIndex == KANCHAN.toIndex()) {
			return KANCHAN;
		}
		if (aIndex == PENCHAN.toIndex()) {
			return PENCHAN;
		}
		if (aIndex == TANKI.toIndex()) {
			return TANKI;
		}
		if (aIndex == NA.toIndex()) {
			return NA;
		}
		return NA;
	}
}
