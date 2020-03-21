package test.design.factory;

/**
 * @author Administrator
 * @description:
 * @date 2020/3/16 18:37
 **/
public class ColorFactory extends AbstractFactory{

    @Override
    public AnimalColor getColorByName(String name){
        if ("红色".equals(name)){
            return new Red();
        }else if ("黄色".equals(name)){
            return new Yellow();
        }
        return  null;
    }

    public  static Object getColor(String className){
        try {
             Class zclass = Class.forName(className);
            Object color =  zclass.getConstructor().newInstance();
            return color;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AnimalAction getActionByName(String name) {
        return null;
    }
}
