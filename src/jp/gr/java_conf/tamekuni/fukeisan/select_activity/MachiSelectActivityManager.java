package jp.gr.java_conf.tamekuni.fukeisan.select_activity;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import jp.gr.java_conf.tamekuni.fukeisan.image.ImageIdManager;
import jp.gr.java_conf.tamekuni.fukeisan.info_data.IdInfoMachi;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Machi;

public class MachiSelectActivityManager implements MachiSelectActivityManagerIF {

	private final IdInfoMachi mIdInfo;
	private final ImageIdManager mImgId;
	private List<Machi> mStack;
	private int mStackCounter;

	public MachiSelectActivityManager(Activity aActivity) {
		mIdInfo = new IdInfoMachi(aActivity);
		mImgId = new ImageIdManager();
		mStack = new ArrayList<Machi>(STACK_SIZE);
		for (int i = 0; i < STACK_SIZE; i++) {
			mStack.add(Machi.NA);
		}
		mStackCounter = 0;
	}

	@Override
	public void initStackData(Machi aMachi) {
		mStack.set(0, aMachi);

		for (int i = 0; i < STACK_SIZE; i++) {
			if (mStack.get(i) == Machi.NA) {
				mStackCounter = i;
				break;
			}
		}

		if (mStack.get(STACK_SIZE - 1) != Machi.NA) {
			mStackCounter = STACK_SIZE;
		}

		reflectUiAll();
	}

	@Override
	public Machi getMachi() {
		return mStack.get(0);
	}

	@Override
	public void push(Machi aMachi) {
		if (mStackCounter >= STACK_SIZE) {
			mStack.set(STACK_SIZE - 1, aMachi);
		} else {
			mStack.set(mStackCounter, aMachi);
			mStackCounter++;
		}

		reflectUiAll();
	}

	@Override
	public Machi pop() {
		Machi ret;

		mStackCounter--;

		if (mStackCounter == -1) {
			mStackCounter = 0;
		}

		ret = mStack.get(mStackCounter);
		mStack.set(mStackCounter, Machi.NA);

		reflectUiAll();

		return ret;
	}

	private void reflectUiAll() {
		TextView tvMachiFu = mIdInfo.getTextViewMachiFuId();
		ImageView imgvMachi = mIdInfo.getImageViewMachiTypeId();
		TextView tvMachiType = mIdInfo.getTextViewMachiTypeId();

		tvMachiFu.setText(String.valueOf(getMachi().toPoint()));
		imgvMachi.setImageResource(mImgId.getImageRId(getMachi()));
		tvMachiType.setText(getMachi().toString());
	}
}
