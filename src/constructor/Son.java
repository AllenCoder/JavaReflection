package constructor;

import method.Father;

/**
 * Created by Allen on 2017/8/3.
 */
public class Son extends Father {

//    public Son() {
//        super();
//    }
//
//    public Son(int a) {
//        super();
//    }

    private String self;
    public Son(){
        System.out.println("Son.Son 无形参");
    }

    public Son(int a, int b) {
        super();
        System.out.println("Son.Son 两个形参");
    }
}