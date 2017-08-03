package constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Allen on 2017/8/3.
 */
public class ConstructorTest {
//Constructor 不能从父类继承，所以就没有办法通过 getConstructor() 获取到父类的 Constructor。

//Class.newInstance() 只能调用无参的构造方法，而 Constructor.newInstance() 则可以调用任意的构造方法。
//  Class.newInstance() 通过构造方法直接抛出异常，而 Constructor.newInstance() 会把抛出来的异常包装到 InvocationTargetException 里面去，这个和 Method 行为一致。
//Class.newInstance() 要求构造方法能够被访问，而 Constructor.newInstance() 却能够访问 private 修饰的构造器。
    public static void main(String[] args) {
        Class clz = Son.class;

        Constructor[] constructors = clz.getConstructors();
        Constructor[] constructors2 = clz.getDeclaredConstructors();

        for (Constructor c : constructors
                ) {
            System.out.println("getConstructors = " + c);

        }
        for (Constructor c : constructors2
                ) {
            System.out.println("getDeclaredConstructors = " + c);
        }

        try {
            Son son = (Son) clz.newInstance();

            System.out.println("son = " + son.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Constructor constructor = clz.getConstructor(int.class,int.class);
            Son son = (Son) constructor.newInstance(1,2);
            System.out.println("son.toString() = " + son.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
