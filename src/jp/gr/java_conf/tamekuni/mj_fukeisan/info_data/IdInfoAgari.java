package jp.gr.java_conf.tamekuni.mj_fukeisan.info_data;

import jp.gr.java_conf.tamekuni.mj_fukeisan.R;
import android.app.Activity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class IdInfoAgari {

	private final TextView mTextViewAgariFuId;
	private final RadioGroup mRadioGrpAgariId;
	private final RadioButton mRadioAgariFuroRonId;
	private final RadioButton mRadioAgariMenzenRonId;
	private final RadioButton mRadioAgariTsumoId;
	private final int mRadioAgariFuroRonRId;
	private final int mRadioAgariMenzenRonRId;
	private final int mRadioAgariTsumoRId;

	public IdInfoAgari(final Activity aActivity) {
		mTextViewAgariFuId = (TextView) aActivity
				.findViewById(R.id.textViewAgariFu);
		mRadioGrpAgariId = (RadioGroup) aActivity
				.findViewById(R.id.radioGrpAgari);
		mRadioAgariFuroRonId = (RadioButton) aActivity
				.findViewById(R.id.radioAgariFuroRon);
		mRadioAgariMenzenRonId = (RadioButton) aActivity
				.findViewById(R.id.radioAgariMenzenRon);
		mRadioAgariTsumoId = (RadioButton) aActivity
				.findViewById(R.id.radioAgariTsumo);

		mRadioAgariFuroRonRId = R.id.radioAgariFuroRon;
		mRadioAgariMenzenRonRId = R.id.radioAgariMenzenRon;
		mRadioAgariTsumoRId = R.id.radioAgariTsumo;

	}

	public int getRadioAgariFuroRonRId() {
		return mRadioAgariFuroRonRId;
	}

	public int getRadioAgariMenzenRonRId() {
		return mRadioAgariMenzenRonRId;
	}

	public int getRadioAgariTsumoRId() {
		return mRadioAgariTsumoRId;
	}

	public TextView getTextViewAgariFuId() {
		return mTextViewAgariFuId;
	}

	public RadioGroup getRadioGrpAgariId() {
		return mRadioGrpAgariId;
	}

	public RadioButton getRadioAgariFuroRonId() {
		return mRadioAgariFuroRonId;
	}

	public RadioButton getRadioAgariMenzenRonId() {
		return mRadioAgariMenzenRonId;
	}

	public RadioButton getRadioAgariTsumoId() {
		return mRadioAgariTsumoId;
	}

}
