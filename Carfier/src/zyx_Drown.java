import javax.swing.*;
import java.awt.*;

@SuppressWarnings("all")
public class zyx_Drown extends JFrame{  //JFame 框架,可以理解为一个画框

    //定义一个面板
    private zyxPanel hp=null;
    public static void main(String[] args) {
        new zyx_Drown();

    }
    public zyx_Drown(){
        //初始化面板
        hp=new zyxPanel();
        //把面板放入到窗口
        this.add(hp);
        //设置窗口大小
        this.setSize(400,300);
        this.setVisible(true);//可以显示
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //点击窗口红×，结束程序
    }
}
//1.先定义一个zyxPanel,继承JPanel类,画图形就在面板上画
//zyxPanel 对象就是一个画板
//Graphics g 把 g 理解成一支画笔
//Graphics 提供了很多绘图方法
class zyxPanel extends JPanel{
    @Override
    public void paint(Graphics g) {  //绘图的方法
        super.paint(g);
        //画出一个圆形
        //g.drawOval(10,10,100,100);
        //画直线
        //g.drawLine(10,10,100,100);
        //画矩形边框
        //g.drawRect(10,10,100,100);
        //设置画笔颜色，填充矩形
        //g.setColor(Color.BLUE);
        //g.fillRect(10,10,10,10);r
        //填充椭圆fillOval()
        //画图片
        //1.获取图片资源  /bg.png:表示项目的根目录去获取这个资源
        Image image = Toolkit.getDefaultToolkit().getImage(zyxPanel.class.getResource("/br.png"));

        g.drawImage(image,0,0,this);
        //画字符串
        //给画笔设置颜色
        //g.setColor(Color.red);
        //g.setFont(new Font("黑体",Font.BOLD,20));
        //g.drawString("陈欣然爱尹人靖",100,100);  //起点为左下角
    }
}
