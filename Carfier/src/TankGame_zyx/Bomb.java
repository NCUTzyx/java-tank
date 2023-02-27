package TankGame_zyx;

//炸弹
public class Bomb {
    int x, y; //炸弹周期
    int life = 16;//炸弹生命周期
    boolean BisLive = true;//是否存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //生命减少
    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            BisLive = false;
        }
    }
}
