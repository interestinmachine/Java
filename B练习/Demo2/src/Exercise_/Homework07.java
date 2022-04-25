package Exercise_;

public class Homework07 {
    public static void main(String[] args) {
        Car car = new Car();
        car.setTemperature(41);
        car.t1();
        car.setTemperature(-2);
        car.t1();
        car.setTemperature(12);
        car.t1();

    }
}

class Car {
    private double temperature;
    class Air {
        public void flow() {
            if (temperature > 40){
                System.out.println("吹冷气");
            } else if (temperature < 0) {
                System.out.println("吹暖气");
            } else {
                System.out.println("关闭空调");
            }
        }
    }

    public void t1(){
        Air air = new Air();
        air.flow();
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }
}