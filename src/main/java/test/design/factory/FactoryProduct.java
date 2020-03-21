package test.design.factory;

/**
 * @author Administrator
 * @description: 工厂生成类
 * @date 2020/3/16 18:43
 **/
public class FactoryProduct {

    public static AbstractFactory getFactoryByName(String name){
        if ("行为".equals(name)){
            return  new AnimalFactory();
        }else if("颜色".equals(name)){
            return new ColorFactory();
        }
        return null;
    }
}
