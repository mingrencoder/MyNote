package proxy;

import org.junit.Test;

/*
 * 代理模式：
 * 
 * 静态代理：代理和被代理对象在代理之前是确定的，都实现相同的接口或继承相同的抽象类
 */
public class ProxyTest {

	@Test
	public void test1(){
		new Car().move();
	}
	
	@Test
	public void testTimeProxy(){
		new CarTimeProxy(new Car()).move();
	}
	
	/**
	 * 这里其实都是面向的接口，每个代理都是实现的接口的方法，并在其原有方法上加入其它的业务逻辑
	 * 这里参数都是实现了接口的代理类，所以如果想改变其代理的顺序，只需要改变下面代码代理类的顺序就可以了
	 */
	@Test
	public void TestLogProxy(){
		Car car = new Car();
//		CarLogProxy clp = new CarLogProxy(car);
//		CarTimeProxy ctp = new CarTimeProxy(clp);
//		ctp.move();
		
		//改变顺序
		CarTimeProxy ctp = new CarTimeProxy(car);
		CarLogProxy clp = new CarLogProxy(ctp);
		clp.move();
	}
	
	/**
	 * 动态代理实现思路：
	 * 实现功能：通过Proxy的newProxyInstance返回代理对象
	 * 1、声明一段源码（动态产生代理）
	 * 2、编译源码（JDK Compiler API）,产生新的代理类（代理类）
	 * 3、将这个类load到内存中，产生一个新的对象（代理对象）
	 * 4、return代理对象
	 */
}
