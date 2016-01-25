/*
 * created by :hm_53
 * created date:16-1-25 上午11:00
 */

package com.yanb.viewinjectlibary;

import android.app.Activity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/1/25.
 */
public class ViewInjectUtils {

    public static void inject(Activity activity)
    {

        injectContentView(activity);
        injectViews(activity);

    }

    static final String METHOD_SET_CONTENTVIEW = "setContentView";

    /**
     * 注入主布局文件
     *
     * @param activity
     */
    private static void injectContentView(Activity activity) {
        Class<? extends Activity> clazz = activity.getClass();
        // 查询类上是否存在ContentView注解
        ContentView contentView = clazz.getAnnotation(ContentView.class);
        if (contentView != null)// 存在
        {
            int contentViewLayoutId = contentView.value();
//            activity.setContentView(contentViewLayoutId);
            try {/**
             B.class.isAnnotionPresent(
             A.class);
             A a = B.class.getAnnotion(
             A.class);
             **/
                Method method = clazz.getMethod(METHOD_SET_CONTENTVIEW,
                        int.class);
                method.setAccessible(true);
                method.invoke(activity, contentViewLayoutId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private static final String METHOD_FIND_VIEW_BY_ID = "findViewById";

    /**
     * 注入所有的控件
     *
     * @param activity
     */
    private static void injectViews(Activity activity) {
        Class<? extends Activity> clazz = activity.getClass();
        Field[] fields = clazz.getFields();
        for (Field field:fields
             ) {
            ViewInject annotation = field.getAnnotation(ViewInject.class);

            if (annotation != null) {

                int viewId = annotation.value();
                try {
                    Method method = clazz.getMethod(METHOD_FIND_VIEW_BY_ID, int.class);
                    method.setAccessible(true);
                    //调用findviewbyid
                    Object resView = method.invoke(activity, viewId);
                    field.setAccessible(true);
                    //最后把值设置给field~~~
                    field.set(activity,resView);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }



    }

}
