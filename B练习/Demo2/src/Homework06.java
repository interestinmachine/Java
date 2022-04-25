public class Homework06 {
    public static void main(String[] args) {
        Person monk = new Person("唐僧",new Horse());
        monk.passRiver();
        monk.common();
        monk.passMountain();
    }
}

interface Vehicles {
    public void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("Horse is working");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("Boat is working");
    }
}

class Fly implements Vehicles {
    @Override
    public void work() {
        System.out.println("Plane is working");
    }
}

class traffic_tools_factory {
    //始终使用同一匹马
    private static Horse horse = new Horse();
    private traffic_tools_factory(){

    }
    public static Horse getHorse(){
        return horse;
    }

    public static Boat getBoat(){
        return new Boat();
    }

    public static Fly getFly() {
        return new Fly();
    }
}

class Person {
    public String name;
    public Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)){
            vehicles = traffic_tools_factory.getBoat();
        }
        vehicles.work();
    }

    public void common() {
        if (!(vehicles instanceof Horse)) {
            vehicles = traffic_tools_factory.getHorse();
        }
        vehicles.work();
    }

    public void passMountain() {
        if (!(vehicles instanceof Fly)){
            vehicles = traffic_tools_factory.getFly();
        }
        vehicles.work();
    }
}

