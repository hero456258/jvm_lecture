package com.mingqian.jvm.classloader;

/**
 * Created by mingqian on 2019/4/13.
 * 对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为[Lcom.mingqian.jvm.classloader.MyParent4
 * 这种形式。动态生成的类型，其父类就是Object。
 * 对于数组来说，JavaDoc经常将构成数组的元素为Component，实际上就是将数组降低一个维度后的类型。
 * 助记符：
 *  anewarray:表示创建一个引用类型的(如类、接口、数组)数组，并将其引用值压入栈顶
 *  newarray:表示创建一个指定的原始类型(如int、float、char等)的数组，并将其引用值压入栈顶
 *
 */
public class MyTest4 {
    public static void main(String[] args) {
       // MyParent4 parent = new MyParent4();
        /**
         * 运行结果：
         *      MyParent4 static block
         */
        MyParent4[] myParent4 = new MyParent4[1];
        /**
         * 运行结果：
         *  无(不主动调用MyParent4)
         */
        System.out.println(myParent4.getClass());//class [Lcom.mingqian.jvm.classloader.MyParent4;

        MyParent4[][] myParent4s = new MyParent4[1][1];
        System.out.println(myParent4s.getClass());//class [[Lcom.mingqian.jvm.classloader.MyParent4;
        System.out.println(myParent4s.getClass().getSuperclass());//class java.lang.Object

        System.out.println("----------------------------");
        int[] ints = new int[1];
        System.out.println(ints.getClass());//class [Iclass [I
        System.out.println(ints.getClass().getSuperclass());//class java.lang.Object

        Boolean[] booleans = new Boolean[1];
        System.out.println(booleans.getClass());//class [Ljava.lang.Boolean;
        System.out.println(booleans.getClass().getSuperclass());//class java.lang.Object

        char[] chars = new char[1];
        System.out.println(chars.getClass());//class [C
        System.out.println(chars.getClass().getSuperclass());//class java.lang.Object

        short[] shorts = new short[1];
        System.out.println(shorts.getClass());//class [S
        System.out.println(shorts.getClass().getSuperclass());//class java.lang.Object



    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}


