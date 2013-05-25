package jp.gr.java_conf.tamekuni.fukeisan.public_enum;

public enum Mentsu {
	SHUNTSU(0, 0, "順子"), MINKO_CHUNCHAN(1, 2, "明刻中張牌"), ANKO_CHUNCHAN(2, 4,
			"暗刻中張牌"), MINKAN_CHUNCHAN(3, 8, "明槓中張牌"), ANKAN_CHUNCHAN(4, 16,
			"暗槓中張牌"), MINKO_YAOCHU(5, 4, "明刻么九牌"), ANKO_YAOCHU(6, 8, "暗刻么九牌"), MINKAN_YAOCHU(
			7, 16, "明槓么九牌"), ANKAN_YAOCHU(8, 32, "暗槓么九牌"), NA(9, 0, "");

	private final int mIndex;
	private final int mPoint;
	private final String mString;

	Mentsu(int aIndex, int aPoint, String aString) {
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

	static public Mentsu toMentsu(int aIndex) {
		if (aIndex == SHUNTSU.toIndex()) {
			return SHUNTSU;
		}
		if (aIndex == MINKO_CHUNCHAN.toIndex()) {
			return MINKO_CHUNCHAN;
		}
		if (aIndex == ANKO_CHUNCHAN.toIndex()) {
			return ANKO_CHUNCHAN;
		}
		if (aIndex == MINKAN_CHUNCHAN.toIndex()) {
			return MINKAN_CHUNCHAN;
		}
		if (aIndex == ANKAN_CHUNCHAN.toIndex()) {
			return ANKAN_CHUNCHAN;
		}
		if (aIndex == MINKO_YAOCHU.toIndex()) {
			return MINKO_YAOCHU;
		}
		if (aIndex == ANKO_YAOCHU.toIndex()) {
			return ANKO_YAOCHU;
		}
		if (aIndex == MINKAN_YAOCHU.toIndex()) {
			return MINKAN_YAOCHU;
		}
		if (aIndex == ANKAN_YAOCHU.toIndex()) {
			return ANKAN_YAOCHU;
		}
		if (aIndex == NA.toIndex()) {
			return NA;
		}
		return NA;
	}
}
