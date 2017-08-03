package field;

import java.lang.reflect.Field;

/**
 * Created by Allen on 2017/8/3.
 */
public class FieldTest {

    //    getDeclaredField的() 获取的是Class 中被private修饰的属性 可以获取 private、protected、public 和 default 属性，但是它获取不到从父类继承下来的属性。
//    getField() 获取的是非私有属性，并且getField()在当前class获取不到时会向祖先类获取
//getGenericType() 确实把泛型都打印出来了，它比 getType() 返回的内容更详细。
//    getName()  获取声明名字
    public static void main(String[] args) {
        Class cls = Son.class;
        try {
            Field field = cls.getDeclaredField("c");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            System.out.println("e.getMessage() = [" + e.getMessage() + "]");
        }


        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("f.getName() = " + f.getName());
            System.out.println("f.getType() = " + f.getType());
            System.out.println("f.getGenericType() = " + f.getGenericType());

        }
        System.out.println(" = ========================");
        Field[] fields1 = cls.getFields();
        for (Field f : fields1) {
            System.out.println("f.getName() = " + f.getName());
            System.out.println("f.getType() = " + f.getType());
            System.out.println("f.getGenericType() = " + f.getGenericType());
        }
        modifyField();
    }

    public static void modifyField() {
        Class son =Son.class;
        Son son1 = new Son(1,"2");
//            Son son2 = (Son) son.newInstance();
        try {
           Field field= son.getDeclaredField("c");
           field.setAccessible(true);
                System.out.println("field.getInt(son1) = " + field.getInt(son1));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
