package pers.zpw.bingfa.demo;

public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton instance;

    public DoubleCheckSingleton getInstance() {
        if (instance == null) {
            // 多个线程卡在这里
            synchronized (DoubleCheckSingleton.class) {

                if (instance == null) {
                    DoubleCheckSingleton.instance = new DoubleCheckSingleton();
                }
            }
        }

        return instance;
    }
}
