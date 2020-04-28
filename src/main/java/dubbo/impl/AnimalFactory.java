package dubbo.impl;

import java.util.Scanner;
import test.spi.AnimalAction;

/**
 * Created by liufei on 2018/3/29.
 */
public class AnimalFactory {

    public static  void main(String[] args){
        System.out.println("请输入动物名称：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        AnimalAction animalAction = getAction(name);
        animalAction.eat();
        java.lang.System.out.println("");
    }

    public static AnimalAction getAction(String name){
        if("猫".equals(name)){
            return new Cat(name);
        }else if("狗".equals(name)){
            return  new Dog(name);
        }
        return  null;
    }
}
