package tankgame4;

import tankgame4.Shot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
//为了监听键盘事件，实现 KeyListener
//为了让 Panel 不停的重绘子弹，需要将 MyPanel 实现Runnable,当做一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个Vector，用于存放炸弹
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;
    public MyPanel() {
        //初始化自己的坦克
        hero = new Hero(100,100);
        //初始化敌人坦克
        for(int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank((100*(i+1)),0);
            //设置方向
            enemyTank.setDirect(2);
            //给该 enemyTank 加入一颗子弹
            Shot shot = new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
            //加入enemyTank的Vector成员
            enemyTank.shots.add(shot);
            //启动 shot 对象
            new Thread(shot).start();
            //加入
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形，默认黑色

        //画出自己坦克 -- 封装方法
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),0);

        //画出hero射击的子弹
        if (hero.shot != null && hero.shot.isLive) {
            g.draw3DRect(hero.shot.x,hero.shot.y,2,2,false);
        }

        //画出敌人坦克，遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断当前坦克是否还存活
            if (enemyTank.isLive) {//当敌人坦克是存活的，才画出坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                //画出 enemyTank 所有子弹
                for (int j = 0; j < enemyTank.shots.size(); ++j) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else {
                        //从Vector移除
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
    }

    //编写方法，画出坦克

    /**
     *
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y坐标
     * @param g 画笔
     * @param direct 坦克的方向（上下左右）
     * @param type 坦克的类型
     */
    public void drawTank(int x,int y,Graphics g,int direct,int type){

        //根据不同类型的坦克，设置不同的颜色
        switch (type) {
            case 0: //自己的坦克
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.YELLOW);
                break;
        }

        //根据坦克的方向，来绘制坦克
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x+30,y,10,60,false);//画出坦克右边的轮子
                g.fill3DRect(x+10,y+10,20,40,false);//画出坦克的盖子
                g.fillOval(x+10,y+20,20,20);//画出圆盖
                g.drawLine(x+20,y+30,x+20,y);//画出炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x,y,60,10,false);//画出坦克左边的轮子
                g.fill3DRect(x,y+30,60,10,false);//画出坦克右边的轮子
                g.fill3DRect(x+10,y+10,40,20,false);//画出坦克的盖子
                g.fillOval(x+20,y+10,20,20);//画出圆盖
                g.drawLine(x+30,y+20,x+60,y+20);//画出炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x+30,y,10,60,false);//画出坦克右边的轮子
                g.fill3DRect(x+10,y+10,20,40,false);//画出坦克的盖子
                g.fillOval(x+10,y+20,20,20);//画出圆盖
                g.drawLine(x+20,y+30,x+20,y+60);//画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x,y,60,10,false);//画出坦克左边的轮子
                g.fill3DRect(x,y+30,60,10,false);//画出坦克右边的轮子
                g.fill3DRect(x+10,y+10,40,20,false);//画出坦克的盖子
                g.fillOval(x+20,y+10,20,20);//画出圆盖
                g.drawLine(x+30,y+20,x,y+20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    //编写方法，判断我方的子弹是否击中敌人坦克
    public void hitTank(Shot s,EnemyTank enemyTank) {
        //判断 s 是否击中坦克
        switch (enemyTank.getDirect()) {
            case 0: //坦克向上
            case 2: //坦克向下
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX()+40
                && s.y > enemyTank.getY() && s.y < enemyTank.getY()+60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    Bomb bomb = new Bomb(enemyTank.getX(),enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1: //坦克向右
            case 3: //坦克向左
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX()+60
                && s.y > enemyTank.getY() && s.y < enemyTank.getY()+40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    Bomb bomb = new Bomb(enemyTank.getX(),enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理 wdsa 键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            //改变坦克方向
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDirect(3);
            hero.moveLeft();
        }

        //如果用户按下的是 J 就发射
        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("用户按下了 J，开始射击");
            hero.shotEnemyTank();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { //每隔100ms，重绘区域，刷新绘图区域，子弹就移动起来了
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //判断是否击中敌人坦克
            if (hero.shot != null && hero.shot.isLive) { //当我的子弹还存活
                //遍历敌人所有的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(hero.shot,enemyTank);
                }
            }
            this.repaint();
        }
    }
}

