package jp.gr.java_conf.tamekuni.mj_fukeisan;

import jp.gr.java_conf.tamekuni.mj_fukeisan.info_data.IdInfoMachiSelect;
import jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum.Machi;
import jp.gr.java_conf.tamekuni.mj_fukeisan.select_activity.MachiSelectActivityManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MachiSelectActivity extends Activity {

	private MachiSelectActivityManager mMSAMng;
	private IdInfoMachiSelect mIdInfoSelect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_machi_select);

		mMSAMng = new MachiSelectActivityManager(this);
		mIdInfoSelect = new IdInfoMachiSelect(this);

		// データを受け取る
		Intent data = getIntent();
		int machiIndex = data.getIntExtra("Machi", Machi.NA.toIndex());

		mMSAMng.initStackData(Machi.toMachi(machiIndex));

		setListenerSelect();
		setListenerDel();
		setListenerOk();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		// 状態を保存
		outState.putInt("SaveDataMachi", mMSAMng.getMachi().toIndex());
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		// 保存した状態を読み出す
		int machiIndex = savedInstanceState.getInt("SaveDataMachi",
				Machi.NA.toIndex());

		mMSAMng.initStackData(Machi.toMachi(machiIndex));
	}

	private void setListenerSelect() {

		ImageButton imgBtnRyanmen = mIdInfoSelect.getImgBtnRyanmenId();
		ImageButton imgBtnShabo = mIdInfoSelect.getImgBtnShaboId();
		ImageButton imgBtnKanchan = mIdInfoSelect.getImgBtnKanchanId();
		ImageButton imgBtnPenchan = mIdInfoSelect.getImgBtnPenchanId();
		ImageButton imgBtnTanki = mIdInfoSelect.getImgBtnTankiId();

		imgBtnRyanmen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Machi.RYANMEN);
			}
		});

		imgBtnShabo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Machi.SHABO);
			}
		});

		imgBtnKanchan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Machi.KANCHAN);
			}
		});

		imgBtnPenchan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Machi.PENCHAN);
			}
		});

		imgBtnTanki.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.push(Machi.TANKI);
			}
		});
	}

	private void setListenerDel() {
		Button btnDel = mIdInfoSelect.getBtnDel();
		btnDel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMSAMng.pop();
			}
		});
	}

	private void setListenerOk() {

		Button btnOk = mIdInfoSelect.getBtnOk();

		btnOk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("Machi", mMSAMng.getMachi().toIndex());
				setResult(RESULT_OK, intent);
				finish();
			}
		});
	}

}
