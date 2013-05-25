package jp.gr.java_conf.tamekuni.fukeisan.image;

import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Machi;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Mentsu;

public interface ImageIdManagerIF {

	public int getImageRId(Mentsu aMentsu);

	public int getImageRId(Machi aMachi);

}
