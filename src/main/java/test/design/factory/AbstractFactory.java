package test.design.factory;

/**
 * @author Administrator
 * @description: 抽象工厂类
 * @date 2020/3/16 18:36
 **/
public  abstract class AbstractFactory {

    public abstract AnimalColor getColorByName(String name);

    public abstract AnimalAction getActionByName(String name);

}
