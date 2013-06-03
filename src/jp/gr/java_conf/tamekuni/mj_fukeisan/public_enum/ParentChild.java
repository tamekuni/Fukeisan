package jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum;

public enum ParentChild {
	PARENT(0, "親"), CHILD(1, "子");

	private final String mString;
	private final int mIndex;

	ParentChild(int aIndex, String aString) {
		mString = aString;
		mIndex = aIndex;
	}

	public String toString() {
		return mString;
	}

	public int toIndex() {
		return mIndex;
	}

	static public ParentChild toParentChild(int aIndex) {
		if (aIndex == PARENT.toIndex()) {
			return PARENT;
		}
		if (aIndex == CHILD.toIndex()) {
			return CHILD;
		}

		return PARENT;
	}

}
