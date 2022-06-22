package org.example.ReflectionTest;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


public class GetGenericTypeDemo14 {

    Map<String, Integer> map = new HashMap<String, Integer>();


    public static void main(String[] args) throws Exception {

        Class c = GetGenericTypeDemo14.class;

        Field f = c.getDeclaredField("map");

        System.out.println(f);

        System.out.println(f.getName());//map


        // Class<?> getType()  返回一个 Class 对象，它标识了此 Field 对象所表示字段的声明类型。

        Class cl = f.getType();

        System.out.println("获得其类型：" + cl);

//获得其类型：interface java.util.Map


        /**
         *  Type getGenericType() 返回一个 Type 对象，它表示此 Field 对象所表示字段的声明类型。
         *  Type是Class的接口;

         */

        Type t = f.getGenericType();//包含泛型的类型

        System.out.println(t);

//java.util.Map<java.lang.String, java.lang.Integer>


        /**
         * Type这个类里面没有任何的方法，所以需要调用子类的方法，那么大的类型转到小的类型，需要强转！

         */

        ParameterizedType pt = (ParameterizedType) t;//强转到其子类

        /**
         *  Type[] getActualTypeArguments()

         返回表示此类型实际类型参数的 Type对象的数组。

         Type getOwnerType()

         返回 Type 对象，表示此类型是其成员之一的类型。

         Type getRawType()

         返回 Type 对象，表示声明此类型的类或接口。

         */


        t = pt.getRawType();//类型的类或接口

        System.out.println(t);


        Type[] ts = pt.getActualTypeArguments();

        for (Type type : ts) {

            System.out.println(type);

            /**
             *  class java.lang.String

             class java.lang.Integer

             */

        }

    }

}