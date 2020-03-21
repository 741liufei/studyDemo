package test.design;

/**
 * @author Administrator
 * @description: 单例模式-饿汉式
 * @date 2020/3/16 17:28
 **/
public class SingleDemo {
    private static SingleDemo instance = new SingleDemo();
    private SingleDemo(){};
    public  static SingleDemo getInstance (){
        return instance;
    }
}

//双重加锁式

class Singleton2{
    private static Singleton2 instance;

    public synchronized static Singleton2 getInstance(){


        synchronized(Singleton2.class){
            if (instance == null){
                instance = new Singleton2();
            }
            return instance;
        }
    }
}
