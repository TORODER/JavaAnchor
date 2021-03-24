# break continue

- break在任何循环语句的主体部分,均可用break控制循环的流程.break用于强行退出循环,不执行循环中剩余的语句
- continue语句在循环语句体中,用于终止某次循环过程,即跳过循环体中尚未执行的语句,接着惊醒下一次是否执行循环的判定
- 关于goto关键字
  - goto关键字很早就在程序设计语言中出现.尽管goto仍是Java的一个保留字,但并未在语言中得到正式使用;Java没有goto.然而,在break和continue这两个关键字的身上,我们仍然能看出一些goto的影子---带标签的break和continue.
  - "标签"是指后面跟一个冒号的标识符
  - 对Java来说唯一用到标签的地方实在循环语句之前.而在循环之前设置标签的唯一理由是:我们希望在其中嵌套另一个循环,由于break和continue关键字通常只中断当前循环,但若随同标签使用,它们就会中断到存在标签的地方.



break:

```java
package 流程控制.loop;

public class Break01 {
    public static void main(String[] args) {
        int i = 0;
        while (i<100){
            i++;
            System.out.println(i);
            if (i==30){
                break;
            }
        }
    }
}
```

continue:

```java
package 流程控制.loop;

public class Continue01 {
    public static void main(String[] args) {
        int i = 0;
        while (1<100){
            i++;
            if (i%10==0){
                System.out.println(i);
                continue;
            }
        }
    }
}
```

goto:

```java
package 流程控制.loop;

public class LabelGoto01 {
    public static void main(String[] args) {
        //打印101-150之间的所有质数
        //质数是指在大于1的自然数中,

        int count  = 0;
        
        outer:for (int i = 101; i < 150; i++) {
            for (int j = 3; j < i/2; j++) {
                if (i % j == 0){
                    continue outer;
                }
            }
            System.out.println(i);
        }

    }
}
```

