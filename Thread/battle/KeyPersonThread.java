package battle;

public class KeyPersonThread extends Thread {

	@Override
	public void run() {
		System.out.println(getName() + "开始战斗" );

		for(int i=0; i<10; i++){
			System.out.println(getName() + "关键人物进攻[" + i + "]" );

		}
		System.out.println(getName() + "结束战斗" );
	}
}
