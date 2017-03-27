package base;
//要点：主要这个instance是属性修饰符  有没有final 总结是内部类和饿汉式两个不判断
public class SingletonModel {

	public static void main(String[] args) {
		//这里仅仅针对做一个试验，复习主动引用(调用static和static final)
		//System.out.println(Singleton1.instance);
		Singleton1.getInstance();
		Singleton2.getInstance();
		Singleton3.getInstance();
		Singleton4 s1 = Singleton4.getInstance();
		Singleton4 s2 = Singleton4.getInstance();
		System.out.println(s1==s2);
	}

}

//懒汉式，不提倡，多线程会创建多个实例
class Singleton1{
	static{
		System.out.println("实例化懒汉式Singleton1");
	}
	private Singleton1(){
	}
	//private static Singleton1 instance = null;
	private static Singleton1 instance = null;
	public static Singleton1 getInstance(){
		if(instance==null){
			instance = new Singleton1();
		}
		return instance;
	}
}
/*
 * 饿汉式的  这种最常用，调用该静态方法是主动引用，因此在引用之前类初始化(应该是准备阶段)一个单例对象
 * 想清楚这里：实例化和初始化区别！ 这里的初始化是static的变量instance，
 * 而这个instance就是Singleton1的实例化，因此这个实例化对象就是初始化的值
 */
class Singleton2{
	static{
		System.out.println("实例化饿汉式Singleton2");
	}
	private Singleton2(){
	}
	private static final Singleton2 instance = new Singleton2();
	
	public static Singleton2 getInstance(){
		return instance;
	}
}
/*
 * 第一层判断instance是否为空是为了实现懒加载
 * 第二层是为了防止两个同时进入synchronized方法的线程重复加载，再进行一次判断
 * 因为是加了锁，所以效率会相对低
 */
class Singleton3{
	static{
		System.out.println("双重加锁机制下实例化Singleton3");
	}
	private Singleton3(){
	}
	private static Singleton3 instance = new Singleton3();
	
	public static Singleton3 getInstance(){
		if(instance==null){
			synchronized(Singleton3.class){//这里上面的instance不先new，就要用class，不然会报空指针异常
				if(instance==null){
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}

/*
 * 使用内部类，因为内部类只被加载一次，因此保证了线程安全
 * 没有锁，保证了运算效率
 * 与饿汉式区别：
 * 1)只要Singleton类被装载了，那么instance就会被实例化（没有达到lazy loading效果），
 * 而这种方式是Singleton类被装载了，instance不一定被初始化。
 * 因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，
 * 才会显示装载SingletonHolder类，从而实例化instance。
 * 2)我不希望在Singleton类加载时就实例化，
 * 因为我不能确保Singleton类还可能在其他的地方被主动使用从而被加载
 */
class Singleton4{
	static{
		System.out.println("使用内部类实例化Singleton4");
	}
	private Singleton4(){
	}
	//内部类属性这里设置为private
	private static class Nested{
		private static final Singleton4 instance = new Singleton4();
	}
	
	public static Singleton4 getInstance(){
		Singleton4 instance = Nested.instance;
		return instance;
	}
	
}
