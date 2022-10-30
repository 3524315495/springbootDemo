package com.example.demo.demo10Reflect;

import com.example.demo.demo10Reflect.entity.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.jupiter.api.Test;

import javax.imageio.stream.ImageOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class ReflectTest01 {
    @Test
    public void test01() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取class的三种方法
        Employee zs = new Employee("zs", 12);
        Class<? extends Employee> zsClass = zs.getClass();
        System.out.println(zsClass.getName());

        Class<Employee> employeeClass = Employee.class;
        Employee employee = employeeClass.getConstructor().newInstance();

        Class<?> aClass = Class.forName("com.example.demo.demo10Reflect.entity.Employee");
    }

    @Test
    public void test02() {
        Class<Employee> employeeClass = Employee.class;
        // 获取class文件同目录下的 文件url
        URL resource = employeeClass.getResource("img.png");
        System.out.println(resource);

        try (InputStream is = employeeClass.getResourceAsStream("img.png");
             OutputStream os = new FileOutputStream(new File("D:\\测试用例\\img.png"));) {
            int length = 0;
            byte[] bytes = new byte[1024];
            while ((length = is.read(bytes)) != -1) {
                os.write(length);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void test03() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.example.demo.demo10Reflect.entity.Employee");
        System.out.println("superClass " + aClass.getSuperclass());
        System.out.println("modifier " + Modifier.toString(aClass.getModifiers()));

        // 打印所有构造器方法
        printConstructors(aClass);

        // 打印所有普通方法
        printMethods(aClass);

    }

    private void printMethods(Class<?> aClass) {
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            String methodName = declaredMethods[i].getName();
            String modifierName = Modifier.toString(declaredMethods[i].getModifiers());
            System.out.println("方法名称：" + methodName + "方法修饰符" + modifierName);
            for (int i1 = 0; i1 < declaredMethods[i].getParameterCount(); i1++) {
                System.out.println("参数类型：" + declaredMethods[i].getParameterTypes()[i1]);
            }
        }
    }

    private void printConstructors(Class<?> aClass) {
        Constructor<?>[] constructors = aClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            String name = constructor.getName();
            String modifier = Modifier.toString(constructor.getModifiers());
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            System.out.println("构造函数名：" + name + "修饰符" + modifier);
            for (Class<?> parameterType : parameterTypes) {
                String paramName = parameterType.getName();
                System.out.println("参数：" + paramName);
            }
        }
    }

    @Test
    public void test04() {
        Employee zs = new Employee();
        zs.setSalary(2000);

        Employee ls = new Employee();
        ls.setSalary(1000);

        int i = zs.compareTo(ls);
        System.out.println(i);
    }
}
