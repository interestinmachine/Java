package tankgame4;

import javax.swing.*;

public class tankGame04 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        tankGame04 tankGame01 = new tankGame04();
    }

    public tankGame04(){
        mp = new MyPanel();
        //将 mp 放入到Thread，并启动
        new Thread(mp).start();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

