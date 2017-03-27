package battle;

/*
 * 军队线程
 * 模拟作战双方的行为
 */
public class ArmyRunnable implements Runnable {

	//保证了线程可以正确地读取其他现场写入的指
	//可见性 ref JVM
	public volatile boolean keepRunning = true;
	
	@Override
	public void run() {
		while(keepRunning){
			//发动五连击
			for(int i=0; i<5; i++){
				System.out.println(Thread.currentThread().getName() + "进攻[" + i + "]" );
				//对手有还手机会
				Thread.yield();
			}
		}
		System.out.println(Thread.currentThread().getName() + "结束战斗" );
	}

}
