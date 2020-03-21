package test.design.factory;

/**
 * @author Administrator
 * @description: 工厂模式测试
 * @date 2020/3/16 18:17
 **/
public class TestFactory {

    public  static void  main(String[] args){
//        AnimalAction a1 = AnimalFactory.getByName("猫");
//        a1.eat();
//        AnimalAction a2 = AnimalFactory.getByName("狗");
//        a2.eat();
//        //获取红色猫的行为
//        //获取颜色的工厂
//        AbstractFactory colorFactory = FactoryProduct.getFactoryByName("颜色");
//        AnimalColor red = colorFactory.getColorByName("红色");
//        red.getColor();
//        //获取行为的工厂
//        AbstractFactory actionFactory = FactoryProduct.getFactoryByName("动物");
//        AnimalAction cat = actionFactory.getActionByName("猫");
//        cat.eat();
        Object obj = ColorFactory.getColor(Cat.class.getName());
        Cat cat = (Cat)obj;
        cat.eat();
    }
}
