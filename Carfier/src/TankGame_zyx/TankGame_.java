package TankGame_zyx;

//坦克大战小游戏-简易版
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

public class TankGame_ extends JFrame {


    Panel_zyx map;
    static  Scanner scanner =new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        new TankGame_();
    }

    public TankGame_() throws IOException {


        System.out.println("欢迎来到坦克大作战游戏系统");
        System.out.println("请输入您的选择");
        System.out.println("1.开始新的游戏");
        System.out.println("2.继续上局游戏");

        String op =scanner.next();

        //定义画布
        map = new Panel_zyx(op);
        //启动线程
        Thread thread = new Thread(map);
        thread.start();
        this.add(map); //把游戏区域加进去
        this.setSize(1980, 800);
        this.addKeyListener(map);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //点击窗口红×，结束程序

        //关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    RecordTank.SaveFile();
                    System.out.println("退出游戏，谢谢使用！");
                    System.exit(0);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

    }


}
