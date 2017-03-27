package strategy;

import org.junit.Test;

/*
 * 策略模式
 * 
 * 优点：足够灵活，易于维护
 * 缺点：客户端必须了解每个策略实现的细节；增加了策略对象的数目
 * 
 * 适用情况：
 * （1）许多相关类仅仅是行为差异
 * （2）运行时选取不同的算法变体
 * （3）通过条件语句在多个分支判断
 */
public class StrategyTest {

	Duck duck1 = null;
	Duck duck2 = null;
	
	@Test
	public void test1(){
		duck1 = new RedDuck();
		duck1.display();
		duck1.fly();
		
		duck2 = new GreenDuck();
		duck2.display();
		duck2.fly();
	}
}
