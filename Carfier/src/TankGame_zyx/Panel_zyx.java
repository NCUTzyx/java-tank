package TankGame_zyx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

@SuppressWarnings("all")
//游戏界面
//为了监听键盘事件，实现KeyListener
//为了让Panel 不断的重绘，需要Panel_zyx 实现Runnable接口，当成线程
public class Panel_zyx extends JPanel implements KeyListener, Runnable {

    //定义一个Vector,用于存放炸弹
    Vector<Bomb> bombs = new Vector<>();
    int bomsize = 3;

    //定义1张图片，用于显示爆炸效果
    //当子弹击中坦克时，就加入Bomb对象到bombs中
    Image image1 = null;

    //定义自己的坦克
    Tank_zyx tank_zyx = null;
    //定义敌人的坦克,放入Vector里面
    Vector<Tank_enemy> tank_enemy = new Vector<>();
    int enemySize = 4;  //敌人的数量
    //定义一个存放Node对象的TankNode,用于恢复敌人坦克的坐标和方向
    Vector<TankNode> tankNodes =new Vector<>();

    public Panel_zyx(String op) throws IOException {

        //判断记录文件是否存在
        File file = new File(RecordTank.getPathFile());
        if (file.exists()){
            //接收数据
            tankNodes=RecordTank.remakeGame();
        }else{
            System.out.println("数据不存在，开启新的游戏");
            op="1";
        }

        //将tank_enemy 设置给Record
        RecordTank.setEnemytanks(tank_enemy);
        //初始化自己坦克
        tank_zyx = new Tank_zyx(600, 500);
        tank_zyx.setSpeed(5);  //设置速度5

        switch (op){
            case"1":  //开始新的游戏
                System.out.println("作者 : 张宇森");
                System.out.println("班级 : 2003");
                System.out.println("学号 : 8008120063");

                //初始化敌人的坦克
                for (int i = 0; i < enemySize; i++) {
                    //创建坦克
                    Tank_enemy entank = new Tank_enemy((100 * (i + 1)), 100);
                    //将集合设置为entank 坦克对象
                    entank.setTank_enemies(tank_enemy);
                    entank.setDire(2); //设置方向
                    //启动敌人坦克
                    new Thread(entank).start();
                    //给敌人坦克加入子弹
                    Shot shot = new Shot(entank.getX() + 20, entank.getY() + 60, entank.getDire());
                    entank.shot_e.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    //加入坦克
                    tank_enemy.add(entank);
                }
                break;
            case"2":  //继续上局游戏
                System.out.println("作者 : 张宇森");
                System.out.println("班级 : 2003");
                System.out.println("学号 : 8008120063");

                for (int i = 0; i < tankNodes.size(); i++) {
                    TankNode tankNode = tankNodes.get(i);
                    //创建坦克
                    Tank_enemy entank = new Tank_enemy(tankNode.getX(),tankNode.getY());
                    //将集合设置为entank 坦克对象
                    entank.setTank_enemies(tank_enemy);
                    entank.setDire(tankNode.getDire()); //设置方向
                    //启动敌人坦克
                    new Thread(entank).start();
                    //给敌人坦克加入子弹
                    Shot shot = new Shot(entank.getX() + 20, entank.getY() + 60, entank.getDire());
                    entank.shot_e.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    //加入坦克
                    tank_enemy.add(entank);

                }
                break;
            default:
                System.out.println("作者 : 张宇森");
                System.out.println("班级 : 2003");
                System.out.println("学号 : 8008120063");
                System.out.println("输入错误......");
                break;
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel_zyx.class.getResource("/12.gif"));
        //播放音乐
        new music_tank("src\\tank.wav").start();
    }

    //编写方法，显示我方击毁敌方坦克的信息
    public void InforTank(Graphics g){

        //画出玩家成绩
        //画笔会重置
        g.setColor(Color.BLUE);
        Font font = new Font("黑体",Font.BOLD,30);
        Font font1 = new Font("黑体",Font.BOLD,50);
        Font font3 = new Font("黑体",Font.BOLD,40);
        g.setFont(font3);
        g.drawString("****欢迎来到坦克大战****",1020,50);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString("玩家累计得分:",1020,150);
        drawTank(1020,210,g,1,1);  //画出我方坦克
        g.setColor(Color.red);
        g.setFont(font1);
        g.drawString(""+RecordTank.getZyx_num(),1111,260);
        g.setColor(Color.CYAN);
        g.setFont(font);
        g.drawString("敌方累计得分:",1020,350);
        drawTank(1020,410,g,1,2);  //画出敌方坦克
        g.setColor(Color.CYAN);
        g.setFont(font1);
        g.drawString(""+RecordTank.getTank_num(),1111,460);
        g.setColor(Color.PINK);
        g.setFont(font);
        g.drawString("输入J即可发射子弹",1020,560);
        g.drawString("输入WSAD即可控制坦克",1020,600);
        g.drawString("祝您玩得愉快，谢谢使用",1020,640);
        drawTank(1040,680,g,1,1);  //画出敌方坦克
        drawTank(1100,680,g,1,2);  //画出敌方坦克
        drawTank(1160,680,g,1,2);  //画出敌方坦克
        drawTank(1220,680,g,1,2);  //画出敌方坦克
        drawTank(1280,680,g,1,2);  //画出敌方坦克

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 800);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(1000, 0, 980, 800);
        //玩家信息
        InforTank(g);

        //画出自己的坦克
        if (tank_zyx != null && tank_zyx.isLive) {
            drawTank(tank_zyx.getX(), tank_zyx.getY(), g, tank_zyx.getDire(), 1);
        }
        //画出自己坦克发射的子弹 单发
//        if(tank_zyx.shot!=null&&tank_zyx.shot.isLive==true){
//            g.setColor(Color.RED);
//            g.drawOval(tank_zyx.shot.x,tank_zyx.shot.y,2,2);
//        }

        //将子弹集合遍历取出
        for (int i = 0; i < tank_zyx.shots.size(); i++) {
            Shot shot = tank_zyx.shots.get(i);
            if (shot != null && shot.isLive == true) {
                g.setColor(Color.RED);
                g.drawOval(shot.x, shot.y, 2, 2);
            } else {  //shot对象不存在,去点
                tank_zyx.shots.remove(shot);
            }
        }

        //bombs中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前对象那个的life值，来画出对应的图片
            if (bomb.life <= 20) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }


        //画出敌人的坦克，遍历Vector
        for (Tank_enemy tankEnemy : tank_enemy) {
            //画出敌人坦克
            //判断敌人坦克是否存活
            if (tankEnemy.isLive) {
                drawTank(tankEnemy.getX(), tankEnemy.getY(), g, tankEnemy.getDire(), 2);
                //画出敌人子弹
                g.setColor(Color.cyan);
                for (int j = 0; j < tankEnemy.shot_e.size(); j++) {
                    //取出子弹
                    Shot shot = tankEnemy.shot_e.get(j);
                    //绘制
                    if (shot.isLive == true) {
                        g.setColor(Color.cyan);
                        g.drawOval(shot.x, shot.y, 2, 2);
                    } else {
                        //移除
                        tankEnemy.shot_e.remove(shot);
                    }
                }
            }
        }
    }

    //编写方法,画出坦克
    //(x,y) 坦克左上角坐标，g 画笔，dire 坦克方向，type 坦克类型
    public void drawTank(int x, int y, Graphics g, int dire, int type) {

        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 1://自己的坦克
                g.setColor(Color.red);
                break;
            case 2://敌人的坦克
                g.setColor(Color.cyan);
                break;
        }
        //根据坦克方向，设置不同坦克

        switch (dire) {
            case 1://向上的
                g.fillRect(x + 10, y + 10, 20, 40);//坦克中间
                g.setColor(Color.blue);
                g.fillRect(x, y, 10, 60); //坦克左边轮子
                g.fillRect(x + 30, y, 10, 60); //坦克右边轮子
                g.setColor(Color.orange);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y - 10, x + 20, y + 30); //弹道
                break;
            case 2://向下
                g.fillRect(x + 10, y + 10, 20, 40);//坦克中间
                g.setColor(Color.blue);
                g.fillRect(x, y, 10, 60); //坦克左边轮子
                g.fillRect(x + 30, y, 10, 60); //坦克右边轮子
                g.setColor(Color.orange);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 70); //弹道
                break;
            case 3://向左
                g.fillRect(x + 10, y + 10, 40, 20);//坦克中间
                g.setColor(Color.blue);
                g.fillRect(x, y, 60, 10); //坦克左边轮子
                g.fillRect(x, y + 30, 60, 10); //坦克左边轮子
                g.setColor(Color.orange);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x - 10, y + 20, x + 30, y + 20); //弹道
                break;
            case 4://向右
                g.fillRect(x + 10, y + 10, 40, 20);//坦克中间
                g.setColor(Color.blue);
                g.fillRect(x, y, 60, 10); //坦克左边轮子
                g.fillRect(x, y + 30, 60, 10); //坦克左边轮子
                g.setColor(Color.orange);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 70, y + 20, x + 30, y + 20); //弹道
                break;
        }
    }

    //判断我方的子弹是否击中敌人坦克
    //需要加入循环
    public void hitEnemy(Shot s, Tank entank) {
        //判断是否击中
        switch (entank.getDire()) {
            case 1:
            case 2:
                if (s.x > entank.getX() && s.x < entank.getX() + 40
                        && s.y > entank.getY() && s.y < entank.getY() + 60) {
                    s.isLive = false;
                    entank.isLive = false;
                    //子弹击中敌人坦克后，将entank从集合中拿掉
                    tank_enemy.remove(entank);
                    //当我方击毁敌方坦克时
                    if(entank instanceof Tank_enemy){
                        RecordTank.addNum();
                    }

                    System.out.println("敌方坦克被击杀");
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(entank.getX(), entank.getY());
                    bombs.add(bomb);

                }
                break;
            case 3:
            case 4:
                if (s.x > entank.getX() && s.x < entank.getX() + 60
                        && s.y > entank.getY() && s.y < entank.getY() + 40) {
                    s.isLive = false;
                    entank.isLive = false;
                    tank_enemy.remove(entank);
                    //当我方击毁敌方坦克时
                    if(entank instanceof Tank_enemy){
                        RecordTank.addNum();
                    }
                    System.out.println("敌方坦克被击杀");
                    Bomb bomb = new Bomb(entank.getX(), entank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    //发射多发子弹时
    //判断我方的子弹是否击中敌人坦克
    public void hitTeskEnemy() {

        //遍历子弹
        for (int j = 0; j < tank_zyx.shots.size(); j++) {
            Shot shot = tank_zyx.shots.get(j);
            if (shot != null && shot.isLive) {//当前我的子弹还在
                //遍历敌人所有存活坦克
                for (int i = 0; i < tank_enemy.size(); i++) {
                    Tank_enemy tank_enemy = this.tank_enemy.get(i);
                    //判断是否击中
                    hitEnemy(shot, tank_enemy);
                }
            }
        }
    }

    //判断敌人坦克是否命中我方坦克
    public void hitTeskzyx() {
        //遍历所有敌人坦克
        for (int i = 0; i < tank_enemy.size(); i++) {
            //取出坦克
            Tank_enemy tamy = this.tank_enemy.get(i);
            //遍历坦克对象子弹
            for (int j = 0; j < tamy.shot_e.size(); j++) {
                //取出子弹
                Shot shot = tamy.shot_e.get(j);
                //p判断是否击中
                if (tank_zyx.isLive && shot.isLive) {
                    hitEnemy(shot, tank_zyx);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wdsa方向键，按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //改变坦克方向
            tank_zyx.setDire(1);
            //让坦克向上移动
            if (tank_zyx.getY() > 0) {
                tank_zyx.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            //改变坦克方向
            tank_zyx.setDire(2);
            //让坦克向下移动
            if (tank_zyx.getY() < 700) {
                tank_zyx.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {

            tank_zyx.setDire(3);
            //让坦克向左移动
            if (tank_zyx.getX() > 0) {
                tank_zyx.moveLeft();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            tank_zyx.setDire(4);
            //让坦克向右移动
            if (tank_zyx.getX() < 920) {
                tank_zyx.moveRight();
            }
        }
//        //如果用户按下J,就需要发射 ->发射一颗子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {
//            //判断子弹是否消亡
//            if(tank_zyx.shot==null||!tank_zyx.shot.isLive) {
//                System.out.println("用户按下J....");
//                tank_zyx.shotEnemy();
//            }
            //如果用户按下J,就需要发射 ->发射多颗子弹
            System.out.println("用户按下J....");
            tank_zyx.shotEnemy();
        }
        //重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {  //每隔100ms重绘区域,刷新绘图区域
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断是否击中敌人坦克
            hitTeskEnemy();
            hitTeskzyx();
            //重绘
            this.repaint();
        }
    }
}

