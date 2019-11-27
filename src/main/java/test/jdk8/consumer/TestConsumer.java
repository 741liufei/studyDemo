package test.jdk8.consumer;

import test.jdk8.lambda.Person;

import java.util.function.Consumer;

/**
 * @author: feis.liu
 * @date: 2018/7/25 15:49
 * @Description:
 */
public class TestConsumer {
    public static void main(String[]args){
        Person person =new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000);
        Consumer<Person> personConsumer = person1 -> person1.setFirstName("liufei");
        personConsumer.accept(person);
        System.out.println(person.getFirstName());
    }
}
