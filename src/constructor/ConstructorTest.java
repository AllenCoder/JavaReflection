package constructor;

import java.lang.reflect.Constructor;

/**
 * Created by Allen on 2017/8/3.
 */
public class ConstructorTest {
//Constructor 不能从父类继承，所以就没有办法通过 getConstructor() 获取到父类的 Constructor。


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
    }
}
