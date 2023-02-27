package TankGame_zyx;

//表示敌人坦克的信息

public class TankNode {
    private int x;
    private int y;
    private int dire;

    public TankNode(int x, int y, int dire) {
        this.x = x;
        this.y = y;
        this.dire = dire;
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

    public int getDire() {
        return dire;
    }

    public void setDire(int dire) {
        this.dire = dire;
    }

}
