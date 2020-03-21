package test.design.factory;

/**
 * @author Administrator
 * @description: 猫
 * @date 2020/3/16 18:11
 **/
public class Cat implements AnimalAction {
    @Override
    public void eat(){
        System.out.println("猫吃鱼");
    }
}
