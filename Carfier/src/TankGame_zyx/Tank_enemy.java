package TankGame_zyx;

import java.util.Vector;

@SuppressWarnings({"all"})
//敌人的坦克
public class Tank_enemy extends Tank implements Runnable {

    //使用Vector保存多个Shot
    Vector<Shot> shot_e = new Vector<>();
    //增加成员，利于相互比较
    Vector<Tank_enemy> tank_enemies = new Vector<>();

    //设置一个方法
    //可以将MyPanel 对象的Vector<Tank_enemy> tank_enemy =new Vector<>() 设置进来
    public void setTank_enemies(Vector<Tank_enemy> tank_enemies) {
        this.tank_enemies = tank_enemies;
    }

    //编写方法，判断当前敌人坦克是否和tank_enemy 里的坦克碰撞
    public boolean EisTouch() {

        //判断当前敌人坦克（this）方向
        switch (this.getDire()) {
            case 1: //向上
                //当前的敌人坦克和其他所有的坦克比较
                for (int i = 0; i < tank_enemies.size(); i++) {
                    //从vector取出一个坦克
                    Tank_enemy tank_enemy = tank_enemies.get(i);
                    //不和自己比较
                    if (tank_enemy != this) {
                        //1.如果敌人坦克是上下
                        //确定敌人坦克的x范围 [tank_enemy.getX(),tank_enemy.getX()+40]
                        //确定敌人坦克的y范围 [tank_enemy.getY(),tank_enemy.getY()+60]
                        if (tank_enemy.getDire() == 1 || tank_enemy.getDire() == 2) {
                            // 当前坦克左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= tank_enemy.getX()
                                    && this.getX() <= tank_enemy.getX() + 40
                                    && this.getY() >= tank_enemy.getY()
                                    && this.getY() <= tank_enemy.getY() + 60) {
                                return true;
                            }
                            //当前坦克右上角坐标[this.getX()+40,this.getY()]
                            if (this.getX() + 40 >= tank_enemy.getX()
                                    && this.getX() + 40 <= tank_enemy.getX() + 40
                                    && this.getY() >= tank_enemy.getY()
                                    && this.getY() <= tank_enemy.getY() + 60) {
                                return true;
                            }
                        }
                        //2.如果敌人坦克是左右
                        //确定敌人坦克的x范围 [tank_enemy.getX(),tank_enemy.getX()+60]
                        //确定敌人坦克的y范围 [tank_enemy.getY(),tank_enemy.getY()+40]
                        if (tank_enemy.getDire() == 3 || tank_enemy.getDire() == 4) {
                            // 当前坦克左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= tank_enemy.getX()
                                    && this.getX() <= tank_enemy.getX() + 60
                                    && this.getY() >= tank_enemy.getY()
                                    && this.getY() <= tank_enemy.getY() + 40) {
                                return true;
                            }
                            //当前坦克右上角坐标[this.getX()+40,this.getY()]
                            if (this.getX() + 40 >= tank_enemy.getX()
                                    && this.getX() + 40 <= tank_enemy.getX() + 60
                                    && this.getY() >= tank_enemy.getY()
                                    && this.getY() <= tank_enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2: //向下
                //当前的敌人坦克和其他所有的坦克比较
                for (int i = 0; i < tank_enemies.size(); i++) {
                    //从vector取出一个坦克
                    Tank_enemy tank_enemy = tank_enemies.get(i);
                    //不和自己比较
                    if (tank_enemy != this) {
                        //1.如果敌人坦克是上下
                        //确定敌人坦克的x范围 [tank_enemy.getX(),tank_enemy.getX()+40]
                        //确定敌人坦克的y范围 [tank_enemy.getY(),tank_enemy.getY()+60]
                        if (tank_enemy.getDire() == 1 || tank_enemy.getDire() == 2) {
                            // 当前坦克左下角坐标[this.getX(),this.getY()+60]
                            if (this.getX() >= tank_enemy.getX()
                                    && this.getX() <= tank_enemy.getX() + 40
                                    && this.getY() + 60 >= tank_enemy.getY()
                                    && this.getY() + 60 <= tank_enemy.getY() + 60) {
                                return true;
                            }
                            // 当前坦克右下角坐标[this.getX()+40,this.getY()+60]
                            if (this.getX() + 40 >= tank_enemy.getX()
                                    && this.getX() + 40 <= tank_enemy.getX() + 40
                                    && this.getY() + 60 >= tank_enemy.getY()
                                    && this.getY() + 60 <= tank_enemy.getY() + 60) {
                                return true;
                            }
                        }
                        //2.如果敌人坦克是左右
                        //确定敌人坦克的x范围 [tank_enemy.getX(),tank_enemy.getX()+60]
                        //确定敌人坦克的y范围 [tank_enemy.getY(),tank_enemy.getY()+40]
                        if (tank_enemy.getDire() == 3 || tank_enemy.getDire() == 4) {
                            // 当前坦克左下角坐标[this.getX(),this.getY()+60]
                            if (this.getX() >= tank_enemy.getX()
                                    && this.getX() <= tank_enemy.getX() + 60
                                    && this.getY() + 60 >= tank_enemy.getY()
                                    && this.getY() + 60 <= tank_enemy.getY() + 40) {
                                return true;
                            }
                            //当前坦克右下角坐标[this.getX()+40,this.getY()+60]
                            if (this.getX() + 40 >= tank_enemy.getX()
                                    && this.getX() + 40 <= tank_enemy.getX() + 60
                                    && this.getY() + 60 >= tank_enemy.getY()
                                    && this.getY() + 60 <= tank_enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:  //向左
                //当前的敌人坦克和其他所有的坦克比较
                for (int i = 0; i < tank_enemies.size(); i++) {
                    //从vector取出一个坦克
                    Tank_enemy tank_enemy = tank_enemies.get(i);
                    //不和自己比较
                    if (tank_enemy != this) {
                        //1.如果敌人坦克是上下
                        //确定敌人坦克的x范围 [tank_enemy.getX(),tank_enemy.getX()+40]
                        //确定敌人坦克的y范围 [tank_enemy.getY(),tank_enemy.getY()+60]
                        if (tank_enemy.getDire() == 1 || tank_enemy.getDire() == 2) {
                            // 当前坦克左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= tank_enemy.getX()
                                    && this.getX() <= tank_enemy.getX() + 40
                                    && this.getY() >= tank_enemy.getY()
                                    && this.getY() <= tank_enemy.getY() + 60) {
                                return true;
                            }
                            //当前坦克左下角坐标[this.getX(),this.getY()+40]
                            if (this.getX() >= tank_enemy.getX()
                                    && this.getX() <= tank_enemy.getX() + 40
                                    && this.getY() + 40 >= tank_enemy.getY()
                                    && this.getY() + 40 <= tank_enemy.getY() + 60) {
                                return true;
                            }
                        }
                        //2.如果敌人坦克是左右
                        //确定敌人坦克的x范围 [tank_enemy.getX(),tank_enemy.getX()+60]
                        //确定敌人坦克的y范围 [tank_enemy.getY(),tank_enemy.getY()+40]
                        if (tank_enemy.getDire() == 3 || tank_enemy.getDire() == 4) {
                            // 当前坦克左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= tank_enemy.getX()
                                    && this.getX() <= tank_enemy.getX() + 60
                                    && this.getY() >= tank_enemy.getY()
                                    && this.getY() <= tank_enemy.getY() + 40) {
                                return true;
                            }
                            //当前坦克左下角坐标[this.getX(),this.getY()+40]
                            if (this.getX() >= tank_enemy.getX()
                                    && this.getX() <= tank_enemy.getX() + 60
                                    && this.getY() + 40 >= tank_enemy.getY()
                                    && this.getY() + 40 <= tank_enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 4:  //向右
                for (int i = 0; i < tank_enemies.size(); i++) {
                    //从vector取出一个坦克
                    Tank_enemy tank_enemy = tank_enemies.get(i);
                    //不和自己比较
                    if (tank_enemy != this) {
                        //1.如果敌人坦克是上下
                        //确定敌人坦克的x范围 [tank_enemy.getX(),tank_enemy.getX()+40]
                        //确定敌人坦克的y范围 [tank_enemy.getY(),tank_enemy.getY()+60]
                        if (tank_enemy.getDire() == 1 || tank_enemy.getDire() == 2) {
                            // 当前坦克右上角坐标[this.getX()+60,this.getY()]
                            if (this.getX() + 60 >= tank_enemy.getX()
                                    && this.getX() + 60 <= tank_enemy.getX() + 40
                                    && this.getY() >= tank_enemy.getY()
                                    && this.getY() <= tank_enemy.getY() + 60) {
                                return true;
                            }
                            // 当前坦克右下角坐标[this.getX()+60,this.getY()+40]
                            if (this.getX() + 60 >= tank_enemy.getX()
                                    && this.getX() + 60 <= tank_enemy.getX() + 40
                                    && this.getY() + 40 >= tank_enemy.getY()
                                    && this.getY() + 40 <= tank_enemy.getY() + 60) {
                                return true;
                            }
                        }
                        //2.如果敌人坦克是左右
                        //确定敌人坦克的x范围 [tank_enemy.getX(),tank_enemy.getX()+60]
                        //确定敌人坦克的y范围 [tank_enemy.getY(),tank_enemy.getY()+40]
                        if (tank_enemy.getDire() == 3 || tank_enemy.getDire() == 4) {
                            // 当前坦克右上角坐标[this.getX()+60,this.getY()]
                            if (this.getX() + 60 >= tank_enemy.getX()
                                    && this.getX() + 60 <= tank_enemy.getX() + 60
                                    && this.getY() >= tank_enemy.getY()
                                    && this.getY() <= tank_enemy.getY() + 40) {
                                return true;
                            }
                            //当前坦克右下角坐标[this.getX()+60,this.getY()+40]
                            if (this.getX() + 60 >= tank_enemy.getX()
                                    && this.getX() + 60 <= tank_enemy.getX() + 60
                                    && this.getY() + 40 >= tank_enemy.getY()
                                    && this.getY() + 40 <= tank_enemy.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

    //坦克是否存在
    boolean isLive = true;

    public Tank_enemy() {
    }

    public Tank_enemy(int x, int y) {
        super(x, y);
    }


    @Override
    public void run() {
        while (true) {

            //集合里没有子弹，创建子弹
            if (isLive && shot_e.size() < 2) {
                Shot s = null;
                //判断坦克的方向
                //根据坦克的方向继续移动
                switch (getDire()) {
                    case 1: //向上
                        s = new Shot(getX() + 20, getY() - 10, 1);
                        break;
                    case 2: //向下
                        s = new Shot(getX() + 20, getY() + 70, 2);
                        break;
                    case 3: //向左
                        s = new Shot(getX() - 10, getY() + 20, 3);
                        break;
                    case 4://向右
                        s = new Shot(getX() + 70, getY() + 20, 4);
                        break;
                }
                shot_e.add(s);
                //启动线程
                new Thread(s).start();
            }

            //根据坦克的方向继续移动
            switch (getDire()) {
                case 1: //向上
                    for (int i = 0; i < 50; i++) {
                        if (getY() > 0 && !EisTouch()) {
                            moveUp();
                        }
                        //休眠50ms
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2: //向下
                    for (int i = 0; i < 50; i++) {
                        if (getY() < 700 && !EisTouch())
                            moveDown();
                        //休眠50ms
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3: //向左
                    for (int i = 0; i < 50; i++) {
                        if (getX() > 0 && !EisTouch()) {
                            moveLeft();
                        }
                        //休眠50ms
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 4://向右
                    for (int i = 0; i < 50; i++) {
                        if (getX() < 920 && !EisTouch()) {
                            moveRight();
                        }
                        //休眠50ms
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            //随机的改变坦克的方向
            setDire((int) (Math.random() * 4 + 1));
            //退出线程
            if (isLive == false) {
                break;  //退出线程
            }
        }
    }
}
