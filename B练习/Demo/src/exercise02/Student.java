package exercise02;

public class Student extends Person{
    private int id;
    private int score;

    public Student(){}

    public Student(String name, int age, int id, int score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    @Override
    public String say(){
        return super.say() + " my id is " + this.id + " and my score is " + this.score;
    }
}

