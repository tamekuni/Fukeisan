package jp.gr.java_conf.tamekuni.fukeisan;

import jp.gr.java_conf.tamekuni.fukeisan.input_activity.InputActivityManager;
import jp.gr.java_conf.tamekuni.fukeisan.input_activity.InputActivityIdInfo;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Agari;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Jyanto;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Machi;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Mentsu;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Yaku;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class InputActivity extends Activity {

	private InputActivityManager mIAMgr;
	private InputActivityIdInfo mIdInfo;
	private Activity mActivity;
	private static final int MENTSU_SELECT_RESULT_CODE = 0x1;
	private static final int MACHI_SELECT_RESULT_CODE = 0x2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);

		mIdInfo = new InputActivityIdInfo(this);
		mIAMgr = new InputActivityManager(mIdInfo);
		mActivity = this;

		// コールバック
		setListenerYaku();
		setListenerMentsuSelect();
		setListenerJyanto();
		setListenerMachiSelect();
		setListenerAgari();
		setListenerClear();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		Yaku yaku = mIAMgr.getCurYakutype();

		// 状態を保存
		outState.putInt("SaveDataYakuType", mIAMgr.getCurYakutype().toIndex());

		mIAMgr.selectYakutype(Yaku.NORMAL, false);
		outState.putInt("SaveDataNormalMentsu1", mIAMgr.getCurMentsu1()
				.toIndex());
		outState.putInt("SaveDataNormalMentsu2", mIAMgr.getCurMentsu2()
				.toIndex());
		outState.putInt("SaveDataNormalMentsu3", mIAMgr.getCurMentsu3()
				.toIndex());
		outState.putInt("SaveDataNormalMentsu4", mIAMgr.getCurMentsu4()
				.toIndex());
		outState.putInt("SaveDataNormalJyanto", mIAMgr.getCurJyanto().toIndex());
		outState.putInt("SaveDataNormalMachi", mIAMgr.getCurMachi().toIndex());
		outState.putInt("SaveDataNormalAgari", mIAMgr.getCurAgari().toIndex());

		mIAMgr.selectYakutype(Yaku.PINFU, false);
		outState.putInt("SaveDataPinfuAgari", mIAMgr.getCurAgari().toIndex());

		mIAMgr.selectYakutype(Yaku.CHITOITSU, false);
		outState.putInt("SaveDataChitoitsuAgari", mIAMgr.getCurAgari()
				.toIndex());

		mIAMgr.selectYakutype(yaku, false);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		// 保存した状態を読み出す
		int mentsu1Index = savedInstanceState.getInt("SaveDataNormalMentsu1",
				Mentsu.NA.toIndex());
		int mentsu2Index = savedInstanceState.getInt("SaveDataNormalMentsu2",
				Mentsu.NA.toIndex());
		int mentsu3Index = savedInstanceState.getInt("SaveDataNormalMentsu3",
				Mentsu.NA.toIndex());
		int mentsu4Index = savedInstanceState.getInt("SaveDataNormalMentsu4",
				Mentsu.NA.toIndex());
		int jyantoIndex = savedInstanceState.getInt("SaveDataNormalJyanto",
				Jyanto.OTHER.toIndex());
		int machiIndex = savedInstanceState.getInt("SaveDataNormalMachi",
				Machi.NA.toIndex());
		int agariIndex = savedInstanceState.getInt("SaveDataNormalAgari",
				Agari.TSUMO.toIndex());

		mIAMgr.selectYakutype(Yaku.NORMAL, false);
		mIAMgr.setCurMentsu(Mentsu.toMentsu(mentsu1Index),
				Mentsu.toMentsu(mentsu2Index), Mentsu.toMentsu(mentsu3Index),
				Mentsu.toMentsu(mentsu4Index), false);
		mIAMgr.setCurJyanto(Jyanto.toJyanto(jyantoIndex), false);
		mIAMgr.setCurMachi(Machi.toMachi(machiIndex), false);
		mIAMgr.setCurAgari(Agari.toAgari(agariIndex), false);

		mIAMgr.selectYakutype(Yaku.PINFU, false);
		agariIndex = savedInstanceState.getInt("SaveDataPinfuAgari",
				Agari.TSUMO.toIndex());
		mIAMgr.setCurAgari(Agari.toAgari(agariIndex), false);

		mIAMgr.selectYakutype(Yaku.CHITOITSU, false);
		agariIndex = savedInstanceState.getInt("SaveDataChitoitsuAgari",
				Agari.TSUMO.toIndex());
		mIAMgr.setCurAgari(Agari.toAgari(agariIndex), false);

		int yakuIndex = savedInstanceState.getInt("SaveDataYakuType",
				Yaku.NORMAL.toIndex());
		mIAMgr.selectYakutype(Yaku.toYaku(yakuIndex), false);
		mIAMgr.reflectUiAll();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自動生成されたメソッド・スタブ
		super.onActivityResult(requestCode, resultCode, data);

		if (data == null) {
			return;
		}

		switch (requestCode) {
		case MENTSU_SELECT_RESULT_CODE:
			setResultMentsuSelect(resultCode, data);
			break;
		case MACHI_SELECT_RESULT_CODE:
			setResultJyantoSelect(resultCode, data);
			break;
		default:
			break;
		}
	}

	private void setListenerYaku() {
		RadioButton rbYakuNormal = mIdInfo.getInfoYaku().getRadioYakuNormalId();
		RadioButton rbYakuPinfu = mIdInfo.getInfoYaku().getRadioYakuPinfuId();
		RadioButton rbYakuChitoitsu = mIdInfo.getInfoYaku()
				.getRadioYakuChitoitsuId();

		rbYakuNormal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mIAMgr.selectYakutype(Yaku.NORMAL, true);
			}
		});

		rbYakuPinfu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mIAMgr.selectYakutype(Yaku.PINFU, true);
			}
		});

		rbYakuChitoitsu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mIAMgr.selectYakutype(Yaku.CHITOITSU, true);
			}
		});
	}

	private void setListenerMentsuSelect() {
		Button btnMentsu = mIdInfo.getInfoMentsu().getBtnMentsuSelectId();

		btnMentsu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getApplicationContext(),
						MentsuSelectActivity.class);

				intent.putExtra("Mentsu1", mIAMgr.getCurMentsu1().toIndex());
				intent.putExtra("Mentsu2", mIAMgr.getCurMentsu2().toIndex());
				intent.putExtra("Mentsu3", mIAMgr.getCurMentsu3().toIndex());
				intent.putExtra("Mentsu4", mIAMgr.getCurMentsu4().toIndex());

				startActivityForResult(intent, MENTSU_SELECT_RESULT_CODE);
			}
		});
	}

	private void setListenerJyanto() {
		RadioButton rbRenpuhai = mIdInfo.getInfoJyanto()
				.getRadioJyantoRenpuhaiId();
		RadioButton rbYakuhai = mIdInfo.getInfoJyanto()
				.getRadioJyantoYakuhaiId();
		RadioButton rbOther = mIdInfo.getInfoJyanto().getRadioJyantoOtherId();

		rbRenpuhai.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mIAMgr.setCurJyanto(Jyanto.RENPUHAI, true);
			}
		});

		rbYakuhai.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mIAMgr.setCurJyanto(Jyanto.YAKUHAI, true);
			}
		});

		rbOther.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mIAMgr.setCurJyanto(Jyanto.OTHER, true);
			}
		});
	}

	private void setListenerMachiSelect() {
		Button btnMachi = mIdInfo.getInfoMachi().getBtnMachiSelectId();
		// TODO
		btnMachi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getApplicationContext(),
						MachiSelectActivity.class);

				intent.putExtra("Machi", mIAMgr.getCurMachi().toIndex());

				startActivityForResult(intent, MACHI_SELECT_RESULT_CODE);
			}
		});

	}

	private void setListenerAgari() {
		RadioButton rbTsumo = mIdInfo.getInfoAgari().getRadioAgariTsumoId();
		RadioButton rbMenZenRon = mIdInfo.getInfoAgari()
				.getRadioAgariMenzenRonId();
		RadioButton rbFuroRon = mIdInfo.getInfoAgari().getRadioAgariFuroRonId();

		rbTsumo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mIAMgr.setCurAgari(Agari.TSUMO, true);
			}
		});

		rbMenZenRon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mIAMgr.setCurAgari(Agari.MENZEN_RON, true);
			}
		});

		rbFuroRon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mIAMgr.setCurAgari(Agari.FURO_RON, true);
			}
		});
	}

	private void setListenerClear() {
		Button btnClear = mIdInfo.getBtnClearId();
		btnClear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
				builder.setTitle("確認");
				builder.setMessage("クリアしますか？");
				builder.setPositiveButton("はい",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								mIAMgr.clear();
							}
						});
				builder.setNegativeButton("いいえ", null);
				builder.create().show();
			}
		});
	}

	private void setResultMentsuSelect(int aResultCode, Intent aData) {

		int mentsu1Index = aData.getIntExtra("Mentsu1", Mentsu.NA.toIndex());
		int mentsu2Index = aData.getIntExtra("Mentsu2", Mentsu.NA.toIndex());
		int mentsu3Index = aData.getIntExtra("Mentsu3", Mentsu.NA.toIndex());
		int mentsu4Index = aData.getIntExtra("Mentsu4", Mentsu.NA.toIndex());

		mIAMgr.setCurMentsu(Mentsu.toMentsu(mentsu1Index),
				Mentsu.toMentsu(mentsu2Index), Mentsu.toMentsu(mentsu3Index),
				Mentsu.toMentsu(mentsu4Index), true);
	}

	private void setResultJyantoSelect(int aResultCode, Intent aData) {
		int machiIndex = aData.getIntExtra("Machi", Machi.NA.toIndex());

		mIAMgr.setCurMachi(Machi.toMachi(machiIndex), true);
	}
}
