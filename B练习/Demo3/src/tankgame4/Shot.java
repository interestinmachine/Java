package tankgame4;

public class Shot implements Runnable{
    int x;
    int y;
    int direct = 0;//子弹的方向
    int speed = 1; //子弹的速度
    boolean isLive = true; //子弹是否还存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50); //休眠50ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct) {
                case 0: //向上
                    y -= speed;
                    break;
                case 1: //向右
                    x += speed;
                    break;
                case 2: //向下
                    y += speed;
                    break;
                case 3: //向左
                    x -= speed;
                    break;
            }
            //测试
            System.out.println("子弹 x=" + x + " y=" + y);
            //当子弹移动到面板的边界时，就应该销毁（把启动子弹的线程销毁）
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 7500)) {
                isLive = false;
                break;
            }
        }
    }
}

