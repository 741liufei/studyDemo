package dubbo.impl;

import test.spi.AnimalAction;

/**
 * @author liufei
 * @description:
 * @date 2020/4/21 10:35
 **/
public class Monkey implements AnimalAction {

    @Override
    public void eat() {
        System.out.println("猴子吃香蕉");
    }
}
