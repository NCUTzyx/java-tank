package TankGame_zyx;


import java.io.*;
import java.util.Vector;

@SuppressWarnings({"all"})
//记录玩家信息
public class RecordTank {

    //我方击毁敌人坦克数
    private static int zyx_num=0;
    //敌人剩余坦克数
    private static int tank_num=4;
    //定义一个Vector,指向敌人坦克的Vector
    private static Vector<Tank_enemy> enemytanks=null;

    public static void setEnemytanks(Vector<Tank_enemy> enemytanks) {
        RecordTank.enemytanks = enemytanks;
    }

    //定义Node 的Vector,用于保存敌人的信息Node
    private static  Vector<TankNode> Nodes =new Vector<>();


    //写入文件路径
    //把记录文件保存到src上
    private static String PathFile="src\\zyx.txt";

    //返回记录文件的路径
    public static String getPathFile(){
        return PathFile;
    }

    public static int getZyx_num() {
        return zyx_num;
    }

    public static void setZyx_num(int zyx_num) {
        RecordTank.zyx_num = zyx_num;
    }

    public static int getTank_num() {
        return tank_num;
    }

    public static void setTank_num(int tank_num) {
        RecordTank.tank_num = tank_num;
    }

    //当我方击毁一个敌方坦克时，变化方法
    public static void addNum(){
       tank_num--;
       zyx_num++;
    }

    //用于读取文件，恢复相关的信息
    public static Vector<TankNode> remakeGame() throws IOException {


        BufferedReader bur = new BufferedReader(new FileReader(PathFile));

        zyx_num=Integer.parseInt(bur.readLine());
        tank_num=Integer.parseInt(bur.readLine());

        String line="";
        while ((line=bur.readLine())!=null) {
            String[] s=line.split(" ");
            TankGame_zyx.TankNode tankNode = new TankNode(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            Nodes.add(tankNode);  //将tanknode 放入Nodes里面
        }

        if(bur!=null){
            bur.close();
        }
        return Nodes;
    }


    //当游戏退出时，保存信息
    //保存敌人坦克坐标和方向
    public static void SaveFile() throws Exception {
        ////定义IO对象,用于写数据当文件中
        BufferedWriter buf= new BufferedWriter(new FileWriter(PathFile));

        buf.write(zyx_num+"\r\n");
        buf.write(tank_num+"\r\n");

//        遍历敌人坦克的Vector,然后根据情况退出
//        定义一个属性，然后set获得敌人坦克的Vector
        for(int i=0;i<enemytanks.size();i++){
            //取出敌人坦克
            Tank_enemy tank_enemy = enemytanks.get(i);
            if(tank_enemy.isLive){
                //保存坦克信息
                String tfile = tank_enemy.getX()+" "+tank_enemy.getY()+" "+tank_enemy.getDire();
                //写入文件
                buf.write(tfile+"\r\n");
            }
        }
        if (buf!=null){
            buf.close();
        }
    }
}
