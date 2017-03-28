package adapter;

import org.junit.Test;

/*
 * 适配器模式
 * 
 * 2相——>3相
 * 
 * 1、对象适配器：“被适配者”作为一个对象组合到适配器类中，以修改目标接口包装被适配者
 * 
 * 2、类适配器：通过多重集成，不兼容接口，实现目标接口的配对，单一为某各类进行适配
 */
public class AdapterTest {

	@Test
	public void test1(){
		GBTwoPhrase gbTwoPhrase = new GBTwoPhrase();
		ThreePhase adapter = new TwoPhraseAdapter(gbTwoPhrase);
		NoteBook noteBook = new NoteBook(adapter);
		noteBook.charge(); 
	}
	
	@Test
	public void test2(){
		ThreePhase adapter = new TwoPhraseAdapterExtentd();
		NoteBook noteBook = new NoteBook(adapter);
		noteBook.charge(); 
	}
}
