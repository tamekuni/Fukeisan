package jp.gr.java_conf.tamekuni.fukeisan;

import jp.gr.java_conf.tamekuni.fukeisan.point_table_activity.PointDispManager;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Agari;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Fu;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.ParentChild;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PointDispActivity extends Activity {

	private PointDispManager mPDMng;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_point_disp);

		mPDMng = new PointDispManager(this);

		// データを受け取る
		Intent data = getIntent();
		int totalFuValue = data.getIntExtra("TotalFuValue", 30);
		int agariIndex = data.getIntExtra("Agari", Agari.TSUMO.toIndex());
		int parentChildIndex = data.getIntExtra("ParentChild",
				ParentChild.PARENT.toIndex());

		Fu fu = mPDMng.convIntToFu(totalFuValue);
		Agari agari = Agari.toAgari(agariIndex);
		ParentChild parentChild = ParentChild.toParentChild(parentChildIndex);

		mPDMng.setPointInfo(parentChild, fu, agari);

	}
}
