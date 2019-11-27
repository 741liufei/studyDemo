package test.design;

/**
 * @description: builder设计模式
 * @author: feis.liu
 * @create: 2019-07-04 17:26
 **/
public class PersonInfo {
    private String name;

    private int age;

    private String sex;

    private String birthday;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public   PersonInfo(PersonInfoBuilder personInfoBuilder){
        this.name=personInfoBuilder.name;
        this.age=personInfoBuilder.age;
        this.sex=personInfoBuilder.sex;
        this.birthday=personInfoBuilder.birthday;
    }

    public static PersonInfoBuilder getPersonBuilder(){
        return  new PersonInfoBuilder();
    }

    public static class PersonInfoBuilder{
        private String name;

        private int age;

        private String sex;

        private String birthday;

        public PersonInfoBuilder setName(final String name) {
            this.name = name;
            return this;
        }

        public PersonInfoBuilder setAge(final int age) {
            this.age = age;
            return  this;
        }

        public PersonInfoBuilder setSex(final String sex) {
            this.sex = sex;
            return this;
        }

        public PersonInfoBuilder setBirthday(final String birthday) {
            this.birthday = birthday;
            return this;
        }
        public    PersonInfo builder(){
            return  new PersonInfo(this);
        }
    }
}
