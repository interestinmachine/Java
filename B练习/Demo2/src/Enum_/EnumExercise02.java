package Enum_;

public class EnumExercise02 {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        for(Week w : weeks){
            System.out.println(w);
        }
    }
}

enum Week{
    MONDAY("星期一"),
    TUESDAY("星期二");

    private String desci;

    private Week(String desc){
        this.desci = desc;
    }


    @Override
    public String toString() {
        return desci;
    }
}

