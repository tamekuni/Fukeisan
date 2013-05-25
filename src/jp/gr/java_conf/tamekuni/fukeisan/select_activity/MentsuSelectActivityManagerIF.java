package jp.gr.java_conf.tamekuni.fukeisan.select_activity;

import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Mentsu;

public interface MentsuSelectActivityManagerIF {

	public static final int STACK_SIZE = 4;

	public void initStackData(Mentsu aMentsu1, Mentsu aMentsu2,
			Mentsu aMentsu3, Mentsu aMentsu4);

	public Mentsu getMentsu1();

	public Mentsu getMentsu2();

	public Mentsu getMentsu3();

	public Mentsu getMentsu4();

	public void push(Mentsu aMentsu);

	public Mentsu pop();

}
