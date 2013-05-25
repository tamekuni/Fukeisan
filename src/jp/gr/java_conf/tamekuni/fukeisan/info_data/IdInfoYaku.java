package jp.gr.java_conf.tamekuni.fukeisan.info_data;

import jp.gr.java_conf.tamekuni.fukeisan.R;
import android.app.Activity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class IdInfoYaku {

	private final RadioGroup mRadioGrpYakuId;
	private final RadioButton mRadioYakuNormalId;
	private final RadioButton mRadioYakuPinfuId;
	private final RadioButton mRadioYakuChitoitsuId;

	private final int mRadioYakuNormalRId;
	private final int mRadioYakuPinfuRId;
	private final int mRadioYakuChitoitsuRId;

	public IdInfoYaku(final Activity aActivity) {
		mRadioGrpYakuId = (RadioGroup) aActivity
				.findViewById(R.id.radioGrpYaku);
		mRadioYakuNormalId = (RadioButton) aActivity
				.findViewById(R.id.radioYakuNormal);
		mRadioYakuPinfuId = (RadioButton) aActivity
				.findViewById(R.id.radioYakuPinfu);
		mRadioYakuChitoitsuId = (RadioButton) aActivity
				.findViewById(R.id.radioYakuChitoitsu);

		mRadioYakuNormalRId = R.id.radioYakuNormal;
		mRadioYakuPinfuRId = R.id.radioYakuPinfu;
		mRadioYakuChitoitsuRId = R.id.radioYakuChitoitsu;

	}

	public RadioGroup getRadioGrpYakuId() {
		return mRadioGrpYakuId;
	}

	public RadioButton getRadioYakuNormalId() {
		return mRadioYakuNormalId;
	}

	public RadioButton getRadioYakuPinfuId() {
		return mRadioYakuPinfuId;
	}

	public RadioButton getRadioYakuChitoitsuId() {
		return mRadioYakuChitoitsuId;
	}

	public RadioButton getmRadioYakuPinfuId() {
		return mRadioYakuPinfuId;
	}

	public int getRadioYakuNormalRId() {
		return mRadioYakuNormalRId;
	}

	public int getRadioYakuPinfuRId() {
		return mRadioYakuPinfuRId;
	}

	public int getRadioYakuChitoitsuRId() {
		return mRadioYakuChitoitsuRId;
	}
	
}
