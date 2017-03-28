package proxy.jdkproxy.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import proxy.jdkproxy.InvocationHandler;

public class TransactionHandler implements InvocationHandler {

	private Object target;
	
	public TransactionHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object obj, Method m) {
		System.out.println("事务开始");
		
		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("事务结束");
	}

}
