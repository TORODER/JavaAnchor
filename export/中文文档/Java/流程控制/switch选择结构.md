# switch选择

switch case 语句判断一个变量与一个系列值中某个值是否相等,每个值称为一个分支.

switch语句中的变量类型可以是:

- byte,short,int或者char
- **从Java SE 7开始**
- **switch支持字符串String类型了**
- 同时case标签必须为字符串常量或字面量

```java
package 流程控制.scanner;

public class switch01 {
    public static void main(String[] args) {

        char grade = 'F';
        //case穿透 //switch 匹配一个具体的值
        switch (grade){
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
                System.out.println("良好");
                break;
            case 'C':
                System.out.println("及格");
                break;
            case 'D':
                System.out.println("再接再厉");
                break;
            case 'E':
                System.out.println("挂科");
                break;
            default:
                System.out.println("未知等级");
        }

    }
}
```

