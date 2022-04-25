package exercise03;

public class Homework03 {
    public static void main(String[] args) {
        Teacher teacher1 = new professor("宋",33,"教授",5000);
        Teacher teacher2 = new associate_professor("李",50,"副教授",4000);
        Teacher teacher3 = new lecturer("管",23,"讲师",3000);

        teacher1.introduce();
        teacher2.introduce();
        teacher3.introduce();
    }
}

class Teacher{
    private String name;
    private int age;
    private String post;
    private double salary;

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    public void introduce(){
        System.out.println("姓名：" + this.name + " 年龄：" + this.age
            + " 职称：" + this.post + " 薪水：" + this.salary);
    }
}

class professor extends Teacher{
    public professor(String name, int age, String post, double salary) {
        super(name, age, post = "教授", salary*1.3);
    }

    @Override
    public void introduce() {
        super.introduce();
    }
}

class associate_professor extends Teacher{
    public associate_professor(String name, int age, String post, double salary) {
        super(name, age, post="副教授", salary*1.2);
    }

    @Override
    public void introduce() {
        super.introduce();
    }
}

class lecturer extends Teacher{
    public lecturer(String name, int age, String post, double salary) {
        super(name, age, post="讲师", salary*1.1);
    }

    @Override
    public void introduce() {
        super.introduce();
    }
}

