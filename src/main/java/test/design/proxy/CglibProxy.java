package test.design.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author liufei
 * @description:CGLib代理 实现了方法拦截器的逻辑
 * @date 2020/4/28 9:47
 **/
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(final Object target){
        this.target = target;
        //动态子类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    /**
     *
     * @param object
     * @param method
     * @param args
     * @param methodProxy 当调用拦截方法时，由{@link Enhancer}生成的类将此对象传递给已注册的{@link MethodInterceptor}对象。它可以*用来调用原始方法，或在相同类型的另一个对象上调用相同的方法。
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("买房前准备");
        Object result = methodProxy.invokeSuper(object,args);
        System.out.println("买房后准备");
        return result;
    }
}
