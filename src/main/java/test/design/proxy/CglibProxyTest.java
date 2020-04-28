package test.design.proxy;

/**
 * @author liufei
 * @description:
 * @date 2020/4/28 9:57
 **/
public class CglibProxyTest {
    public static void main(String[] args){
        BuyHouseByMySelf buyHouseByMySelf = new BuyHouseByMySelf();
        CglibProxy cglibProxy = new CglibProxy();
        BuyHouseByMySelf buyHouseCglibProxy = (BuyHouseByMySelf) cglibProxy.getInstance(buyHouseByMySelf);
        buyHouseCglibProxy.buyHouseByMyself();
    }

}
