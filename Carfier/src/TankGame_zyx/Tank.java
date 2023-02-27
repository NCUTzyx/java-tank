package TankGame_zyx;

@SuppressWarnings("all")
//坦克
public class Tank {

    private int x; //坦克横坐标
    private int y; //坦克纵坐标
    private int dire = 1; //坦克的方向 1上 2下 3左 4右
    private int speed = 1;  //坦克的速度，默认为1
    boolean isLive = true;

    public int getSpeed() {
        return speed;
    }

    public Tank() {
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //向上移动
    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public int getDire() {
        return dire;
    }

    public void setDire(int dire) {
        this.dire = dire;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
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
