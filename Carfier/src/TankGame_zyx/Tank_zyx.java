package TankGame_zyx;

import java.util.Vector;

@SuppressWarnings({"all"})
//自己的坦克
public class Tank_zyx extends Tank {

    //定义一个Shot对象
    Shot shot = null;
    //可以发射多颗子弹
    Vector<Shot> shots = new Vector<>();

    public Tank_zyx() {
    }

    public Tank_zyx(int x, int y) {
        super(x, y);
    }

    //射击行为
    public void shotEnemy() {
        //自己的坦克最多有6个
        if (shots.size() == 6) {
            return;
        }

        //创建shot对象 ->根据当前对象创建shot对象
        switch (getDire()) {  //坦克的方向
            case 1://向上
                shot = new Shot(getX() + 20, getY() - 10, 1);
                break;
            case 2://向下
                shot = new Shot(getX() + 20, getY() + 70, 2);
                break;
            case 3://向左
                shot = new Shot(getX() - 10, getY() + 20, 3);
                break;
            case 4://向右
                shot = new Shot(getX() + 70, getY() + 20, 4);
                break;
        }

        //创建的shot放入到集合中
        shots.add(shot);
        //启动shot线程
        Thread thread = new Thread(shot);
        thread.start();

    }
}
