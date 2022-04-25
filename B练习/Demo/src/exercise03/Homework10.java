package exercise03;

public class Homework10 {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("111",18,"it","男","A");
        Doctor doctor2 = new Doctor("111",19,"it","男","A");
        System.out.println(doctor1.equals(doctor2));
    }
}

class Doctor{
    private String name;
    private int age;
    private String job;
    private String gender;
    private String sal;

    public Doctor(String name, int age, String job, String gender, String sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    @Override
    public boolean equals(Object obj) {
        Doctor d = (Doctor) obj;
        if (this.name.equals(d.name) && this.age == d.age && this.gender.equals(d.gender)
            && this.job.equals(d.job) && this.sal.equals(d.sal)){
            return true;
        }
        return false;
    }
}
