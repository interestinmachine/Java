package exercise;

public class PC extends Computer{
    private String brand;

    public PC(String cpu, int memory, int dirve, String brand) {
        super(cpu, memory, dirve);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void print(){
        System.out.println("pc信息为：");
        // 调用父类的getDetails方法获得父类属性
        System.out.println(getDetails() + " " + " brand = " + this.brand);
    }
}

