package com.example.demo.demo01Anno;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

@SpringBootTest
class SpringbootDemoApplicationTests {

    private Class<? extends Persion> aClass;

    @Test
    void contextLoads() throws IllegalAccessException {
        Persion persion = new Persion("", -1);

        Field[] fields = persion.getClass().getFields();
        //设置可以获取私有属性
//        fields.setAccessible(true);
        for (Field field : fields) {
            Range range = field.getAnnotation(Range.class);
            if (range != null) {
                //返回的 Field表示字段的值，指定对象上。
                Object o = field.get(persion);
                if (o instanceof String) {
                    String name = (String) o;
                    if (name.equals("")) {
                        persion.name = range.name();
                    }
                    System.out.println(persion.toString());
                }
            }
        }
    }
}
