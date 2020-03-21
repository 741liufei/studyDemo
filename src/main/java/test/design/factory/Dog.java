package test.design.factory;

/**
 * @author Administrator
 * @description: 狗
 * @date 2020/3/16 18:12
 **/
public class Dog implements AnimalAction {

    @Override
    public void eat() {
        System.out.println("狗吃屎");
    }
}
