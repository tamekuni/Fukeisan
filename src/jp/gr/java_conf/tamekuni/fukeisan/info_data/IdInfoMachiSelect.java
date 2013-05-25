package jp.gr.java_conf.tamekuni.fukeisan.info_data;

import jp.gr.java_conf.tamekuni.fukeisan.R;
import android.app.Activity;
import android.widget.Button;
import android.widget.ImageButton;

public class IdInfoMachiSelect {

	private final ImageButton mImgBtnRyanmenId;
	private final ImageButton mImgBtnShaboId;
	private final ImageButton mImgBtnKanchanId;
	private final ImageButton mImgBtnPenchanId;
	private final ImageButton mImgBtnTankiId;
	private final Button mBtnDel;
	private final Button mBtnOk;

	public IdInfoMachiSelect(Activity aActivity) {
		mImgBtnRyanmenId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnRyanmen);
		mImgBtnShaboId = (ImageButton) aActivity.findViewById(R.id.imgBtnShabo);
		mImgBtnKanchanId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnKanchan);
		mImgBtnPenchanId = (ImageButton) aActivity
				.findViewById(R.id.imgBtnPenchan);
		mImgBtnTankiId = (ImageButton) aActivity.findViewById(R.id.imgBtnTanki);
		mBtnDel = (Button) aActivity.findViewById(R.id.btnDel);
		mBtnOk = (Button) aActivity.findViewById(R.id.btnOk);
	}

	public ImageButton getImgBtnRyanmenId() {
		return mImgBtnRyanmenId;
	}

	public ImageButton getImgBtnShaboId() {
		return mImgBtnShaboId;
	}

	public ImageButton getImgBtnKanchanId() {
		return mImgBtnKanchanId;
	}

	public ImageButton getImgBtnPenchanId() {
		return mImgBtnPenchanId;
	}

	public ImageButton getImgBtnTankiId() {
		return mImgBtnTankiId;
	}

	public Button getBtnDel() {
		return mBtnDel;
	}

	public Button getBtnOk() {
		return mBtnOk;
	}
}
