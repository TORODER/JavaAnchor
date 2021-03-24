# AWT

### 介绍

1. 包含了很多类和接口	GUI : 图形用户界面编程
2. 元素: 窗口,按钮,文本框
3. java.awt

### 组件和容器

#### Frame

```java
package gui01;

import java.awt.*;

//GUI的第一个界面
public class TestFrame {
    public static void main(String[] args) {

        //Fram,JDK,看源码
        Frame frame = new Frame("我的第一个java图形界面窗口");

        //设置可见性 w h
        frame.setVisible(true);

        //设置窗口大小
        frame.setSize(400,400);

        //设置颜色
        frame.setBackground(Color.BLACK);

        //弹出的初始位置
        frame.setLocation(200,200);

        //设置大小固定
        frame.setResizable(false);

    }
}
```

创建多个

```java
package gui01;

import java.awt.*;

public class TestFrame02 {
    public static void main(String[] args) {
        //展示多个窗口
        MyFrame myFrame1 = new MyFrame(100, 100, 200, 200,Color.red);
        MyFrame myFrame2 = new MyFrame(300, 100, 200, 200,Color.green);
        MyFrame myFrame3 = new MyFrame(100, 300, 200, 200,Color.blue);
        MyFrame myFrame4 = new MyFrame(300, 300, 200, 200,Color.yellow);
    }
}

class MyFrame extends Frame{
    static int id = 0;//可能存在多个窗口,我们需要一个计数器

    public MyFrame(int x,int y,int w,int h,Color color){
        super("MyFrame"+(++id));
        setVisible(true);
        setBounds(x,y,w,h);
        setBackground(color);
    }
}
```

#### 面板Panel

```java
package gui01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Panel 可以看成是一个空间,但是不能单独存在
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //布局的概念
        Panel panel = new Panel();

        //设置布局
        frame.setLayout(null);

        //坐标
        frame.setBounds(300,300,500,500);
        frame.setBackground(Color.LIGHT_GRAY);

        //panel设置坐标,相对于frame
        panel.setBounds(50,60,400,400);
        panel.setBackground(Color.gray);

        //frame.add(panel)
        frame.add(panel);

        frame.setVisible(true);

        //监听事件,监听窗口关闭时间 system.exit(0)
        //适配器模式:
        frame.addWindowListener(new WindowAdapter() {
            //窗口点击关闭的时候需要做的事情
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}
```

### 布局

- 流式布局

  ```java
  package gui01;
  
  import java.awt.*;
  
  public class TestFlowLayout {
      public static void main(String[] args) {
          Frame frame = new Frame();
  
          //按钮组件
          Button button1 = new Button("button1");
          Button button2 = new Button("button2");
          Button button3 = new Button("button3");
  
          //设置流式布局
          //居中
  //        frame.setLayout(new FlowLayout());
          //靠左
          frame.setLayout(new FlowLayout(FlowLayout.LEFT));
          frame.setSize(200,200);
  
          //吧按钮添加上去
          frame.add(button1);
          frame.add(button2);
          frame.add(button3);
  
          frame.setVisible(true);
  
      }
  }
  ```

- 东西南北中

  ```java
  package gui01;
  
  import java.awt.*;
  
  public class TestBordLayout {
      public static void main(String[] args) {
          Frame frame = new Frame();
  
          //按钮组件
          Button east = new Button("east");
          Button west = new Button("west");
          Button south = new Button("south");
          Button north = new Button("north");
          Button center = new Button("center");
  
          //吧按钮添加上去
          frame.add(east,BorderLayout.EAST);
          frame.add(west,BorderLayout.WEST);
          frame.add(south,BorderLayout.SOUTH);
          frame.add(north,BorderLayout.NORTH);
          frame.add(center,BorderLayout.CENTER);
  
          frame.setSize(500,500);
          frame.setVisible(true);
  
      }
  }
  ```

- 表格布局

  ```java
  package gui01;
  
  import java.awt.*;
  
  public class TestGridLayout {
      public static void main(String[] args) {
  
          Frame frame = new Frame();
  
          Button btn1 = new Button("btn1");
          Button btn2 = new Button("btn2");
          Button btn3 = new Button("btn3");
          Button btn4 = new Button("btn4");
          Button btn5 = new Button("btn5");
          Button btn6 = new Button("btn6");
  
          frame.setLayout(new GridLayout(3,2));
  
          frame.add(btn1);
          frame.add(btn2);
          frame.add(btn3);
          frame.add(btn4);
          frame.add(btn5);
          frame.add(btn6);
  
          frame.pack();//Java函数 自动布局,自动填充
          frame.setVisible(true);
  
      }
  }
  ```

### 事件监听

```java
package gui02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestActionEvent {
    public static void main(String[] args) {
        //按下按钮,触发一些事件
        Frame frame = new Frame();
        Button button = new Button("NMSL");

        //因为 addActionListener()需要一个ActionListener,所以我们需要建造一个ActionListener
        MyActionListener myActionListener = new MyActionListener();
        button.addActionListener(myActionListener);
        frame.add(button);
        frame.pack();
        windowClose(frame);
        frame.setVisible(true);
    }

    //关闭窗体的事件
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}

//事件监听
class MyActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("王沈涛 NMSL");
    }
}
```

多个按钮共享一个时间

```
package gui02;

import jdk.internal.org.objectweb.asm.tree.FrameNode;
import org.omg.CORBA.NO_RESOURCES;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

public class TestActionEvent02 {
    public static void main(String[] args) {
        //两个按钮,实现同一个监听
        //开始        停止
        Frame frame = new Frame();
        Button button1 = new Button("start");
        Button button2 = new Button("stop");

        //可以显示的定义触发会返回的命令,如果不显示定义,则会走默认的值
        //可以多个按钮,只写一个监听
        button2.setActionCommand("button2-stop");

        MyMonitor myMonitor = new MyMonitor();
        button1.addActionListener(myMonitor);
        button2.addActionListener(myMonitor);

        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}

class MyMonitor implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        //e.getActionCommand() 获得按钮的信息
        System.out.println("按钮被点击了:msg=>" + e.getActionCommand());\
        //判断按钮 执行不同操作
        if (e.getActionCommamd().equals("start"))
    }
}
```

### 输入框Text Field监听

```java
package gui02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestField01 {
    public static void main(String[] args) {
        //启动!
        new MyFram();
    }
}

class MyFram extends Frame{
    public MyFram(){
        TextField textField = new TextField();
        add(textField);

        //监听这个文本框输入的文字
        MyActionListener2 myActionListener2 = new MyActionListener2();

        //回车触发输入框的事件
        textField.addActionListener(myActionListener2);

        //设置替换编码
        textField.setEchoChar('*');

        pack();
        setVisible(true);

    }
}

class MyActionListener2 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField filed = (TextField) e.getSource();//获得一些资源,返回的一个对象
        System.out.println(filed.getText());//获得输入框的文本
    }
}
```

### 简易计算器

```java
package gui02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//简易计算器
public class TestCalc {
    public static void main(String[] args) {
        new Claculator().loadFram();
    }
}

//计算器类
class Claculator extends Frame {

    //属性
    TextField num1, num2, num3;

    //方法
    public void loadFram() {
        //3个文本框
        TextField num1 = new TextField(10);//字符数
        TextField num2 = new TextField(10);//字符数
        TextField num3 = new TextField(20);//字符数

        //一个按钮
        Button sum = new Button("=");
        sum.addActionListener(new CalcActionListener());

        //一个标签
        Label label = new Label("+");

        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(sum);
        add(num3);

        pack();
        setVisible(true);
    }

    //监听器
    //内部类最大的好处,就是可以畅通无阻的访问外部类的属性
    private class CalcActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //获得加数和被加数
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            //将这个值 + 发运算后,放到第三个框
            num3.setText("" + (n1 + n2));
            //清除前两个框
            num1.setText("");
            num2.setText("");

        }

    }
}
```

### 画笔

```java
package gui03;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().LoadFram();
    }
}

class MyPaint extends Frame{

    public void LoadFram(){
        setBounds(200,200,600,500);
        setVisible(true);
    }

    //画笔
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawOval(100,100,100,100);//画圆
        g.fillOval(200,100,100,100);//实心的圆

        g.setColor(Color.green);
        g.fillRect(100,200,200,200);

        //养成习惯,画笔用完,将它还原到最初的颜色
    }
}
```

### 鼠标监听

```java
package gui03;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class TestMouse {
    public static void main(String[] args) {
        new MyFram("画图");
    }
}

class MyFram extends Frame{
    //画画需要画笔,需要监听鼠标当前的位置,需要集合来存储这个点
    ArrayList points;

    public MyFram(String title){
        super(title);
        setBounds(200,200,600,500);

        //存鼠标点击的点
        points = new ArrayList<>();

        setVisible(true);
        //鼠标监听器,针对这个窗口
        this.addMouseListener(new MyMouseListen());
    }

    @Override
    public void paint(Graphics g) {
        //画画,监听鼠标的事件
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            Point point = (Point) iterator.next();
            g.setColor(Color.blue);
            g.fillOval(point.x,point.y,10,10);
        }
    }

    //添加一个点到界面上
    public void addPaint(Point point){
        points.add(point);
    }

    private class MyMouseListen extends MouseAdapter{
        //鼠标,按下,弹起,按住不放
        @Override
        public void mousePressed(MouseEvent e) {
            MyFram myFram = (MyFram) e.getSource();
            //这里我们点击的时候就会在界面上产生一个点!
            //这个点就是鼠标的点
            myFram.addPaint(new Point(e.getX(),e.getY()));

            //每次点击鼠标都需要重新画一遍
            myFram.repaint();
        }
    }

}
```

