package jp.gr.java_conf.tamekuni.mj_fukeisan.info_data;

import jp.gr.java_conf.tamekuni.mj_fukeisan.R;
import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IdInfoMentsu {

	private final Button mBtnMentsuSelectId;

	private final TextView mTextViewMentsu1FuId;
	private final ImageView mImageViewMentsu1TypeId;
	private final TextView mTextViewMentsu1TypeId;

	private final TextView mTextViewMentsu2FuId;
	private final ImageView mImageViewMentsu2TypeId;
	private final TextView mTextViewMentsu2TypeId;

	private final TextView mTextViewMentsu3FuId;
	private final ImageView mImageViewMentsu3TypeId;
	private final TextView mTextViewMentsu3TypeId;

	private final TextView mTextViewMentsu4FuId;
	private final ImageView mImageViewMentsu4TypeId;
	private final TextView mTextViewMentsu4TypeId;

	public IdInfoMentsu(final Activity aActivity) {

		mBtnMentsuSelectId = (Button) aActivity
				.findViewById(R.id.btnMentsuSelect);

		mTextViewMentsu1FuId = (TextView) aActivity
				.findViewById(R.id.textViewMentsu1Fu);
		mImageViewMentsu1TypeId = (ImageView) aActivity
				.findViewById(R.id.imageViewMentsu1Type);
		mTextViewMentsu1TypeId = (TextView) aActivity
				.findViewById(R.id.textViewMentsu1Type);

		mTextViewMentsu2FuId = (TextView) aActivity
				.findViewById(R.id.textViewMentsu2Fu);
		mImageViewMentsu2TypeId = (ImageView) aActivity
				.findViewById(R.id.imageViewMentsu2Type);
		mTextViewMentsu2TypeId = (TextView) aActivity
				.findViewById(R.id.textViewMentsu2Type);

		mTextViewMentsu3FuId = (TextView) aActivity
				.findViewById(R.id.textViewMentsu3Fu);
		mImageViewMentsu3TypeId = (ImageView) aActivity
				.findViewById(R.id.imageViewMentsu3Type);
		mTextViewMentsu3TypeId = (TextView) aActivity
				.findViewById(R.id.textViewMentsu3Type);

		mTextViewMentsu4FuId = (TextView) aActivity
				.findViewById(R.id.textViewMentsu4Fu);
		mImageViewMentsu4TypeId = (ImageView) aActivity
				.findViewById(R.id.imageViewMentsu4Type);
		mTextViewMentsu4TypeId = (TextView) aActivity
				.findViewById(R.id.textViewMentsu4Type);
	}

	public Button getBtnMentsuSelectId() {
		return mBtnMentsuSelectId;
	}

	public TextView getTextViewMentsu1FuId() {
		return mTextViewMentsu1FuId;
	}

	public ImageView getImageViewMentsu1TypeId() {
		return mImageViewMentsu1TypeId;
	}

	public TextView getTextViewMentsu1TypeId() {
		return mTextViewMentsu1TypeId;
	}

	public TextView getTextViewMentsu2FuId() {
		return mTextViewMentsu2FuId;
	}

	public ImageView getImageViewMentsu2TypeId() {
		return mImageViewMentsu2TypeId;
	}

	public TextView getTextViewMentsu2TypeId() {
		return mTextViewMentsu2TypeId;
	}

	public TextView getTextViewMentsu3FuId() {
		return mTextViewMentsu3FuId;
	}

	public ImageView getImageViewMentsu3TypeId() {
		return mImageViewMentsu3TypeId;
	}

	public TextView getTextViewMentsu3TypeId() {
		return mTextViewMentsu3TypeId;
	}

	public TextView getTextViewMentsu4FuId() {
		return mTextViewMentsu4FuId;
	}

	public ImageView getImageViewMentsu4TypeId() {
		return mImageViewMentsu4TypeId;
	}

	public TextView getTextViewMentsu4TypeId() {
		return mTextViewMentsu4TypeId;
	}

}
