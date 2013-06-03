package jp.gr.java_conf.tamekuni.mj_fukeisan.info_data;

import jp.gr.java_conf.tamekuni.mj_fukeisan.R;
import android.app.Activity;
import android.widget.Button;
import android.widget.ImageButton;

public class IdInfoMentsuSelect {

	private final ImageButton mImgBtnShuntsuId;
	private final ImageButton mImgBtnMinkoChunchanId;
	private final ImageButton mImgBtnMinkoYaochuId;
	private final ImageButton mImgBtnAnkoChunchanId;
	private final ImageButton mImgBtnAnkoYaochuId;
	private final ImageButton mImgBtnMinkanChunchanId;
	private final ImageButton mImgBtnMinKanYaochuId;
	private final ImageButton mImgBtnAnkanChunchanId;
	private final ImageButton mImgBtnAnkanYaochuId;
	private final Button mBtnOneDel;
	private final Button mBtnOk;

	public IdInfoMentsuSelect(Activity aActivity) {
		mImgBtnShuntsuId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnShuntsu);
		mImgBtnMinkoChunchanId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnMinkoChunchan);
		mImgBtnMinkoYaochuId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnMinkoYaochu);
		mImgBtnAnkoChunchanId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnAnkoChunchan);
		mImgBtnAnkoYaochuId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnAnkoYaochu);
		mImgBtnMinkanChunchanId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnMinkanChunchan);
		mImgBtnMinKanYaochuId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnMinkanYaochu);
		mImgBtnAnkanChunchanId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnAnkanChunchan);
		mImgBtnAnkanYaochuId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnAnkanYaochu);
		mBtnOneDel = (Button) aActivity.findViewById(R.id.btnOneDel);
		mBtnOk = (Button) aActivity.findViewById(R.id.btnOk);

	}

	public ImageButton getImgBtnShuntsuId() {
		return mImgBtnShuntsuId;
	}

	public ImageButton getImgBtnMinkoChunchanId() {
		return mImgBtnMinkoChunchanId;
	}

	public ImageButton getImgBtnMinkoYaochuId() {
		return mImgBtnMinkoYaochuId;
	}

	public ImageButton getImgBtnAnkoChunchanId() {
		return mImgBtnAnkoChunchanId;
	}

	public ImageButton getImgBtnAnkoYaochuId() {
		return mImgBtnAnkoYaochuId;
	}

	public ImageButton getImgBtnMinkanChunchanId() {
		return mImgBtnMinkanChunchanId;
	}

	public ImageButton getImgBtnMinKanYaochuId() {
		return mImgBtnMinKanYaochuId;
	}

	public ImageButton getImgBtnAnkanChunchanId() {
		return mImgBtnAnkanChunchanId;
	}

	public ImageButton getImgBtnAnkanYaochuId() {
		return mImgBtnAnkanYaochuId;
	}

	public Button getBtnOneDel() {
		return mBtnOneDel;
	}

	public Button getBtnOk() {
		return mBtnOk;
	}

}
