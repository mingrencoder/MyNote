package proxy;


import java.io.File;

import org.junit.Test;

import proxy.cglib.CglibProxy;
import proxy.cglib.Train;
import proxy.jdk.TimeHandler;
import proxy.jdkproxy.InvocationHandler;
import proxy.jdkproxy.Proxy;
import proxy.jdkproxy.TimeInvocation;
import proxy.jdkproxy.test.TransactionHandler;
import proxy.jdkproxy.test.UserMgr;
import proxy.jdkproxy.test.UserMgrImp;

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
	
	/********************************************
	 * 静态代理
	 ********************************************/
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
		Moveable ctp = new CarTimeProxy(car);
		Moveable clp = new CarLogProxy(ctp);
		clp.move();
	}

	
	/********************************************
	 * 动态代理  (无需知道这个代理对象的名字)
	 * 
	 * 好处就是不需要每次都建立一个新的代理类，这里能够动态生成
	 * 
	 * 方式有很多：
	 * 1、JDK提供 (需要编译)
	 * 2、CGLIB 
	 * 3、ASM
	 * 后两种直接生成二进制文件，不需要编译
	 * @throws Exception 
	 * 
	 ********************************************/
	/*
	 * 测试JDK中原生Proxy代理
	 */
	@Test
	public void TestJDK(){
		Moveable car = new Car();
		java.lang.reflect.InvocationHandler handler = new TimeHandler(car);
		Class<?> clazz = car.getClass();
		Moveable m = (Moveable) java.lang.reflect.Proxy.newProxyInstance(clazz.getClassLoader(),
				clazz.getInterfaces(), handler);
		
		m.move();
	}
	
	/*
	 * 测试CGLIB代理
	 */
	@Test
	public void TestCGLIB(){
		CglibProxy cglibProxy = new CglibProxy();
		Train train = (Train) cglibProxy.getProxy(Train.class);
		train.move();
	}
	
	/*
	 * 模拟JDK中Proxy代理
	 */
	@Test
	public void testJDKProxy() throws Exception{
		deleteCache();
		
		//Moveable m = (Moveable) Proxy.newProxyInstance();
		//Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class);
		Moveable car = new Car();
		InvocationHandler handler = new TimeInvocation(car);
		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, handler);
		
		m.move();
	}
	
	/*
	 * 面向切面编程，方法可以叠加，顺序可以变化，类似上面的静态代理方法
	 * 叠加暂时不行，以后再修改
	 */
	@Test
	public void testUserMgr() throws Exception{
		deleteCache();
		
		UserMgr userMgrImp = new UserMgrImp();
		InvocationHandler handler1 = new TransactionHandler(userMgrImp);
		TimeInvocation handler2 = new TimeInvocation(handler1);
		UserMgr userMgr = (UserMgr) Proxy.newProxyInstance(UserMgr.class, handler2);
		
		userMgr.addUser();
	}
	
	//没效果 需要手动删除
	private void deleteCache(){
		String filename = System.getProperty("user.dir") +"/designPattern/proxy/jdkproxy/$Proxy.class";
		File file = new File(filename);
		if (file.isFile() && file.exists()) {  
	        file.delete();  
	    } 
	}
}
