package jp.gr.java_conf.tamekuni.fukeisan.image;

import jp.gr.java_conf.tamekuni.fukeisan.R;

public class ImageIdInfoMachi {

	private final int mRyanmenRId;
	private final int mShaboRId;
	private final int mKanchanRId;
	private final int mPenchanRId;
	private final int mTankiRId;
	private final int mNaRId;

	public ImageIdInfoMachi() {
		mRyanmenRId = R.drawable.ryanmen;
		mShaboRId = R.drawable.shabo;
		mKanchanRId = R.drawable.kanchan;
		mPenchanRId = R.drawable.penchan;
		mTankiRId = R.drawable.tanki;
		mNaRId = R.drawable.machi_na;
	}

	public int getRyanmenRId() {
		return mRyanmenRId;
	}

	public int getShaboRId() {
		return mShaboRId;
	}

	public int getKanchanRId() {
		return mKanchanRId;
	}

	public int getPenchanRId() {
		return mPenchanRId;
	}

	public int getTankiRId() {
		return mTankiRId;
	}

	public int getNaRId() {
		return mNaRId;
	}
}
