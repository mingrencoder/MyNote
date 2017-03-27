package adapter;

public class TwoPhraseAdapterExtentd extends GBTwoPhrase implements ThreePhase {

	@Override
	public void powerWithThree() {
		System.out.println("通过类适配器转化");
		this.powerWithTwo();
	}


}
