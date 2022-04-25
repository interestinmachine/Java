package smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {

    //1. 先完成显示菜单，并可以选择菜单，给出对应提示
    //2. 完成零钱通明细
    //3. 完成收益入账
    //4. 完成消费

    public static void main(String[] args) {

        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2.零钱通明细
        String details = "-----------------零钱通明细-----------------";

        //3. 完成收益入账
        double money = 0;
        double balance = 0;//余额
        Date date = null; //日期类
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于日期格式化

        //4. 完成消费
        String note = ""; //消费的原因


        do{
            System.out.println("============零钱通菜单============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.println("请选择（1-4）：");
            key = scanner.next();

            switch (key){
                case "1":
                    System.out.println(details);
                    break;

                case "2":
                    System.out.print("收益入账金额：");
                    money = scanner.nextDouble();
                    if (money <=0){
                        System.out.println("收益入账金额应大于0！");
                        break;
                    }
                    balance += money;
                    date = new Date(); // 获取当前日期
                    //拼接入账信息
                    details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
                    break;

                case "3":
                    System.out.print("消费金额：");
                    money = scanner.nextDouble();
                    if(money <= 0 || money > balance){
                        System.out.println("消费金额应在1~" + balance);
                        break;
                    }
                    balance -= money;
                    System.out.print("消费原因：");
                    note = scanner.next();
                    //拼接消费信息
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
                    break;

                case "4":
                    String choice = "";
                    while(true){
                        System.out.println("你确定要退出吗？y/n");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)){
                            break;
                        }
                    }
                    if ("y".equals(choice)){
                        loop = false;
                        System.out.println("退出零钱通！");
                    }
                    break;
                default:
                    System.out.println("输入有误！");
                    break;
            }

        }while(loop);

    }
}

