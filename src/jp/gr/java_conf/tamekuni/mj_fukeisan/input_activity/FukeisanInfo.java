package jp.gr.java_conf.tamekuni.mj_fukeisan.input_activity;

import jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum.Agari;
import jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum.Jyanto;
import jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum.Machi;
import jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum.Mentsu;
import jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum.Yaku;

public class FukeisanInfo {

	private Yaku mYaku;
	private Mentsu mMentsu1;
	private Mentsu mMentsu2;
	private Mentsu mMentsu3;
	private Mentsu mMentsu4;
	private Jyanto mJyanto;
	private Machi mMachi;
	private Agari mAgari;
	private int mTotalFu;

	public static final int FUTE = 20;
	public static final int CHITOITSU_FU = 25;

	public FukeisanInfo(Yaku aYaku) {
		switch (aYaku) {
		case PINFU:
			mYaku = Yaku.PINFU;
			mMentsu1 = Mentsu.SHUNTSU;
			mMentsu2 = Mentsu.SHUNTSU;
			mMentsu3 = Mentsu.SHUNTSU;
			mMentsu4 = Mentsu.SHUNTSU;
			mJyanto = Jyanto.OTHER;
			mMachi = Machi.RYANMEN;
			mAgari = Agari.TSUMO;
			mTotalFu = FUTE;
			break;

		case CHITOITSU:
			mYaku = Yaku.CHITOITSU;
			mMentsu1 = Mentsu.NA;
			mMentsu2 = Mentsu.NA;
			mMentsu3 = Mentsu.NA;
			mMentsu4 = Mentsu.NA;
			mJyanto = Jyanto.OTHER;
			mMachi = Machi.NA;
			mAgari = Agari.TSUMO;
			mTotalFu = CHITOITSU_FU;
			break;

		case NORMAL:
		default:
			mYaku = Yaku.NORMAL;
			mMentsu1 = Mentsu.NA;
			mMentsu2 = Mentsu.NA;
			mMentsu3 = Mentsu.NA;
			mMentsu4 = Mentsu.NA;
			mJyanto = Jyanto.OTHER;
			mMachi = Machi.NA;
			mAgari = Agari.TSUMO;
			mTotalFu = FUTE;
			break;
		}
	}

	public Yaku getYakuType() {
		return mYaku;
	}

	public void setYakuType(Yaku aYaku) {
		mYaku = aYaku;
	}

	public Mentsu getMentsu1() {
		return mMentsu1;
	}

	public void setMentsu1(Mentsu aMentsu1) {
		mMentsu1 = aMentsu1;
	}

	public Mentsu getMentsu2() {
		return mMentsu2;
	}

	public void setMentsu2(Mentsu aMentsu2) {
		mMentsu2 = aMentsu2;
	}

	public Mentsu getMentsu3() {
		return mMentsu3;
	}

	public void setMentsu3(Mentsu aMentsu3) {
		mMentsu3 = aMentsu3;
	}

	public Mentsu getMentsu4() {
		return mMentsu4;
	}

	public void setMentsu4(Mentsu aMentsu4) {
		mMentsu4 = aMentsu4;
	}

	public Jyanto getJyanto() {
		return mJyanto;
	}

	public void setJyanto(Jyanto aJyanto) {
		mJyanto = aJyanto;
	}

	public Machi getMachi() {
		return mMachi;
	}

	public void setMachi(Machi aMachi) {
		mMachi = aMachi;
	}

	public Agari getAgari() {
		return mAgari;
	}

	public void setAgari(Agari aAgari) {
		mAgari = aAgari;
	}

	public int getTotalFu() {
		return mTotalFu;
	}

	public void setTotalFu(int aTotalFu) {
		mTotalFu = aTotalFu;
	}

}
