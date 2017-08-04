package reflectenum;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by Allen on 2017/8/4.
 */
public class TestEnum {


    public static void main(String[] args) {
        Class cls = State.class;
        if (cls.isEnum()) {
            System.out.println("cls.isEnum() = " + cls.isEnum());
            System.out.println(Arrays.asList(cls.getEnumConstants()));

            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields
                    ) {

                if (f.isEnumConstant()) {
                    System.out.println("f.getName() = " + f.getName() + " is  EnumConstant");
                } else {
                    System.out.println("f.getName() +\"is not EnumConstant\" = " + f.getName() + "is not EnumConstant");
                }
            }
            Class cMeiju = Meiju.class;
            Meiju meiju = new Meiju();
            try {
                Field f = cMeiju.getDeclaredField("state");
                f.setAccessible(true);

                State state = (State) f.get(meiju);
                state.test1();
                f.set(meiju, State.STOPPING);
                System.out.println("State current is " + meiju.getState());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


    }
}
