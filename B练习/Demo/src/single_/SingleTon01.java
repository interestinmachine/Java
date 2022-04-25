package single_;

public class SingleTon01 {
    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);

        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance == instance2); // true
    }
}

class GirlFriend {
    private String name;

    // 为了能够在静态方法中，返回 gf 对象，需要将其修饰为 static
    private static GirlFriend gf = new GirlFriend("小红");

    // 如何保证我们只能创建一个 GirlFriend 对象
    // 步骤[单例模式-饿汉式]
    // 1. 构造器私有化
    // 2. 在类的内部直接创建
    // 3. 提供一个公共的static方法，返回 gf 对象
    private GirlFriend(String name){
        this.name = name;
    }

    public static GirlFriend getInstance(){
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}

