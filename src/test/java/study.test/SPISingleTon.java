package study.test;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 *
 * @author liufei
 * @description:测试javaSPI机制
 * @date 2020/4/20 10:59
 **/
public class SPISingleTon {

    @Test
    public  void Test(){
        try {
//            ServiceLoader<AnimalAction> actions = ServiceLoader.load(AnimalAction.class);
//            actions.forEach(AnimalAction::eat);
            Map map  = new HashMap<>();
            map.put(1,1);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
