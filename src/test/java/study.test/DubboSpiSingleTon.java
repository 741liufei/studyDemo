package study.test;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;
import test.spi.AnimalAction;

/**
 * @author liufei
 * @description:
 * @date 2020/4/20 11:16
 **/
public class DubboSpiSingleTon {

    @Test
    public void DubboSpiTest(){
        ExtensionLoader<AnimalAction> extensionLoader = ExtensionLoader.getExtensionLoader(AnimalAction.class);
        AnimalAction cat = extensionLoader.getExtension("cat");
        cat.eat();
    }
}
