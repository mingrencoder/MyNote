package proxy;

/*
 * 通过聚合方式实现代理
 */
public class CarTimeProxy implements Moveable {

	private Moveable m;
	
	
	public CarTimeProxy(Moveable m) {
		super();
		this.m = m;
	}

	@Override
	public void move() {
		System.out.println("开始行驶");
		long start = System.currentTimeMillis();
		
		//在move方法前后增加业务逻辑
		m.move();
		
		long end = System.currentTimeMillis();
		System.out.println("行驶结束，时间为：" + (end - start) + "毫秒");
		
	}

}
