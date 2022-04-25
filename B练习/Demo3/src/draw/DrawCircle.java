package draw;

import javax.swing.*;
import java.awt.*;

// 演示如何在面板上画出圆形
public class DrawCircle extends JFrame{ // JFrame 对应窗口，可以理解成就是一个画框
    //定义一个画板
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() { //构造器
        //初始化面板
        mp = new MyPanel();
        //把画板放入到窗口（画框）
        this.add(mp);
        //设置窗口的大小
        this.setSize(400,300);
        // 当电机窗口的×时，程序会完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); // 可以显示
    }
}

//1. 先定义一个MyPanel，继承JPanel类，画圆形，就在面板上画
class MyPanel extends JPanel {

    //说明：
    //1. MyPanel 对象就是一个画板
    //2. Graphics g 把 g 理解成一支画笔
    //3. Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g) { // 绘图方法
        super.paint(g); // 调用父类的方法完成初始化
        //画出一个圆形
        //g.drawOval(10,10,100,100);

        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/1635861078670.jpeg"));
        g.drawImage(image,10,10,636,400,this);
    }
}

