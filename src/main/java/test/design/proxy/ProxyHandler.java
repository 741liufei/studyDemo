package test.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liufei
 * @description: 动态代理实现类
 * @date 2020/4/28 9:22
 **/
public class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前执行逻辑");
        Object result = method.invoke(object,args);
        System.out.println("代理后执行逻辑");
        return result;
    }
}
