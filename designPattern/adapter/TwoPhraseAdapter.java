package adapter;

/*
 * 二相转三相的适配器
 * 
 * 传入2相接口——>利用适配器——>通过3相供电方式供电
 */
public class TwoPhraseAdapter implements ThreePhase {

	private GBTwoPhrase gbTwoPhrase;
	
	public TwoPhraseAdapter(GBTwoPhrase gbTwoPhrase) {
		this.gbTwoPhrase = gbTwoPhrase;
	}

	@Override
	public void powerWithThree() {
		System.out.println("通过对象适配器转化");
		gbTwoPhrase.powerWithTwo();
	}

}
