package proxy.jdkproxy;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

/*
 * 只要一个类实现了某个接口，那么就可以生成其代理类	（继承也可以，但是不推荐）
 * 动态代理实现思路：
 * 实现功能：通过Proxy的newProxyInstance返回代理对象
 * 1、声明一段源码，并生成一个java文件
 * 2、编译源码（JDK Compiler API）,产生新的代理类（代理类）
 * 3、将这个类load到内存中，产生一个新的对象（代理对象）
 * 4、return代理对象
 * 
 * 可以实现对任意对象、任意接口方法的代理
 */
public class Proxy {
	
	public static Object newProxyInstance(Class<?> infce, InvocationHandler handler) throws Exception{
		/*******************************************
		 * 第一步、声明
		 *******************************************/
		//换行转义
		String rt = "\r\n"; 
		//遍历所有方法
		String methods = "";
		/* 只传入了infce
		 * for(Method m : infce.getMethods()){
			methods += 
				"    @Override" + rt +
				"    public void " + m.getName() + "() {"+ rt +
				"        System.out.println(\"开始行驶\");"+ rt +
				"        long start = System.currentTimeMillis();"+ rt +
						
				"        m." + m.getName() + "();"+ rt +
						
				"        long end = System.currentTimeMillis();"+ rt +
				"        System.out.println(\"行驶结束，时间为：\" + (end - start) + \"毫秒\");"+ rt +
				"    }" + rt;
		}*/
		
		//利用事务处理器接口, 另外这里还需要处理invoke的异常
		for(Method m : infce.getMethods()){
			methods += 
				"    @Override" + rt +
				"    public void " + m.getName() + "(){"+ rt +
				"        try{" + rt +
				"            Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\") ;" + rt +
				"            handler.invoke(this, md);" + rt +
				"        }catch (Exception e){" + rt +
				"            e.printStackTrace();" + rt +
				"        }" + rt +
				"    }" + rt;
		}
		
		String src = 
			"package proxy.jdkproxy;"+ rt +
			"import java.lang.reflect.Method;"+ rt +
			"public class $Proxy implements " +  infce.getName() + "{" + rt +
			"    private proxy.jdkproxy.InvocationHandler handler;" + rt +
			"    public $Proxy(InvocationHandler handler) {" + rt +
			"        super();" + rt +
			"        this.handler = handler;" + rt +
			"    }" + rt +
			methods + rt +
			"}";
		
		String filename = System.getProperty("user.dir") +"/designPattern/proxy/jdkproxy/$Proxy.java";
		File file = new File(filename);
		FileUtils.writeStringToFile(file, src);

		/*******************************************
		 * 第二步、编译
		 *******************************************/
		//1、拿到编译
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//2、拿到文件管理者
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		//3、获得编译的单元
		Iterable units = fileManager.getJavaFileObjects(filename);
		//4、拿到编译任务
		CompilationTask task = compiler.getTask(null, fileManager, null, null, null, units);
		//5、编译
		task.call();
		//6、关掉文件管理者
		fileManager.close();
		
		/*******************************************
		 * 第三步、load
		 *******************************************/
		//使用一个特殊的ClassLoader，不需要使文件一定在classpath下， 这里URL创建遵循一定格式
		URL[] urls = new URL[] {new URL("file:/" + System.getProperty("user.dir") + "/designPattern")};
		URLClassLoader loader = new URLClassLoader(urls);
		Class<?> clazz = loader.loadClass("proxy.jdkproxy.$Proxy");

		//这里如果是生成在bin目录下，则直接用ClassLoader即可
		
		/*******************************************
		 * 第四步、return
		 *******************************************/
		/*
		 * 通过Constructor反射产生了clazz，传入的参数是InvocationHandler类型
		 * 
		 * 由于class文件中没有空的构造方法，就不能用newInstance，这里用反射机制
		 * 在虚拟机角度，每一个class中的构造方法也是一个对象！！！ 
		 */
		Constructor constructor = clazz.getConstructor(InvocationHandler.class);
		Object m = constructor.newInstance(handler);
		return m;
	}
}
