package proxy.jdkproxy;
import java.lang.reflect.Method;
public class $Proxy implements proxy.jdkproxy.test.UserMgr{
    private proxy.jdkproxy.InvocationHandler handler;
    public $Proxy(InvocationHandler handler) {
        super();
        this.handler = handler;
    }
    @Override
    public void addUser(){
        try{
            Method md = proxy.jdkproxy.test.UserMgr.class.getMethod("addUser") ;
            handler.invoke(this, md);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}