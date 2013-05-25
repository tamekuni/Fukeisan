package jp.gr.java_conf.tamekuni.fukeisan.point_table_activity;

import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Fu;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Han;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.ParentChild;

public class MjPointTableManager {

	private final MjPointTable mMjTbl;

	public MjPointTableManager() {
		mMjTbl = new MjPointTable();
	}

	// get ron
	public String getRonPointString(ParentChild aPC, Fu aFu, Han aHan) {
		String ret = "";
		int[] manganTbl;
		int[][] tbl;

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

	public String getTsumoPointString(ParentChild aPC, Fu aFu, Han aHan) {
		String ret = "";
		int[] manganTblParent;
		int[] manganTblChild;
		int[][] tblParent;
		int[][] tblChild;

		switch (aPC) {

		case PARENT:
			if (isOverMangan(aHan)) {
				manganTblParent = mMjTbl.getParentTsumoMangan();
				ret = String.valueOf(manganTblParent[aHan.toIndex()]) + "all";
			} else {
				tblParent = mMjTbl.getParentTsumo();
				ret = String.valueOf(tblParent[aFu.toIndex()][aHan.toIndex()])
						+ "all";
			}
			break;

		case CHILD:
		default:
			if (isOverMangan(aHan)) {
				manganTblChild = mMjTbl.getChildTsumoMangan();
				manganTblParent = mMjTbl.getParentTsumoMangan();
				ret = String.valueOf(manganTblChild[aHan.toIndex()]) + "/"
						+ String.valueOf(manganTblParent[aHan.toIndex()]);
			} else {
				tblChild = mMjTbl.getChildTsumo();
				tblParent = mMjTbl.getParentTsumo();
				ret = String.valueOf(tblChild[aHan.toIndex()]) + "/"
						+ String.valueOf(tblParent[aHan.toIndex()]);
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
