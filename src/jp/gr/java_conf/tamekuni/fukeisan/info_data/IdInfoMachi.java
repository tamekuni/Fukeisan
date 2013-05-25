package jp.gr.java_conf.tamekuni.fukeisan.info_data;

import jp.gr.java_conf.tamekuni.fukeisan.R;
import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IdInfoMachi {

	private final Button mBtnMachiSelectId;
	private final TextView mTextViewMachiFuId;
	private final ImageView mImageViewMachiTypeId;
	private final TextView mTextViewMachiTypeId;

	public IdInfoMachi(final Activity aActivity) {
		mBtnMachiSelectId = (Button) aActivity
				.findViewById(R.id.btnMachiSelect);
		mTextViewMachiFuId = (TextView) aActivity
				.findViewById(R.id.textViewMachiFu);
		mImageViewMachiTypeId = (ImageView) aActivity
				.findViewById(R.id.imageViewMachiType);
		mTextViewMachiTypeId = (TextView) aActivity
				.findViewById(R.id.textViewMachiType);
	}

	public Button getBtnMachiSelectId() {
		return mBtnMachiSelectId;
	}

	public TextView getTextViewMachiFuId() {
		return mTextViewMachiFuId;
	}

	public ImageView getImageViewMachiTypeId() {
		return mImageViewMachiTypeId;
	}

	public TextView getTextViewMachiTypeId() {
		return mTextViewMachiTypeId;
	}

}
