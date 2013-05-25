package jp.gr.java_conf.tamekuni.fukeisan.select_activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import jp.gr.java_conf.tamekuni.fukeisan.image.ImageIdManager;
import jp.gr.java_conf.tamekuni.fukeisan.info_data.IdInfoMentsu;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Mentsu;

public class MentsuSelectActivityManager implements
		MentsuSelectActivityManagerIF {

	private final IdInfoMentsu mIdInfo;
	private final ImageIdManager mImgId;
	private List<Mentsu> mStack;
	private int mStackCounter;

	public MentsuSelectActivityManager(Activity aActivity) {
		mIdInfo = new IdInfoMentsu(aActivity);
		mImgId = new ImageIdManager();
		mStack = new ArrayList<Mentsu>(STACK_SIZE);
		for (int i = 0; i < STACK_SIZE; i++) {
			mStack.add(Mentsu.NA);
		}
		mStackCounter = 0;
	}

	@Override
	public void initStackData(Mentsu aMentsu1, Mentsu aMentsu2,
			Mentsu aMentsu3, Mentsu aMentsu4) {

		mStack.set(0, aMentsu1);
		mStack.set(1, aMentsu2);
		mStack.set(2, aMentsu3);
		mStack.set(3, aMentsu4);

		for (int i = 0; i < STACK_SIZE; i++) {
			if (mStack.get(i) == Mentsu.NA) {
				mStackCounter = i;
				break;
			}
		}

		if (mStack.get(STACK_SIZE - 1) != Mentsu.NA) {
			mStackCounter = STACK_SIZE;
		}

		reflectUiAll();
	}

	@Override
	public Mentsu getMentsu1() {
		return mStack.get(0);
	}

	@Override
	public Mentsu getMentsu2() {
		return mStack.get(1);
	}

	@Override
	public Mentsu getMentsu3() {
		return mStack.get(2);
	}

	@Override
	public Mentsu getMentsu4() {
		return mStack.get(3);
	}

	@Override
	public void push(Mentsu aMentsu) {
		if (mStackCounter >= STACK_SIZE) {
			mStack.set(STACK_SIZE - 1, aMentsu);
		} else {
			mStack.set(mStackCounter, aMentsu);
			mStackCounter++;
		}

		reflectUiAll();
	}

	@Override
	public Mentsu pop() {
		Mentsu ret;

		mStackCounter--;

		if (mStackCounter == -1) {
			mStackCounter = 0;
		}

		ret = mStack.get(mStackCounter);
		mStack.set(mStackCounter, Mentsu.NA);

		reflectUiAll();

		return ret;
	}

	private void reflectUiAll() {
		TextView tvMentsu1Fu = mIdInfo.getTextViewMentsu1FuId();
		TextView tvMentsu2Fu = mIdInfo.getTextViewMentsu2FuId();
		TextView tvMentsu3Fu = mIdInfo.getTextViewMentsu3FuId();
		TextView tvMentsu4Fu = mIdInfo.getTextViewMentsu4FuId();

		ImageView imgvMentsu1 = mIdInfo.getImageViewMentsu1TypeId();
		ImageView imgvMentsu2 = mIdInfo.getImageViewMentsu2TypeId();
		ImageView imgvMentsu3 = mIdInfo.getImageViewMentsu3TypeId();
		ImageView imgvMentsu4 = mIdInfo.getImageViewMentsu4TypeId();

		TextView tvMentsu1Type = mIdInfo.getTextViewMentsu1TypeId();
		TextView tvMentsu2Type = mIdInfo.getTextViewMentsu2TypeId();
		TextView tvMentsu3Type = mIdInfo.getTextViewMentsu3TypeId();
		TextView tvMentsu4Type = mIdInfo.getTextViewMentsu4TypeId();

		tvMentsu1Fu.setText(String.valueOf(getMentsu1().toPoint()));
		tvMentsu2Fu.setText(String.valueOf(getMentsu2().toPoint()));
		tvMentsu3Fu.setText(String.valueOf(getMentsu3().toPoint()));
		tvMentsu4Fu.setText(String.valueOf(getMentsu4().toPoint()));

		imgvMentsu1.setImageResource(mImgId.getImageRId(getMentsu1()));
		imgvMentsu2.setImageResource(mImgId.getImageRId(getMentsu2()));
		imgvMentsu3.setImageResource(mImgId.getImageRId(getMentsu3()));
		imgvMentsu4.setImageResource(mImgId.getImageRId(getMentsu4()));

		tvMentsu1Type.setText(getMentsu1().toString());
		tvMentsu2Type.setText(getMentsu2().toString());
		tvMentsu3Type.setText(getMentsu3().toString());
		tvMentsu4Type.setText(getMentsu4().toString());
	}

}
