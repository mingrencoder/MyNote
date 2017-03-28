package proxy.jdkproxy;

import java.lang.reflect.Method;

/*
 * 事务处理逻辑接口
 * 
 * 这里比静态代理类的好处是：
 * 1、静态代理类需要知道被代理类的具体方法名，而这里以Method代替，利用反射方法实现任意方法的代理
 * 2、实现该接口的事务处理类中，通过构造方法传入的可以是任意Object对象，
 *   而静态代理实现类需要传入具体接口
 *   
 *   
 * 因此这里相当于在代理类与被代理类之间，加入了事务处理类
 */
public interface InvocationHandler {

	public void invoke(Object obj, Method m);
}
