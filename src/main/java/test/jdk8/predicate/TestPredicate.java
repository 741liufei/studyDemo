package test.jdk8.predicate;

import java.util.function.Predicate;

/**
 * @author: feis.liu
 * @date: 2018/7/25 15:55
 * @Description:
 */
public class TestPredicate {

    public static void main(String[]args){
        Predicate<Integer> predicate = x->x>5;
        System.out.println(predicate.test(1));
        System.out.println(predicate.test(6));
    }
}
