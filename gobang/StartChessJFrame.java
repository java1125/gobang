package gobang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TODO
 * 游戏主框架类 启动类
 * @author edda
 * @date 2023/04/25 16:55
 **/
public class StartChessJFrame extends JFrame {
    private ChessBoard chessBoard;
    private JPanel toolbar;
    /**
     * 开始，悔棋，退出按钮
     */
    private JButton startButton,backButton,exitButton;

    private JMenuBar menuBar;
    private JMenu sysMenu;
    private JMenuItem startMenuItem,exitMenuItem,backMenuItem;

    //重新开始
    public StartChessJFrame(){
        setTitle("单机版五子棋");
        chessBoard = new ChessBoard();

        Container contentPane = getContentPane();
        contentPane.add(chessBoard);
        chessBoard.setOpaque(true);

        //创建喝添加菜单
        menuBar = new JMenuBar();//初始化菜单栏
        sysMenu = new JMenu("系统");
        //初始化
        startMenuItem = new JMenuItem("重新开始");
        exitMenuItem = new JMenuItem("退出");
        backMenuItem = new JMenuItem("悔棋");

        //将三个菜单项新增
        sysMenu.add(startMenuItem);
        sysMenu.add(exitMenuItem);
        sysMenu.add(backMenuItem);
        //初始化按钮事件监听器内部类
        MyItemListener lis = new MyItemListener();
        //将三个菜单注册到事件监听器上
        this.startMenuItem.addActionListener(lis);
        backMenuItem.addActionListener(lis);
        exitMenuItem.addActionListener(lis);
        menuBar.add(sysMenu);//将系统菜单添加到菜单栏
        setJMenuBar(menuBar);//将menuBar设置为菜单栏

        toolbar = new JPanel();//工具面板实例化
        //三个按钮初始化
        startButton = new JButton("重新开始");
        exitButton = new JButton("退出");
        backButton = new JButton("悔棋");
        //将工具面板用FlowLayout布局
        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        //将三个按钮添加到工具面板
        toolbar.add(startButton);
        toolbar.add(exitButton);
        toolbar.add(backButton);
        //将三个按钮注册监听事件
        startButton.addActionListener(lis);
        exitButton.addActionListener(lis);
        backButton.addActionListener(lis);
        //将工具面板布局到界面下方
        add(toolbar,BorderLayout.SOUTH);
        add(chessBoard);//将面板对象添加到窗体上
        //设置界面关闭事件
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(800,800);
        pack();//自适应大小
    }


    /**
     * 菜单按钮监听事件
     */
    private class MyItemListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();//获得事件源
            if (obj==StartChessJFrame.this.startMenuItem||obj==startButton){
                //重新开始
                //JFiveFrame.this内部类引用外部类
                System.out.println("重新开始");
                chessBoard.restartGame();
            }
            else if (obj==exitMenuItem||obj==exitButton){
                System.exit(0);
            }else if(obj==backMenuItem||obj==backButton){
                System.out.println("重新思考一下");
                chessBoard.goBack();
            }
        }
    }

    public static void main(String[] args) {
        StartChessJFrame f = new StartChessJFrame();//创建主框架
        f.setVisible(true);//显示主框架
    }
}
