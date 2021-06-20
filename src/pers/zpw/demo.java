package pers.zpw;

/**
 *
 * @author ZhuPengWei
 * @email pengwei@mgtv.com
 * @date 2020-03-31 17:43
 */
public class demo {

    private static  int data = 0;

    public static void main(String[] args) {


        for (int i = 0; i < 1000; i++) {
            new Thread(demo::run).start();
        }

        System.out.println(data+"----");
    }

    private static void run() {
        for (int i = 0; i < 200; i++) {
            data++;
        }
    }
}
