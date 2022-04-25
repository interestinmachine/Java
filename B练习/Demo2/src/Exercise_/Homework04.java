package Exercise_;

public class Homework04 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new calculator() {
            @Override
            public double work(double n1, double n2) {
                return n1*n2;
            }
        },10,8);
    }
}

interface calculator {
    public double work(double n1,double n2);
}

class CellPhone {
    public void testWork(calculator ical,double n1,double n2){
        double result = ical.work(n1,n2);
        System.out.println("计算后的结果是 = " + result);
    }
}

