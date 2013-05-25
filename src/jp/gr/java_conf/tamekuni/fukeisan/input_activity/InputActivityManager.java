package jp.gr.java_conf.tamekuni.fukeisan.input_activity;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import jp.gr.java_conf.tamekuni.fukeisan.image.ImageIdManager;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Agari;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Jyanto;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Machi;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Mentsu;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Yaku;

public class InputActivityManager implements InputActivityManagerIF {

	private FukeisanInfo mCur;
	private final FukeisanInfo mNormalYaku;
	private final FukeisanInfo mPinfu;
	private final FukeisanInfo mChitoitsu;
	private final InputActivityIdInfo mIdInfo;
	private final ImageIdManager mImgId;

	public InputActivityManager(InputActivityIdInfo aIdInfo) {
		mNormalYaku = new FukeisanInfo(Yaku.NORMAL);
		mPinfu = new FukeisanInfo(Yaku.PINFU);
		mChitoitsu = new FukeisanInfo(Yaku.CHITOITSU);
		mImgId = new ImageIdManager();
		mIdInfo = aIdInfo;
		selectYakutype(Yaku.NORMAL, true);
	}

	@Override
	public void selectYakutype(Yaku aYaku, boolean aIsRefUi) {
		switch (aYaku) {
		case PINFU:
			mCur = mPinfu;
			break;

		case CHITOITSU:
			mCur = mChitoitsu;
			break;

		case NORMAL:
		default:
			mCur = mNormalYaku;
			break;
		}
		if (aIsRefUi) {
			reflectUiAll();
		}
	}

	@Override
	public Yaku getCurYakutype() {
		return mCur.getYakuType();
	}

	@Override
	public Mentsu getCurMentsu1() {
		return mCur.getMentsu1();
	}

	@Override
	public Mentsu getCurMentsu2() {
		return mCur.getMentsu2();
	}

	@Override
	public Mentsu getCurMentsu3() {
		return mCur.getMentsu3();
	}

	@Override
	public Mentsu getCurMentsu4() {
		return mCur.getMentsu4();
	}

	@Override
	public Jyanto getCurJyanto() {
		return mCur.getJyanto();
	}

	@Override
	public Machi getCurMachi() {
		return mCur.getMachi();
	}

	@Override
	public Agari getCurAgari() {
		return mCur.getAgari();
	}

	@Override
	public void setCurMentsu(Mentsu aMentsu1, Mentsu aMentsu2, Mentsu aMentsu3,
			Mentsu aMentsu4, boolean aIsRefUi) {

		Yaku yaku = getCurYakutype();

		switch (yaku) {
		case NORMAL:
			mCur.setMentsu1(aMentsu1);
			mCur.setMentsu2(aMentsu2);
			mCur.setMentsu3(aMentsu3);
			mCur.setMentsu4(aMentsu4);
			break;

		default:
			break;
		}

		if (aIsRefUi) {
			reflectUiMentsu();
		}
		calcTotalFu(aIsRefUi);
	}

	@Override
	public void setCurJyanto(Jyanto aJyanto, boolean aIsRefUi) {
		Yaku yaku = getCurYakutype();

		switch (yaku) {
		case NORMAL:
			mCur.setJyanto(aJyanto);
			break;

		default:
			break;
		}

		if (aIsRefUi) {
			reflectUiJyanto();
		}
		calcTotalFu(aIsRefUi);
	}

	@Override
	public void setCurMachi(Machi aMachi, boolean aIsRefUi) {
		Yaku yaku = getCurYakutype();

		switch (yaku) {
		case NORMAL:
			mCur.setMachi(aMachi);
			break;
		default:
			break;
		}

		if (aIsRefUi) {
			reflectUiMachi();
		}
		calcTotalFu(aIsRefUi);
	}

	@Override
	public void setCurAgari(Agari aAgari, boolean aIsRefUi) {
		Yaku yaku = getCurYakutype();

		switch (yaku) {
		case PINFU:
		case CHITOITSU:
			if (aAgari == Agari.TSUMO) {
				mCur.setAgari(Agari.TSUMO);
			} else {
				mCur.setAgari(Agari.MENZEN_RON);
			}
			break;

		case NORMAL:
		default:
			mCur.setAgari(aAgari);
			break;
		}
		if (aIsRefUi) {
			reflectUiAgari();
		}
		calcTotalFu(aIsRefUi);
	}

	@Override
	public void reflectUiAll() {
		reflectUiYakutype();
		reflectUiMentsu();
		reflectUiJyanto();
		reflectUiMachi();
		reflectUiAgari();
		calcTotalFu(true);
	}

	@Override
	public void clear() {
		selectYakutype(Yaku.NORMAL, false);
		setCurMentsu(Mentsu.NA, Mentsu.NA, Mentsu.NA, Mentsu.NA, false);
		setCurJyanto(Jyanto.OTHER, false);
		setCurMachi(Machi.NA, false);
		setCurAgari(Agari.TSUMO, false);

		selectYakutype(Yaku.PINFU, false);
		setCurAgari(Agari.TSUMO, false);

		selectYakutype(Yaku.CHITOITSU, false);
		setCurAgari(Agari.TSUMO, false);

		selectYakutype(Yaku.NORMAL, false);
		reflectUiAll();
	}

	private void reflectUiYakutype() {
		Yaku yaku = getCurYakutype();
		RadioGroup rgYaku = mIdInfo.getInfoYaku().getRadioGrpYakuId();
		Button btnMentsu = mIdInfo.getInfoMentsu().getBtnMentsuSelectId();
		RadioButton rbRenpuhai = mIdInfo.getInfoJyanto()
				.getRadioJyantoRenpuhaiId();
		RadioButton rbYakuhai = mIdInfo.getInfoJyanto()
				.getRadioJyantoYakuhaiId();
		RadioButton rbOther = mIdInfo.getInfoJyanto().getRadioJyantoOtherId();
		Button btnMachi = mIdInfo.getInfoMachi().getBtnMachiSelectId();
		RadioButton rbTsumo = mIdInfo.getInfoAgari().getRadioAgariTsumoId();
		RadioButton rbMenZenRon = mIdInfo.getInfoAgari()
				.getRadioAgariMenzenRonId();
		RadioButton rbFuroRon = mIdInfo.getInfoAgari().getRadioAgariFuroRonId();

		rgYaku.clearCheck();

		switch (yaku) {
		case PINFU:
			rgYaku.check(mIdInfo.getInfoYaku().getRadioYakuPinfuRId());
			btnMentsu.setEnabled(false);
			rbRenpuhai.setEnabled(false);
			rbYakuhai.setEnabled(false);
			rbOther.setEnabled(false);
			btnMachi.setEnabled(false);
			rbTsumo.setEnabled(true);
			rbMenZenRon.setEnabled(true);
			rbFuroRon.setEnabled(false);
			break;

		case CHITOITSU:
			rgYaku.check(mIdInfo.getInfoYaku().getRadioYakuChitoitsuRId());
			btnMentsu.setEnabled(false);
			rbRenpuhai.setEnabled(false);
			rbYakuhai.setEnabled(false);
			rbOther.setEnabled(false);
			btnMachi.setEnabled(false);
			rbTsumo.setEnabled(true);
			rbMenZenRon.setEnabled(true);
			rbFuroRon.setEnabled(false);
			break;

		case NORMAL:
		default:
			rgYaku.check(mIdInfo.getInfoYaku().getRadioYakuNormalRId());
			btnMentsu.setEnabled(true);
			rbRenpuhai.setEnabled(true);
			rbYakuhai.setEnabled(true);
			rbOther.setEnabled(true);
			btnMachi.setEnabled(true);
			rbTsumo.setEnabled(true);
			rbMenZenRon.setEnabled(true);
			rbFuroRon.setEnabled(true);
			break;
		}
	}

	private void reflectUiMentsu() {
		TextView tvMentsu1Fu = mIdInfo.getInfoMentsu().getTextViewMentsu1FuId();
		TextView tvMentsu2Fu = mIdInfo.getInfoMentsu().getTextViewMentsu2FuId();
		TextView tvMentsu3Fu = mIdInfo.getInfoMentsu().getTextViewMentsu3FuId();
		TextView tvMentsu4Fu = mIdInfo.getInfoMentsu().getTextViewMentsu4FuId();

		ImageView imgvMentsu1 = mIdInfo.getInfoMentsu()
				.getImageViewMentsu1TypeId();
		ImageView imgvMentsu2 = mIdInfo.getInfoMentsu()
				.getImageViewMentsu2TypeId();
		ImageView imgvMentsu3 = mIdInfo.getInfoMentsu()
				.getImageViewMentsu3TypeId();
		ImageView imgvMentsu4 = mIdInfo.getInfoMentsu()
				.getImageViewMentsu4TypeId();

		TextView tvMentsu1Type = mIdInfo.getInfoMentsu()
				.getTextViewMentsu1TypeId();
		TextView tvMentsu2Type = mIdInfo.getInfoMentsu()
				.getTextViewMentsu2TypeId();
		TextView tvMentsu3Type = mIdInfo.getInfoMentsu()
				.getTextViewMentsu3TypeId();
		TextView tvMentsu4Type = mIdInfo.getInfoMentsu()
				.getTextViewMentsu4TypeId();

		tvMentsu1Fu.setText(String.valueOf(mCur.getMentsu1().toPoint()));
		tvMentsu2Fu.setText(String.valueOf(mCur.getMentsu2().toPoint()));
		tvMentsu3Fu.setText(String.valueOf(mCur.getMentsu3().toPoint()));
		tvMentsu4Fu.setText(String.valueOf(mCur.getMentsu4().toPoint()));

		imgvMentsu1.setImageResource(mImgId.getImageRId(mCur.getMentsu1()));
		imgvMentsu2.setImageResource(mImgId.getImageRId(mCur.getMentsu2()));
		imgvMentsu3.setImageResource(mImgId.getImageRId(mCur.getMentsu3()));
		imgvMentsu4.setImageResource(mImgId.getImageRId(mCur.getMentsu4()));

		tvMentsu1Type.setText(mCur.getMentsu1().toString());
		tvMentsu2Type.setText(mCur.getMentsu2().toString());
		tvMentsu3Type.setText(mCur.getMentsu3().toString());
		tvMentsu4Type.setText(mCur.getMentsu4().toString());

		// 鳴きメンツがある場合は門前ロンできないようにする。
		// すべて門前メンツの場合は副露ロンできないようにする。

		final RadioGroup rgAgari = mIdInfo.getInfoAgari().getRadioGrpAgariId();
		final RadioButton furoRon = mIdInfo.getInfoAgari()
				.getRadioAgariFuroRonId();
		final RadioButton menzenRon = mIdInfo.getInfoAgari()
				.getRadioAgariMenzenRonId();
		final int furoRonRId = mIdInfo.getInfoAgari().getRadioAgariFuroRonRId();
		final int menzenRonRId = mIdInfo.getInfoAgari()
				.getRadioAgariMenzenRonRId();

		Yaku yaku = getCurYakutype();

		switch (yaku) {
		case NORMAL:
			if (isFuroCheck(mCur.getMentsu1())
					|| isFuroCheck(mCur.getMentsu2())
					|| isFuroCheck(mCur.getMentsu3())
					|| isFuroCheck(mCur.getMentsu4())) {

				menzenRon.setEnabled(false);
				furoRon.setEnabled(true);

				if (rgAgari.getCheckedRadioButtonId() == menzenRonRId) {
					setCurAgari(Agari.FURO_RON, true);
				}

			} else if (isMenzenCheck(mCur.getMentsu1())
					&& isMenzenCheck(mCur.getMentsu2())
					&& isMenzenCheck(mCur.getMentsu3())
					&& isMenzenCheck(mCur.getMentsu4())) {

				menzenRon.setEnabled(true);
				furoRon.setEnabled(false);

				if (rgAgari.getCheckedRadioButtonId() == furoRonRId) {
					setCurAgari(Agari.MENZEN_RON, true);
				}

			} else {
				menzenRon.setEnabled(true);
				furoRon.setEnabled(true);
			}
			break;

		default:
			break;
		}
	}

	private boolean isFuroCheck(Mentsu aMentsu) {
		if (aMentsu == Mentsu.MINKAN_CHUNCHAN
				|| aMentsu == Mentsu.MINKAN_YAOCHU
				|| aMentsu == Mentsu.MINKO_CHUNCHAN
				|| aMentsu == Mentsu.MINKO_YAOCHU) {
			return true;
		}
		return false;
	}

	private boolean isMenzenCheck(Mentsu aMentsu) {
		if (aMentsu == Mentsu.ANKAN_CHUNCHAN || aMentsu == Mentsu.ANKAN_YAOCHU
				|| aMentsu == Mentsu.ANKO_CHUNCHAN
				|| aMentsu == Mentsu.ANKO_YAOCHU) {
			return true;
		}
		return false;
	}

	private void reflectUiJyanto() {
		RadioGroup rg = mIdInfo.getInfoJyanto().getRadioGrpJyantoId();
		TextView tvFu = mIdInfo.getInfoJyanto().getTextViewJyantoFuId();

		rg.clearCheck();

		switch (mCur.getJyanto()) {
		case RENPUHAI:
			rg.check(mIdInfo.getInfoJyanto().getRadioJyantoRenpuhaiRId());
			break;

		case YAKUHAI:
			rg.check(mIdInfo.getInfoJyanto().getRadioJyantoYakuhaiRId());
			break;

		case OTHER:
		default:
			rg.check(mIdInfo.getInfoJyanto().getRadioJyantoOtherRId());
			break;
		}
		tvFu.setText(String.valueOf(mCur.getJyanto().toPoint()));
	}

	private void reflectUiMachi() {

		TextView tvMachiFu = mIdInfo.getInfoMachi().getTextViewMachiFuId();
		ImageView imgvMachi = mIdInfo.getInfoMachi().getImageViewMachiTypeId();
		TextView tvMachiType = mIdInfo.getInfoMachi().getTextViewMachiTypeId();

		tvMachiFu.setText(String.valueOf(mCur.getMachi().toPoint()));
		imgvMachi.setImageResource(mImgId.getImageRId(mCur.getMachi()));
		tvMachiType.setText(mCur.getMachi().toString());
	}

	private void reflectUiAgari() {
		Yaku yaku = getCurYakutype();
		Agari agari = mCur.getAgari();
		RadioGroup rg = mIdInfo.getInfoAgari().getRadioGrpAgariId();
		TextView tvFu = mIdInfo.getInfoAgari().getTextViewAgariFuId();

		rg.clearCheck();

		switch (agari) {
		case FURO_RON:
			rg.check(mIdInfo.getInfoAgari().getRadioAgariFuroRonRId());
			break;

		case MENZEN_RON:
			rg.check(mIdInfo.getInfoAgari().getRadioAgariMenzenRonRId());
			break;

		case TSUMO:
		default:
			rg.check(mIdInfo.getInfoAgari().getRadioAgariTsumoRId());
			break;
		}

		// 平和ツモと七対子は上がり符を0とする。
		if (((yaku == Yaku.PINFU) && (agari == Agari.TSUMO))
				|| (yaku == Yaku.CHITOITSU)) {
			tvFu.setText(String.valueOf(0));
		} else {
			tvFu.setText(String.valueOf(mCur.getAgari().toPoint()));
		}
	}

	private void reflectUiTotalFu() {
		TextView tv = mIdInfo.getTextViewTotalFuId();
		tv.setText(String.valueOf(mCur.getTotalFu()));
	}

	private void calcTotalFu(boolean aIsRefUi) {
		Yaku yaku = getCurYakutype();

		switch (yaku) {
		case PINFU:
			if (mCur.getAgari() == Agari.TSUMO) {
				mCur.setTotalFu(FukeisanInfo.FUTE);
			} else {
				mCur.setTotalFu(FukeisanInfo.FUTE + Agari.MENZEN_RON.toPoint());
			}
			break;

		case CHITOITSU:
			mCur.setTotalFu(FukeisanInfo.CHITOITSU_FU);
			break;

		case NORMAL:
		default:
			int total = 0;
			total = FukeisanInfo.FUTE + mCur.getMentsu1().toPoint()
					+ mCur.getMentsu2().toPoint() + mCur.getMentsu3().toPoint()
					+ mCur.getMentsu4().toPoint() + mCur.getJyanto().toPoint()
					+ mCur.getMachi().toPoint() + mCur.getAgari().toPoint();
			if (total == FukeisanInfo.FUTE) {
				total = 30;
			}
			mCur.setTotalFu(total);
			break;
		}
		if (aIsRefUi) {
			reflectUiTotalFu();
		}
	}
}
