package test.design.proxy;

/**
 * @author liufei
 * @description:
 * @date 2020/4/28 9:29
 **/
public class BuyHouseImpl implements BuyHouse {

    @Override
    public void buyHouse() {
        System.out.println("自己买房");
    }
}
