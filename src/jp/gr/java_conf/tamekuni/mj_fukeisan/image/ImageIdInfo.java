package jp.gr.java_conf.tamekuni.mj_fukeisan.image;

public class ImageIdInfo {

	private final ImageIdInfoMachi mMachi;
	private final ImageIdInfoMentsu mMentsu;

	public ImageIdInfo() {
		mMachi = new ImageIdInfoMachi();
		mMentsu = new ImageIdInfoMentsu();
	}

	public ImageIdInfoMachi getMachi() {
		return mMachi;
	}

	public ImageIdInfoMentsu getMentsu() {
		return mMentsu;
	}
}
