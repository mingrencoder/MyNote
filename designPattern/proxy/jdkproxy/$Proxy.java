package proxy.jdkproxy;
import java.lang.reflect.Method;
public class $Proxy implements proxy.Moveable{
    private proxy.jdkproxy.InvocationHandler handler;
    public $Proxy(InvocationHandler handler) {
        super();
        this.handler = handler;
    }
    @Override
    public void move(){
        try{
            Method md = proxy.Moveable.class.getMethod("move") ;
            handler.invoke(this, md);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}