package test;

import java.io.Serializable;

/**
 * 单例模式 懒加载 线程安全 LRU 实现 大数据分析 -- 大数据应用  --  利用采集数据生成信息。个性数据推送  推荐 偏推荐
 *
 * @author liufei
 * @description:
 * @date 2020/5/14 15:20
 **/
public class SingleTon implements Serializable {

    private static volatile SingleTon single;

    public SingleTon() {
        if (single != null) {
            throw new RuntimeException("禁止使用反射构造方法");
        }
    }

    public static SingleTon getSingleTon() {
        if (single == null) {
            synchronized (SingleTon.class) {
                if (single == null) {
                    single = new SingleTon();
                }
            }
        }
        return single;
    }

    /**
     * 重写克隆方法
     *
     * @return
     */
    @Override
    public Object clone() {
        return single;
    }

    public Object readResolve() {
        return single;
    }
}


