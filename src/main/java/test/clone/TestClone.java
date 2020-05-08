package test.clone;

/**
 * @author liufei
 * @description:
 * @date 2020/5/8 15:44
 **/
public class TestClone {

    public static  void main(String[] args) throws CloneNotSupportedException {
//        Student student = new Student();
//        student.setName("zhangsan");
//        student.setAge("11");
//        ShallowClone s1 = new ShallowClone();
//        s1.setName("liufei");
//        s1.setAge("30");
//        s1.setStudent(student);
//        ShallowClone s2 = (ShallowClone) s1.clone();
//        s2.getStudent().setAge("22");
//        System.out.println(s1.toString());
//        System.out.println(s2.toString());

        Student student = new Student();
        student.setName("zhangsan");
        student.setAge("11");
        DeepClone s1 = new DeepClone();
        s1.setName("liufei");
        s1.setAge("30");
        s1.setStudent(student);
        DeepClone s2 = (DeepClone) s1.clone();
        s2.getStudent().setAge("22");
        System.out.println(s1.toString());
        System.out.println(s2.toString());


    }


}
