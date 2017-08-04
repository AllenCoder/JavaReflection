package classtest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Allen on 2017/8/4.
 */
public class DriveTest {
    public static void main(String[] args) {
        AutoDrive car = new AutoDrive();
        car.drive();

        /*  空挡发动汽车
            打左转向灯
            踩离合器，挂一档
            起步松手刹
            您正在驾驶的 WHITE Nissan汽车，小心驾驶
         */

        Class cls = AutoDrive.class;
        try {
            Constructor constructor= cls.getConstructor(String.class,AutoDrive.Color.class);
            AutoDrive autoDrive = (AutoDrive) constructor.newInstance("Tesla",AutoDrive.Color.REN);
            Method method =cls.getDeclaredMethod("drive");
            System.out.println("=====================\\n自动驾驶马上开始\\n================");
            method.invoke(autoDrive,null);
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
