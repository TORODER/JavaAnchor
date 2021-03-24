#  用户交互Scanner

- 之前我们学的基本语法中我们并没有实现程序和人的交互,但是Java给我们提供了这样一个工具类,我们可以获取用户的输入.

- 基本语法:

  ```java
  Scranner s = new Scanner(System.in);
  ```

- 通过Scanner累的nex()与nexLine()方法获取输入的字符串,在读取前我们一般需要使用hasNex()与hasNextLine()判断是否还有输入的数据



#### Scanner对象

- next():

  1. 一定要读取到有效字符后才可以结束
  2. 对输入有效字符之前遇到的空白,next()方法会自动将其去掉
  3. 只有输入有效字符串后才将其后面输入的空白作为分隔符或者结束符
  4. **next()不能得到带有空格的字符串**

  ```java
  package 流程控制.scanner;
  
  import java.util.Scanner;
  
  public class Scanner01 {
      public static void main(String[] args) {
  
          //创建一个扫描器对象,用于接收键盘数据
          Scanner scanner = new Scanner(System.in);
  
          System.out.println("使用next方式接收: ");
  
          //判断用户有没有输入字符串
          if (scanner.hasNext()){
              //接收用户输入
              String str = scanner.next();//程序会等待用户输入完毕
              System.out.println("输出的内容为: "+str);
          }
  
          //凡是属于IO流的类如果不关闭会一直占用资源
          scanner.close();
  
      }
  }
  //输出Hello
  ```

  

- nextLine():

  1. 以Enter为结束符也就是说nextLine()方法返回的是输入会车之前的所有字符
  2. 可以获得空白

  ```java
  package 流程控制.scanner;
  
  import java.util.Scanner;
  
  public class Scanner02 {
      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
  
          System.out.println("使用nextLine方式接收: ");
  
          if (scanner.hasNextLine()){
              String str = scanner.nextLine();
              System.out.println("输出的内容为: "+str);
          }
  
      }
  }
  //输出Hello World
  ```

  



```java
package 流程控制.scanner;

import java.util.Scanner;

public class Scanner03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入数据: ");

        String str = scanner.nextLine();

        System.out.println("输出的内容为: "+str);

        scanner.close();

    }
}
```

