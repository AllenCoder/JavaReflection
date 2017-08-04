package classtest;

/**
 * Created by Allen on 2017/8/4.
 */
public class AutoDrive {

    public enum Color {
        WHITE,
        REN,
        BLUE
    }

    private String vendor;
    private Color color;

    public AutoDrive(String vendor, Color color) {
        super();
        this.vendor = vendor;
        this.color = color;
    }

    public AutoDrive() {
        this.vendor = "Nissan";
        this.color = Color.WHITE;
    }

    public void drive() {
        boot();
        turnOnLeftLight();
        cailiheguaiyidang();
        songshousha();
        tips();
    }

    private void cailiheguaiyidang() {
        System.out.println("踩离合器，挂一档");
    }

    private void tips() {
        System.out.println("您正在驾驶的 " + color + " " + vendor + "汽车，小心驾驶");
    }

    private void songshousha() {
        System.out.println("起步松手刹");
    }

    private void turnOnLeftLight() {
        System.out.println("打左转向灯");
    }

    private void boot() {

        System.out.println("空挡发动汽车");
    }
}
