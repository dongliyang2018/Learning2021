package com.dong.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * TestStudent
 * @version 1.0 2021/4/25
 * @author dongliyang
 */
public class TestStudent {

    public static void main(String[] args) {
        Student student = new Student();

        Class clazz = student.getClass();
        System.out.println("clazz:" + clazz + ",superClass:" + clazz.getSuperclass());

        //getGenericSuperclass()获取带有泛型的父类
        Type type = clazz.getGenericSuperclass();
        System.out.println("type:" + type);

        //ParameterizedType参数化类型，即泛型
        ParameterizedType p = (ParameterizedType)type;

        //getActualTypeArguments()后去参数化类型的数组，泛型可能有多个
        Type[] actualTypeArguments = p.getActualTypeArguments();

        Class c1 = (Class)actualTypeArguments[0];
        Class c2 = (Class)actualTypeArguments[1];
        System.out.println("c1:" + c1 + ",c2:" + c2);
    }
}
