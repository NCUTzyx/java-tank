import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Java监听键盘事件
//Java 事件控制 ，键盘控制小球的移动
public class event_ extends JFrame{

    MPanel emp =null;
    public static void main(String[] args) {

        new event_();

    }
    //构造器
    public event_(){
        emp = new MPanel();
        this.add(emp);
        this.setSize(400,300);
        //窗口可以监听键盘事件(面板发生的事件
        this.addKeyListener(emp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//KeyListener 监听器，可以监听键盘发生的时间
class MPanel extends JPanel implements KeyListener {  //实现监听接口

    //为了让小球可以继续移动，把他的左上角坐标设置成变量
    int x=10,y=10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.gray);
        g.fillRect(0,0,400,300);
        g.setColor(Color.BLUE);
        g.fillOval(x,y,20,20);

    }

    //有字符输出，该方法触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //当按下某个键，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode()+"被按下...");
        //根据用户按下的不同按键，处理小球的移动
        if(e.getKeyCode()==KeyEvent.VK_DOWN){   //VK_DOWN :向下的箭头对应的code
            y++;
        }else if(e.getKeyCode()==KeyEvent.VK_UP){
            y--;
        }else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            x++;
        }else{
            x--;
        }
        //更新面板，重绘
        this.repaint();
    }
    //当某个键松开了，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}