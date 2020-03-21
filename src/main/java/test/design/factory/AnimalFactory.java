package test.design.factory;

/**
 * @author Administrator
 * @description: 动物工厂模式
 * @date 2020/3/16 18:15
 **/
public class AnimalFactory  extends AbstractFactory{

    @Override
    public AnimalColor getColorByName(String name) {
        return null;
    }

    @Override
    public  AnimalAction getActionByName(String name) {
        if ("猫".equals(name)) {
            return  new Cat();
        }else if ("狗".equals(name)){
            return new Dog();
        }
        return null;
    }

}
