package test.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liufei
 * @description:
 * @date 2020/4/28 9:33
 **/
public class JDKProxyTest {
    public static void main(String[] args){
        BuyHouse buyHouse = new BuyHouseImpl();
        //newProxyInstance 三个参数解释
        //1.被代理接口对象的ClassLoader
        //2.被代理接口的方法列表
        //3.实现了InvocationHandler接口的 invoke回调方法，当代理类被执行时是调用的invoke方法
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(buyHouse.getClass().getClassLoader(),
                buyHouse.getClass().getInterfaces(),
                new InvocationHandler() {
                    //参数proxy 被代理对象
                    //参数method ：目标类执行的方法，代理对象执行的哪个方法method就是哪个方法
                    //参数args ：方法用到的参数
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理前执行逻辑");
                        Object result = method.invoke(buyHouse,args);
                        System.out.println("代理后执行逻辑");
                        return result;
                    }
                });
        proxyBuyHouse.buyHouse();
    }

}
