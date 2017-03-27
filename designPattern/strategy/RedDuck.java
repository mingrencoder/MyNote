package strategy;

import strategy.impl.FlyingWithWing;

public class RedDuck extends Duck{

	public RedDuck() {
		super();
		setFlyingStrategy(new FlyingWithWing());
	}

	@Override
	public void display() {
		System.out.println("我是红色的");
	}

	
}
