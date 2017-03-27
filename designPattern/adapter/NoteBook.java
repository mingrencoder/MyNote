package adapter;

/*
 * 笔记本：只有三相插座线头
 */
public class NoteBook {
	
	private ThreePhase threePhase;

	public NoteBook(ThreePhase threePhase) {
		this.threePhase = threePhase;
	}

	public void charge(){
		threePhase.powerWithThree();
	}
}
