package jp.gr.java_conf.tamekuni.mj_fukeisan.info_data;

import jp.gr.java_conf.tamekuni.mj_fukeisan.R;
import android.app.Activity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class IdInfoJyanto {

	private final TextView mTextViewJyantoFuId;
	private final RadioGroup mRadioGrpJyantoId;
	private final RadioButton mRadioJyantoRenpuhaiId;
	private final RadioButton mRadioJyantoYakuhaiId;
	private final RadioButton mRadioJyantoOtherId;

	private final int mRadioJyantoRenpuhaiRId;
	private final int mRadioJyantoYakuhaiRId;
	private final int mRadioJyantoOtherRId;

	public IdInfoJyanto(final Activity aActivity) {

		mTextViewJyantoFuId = (TextView) aActivity
				.findViewById(R.id.textViewJyantoFu);
		mRadioGrpJyantoId = (RadioGroup) aActivity
				.findViewById(R.id.radioGrpJyanto);
		mRadioJyantoRenpuhaiId = (RadioButton) aActivity
				.findViewById(R.id.radioJyantoRenpuhai);
		mRadioJyantoYakuhaiId = (RadioButton) aActivity
				.findViewById(R.id.radioJyantoYakuhai);
		mRadioJyantoOtherId = (RadioButton) aActivity
				.findViewById(R.id.radioJyantoOther);

		mRadioJyantoRenpuhaiRId = R.id.radioJyantoRenpuhai;
		mRadioJyantoYakuhaiRId = R.id.radioJyantoYakuhai;
		mRadioJyantoOtherRId = R.id.radioJyantoOther;

	}

	public int getRadioJyantoRenpuhaiRId() {
		return mRadioJyantoRenpuhaiRId;
	}

	public int getRadioJyantoYakuhaiRId() {
		return mRadioJyantoYakuhaiRId;
	}

	public int getRadioJyantoOtherRId() {
		return mRadioJyantoOtherRId;
	}

	public TextView getTextViewJyantoFuId() {
		return mTextViewJyantoFuId;
	}

	public RadioGroup getRadioGrpJyantoId() {
		return mRadioGrpJyantoId;
	}

	public RadioButton getRadioJyantoRenpuhaiId() {
		return mRadioJyantoRenpuhaiId;
	}

	public RadioButton getRadioJyantoYakuhaiId() {
		return mRadioJyantoYakuhaiId;
	}

	public RadioButton getRadioJyantoOtherId() {
		return mRadioJyantoOtherId;
	}

}
