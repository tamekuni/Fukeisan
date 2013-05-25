package jp.gr.java_conf.tamekuni.fukeisan.image;

import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Machi;
import jp.gr.java_conf.tamekuni.fukeisan.public_enum.Mentsu;

public class ImageIdManager implements ImageIdManagerIF {

	private final ImageIdInfo mImage;

	public ImageIdManager() {
		mImage = new ImageIdInfo();
	}

	@Override
	public int getImageRId(Mentsu aMentsu) {
		int ret = mImage.getMentsu().getNaRId();

		switch (aMentsu) {
		case SHUNTSU:
			ret = mImage.getMentsu().getShuntsuRId();
			break;

		case ANKAN_CHUNCHAN:
			ret = mImage.getMentsu().getAnkanChunchanRId();
			break;

		case MINKAN_CHUNCHAN:
			ret = mImage.getMentsu().getMinkanChunchanRId();
			break;

		case ANKO_CHUNCHAN:
			ret = mImage.getMentsu().getAnkoChunchanRId();
			break;

		case MINKO_CHUNCHAN:
			ret = mImage.getMentsu().getMinkoChunchanRId();
			break;

		case ANKAN_YAOCHU:
			ret = mImage.getMentsu().getAnkanYaochuRId();
			break;

		case MINKAN_YAOCHU:
			ret = mImage.getMentsu().getMinkanYaochuRId();
			break;

		case ANKO_YAOCHU:
			ret = mImage.getMentsu().getAnkoYaochuRId();
			break;

		case MINKO_YAOCHU:
			ret = mImage.getMentsu().getMinkoYaochuRId();
			break;

		case NA:
		default:
			ret = mImage.getMentsu().getNaRId();
			break;
		}

		return ret;
	}

	@Override
	public int getImageRId(Machi aMachi) {
		int ret = mImage.getMachi().getNaRId();

		switch (aMachi) {
		case RYANMEN:
			ret = mImage.getMachi().getRyanmenRId();
			break;

		case SHABO:
			ret = mImage.getMachi().getShaboRId();
			break;

		case PENCHAN:
			ret = mImage.getMachi().getPenchanRId();
			break;

		case KANCHAN:
			ret = mImage.getMachi().getKanchanRId();
			break;

		case TANKI:
			ret = mImage.getMachi().getTankiRId();
			break;

		case NA:
		default:
			ret = mImage.getMachi().getNaRId();
			break;
		}

		return ret;
	}
}
