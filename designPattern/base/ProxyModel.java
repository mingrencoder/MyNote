package base;
/*
 * 代理模式：三个主要角色
 * Suject
 * RealSubject
 * Proxy
 */
public class ProxyModel {

	public static void main(String[] args) {
		Proxy p = new Proxy();
		p.request();
	}

}

interface subject{
	public abstract void request();
}

class RealSubject implements subject{
	public void request(){
		System.out.println("真实的请求");
	}
}

class Proxy{
	private RealSubject realSubject;
	public void request(){
		if(realSubject==null){
			realSubject = new RealSubject();
		}
		realSubject.request();
	}
}
