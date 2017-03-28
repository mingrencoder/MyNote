package proxy.jdkproxy;

import java.lang.reflect.Method;

import proxy.Car;

/*
 * 实现InvocationHandler来定义自己的处理模式
 * 
 * 封装了被代理的对象，并扩展自己的业务逻辑
 */
public class TimeInvocation implements InvocationHandler {

	//定义需要代理的对象
	private Object target;
	
	public TimeInvocation(Object target) {
		this.target = target;
	}
	
	@Override
	public void invoke(Object obj, Method m) {
		System.out.println("开始行驶");
		long start = System.currentTimeMillis();
		//这里的obj是以为必须有一个对象，方法才可以执行
		//在被代理对象执行完毕后，加入自己的逻辑，而Proxy返回的对象也就是该Handler类
		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("行驶结束，时间为：" + (end - start) + "毫秒");
	}

}
