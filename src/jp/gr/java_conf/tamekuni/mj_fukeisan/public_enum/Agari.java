package jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum;

public enum Agari {
	FURO_RON(0, 0), MENZEN_RON(1, 10), TSUMO(2, 2);

	private final int mPoint;
	private final int mIndex;

	Agari(int aIndex, int aPoint) {
		mPoint = aPoint;
		mIndex = aIndex;
	}

	public int toPoint() {
		return mPoint;
	}

	public int toIndex() {
		return mIndex;
	}

	static public Agari toAgari(int aIndex) {
		if (aIndex == FURO_RON.toIndex()) {
			return FURO_RON;
		}
		if (aIndex == MENZEN_RON.toIndex()) {
			return MENZEN_RON;
		}
		if (aIndex == TSUMO.toIndex()) {
			return TSUMO;
		}
		return TSUMO;
	}

}
