package jp.gr.java_conf.tamekuni.mj_fukeisan;

import jp.gr.java_conf.tamekuni.mj_fukeisan.info_data.IdInfoMentsuSelect;
import jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum.Mentsu;
import jp.gr.java_conf.tamekuni.mj_fukeisan.select_activity.MentsuSelectActivityManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MentsuSelectActivity extends Activity {

	private MentsuSelectActivityManager mMSAMng;
	private IdInfoMentsuSelect mIdInfoSelect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mentsu_select);

		mMSAMng = new MentsuSelectActivityManager(this);
		mIdInfoSelect = new IdInfoMentsuSelect(this);

		// データを受け取る
		Intent data = getIntent();
		int mentsu1Index = data.getIntExtra("Mentsu1", Mentsu.NA.toIndex());
		int mentsu2Index = data.getIntExtra("Mentsu2", Mentsu.NA.toIndex());
		int mentsu3Index = data.getIntExtra("Mentsu3", Mentsu.NA.toIndex());
		int mentsu4Index = data.getIntExtra("Mentsu4", Mentsu.NA.toIndex());

		mMSAMng.initStackData(Mentsu.toMentsu(mentsu1Index),
				Mentsu.toMentsu(mentsu2Index), Mentsu.toMentsu(mentsu3Index),
				Mentsu.toMentsu(mentsu4Index));

		setListenerSelect();
		setListenerOneDel();
		setListenerOk();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		// 状態を保存
		outState.putInt("SaveDataMentsu1", mMSAMng.getMentsu1().toIndex());
		outState.putInt("SaveDataMentsu2", mMSAMng.getMentsu2().toIndex());
		outState.putInt("SaveDataMentsu3", mMSAMng.getMentsu3().toIndex());
		outState.putInt("SaveDataMentsu4", mMSAMng.getMentsu4().toIndex());
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		// 保存した状態を読み出す
		int mentsu1Index = savedInstanceState.getInt("SaveDataMentsu1",
				Mentsu.NA.toIndex());
		int mentsu2Index = savedInstanceState.getInt("SaveDataMentsu2",
				Mentsu.NA.toIndex());
		int mentsu3Index = savedInstanceState.getInt("SaveDataMentsu3",
				Mentsu.NA.toIndex());
		int mentsu4Index = savedInstanceState.getInt("SaveDataMentsu4",
				Mentsu.NA.toIndex());

		mMSAMng.initStackData(Mentsu.toMentsu(mentsu1Index),
				Mentsu.toMentsu(mentsu2Index), Mentsu.toMentsu(mentsu3Index),
				Mentsu.toMentsu(mentsu4Index));
	}

	private void setListenerSelect() {

		ImageButton imgBtnShuntsu = mIdInfoSelect.getImgBtnShuntsuId();
		ImageButton imgBtnMinkoChunchan = mIdInfoSelect
				.getImgBtnMinkoChunchanId();
		ImageButton imgBtnMinkoYaochu = mIdInfoSelect.getImgBtnMinkoYaochuId();
		ImageButton imgBtnAnkoChunchan = mIdInfoSelect
				.getImgBtnAnkoChunchanId();
		ImageButton imgBtnAnkoYaochu = mIdInfoSelect.getImgBtnAnkoYaochuId();
		ImageButton imgBtnMinkanChunchan = mIdInfoSelect
				.getImgBtnMinkanChunchanId();
		ImageButton imgBtnMinkanYaochu = mIdInfoSelect
				.getImgBtnMinKanYaochuId();
		ImageButton imgBtnAnkanChunchan = mIdInfoSelect
				.getImgBtnAnkanChunchanId();
		ImageButton imgBtnAnkanYaochu = mIdInfoSelect.getImgBtnAnkanYaochuId();

		imgBtnShuntsu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Mentsu.SHUNTSU);
			}
		});

		imgBtnMinkoChunchan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Mentsu.MINKO_CHUNCHAN);
			}
		});

		imgBtnMinkoYaochu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Mentsu.MINKO_YAOCHU);
			}
		});

		imgBtnAnkoChunchan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Mentsu.ANKO_CHUNCHAN);
			}
		});

		imgBtnAnkoYaochu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Mentsu.ANKO_YAOCHU);
			}
		});

		imgBtnMinkanChunchan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Mentsu.MINKAN_CHUNCHAN);
			}
		});

		imgBtnMinkanYaochu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Mentsu.MINKAN_YAOCHU);
			}
		});

		imgBtnAnkanChunchan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Mentsu.ANKAN_CHUNCHAN);
			}
		});

		imgBtnAnkanYaochu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Mentsu.ANKAN_YAOCHU);
			}
		});
	}

	private void setListenerOneDel() {

		Button btnOneDel = mIdInfoSelect.getBtnOneDel();

		btnOneDel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.pop();
			}
		});
	}

	private void setListenerOk() {
		//

		Button btnOk = mIdInfoSelect.getBtnOk();

		btnOk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();

				intent.putExtra("Mentsu1", mMSAMng.getMentsu1().toIndex());
				intent.putExtra("Mentsu2", mMSAMng.getMentsu2().toIndex());
				intent.putExtra("Mentsu3", mMSAMng.getMentsu3().toIndex());
				intent.putExtra("Mentsu4", mMSAMng.getMentsu4().toIndex());

				setResult(RESULT_OK, intent);
				finish();
			}
		});
	}
}
