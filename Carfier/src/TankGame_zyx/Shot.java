package TankGame_zyx;

//发射子弹
public class Shot implements Runnable {
    //子弹坐标
    int x, y;
    //子弹方向
    int dire = 1;
    //子弹的速度
    int speed = 10;
    //子弹是否存活
    boolean isLive = true;

    //构造器
    public Shot(int x, int y, int dire) {
        this.x = x;
        this.y = y;
        this.dire = dire;
    }

    //射击行为
    @Override
    public void run() {
        while (true) {
            //子弹休眠
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //根据方向改变x,y的坐标
            switch (dire) {
                case 1://向上
                    y -= speed;
                    break;
                case 2://向下
                    y += speed;
                    break;
                case 3://向左
                    x -= speed;
                    break;
                case 4://向右
                    x += speed;
                    break;
            }
            //子弹移动的坐标
            //System.out.println("x:" + x + "y" + y);

            //子弹移动到边界，销毁 子弹碰到其他坦克
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 800 && isLive)) {
                isLive = false;
                //System.out.println("子线程退出·");
                break;
            }

        }
    }
}
