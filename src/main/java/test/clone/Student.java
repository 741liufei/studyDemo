package test.clone;

/**
 * @author liufei
 * @description:
 * @date 2020/5/8 16:08
 **/
public class Student implements Cloneable{

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
