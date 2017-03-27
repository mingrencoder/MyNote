package strategy.impl;

import strategy.FlyingStrategy;

public class FlyingWithWing implements FlyingStrategy {

	@Override
	public void performFly() {
		System.out.println("用翅膀飞行");
	}

}
