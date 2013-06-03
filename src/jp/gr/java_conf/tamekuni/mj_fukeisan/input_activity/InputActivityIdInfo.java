package jp.gr.java_conf.tamekuni.mj_fukeisan.input_activity;

import jp.gr.java_conf.tamekuni.mj_fukeisan.R;
import jp.gr.java_conf.tamekuni.mj_fukeisan.info_data.IdInfoAgari;
import jp.gr.java_conf.tamekuni.mj_fukeisan.info_data.IdInfoJyanto;
import jp.gr.java_conf.tamekuni.mj_fukeisan.info_data.IdInfoMachi;
import jp.gr.java_conf.tamekuni.mj_fukeisan.info_data.IdInfoMentsu;
import jp.gr.java_conf.tamekuni.mj_fukeisan.info_data.IdInfoYaku;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

public class InputActivityIdInfo {

	private final IdInfoYaku mInfoYaku;
	private final IdInfoMentsu mInfoMentsu;
	private final IdInfoJyanto mInfoJyanto;
	private final IdInfoMachi mInfoMachi;
	private final IdInfoAgari mInfoAgari;
	private final TextView mTextViewTotalFuId;
	private final Button mBtnParentPointId;
	private final Button mBtnChildPointId;
	private final Button mBtnClearId;

	public InputActivityIdInfo(final Activity aActivity) {
		mInfoYaku = new IdInfoYaku(aActivity);
		mInfoMentsu = new IdInfoMentsu(aActivity);
		mInfoJyanto = new IdInfoJyanto(aActivity);
		mInfoMachi = new IdInfoMachi(aActivity);
		mInfoAgari = new IdInfoAgari(aActivity);

		mTextViewTotalFuId = (TextView) aActivity
				.findViewById(R.id.textViewTotalFu);
		mBtnParentPointId = (Button) aActivity
				.findViewById(R.id.btnParentPoint);
		mBtnChildPointId = (Button) aActivity.findViewById(R.id.btnChildPoint);
		mBtnClearId = (Button) aActivity.findViewById(R.id.btnClear);
	}

	public IdInfoYaku getInfoYaku() {
		return mInfoYaku;
	}

	public IdInfoMentsu getInfoMentsu() {
		return mInfoMentsu;
	}

	public IdInfoJyanto getInfoJyanto() {
		return mInfoJyanto;
	}

	public IdInfoMachi getInfoMachi() {
		return mInfoMachi;
	}

	public IdInfoAgari getInfoAgari() {
		return mInfoAgari;
	}

	public TextView getTextViewTotalFuId() {
		return mTextViewTotalFuId;
	}

	public Button getBtnParentPointId() {
		return mBtnParentPointId;
	}

	public Button getBtnChildPointId() {
		return mBtnChildPointId;
	}

	public Button getBtnClearId() {
		return mBtnClearId;
	}

}
