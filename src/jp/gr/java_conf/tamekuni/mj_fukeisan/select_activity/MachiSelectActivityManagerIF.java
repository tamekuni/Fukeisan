package jp.gr.java_conf.tamekuni.mj_fukeisan.select_activity;

import jp.gr.java_conf.tamekuni.mj_fukeisan.public_enum.Machi;

public interface MachiSelectActivityManagerIF {
	public static final int STACK_SIZE = 1;

	public void initStackData(Machi aMachi);

	public Machi getMachi();

	public void push(Machi aMentsu);

	public Machi pop();
}
