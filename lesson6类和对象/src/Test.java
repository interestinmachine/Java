class Person4 {

    private String name;//实例成员变量
    private int age;
    private String sex;
    //默认构造函数 构造对象
    public Person4() {
        this.name = "caocao";
        this.age = 10;
        this.sex = "男";
    }
    //带有3个参数的构造函数
    public Person4(String name,int age,String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void show(){
        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
    }

}
class Test{
    public static void main(String[] args) {
        new Person4("caocao",19,"男").show(); // 通过匿名对象调用方法
    }
}