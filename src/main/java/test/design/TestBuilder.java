package test.design;

import com.alibaba.dubbo.common.json.JSON;

import java.io.IOException;

/**
 * @description: 测试builder模式
 * @author: feis.liu
 * @create: 2019-07-04 17:36
 **/
public class TestBuilder {

    public static void main(String[] args){
        PersonInfo.PersonInfoBuilder builder =PersonInfo.getPersonBuilder();

        builder.setName("小明");
        builder.setAge(21);
        builder.setBirthday("19991111");
        builder.setSex("男");
        PersonInfo personInfo = builder.builder();
        try {
            System.out.println(JSON.json(personInfo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
