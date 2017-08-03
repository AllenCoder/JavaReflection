package method;

/**
 * Created by Allen on 2017/8/3.
 */
public class Son extends Father{
    public static void testStatic(){
        System.out.println("Son.testStatic");
    }
    public void d(){
        System.out.println("Son.d");
    }
    protected void e(){
        System.out.println("Son.e");
    }
    private int f(){
        System.out.println("Son.f");
        return 7;
    }

    @Override
    public void a() {
        super.a();
        System.out.println("Son.a");
    }
    public void testException () throws IllegalAccessException {
        throw new IllegalAccessException("You have some problem.");
    }


}
