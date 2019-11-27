package dubbo.impl;

/**
 * Created by liufei on 2018/3/29.
 */
public class Cat implements AnimalAction {

    private String name;

    public Cat(String name){
        this.name = name;
    }

    @Override
    public void eat (){
        System.out.println(name+"吃鱼");
    }
}
