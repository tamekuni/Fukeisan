package jp.gr.java_conf.tamekuni.fukeisan.public_enum;

public enum Yaku {
	NORMAL(0), PINFU(1), CHITOITSU(2);

	private final int mIndex;

	Yaku(int aIndex) {
		mIndex = aIndex;
	}

	public int toIndex() {
		return mIndex;
	}

	static public Yaku toYaku(int aIndex) {
		if (aIndex == NORMAL.toIndex()) {
			return NORMAL;
		}
		if (aIndex == PINFU.toIndex()) {
			return PINFU;
		}
		if (aIndex == CHITOITSU.toIndex()) {
			return CHITOITSU;
		}
		return NORMAL;
	}
}
