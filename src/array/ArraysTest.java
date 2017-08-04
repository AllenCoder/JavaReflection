package array;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * Created by Allen on 2017/8/4.
 */
public class ArraysTest {

    public static void main(String[] args) {
        Class clz = Shuzu.class;
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields
                ) {
            Class c = field.getType();
            if (c.isArray()) {
                System.out.println("c.getName() = " + c.getName());
                System.out.println("c.getComponentType() = " + c.getComponentType());
            }
        }

        try {
            Shuzu shuzu = (Shuzu) clz.newInstance();

            Field field = clz.getDeclaredField("array");
            field.setAccessible(true);
            Object o = Array.newInstance(int.class, 3);

            Array.set(o,0,1);
            Array.set(o,1,3);
            Array.set(o,2,3);
            field.set(shuzu,o);
            int[] array =shuzu.getArray();
            for(int i =0;i<array.length;i++){
                System.out.println("array index "+i+" value:"+array[i]);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
