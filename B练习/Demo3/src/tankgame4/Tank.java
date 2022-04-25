package tankgame4;

public class Tank {
    private int x; //坦克的横坐标
    private int y; //坦克的纵坐标
    private int direct; //坦克方向

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //移动方法
    public void moveUp() {
        y -= 1;
    }
    public void moveDown() {
        y += 1;
    }
    public void moveLeft() {
        x -= 1;
    }
    public void moveRight() {
        x += 1;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

