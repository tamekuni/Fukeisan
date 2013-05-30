package jp.gr.java_conf.tamekuni.fukeisan.point_table_activity;

import android.app.Activity;
import jp.gr.java_conf.tamekuni.fukeisan.info_data.IdInfoPointDisp;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Agari;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Fu;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Han;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.ParentChild;

public class PointDispManager implements PointDispManagerIF {

	private final MjPointTable mMjTbl;
	private final IdInfoPointDisp mIdInfo;

	private static final String STR_RON = "ロン";
	private static final String STR_TSUMO = "ツモ";
	private static final String STR_HYPHEN = "－";

	public PointDispManager(Activity aActivity) {
		mMjTbl = new MjPointTable();
		mIdInfo = new IdInfoPointDisp(aActivity);
	}

	public void setPointInfo(ParentChild aPC, Fu aFu, Agari aAgari) {

		String pointInfo = aPC.toString() + " " + aFu.toString() + " "
				+ getAgariString(aAgari);
		mIdInfo.getTextViewPointInfoId().setText(pointInfo);

		mIdInfo.getTextView1hanId().setText(
				getPointString(aPC, aFu, Han.HAN1, aAgari));
		mIdInfo.getTextView2hanId().setText(
				getPointString(aPC, aFu, Han.HAN2, aAgari));
		mIdInfo.getTextView3hanId().setText(
				getPointString(aPC, aFu, Han.HAN3, aAgari));
		mIdInfo.getTextView4hanId().setText(
				getPointString(aPC, aFu, Han.HAN4, aAgari));

		mIdInfo.getTextViewManganId().setText(
				getPointString(aPC, aFu, Han.MANGAN, aAgari));
		mIdInfo.getTextViewHanemanId().setText(
				getPointString(aPC, aFu, Han.HANEMAN, aAgari));
		mIdInfo.getTextViewBaimanId().setText(
				getPointString(aPC, aFu, Han.BAIMAN, aAgari));
		mIdInfo.getTextViewSanbaimanId().setText(
				getPointString(aPC, aFu, Han.SANBAIMAN, aAgari));
		mIdInfo.getTextViewYakumanId().setText(
				getPointString(aPC, aFu, Han.YAKUMAN, aAgari));
	}

	public Fu convIntToFu(int aFuValue) {

		if (aFuValue == 25) {
			return Fu.FU25;
		}
		if (aFuValue <= 20) {
			return Fu.FU20;
		}
		if ((aFuValue > 20) && (aFuValue <= 30)) {
			return Fu.FU30;
		}
		if ((aFuValue > 30) && (aFuValue <= 40)) {
			return Fu.FU40;
		}
		if ((aFuValue > 40) && (aFuValue <= 50)) {
			return Fu.FU50;
		}
		if ((aFuValue > 50) && (aFuValue <= 60)) {
			return Fu.FU60;
		}
		if ((aFuValue > 60) && (aFuValue <= 70)) {
			return Fu.FU70;
		}
		if ((aFuValue > 70) && (aFuValue <= 80)) {
			return Fu.FU80;
		}
		if ((aFuValue > 80) && (aFuValue <= 90)) {
			return Fu.FU90;
		}
		if ((aFuValue > 90) && (aFuValue <= 100)) {
			return Fu.FU100;
		}
		if (aFuValue > 100) {
			return Fu.FU110;
		}

		return Fu.FU30;
	}

	private String getAgariString(Agari aAgari) {

		String ret = "";

		switch (aAgari) {
		case TSUMO:
			ret = STR_TSUMO;
			break;
		case MENZEN_RON:
		case FURO_RON:
		default:
			ret = STR_RON;
			break;
		}

		return ret;
	}

	private String getPointString(ParentChild aPC, Fu aFu, Han aHan,
			Agari aAgari) {

		String ret = "";

		if (aAgari == Agari.TSUMO) {
			ret = getTsumoPointString(aPC, aFu, aHan);
		} else {
			ret = getRonPointString(aPC, aFu, aHan);
		}
		return ret;
	}

	private String getRonPointString(ParentChild aPC, Fu aFu, Han aHan) {
		String ret = "";
		int[] manganTbl;
		int[][] tbl;

		// 点数表に存在しない場合は"－"を表示する
		if ((aFu == Fu.FU20) && (aHan == Han.HAN1)) {
			return STR_HYPHEN;
		}
		if ((aFu == Fu.FU25) && (aHan == Han.HAN1)) {
			return STR_HYPHEN;
		}

		switch (aPC) {
		case PARENT:
			if (isOverMangan(aHan)) {
				manganTbl = mMjTbl.getParentRonMangan();
				ret = String.valueOf(manganTbl[aHan.toIndex()]);
			} else {
				tbl = mMjTbl.getParentRon();
				ret = String.valueOf(tbl[aFu.toIndex()][aHan.toIndex()]);
			}
			break;

		default:
		case CHILD:
			if (isOverMangan(aHan)) {
				manganTbl = mMjTbl.getChildRonMangan();
				ret = String.valueOf(manganTbl[aHan.toIndex()]);
			} else {
				tbl = mMjTbl.getChildRon();
				ret = String.valueOf(tbl[aFu.toIndex()][aHan.toIndex()]);
			}
			break;
		}
		return ret;
	}

	private String getTsumoPointString(ParentChild aPC, Fu aFu, Han aHan) {
		String ret = "";
		int[] manganTblParent;
		int[] manganTblChild;
		int[][] tblParent;
		int[][] tblChild;

		if ((aFu == Fu.FU20) && (aHan == Han.HAN1)) {
			return STR_HYPHEN;
		}
		if ((aFu == Fu.FU25) && ((aHan == Han.HAN1) || (aHan == Han.HAN2))) {
			return STR_HYPHEN;
		}

		switch (aPC) {
		case PARENT:
			if (isOverMangan(aHan)) {
				manganTblParent = mMjTbl.getParentTsumoMangan();
				int manganPoint = manganTblParent[aHan.toIndex()];

				ret = String.valueOf(manganPoint) + "all\n("
						+ String.valueOf(manganPoint * 3) + ")";
			} else {
				tblParent = mMjTbl.getParentTsumo();
				int point = tblParent[aFu.toIndex()][aHan.toIndex()];

				tblParent = mMjTbl.getParentTsumo();
				ret = String.valueOf(point) + "all\n("
						+ String.valueOf(point * 3) + ")";
			}
			break;

		case CHILD:
		default:
			if (isOverMangan(aHan)) {
				manganTblChild = mMjTbl.getChildTsumoMangan();
				manganTblParent = mMjTbl.getParentTsumoMangan();
				int manganChildPoint = manganTblChild[aHan.toIndex()];
				int manganParentPoint = manganTblParent[aHan.toIndex()];

				ret = String.valueOf(manganChildPoint)
						+ "/\n"
						+ String.valueOf(manganParentPoint)
						+ "\n("
						+ String.valueOf((manganChildPoint * 2)
								+ manganParentPoint) + ")";
			} else {
				tblChild = mMjTbl.getChildTsumo();
				tblParent = mMjTbl.getParentTsumo();
				int childPoint = tblChild[aFu.toIndex()][aHan.toIndex()];
				int parentPoint = tblParent[aFu.toIndex()][aHan.toIndex()];

				ret = String.valueOf(childPoint) + "/\n"
						+ String.valueOf(parentPoint) + "\n("
						+ String.valueOf((childPoint * 2) + parentPoint) + ")";
			}
			break;
		}

		return ret;
	}

	private boolean isOverMangan(Han aHan) {
		boolean ret = false;

		switch (aHan) {
		case MANGAN:
		case HANEMAN:
		case BAIMAN:
		case SANBAIMAN:
		case YAKUMAN:
			ret = true;
			break;
		default:
			ret = false;
			break;
		}

		return ret;
	}

}
