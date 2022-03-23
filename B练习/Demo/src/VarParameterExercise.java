public class VarParameterExercise {
    public static void main(String[] args) {
        HspMethod msp = new HspMethod();
        msp.showScore("王五",10,20,30,40);
    }
}

class HspMethod{
    public void showScore(String name,double... scores){
        System.out.println(name + "的成绩为：");
        for(int i = 0; i < scores.length; ++i){
            System.out.print(scores[i] + " ");
        }
    }

}

