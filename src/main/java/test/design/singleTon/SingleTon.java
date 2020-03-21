package test.design.singleTon;

/**
 * @author Administrator
 * @description: 双重锁定单例模式
 * @date 2020/3/17 14:48
 **/

public class SingleTon {

    volatile SingleTon instance;
    public SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}
