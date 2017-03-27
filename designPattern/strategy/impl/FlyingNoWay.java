package strategy.impl;

import strategy.FlyingStrategy;

public class FlyingNoWay implements FlyingStrategy {

	@Override
	public void performFly() {
		System.out.println("我不会飞行");
	}

}
