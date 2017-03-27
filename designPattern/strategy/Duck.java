package strategy;

/*
 * 抽象超类
 * 抽象了鸭子的行为
 * 
 * 由于不同的鸭子具有不同的具体飞行方式
 * 这里将飞行行为抽象为接口，在父类中持有该接口，并由该接口代理飞行行为
 */
public abstract class Duck {

	private FlyingStrategy flyingStrategy;
	
	public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
		this.flyingStrategy = flyingStrategy;
	}

	public void fly(){
		flyingStrategy.performFly();
	}
	
	
	/**
	 * 通用行为
	 */
	public void quack(){
		System.out.println("嘎嘎嘎！");
	}
	
	/**
	 * 鸭子外观各不相同，这里用抽象方法
	 */
	public abstract void display();
	
}
