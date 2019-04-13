package com.mingqian.jvm.classloader;

/**
 * Created by mingqian on 2019/4/13.
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中，
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化
 * 注意：这里指的是将常量存放到了MyTest2的常量中，之后，MyTest2与MyParent2就没有任何关系了
 * 甚至我们可以将MyParent2的class文件删除
 *
 * 助记符：
 *      ldc表示将int，float或是String类型的常量值从常量池中推送至栈顶
 *      bipush表示将单字节(-128 ~ 127)的常量值推送至栈顶
 *      sipush表示将一个短整型常量值(-32768 ~ 32767)的常量值推送至栈顶
 *      iconst_1表示将int类型1推送至栈顶(const_m1~const_5)表示-1-5
 * 使用javap +包名+类名 反编译.class文件
 */
public class MyTest2 {

    public static void main(String[] args) {
        System.out.println(MyParen2.str);
        /**
         * 运行结果：
         *      hello wordl
         */
    }
}

class MyParen2{
    public static final String str = "hello wordl"; //助记符：ldc
    public static final Short s = 127; //助记符：bipush
    public static final int i = 128;//助记符： sipush
    public static final int m = 1; //助记符：iconst_1


    static {
        System.out.println("MyParent2 static block");
    }
}
