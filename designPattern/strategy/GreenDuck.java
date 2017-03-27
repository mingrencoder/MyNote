package strategy;

import strategy.impl.FlyingNoWay;

public class GreenDuck extends Duck{

	
	public GreenDuck() {
		super();
		//这里就重写飞行方法
		setFlyingStrategy(new FlyingNoWay());
	}

	@Override
	public void display() {
		System.out.println("我是绿色的");
	}

}
