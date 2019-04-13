package com.mingqian.jvm.classloader;

/**
 * Created by mingqian on 2019/4/13.
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时，要求其父类全部都已经初始化完毕了
 * -XX:+TraceClassLoading   用于追踪类的的加载信息并打印出来
 * -XX:+<option>    表示开启option选项
 * -XX:-<option>    表示关闭option选项
 * -XX:<option>=<value>    表示option选项的值设置为value
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
        /**
         * 运行结果：
         * MyParent1 static block
         * hello world
         * 结果分析：
         *      这里并没有初始化MyChild1因为str是定义在父类，所以没有主动使用MyChild1，
         *      而是主动使用调用的父类，并初始化父类，
         *      所以MyChild1并没有初始化并执行静态代码块，虽然没有初始化MyChile1，
         *      但是jvm加载了MyChild1.class
         *      [Loaded com.mingqian.jvm.classloader.MyParent1 from file:/F:/code/jvm_lecture/build/classes/java/main/]
         *      [Loaded com.mingqian.jvm.classloader.MyChild1 from file:/F:/code/jvm_lecture/build/classes/java/main/]
         */

       // System.out.println(MyChild1.str2);
        /**
         * 运行结果：
         * MyParent1 static block
         * MyChild1 static block
         * welcome
         * 结果分析：
         *    因为str2调用的MyChild1的静态变量，会主动使用MyChild1，
         *    由于MyChild1继承了MyParent1所以会显示初始化MyParent1，
         *    所以会执行MyParent1的静态代码块
         *
         *
         */
    }
}

class MyParent1{
    public static String str = "hello world";
    static {
        System.out.println("MyParent1 static block");
    }

}

class MyChild1 extends MyParent1{
    public static String str2 = "welcome";
    static {
        System.out.println("MyChild1 static block");
    }
}
