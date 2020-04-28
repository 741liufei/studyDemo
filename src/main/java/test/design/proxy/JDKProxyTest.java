package test.design.proxy;

import java.lang.reflect.Proxy;

/**
 * @author liufei
 * @description:
 * @date 2020/4/28 9:33
 **/
public class JDKProxyTest {

    public static void main(String[] args){
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),new Class[]{BuyHouse.class},new ProxyHandler(buyHouse));
        proxyBuyHouse.buyHouse();
    }

}
