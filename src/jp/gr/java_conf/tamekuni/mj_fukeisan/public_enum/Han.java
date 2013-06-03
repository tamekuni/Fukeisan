package jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum;

public enum Han {
	HAN1(0, "1翻"), HAN2(1, "2翻"), HAN3(2, "3翻"), HAN4(3, "4翻"), MANGAN(4, "5翻"), HANEMAN(
			5, "6～7翻"), BAIMAN(6, "8～10翻"), SANBAIMAN(7, "11～12翻"), YAKUMAN(8,
			"13翻～");

	private int mIndex;
	private String mString;
	private static int MANGAN_INDEX = 4;

	Han(int aIndex, String aString) {
		mIndex = aIndex;
		mString = aString;
	}

	public int toIndex() {
		if (mIndex >= MANGAN_INDEX) {
			return mIndex - MANGAN_INDEX;
		}

		return mIndex;
	}

	public String toString() {
		return mString;
	}
}
