package test.jdk8.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 用于测试lambda表达式用于Stream类型数据的处理
 * @author: feis.liu
 * @date: 2018/7/25 15:43
 * @Description:
 */
public class LambdaStream  {

    public static void main(String args[]){
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };
        //现在我们使用forEach方法来迭代输出上述列表:
        System.out.println("所有员工姓名如下：");
        javaProgrammers.forEach(person -> System.out.printf("%s %s; %n ",person.getFirstName(),person.getLastName()));
        phpProgrammers.forEach(person -> System.out.printf("%s %s; %n ",person.getFirstName(),person.getLastName()));
        //我们同样使用forEach方法,增加程序员的工资5%:
        System.out.println("给程序员加薪 5% :");
        javaProgrammers.forEach(person -> person.setSalary(person.getSalary()/100*105));
        phpProgrammers.forEach(person -> person.setSalary(person.getSalary()/100*105));
        //另一个有用的方法是过滤器filter() ,让我们显示月薪超过1400美元的PHP程序员:
        System.out.println("下面是月薪超过 $1,400 的PHP程序员:");
        phpProgrammers.stream()
                .filter(person -> person.getSalary()>1400)//过滤出薪资大于1400的
                .forEach(person -> System.out.printf("%s %s; %n ",person.getFirstName(),person.getLastName()));
        //我们也可以定义过滤器,然后重用它们来执行其他操作:
        //定义filter
        Predicate<Person> ageFilter = person -> person.getAge()>25;//年龄大于25
        //薪资大于1400
        Predicate<Person> salaryFilter = person -> person.getSalary()>1400;
        //女性
        Predicate<Person> genderFilter = person -> "female".equals(person.getGender());

        System.out.println("下面是年龄大于 25岁且月薪在$1,400以上的女PHP程序员:");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach(person -> System.out.printf("%s %s; %n ",person.getFirstName(),person.getLastName()));
        // 重用filters
        System.out.println("年龄大于 25岁的女性 Java programmers:");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .forEach(person -> System.out.printf("%s %s; %n ",person.getFirstName(),person.getLastName()));
        //使用limit方法,可以限制结果集的个数:
        System.out.println("最前面的3个 Java programmers:");
        javaProgrammers.stream()
                .limit(3)
                .forEach(person -> System.out.printf("%s %s; %n ",person.getFirstName(),person.getLastName()));
        System.out.println("根据 name 排序,并显示前5个 Java programmers:");
        List<Person> sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
                .limit(5)
                .collect(Collectors.toList());
        sortedJavaProgrammers.forEach(person -> System.out.printf("%s %s; %n ",person.getFirstName(),person.getLastName()));
        System.out.println("根据 salary 排序 Java programmers:");
        sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted( (p, p2) -> (p.getSalary() - p2.getSalary()) )
                .collect( Collectors.toList() );

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));
        System.out.println("工资最低的 Java programmer:");
        Person pers = javaProgrammers.stream().min((p1,p2)->p1.getSalary()-p2.getSalary()).get();
        System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(), pers.getLastName(), pers.getSalary());

        System.out.println("工资最高的 Java programmer:");
        Person person = javaProgrammers
                .stream()
                .max((p, p2) -> (p.getSalary() - p2.getSalary()))
                .get();
        System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());
    //上面的例子中我们已经看到 collect 方法是如何工作的。 结合 map 方法,我们可以使用 collect 方法来将我们的结果集放到一个字符串,一个 Set 或一个TreeSet中:
        System.out.println("将 PHP programmers 的 first name 拼接成字符串:");
        String phpDevelopers =  phpProgrammers.stream().map(Person::getFirstName).collect(Collectors.joining(","));
        System.out.println(phpDevelopers);
        System.out.println("将 Java programmers 的 first name 存放到 Set:");
        Set<String> javaDevFirstName = javaProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(Collectors.toSet());

        System.out.println("将 Java programmers 的 first name 存放到 TreeSet:");
        TreeSet<String> javaDevLastName = javaProgrammers
                .stream()
                .map(Person::getLastName)
                .collect(Collectors.toCollection(TreeSet::new));
        //Streams 还可以是并行的(parallel)
        System.out.println("计算付给 Java programmers 的所有money:");
        int totalSalary = javaProgrammers.stream().parallel().mapToInt(p->p.getSalary()).sum();
        System.out.println(totalSalary);
        //我们可以使用summaryStatistics方法获得stream 中元素的各种汇总数据。 接下来,我们可以访问这些方法,比如getMax, getMin, getSum或getAverage:
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        IntSummaryStatistics stats = numbers.stream().mapToInt(i->i).summaryStatistics();
        System.out.println("List中最大的数字 : " + stats.getMax());
        System.out.println("List中最小的数字 : " + stats.getMin());
        System.out.println("所有数字的总和   : " + stats.getSum());
        System.out.println("所有数字的平均值 : " + stats.getAverage());


    }


}
