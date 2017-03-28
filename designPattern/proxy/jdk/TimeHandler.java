package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	private Object target;

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("开始行驶");
		long start = System.currentTimeMillis();
			method.invoke(target);
		long end = System.currentTimeMillis();
		System.out.println("行驶结束，时间为：" + (end - start) + "毫秒");
		
		return null;
	}

}
