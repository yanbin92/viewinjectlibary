/*
 * created by :hm_53
 * created date:16-1-25 上午10:10
 */

package com.yanb.viewinjectlibary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2016/1/25.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContentView {
    /**
     ContentView用于在类上使用，主要用于标明该Activity需要使用的布局文件。
     @ContentView(value = R.layout.activity_main)
     public class MainActivity
     */
    int value();
    /**
     声明注解的属性
     注解属性的作用：原来写在配置文件中的信息，可以通过注解的属性进行描述
     特殊属性value：如果注解中有一个名称value的属性，那么使用注解时可以省略value=部分，如@MyAnnotation(“xxx")
     特殊属性value[];
     注解支持类型：String、基本数据类型、枚举、Class 、其它注解类型、以上数据类型相应一维数组

     元 Annotation指修饰Annotation的Annotation。JDK中定义了如下元Annotation：
     @Retention: 只能用于修饰一个 Annotation 定义, 用于指定该 Annotation 可以保留的域, @Rentention 包含一个 RetentionPolicy 类型的成员变量, 通过这个变量指定域。
     RetentionPolicy.CLASS: 编译器将把注解记录在 class 文件中. 当运行 Java 程序时, JVM 不会保留注解. 这是默认值
     RetentionPolicy.RUNTIME:编译器将把注释记录在 class 文件中. 当运行 Java 程序时, JVM 会保留注解. 程序可以通过反射获取该注释
     RetentionPolicy.SOURCE: 编译器直接丢弃这种策略的注释

     @Target：指定注解用于修饰类的哪个成员. @Target 包含了一个名为 value，类型为ElementType的成员变量。
     @Documented: 用于指定被该元 Annotation 修饰的 Annotation 类将被 javadoc 工具提取成文档.
     @Inherited: 被它修饰的 Annotation 将具有继承性.如果某个类使用了被 @Inherited 修饰的 Annotation, 则其子类将自动具有该注解


     */
}
