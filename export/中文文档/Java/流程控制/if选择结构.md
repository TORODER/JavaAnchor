# if选择结构

### if单选结构

我们很多时候需要去判断一个东西是否可行,然后我们采取执行,这样一个过程在程序中用if语句来表示

```java
package 流程控制.scanner;

import java.util.Scanner;

public class if01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入内容: ");
        String s = scanner.nextLine();

        //equals:判断字符串是否相等
        if (s.equals("Hello")){
            System.out.println(s);
        }

        System.out.println("enda");

        scanner.close();
    }
}
```

### if双选择结构

```java
package 流程控制.scanner;

import java.util.Scanner;

public class if02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩: ");
        int score = scanner.nextInt();

        if (score>=60){
            System.out.println("及格");
        }else {
            System.out.println("不及格");
        }


        scanner.close();
    }
}
```

### if多选择结构

```java
package 流程控制.scanner;

import java.util.Scanner;

public class if03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩: ");
        int score = scanner.nextInt();

        if (score==100){
            System.out.println("满分");
        } else if (100>score && score>=90) {
            System.out.println("优秀");
        }else if (90>score && score>=80){
            System.out.println("良好");
        }else if (80>score && score>=60){
            System.out.println("及格");
        }else {
            System.out.println("不及格");
        }

        scanner.close();
    }
}
```

### 嵌套的if结构

