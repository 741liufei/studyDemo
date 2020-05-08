package test.clone;

/**
 * @author liufei
 * @description:
 * @date 2020/5/8 16:17
 **/
public class DeepClone implements Cloneable {
    private String name;
    private String age;

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

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
    public String toString(){
        return "老师"+name + age+"学生"+student.getName()+student.getAge();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DeepClone deepClone = (DeepClone) super.clone();
        if(student != null){
            deepClone.setStudent((Student)deepClone.getStudent().clone());
        }
        return deepClone;
    }
}
