package dubbo.impl;

import test.spi.AnimalAction;

/**
 * Created by liufei on 2018/3/29.
 */
public class Dog implements AnimalAction {
    private String name;

    public Dog(String name){
        this.name = name;
    }

    @Override
    public void eat(){
        System.out.println(name+"吃屎");
    }
}
