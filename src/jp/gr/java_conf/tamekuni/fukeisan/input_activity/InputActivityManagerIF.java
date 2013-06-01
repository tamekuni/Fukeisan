package jp.gr.java_conf.tamekuni.fukeisan.input_activity;

import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Agari;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Jyanto;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Machi;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Mentsu;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Yaku;

public interface InputActivityManagerIF {

	public void selectYakutype(Yaku aYaku, boolean aIsRefUi);

	public Yaku getCurYakutype();

	public Mentsu getCurMentsu1();

	public Mentsu getCurMentsu2();

	public Mentsu getCurMentsu3();

	public Mentsu getCurMentsu4();

	public Jyanto getCurJyanto();

	public Machi getCurMachi();

	public Agari getCurAgari();

	public int getCurTotalFu();

	public void setCurMentsu(Mentsu aMentsu1, Mentsu aMentsu2, Mentsu aMentsu3,
			Mentsu aMentsu4, boolean aIsRefUi);

	public void setCurJyanto(Jyanto aJyanto, boolean aIsRefUi);

	public void setCurMachi(Machi aMachi, boolean aIsRefUi);

	public void setCurAgari(Agari aAgari, boolean aIsRefUi);

	public void clear();

	public void reflectUiAll();

}
