package tankgame4;

import tankgame4.Shot;

import java.util.Vector;

public class EnemyTank extends Tank {
    //在敌人坦克类，使用 Vector 保存多个 Shot
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}

