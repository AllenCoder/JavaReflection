import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
//       通过 .class 标识获取
        Class car = Car.class;
        Class cls2 = int.class;
        Class cls3 = String.class;
        System.out.println("car = " + car);
        System.out.println("cls2 = " + cls2);
        System.out.println("cls3 = " + cls3);


//       通过Class.forName() 方法获取
        try {
            Class clz = Class.forName("Car");
            System.out.println("clz = " + clz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


//        getName 作用

        getClassName();

        getInnerClass();

        getSimpleName();

        getAnonymousClassName();

        getCanonicalName();

    }

    public static void getClassName() {

        System.out.println("\"\\\\ = " + "\n");
        try {
            Class clz = Class.forName("Car");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class clz1 = float.class;
        Class clz2 = Void.class;
        Class clz3 = new int[]{}.getClass();
        Class clz4 = new Car[]{}.getClass();

        System.out.println("clz1 = " + clz1);
        System.out.println("clz2 = " + clz2);
        System.out.println("clz3 = " + clz3);
        System.out.println("clz4 = " + clz4);
    }

    public static void getInnerClass() {

        System.out.println("getInnerClss ---- \n");
        Class clz = Outter.Inner.class;
        System.out.println("clz.getName() = " + clz.getName());
        System.out.println("clz.getSimpleName = " + clz.getSimpleName());

//        clz.getName() = Outter$Inner
//        clz.getSimpleName = Inner
    }

    /**
     * simplename的不同
     *
     * @param args
     */
    public static void getSimpleName() {
        System.out.println("\n");
        Class clz = new Outter.Inner[][][]{}.getClass();
        System.out.println("c = " + clz.getName());
        System.out.println("clz = " + clz.getSimpleName());

//        Inner Class name:[[[Lcom.frank.test.Outter$Inner;
//        Inner Class simple name:Inner[][][]
    }

    /**
     * 匿名的内部类的getSimpleName
     */
    public static void getAnonymousClassName() {

        System.out.println("匿名的内部类的getSimpleName" +"\n");
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("true = " + true);
            }
        };
        System.out.println("run.getClass().getName() = " + run.getClass().getName());
        System.out.println("run.getClass().getSimpleName() = " + run.getClass().getSimpleName());

//        run.getClass().getName() = Main$1
//        run.getClass().getSimpleName() =
    }

    /**
     *
     */
    public static void getCanonicalName() {
        Class clz = new Outter.Inner[][][]{}.getClass();
        System.out.println("clz.getName() = " + clz.getName());
        System.out.println("clz.getSimpleName() = " + clz.getSimpleName());
        System.out.println("clz.getCanonicalName() = " + clz.getCanonicalName());
    }
}
