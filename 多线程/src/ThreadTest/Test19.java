package ThreadTest;

public class Test19 {
    // 饿汉模式
    static class Singleton {
        // 将构造方法设为 private，防止在类外调用构造方法，也就禁止了调用者在其他地方创建实例的机会
        private Singleton() {

        }

        private static Singleton instance = new Singleton();

        public static Singleton getInstance() {
            return instance;
        }
    }
}

