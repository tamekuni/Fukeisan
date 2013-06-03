package jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum;

public enum Fu {
	FU20(0, "20符"), FU25(1, "25符"), FU30(2, "30符"), FU40(3, "40符"), FU50(4,
			"50符"), FU60(5, "60符"), FU70(6, "70符"), FU80(7, "80符"), FU90(8,
			"90符"), FU100(9, "100符"), FU110(10, "110符～");

	private int mIndex;
	private String mString;

	private Fu(int aIndex, String aString) {
		mIndex = aIndex;
		mString = aString;
	}

	public int toIndex() {
		return mIndex;
	}

	public String toString() {
		return mString;
	}

}
