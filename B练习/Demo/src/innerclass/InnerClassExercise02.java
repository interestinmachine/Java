package innerclass;

import javafx.scene.control.Cell;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪，起床了");
            }
        });
        cellPhone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴，上课了");
            }
        });
    }
}

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmclock(Bell bell){
        bell.ring();
    }
}
