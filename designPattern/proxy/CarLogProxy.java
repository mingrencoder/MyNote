package proxy;

/*
 * 通过聚合方式实现代理
 */
public class CarLogProxy implements Moveable {

	private Moveable m;
	
	
	public CarLogProxy(Moveable m) {
		super();
		this.m = m;
	}

	@Override
	public void move() {
		System.out.println("日志开始");
		
		//在move方法前后增加业务逻辑
		m.move();
		
		long end = System.currentTimeMillis();
		System.out.println("日志结束");
		
	}

}
