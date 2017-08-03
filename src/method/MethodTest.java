package method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Allen on 2017/8/3.
 */
public class MethodTest {

    //getDeclaredMethods 获取的是Class类被声明修饰的方法
//    getMethods 获取的是Class 已经父类的所有方法
    public static void main(String[] args) {
        Class cls = Son.class;

        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods
                ) {
            System.out.println("getDeclaredMethods() = " + method);
        }

//        getDeclaredMethods() = public void method.Son.d()
//        getDeclaredMethods() = private void method.Son.f()
//        getDeclaredMethods() = public void method.Son.a()
//        getDeclaredMethods() = protected void method.Son.e()

        Method[] methods1 = cls.getMethods();

        for (Method method : methods1
                ) {
            System.out.println("getMethods = " + method);
            System.out.println("method.getName() = " + method.getName());
            System.out.println("method.getModifiers() = " + method.getModifiers());
        }

        try {
            Method method =cls.getMethod("testStatic",null);
            try {
                method.setAccessible(true);
                method.invoke(null,null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Son son = new Son();

        try {
            Method method =cls.getDeclaredMethod("f",null);
            method.setAccessible(true);

            try {
                int result = (int) method.invoke(son,null);
                System.out.println("result = " + result);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Son t = new Son();

//        try {
//            Method mAdd = cls.getDeclaredMethod("add",int.class,int.class);
//            // 通过这句代码才能访问 private 修饰的 Method
//            mAdd.setAccessible(true);
//            int result = (int) mAdd.invoke(t, 1,2);
//            System.out.println("add method result:"+result);
//        } catch (NoSuchMethodException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (SecurityException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalArgumentException e) {
//            // TODO Auto-generated catch block
//            e.prwintStackTrace();
//        } catch (InvocationTargetException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        try {
            Method testExcep = cls.getMethod("testException",null);

            try {
                testExcep.invoke(t, null);
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();

                // 通过 InvocationTargetException.getCause() 获取被包装的异常
                System.out.println("testException occur some error,Error type is :"+e.getCause().getClass().getName());
                System.out.println("Error message is :"+e.getCause().getMessage());
            }


        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
