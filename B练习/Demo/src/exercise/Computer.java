package exercise;

public class Computer {
    private String CPU;
    private int Memory;
    private int Drive;

    public Computer(String cpu,int memory,int dirve){
        this.CPU = cpu;
        this.Memory = memory;
        this.Drive = dirve;
    }

    public String getDetails(){
        return "CPU = " + this.CPU + " Memory = " + this.Memory + " Drive = " + this.Drive;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getMemory() {
        return Memory;
    }

    public void setMemory(int memory) {
        Memory = memory;
    }

    public int getDrive() {
        return Drive;
    }

    public void setDrive(int drive) {
        Drive = drive;
    }
}





