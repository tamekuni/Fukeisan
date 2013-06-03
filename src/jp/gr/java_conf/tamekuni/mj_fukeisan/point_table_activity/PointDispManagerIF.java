package jp.gr.java_conf.tamekuni.mj_fukeisan.point_table_activity;

import jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum.Agari;
import jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum.Fu;
import jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum.ParentChild;

public interface PointDispManagerIF {

	public void setPointInfo(ParentChild aPC, Fu aFu, Agari aAgari);

	public Fu convIntToFu(int aFuValue);

}
