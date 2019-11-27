package test.jdk8.lambda;

/**
 * @author: feis.liu
 * @date: 2018/6/29 14:21
 * @Description:
 */
public class TestLambda {

    public static void main(String[] args){
        MyPerson myPerson = new MyPerson();
        Person person = new Person();
        myPerson.setPerson(person);
        person.setAge(11);
        System.out.println(myPerson.person.getAge());
    }

    public static void printStr(String value,String value2){
         System.out.println(value+value2);
    }


}
