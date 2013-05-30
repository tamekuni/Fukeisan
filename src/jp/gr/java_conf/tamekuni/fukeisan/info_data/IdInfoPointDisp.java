package jp.gr.java_conf.tamekuni.fukeisan.info_data;

import jp.gr.java_conf.tamekuni.fukeisan.R;
import android.app.Activity;
import android.widget.TextView;

public class IdInfoPointDisp {

	private final TextView mTextViewPointInfoId;

	private final TextView mTextView1hanId;
	private final TextView mTextView2hanId;
	private final TextView mTextView3hanId;
	private final TextView mTextView4hanId;

	private final TextView mTextViewManganId;
	private final TextView mTextViewHanemanId;
	private final TextView mTextViewBaimanId;
	private final TextView mTextViewSanbaimanId;
	private final TextView mTextViewYakumanId;

	public IdInfoPointDisp(Activity aActivity) {
		mTextViewPointInfoId = (TextView) aActivity
				.findViewById(R.id.textViewPointInfo);

		mTextView1hanId = (TextView) aActivity.findViewById(R.id.textView1han);
		mTextView2hanId = (TextView) aActivity.findViewById(R.id.textView2han);
		mTextView3hanId = (TextView) aActivity.findViewById(R.id.textView3han);
		mTextView4hanId = (TextView) aActivity.findViewById(R.id.textView4han);

		mTextViewManganId = (TextView) aActivity
				.findViewById(R.id.textViewMangan);
		mTextViewHanemanId = (TextView) aActivity
				.findViewById(R.id.textViewHaneman);
		mTextViewBaimanId = (TextView) aActivity
				.findViewById(R.id.textViewBaiman);
		mTextViewSanbaimanId = (TextView) aActivity
				.findViewById(R.id.textViewSanbaiman);
		mTextViewYakumanId = (TextView) aActivity
				.findViewById(R.id.textViewYakuman);
	}

	public TextView getTextViewPointInfoId() {
		return mTextViewPointInfoId;
	}

	public TextView getTextView1hanId() {
		return mTextView1hanId;
	}

	public TextView getTextView2hanId() {
		return mTextView2hanId;
	}

	public TextView getTextView3hanId() {
		return mTextView3hanId;
	}

	public TextView getTextView4hanId() {
		return mTextView4hanId;
	}

	public TextView getTextViewManganId() {
		return mTextViewManganId;
	}

	public TextView getTextViewHanemanId() {
		return mTextViewHanemanId;
	}

	public TextView getTextViewBaimanId() {
		return mTextViewBaimanId;
	}

	public TextView getTextViewSanbaimanId() {
		return mTextViewSanbaimanId;
	}

	public TextView getTextViewYakumanId() {
		return mTextViewYakumanId;
	}

}
