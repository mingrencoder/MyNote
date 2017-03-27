package battle;

/*
 * 大舞台
 * 用于整体调度军队，关键人物
 */
public class Stage extends Thread {

	@Override
	public void run() {
		
		System.out.println("欢迎大家观看隋唐演义！-----------------------------");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		ArmyRunnable armyTaskGov = new ArmyRunnable();
		ArmyRunnable armyTaskFarm = new ArmyRunnable();

		//创建两只军队线程
		Thread armyGov = new Thread(armyTaskGov, "政府军队");
		Thread armyFarm = new Thread(armyTaskFarm, "起义军");
		
		//开始作战
		armyGov.start();
		armyFarm.start();
		
		//舞台休眠，大家专心观看
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("激战正酣，杀出程咬金！-----------------------------");
		
		//半路杀出程咬金
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");
		
		//鸣金收兵
		armyTaskGov.keepRunning = false;
		armyTaskFarm.keepRunning = false;

		//舞台休眠
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		//开始杀敌
		mrCheng.start();
		
		//这里join方法十分关键，这里保证了mrCheng执行完该线程方法后，舞台线程才会继续执行
		try {
			mrCheng.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("谢谢观看！-----------------------------");
	}
	
	public static void main(String[] args){
		new Stage().start();;
	}
	
}
