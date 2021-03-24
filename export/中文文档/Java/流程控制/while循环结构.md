# while循环

- while是最基本的循环

- ```java
  while(布尔表达式){
      //循环内容
  }
  ```

- 只要布尔表达式为true,循环就会一直执行下去

- **我们大多数情况是会让循环停止下来的,我们需要一个让表达式失效的方式来结束循环**

- 少部分情况需要循环一直执行,比如服务器的请求响应监听等

- 循环条件一直为true就会造成无限循环(死循环),我们正常的业务编程中应该尽量避免死循环.会影响程序性能或者程序卡死崩溃

```java
package 流程控制.scanner;

public class While01 {
    public static void main(String[] args) {

        //输出1~100
        int i = 0;

        while (i<100){
            i++;
            System.out.println(i);
        }
    }
}
```

死循环

```java
package 流程控制.scanner;

public class While02 {
    public static void main(String[] args) {
        //死循环
        while (true){
            //
        }
    }
}
```

1加到100

```java
package 流程控制.scanner;

public class While03 {
    public static void main(String[] args) {

        //计算1加到100
        
        int i = 0;
        int sum = 0;
        while (i<100){
            i++;
            sum = sum+i;
        }
        System.out.println(sum);

    }
}
```

