# For循环

- 虽然所有循环结构都可以用while或者do...while表示,但Java提供了另一种语言---for循环,使一些循环结构变得更加简单

- for循环语句时支持迭代的一种通用结构,**是最有效,最灵活的循环结构**

- for循环执行的次数是在执行前就确定的.语法格式如下

- ```java
  for(初始化;布尔表达式;更行){
      //代码语句
  }
  ```

  

### 关于for循环有以下几点说明:

- 最先执行初始化步骤.可以声明一种类型,但可初始化一个或多个循环控制变量,也可以是空语句.
- 然后,检测布尔表达式的值.如果为true,循环体被执行,如果为false,循环终止,开始执行循环体后面的语句
- 执行一次循环后,更新循环控制变量(迭代因子控制循环变量的增减).
- 再次测试布尔表达式.循环执行上面的过程

### 计算0到100之间的奇数和偶数的和

```java
package 流程控制.loop;

public class For02 {
    public static void main(String[] args) {
        //练习1:计算0到100之间的奇数和偶数的和
        
        int oddsum=0;
        int evensum=0;

        for (int i = 0; i <= 100; i++) {
            if (i%2==1){
                oddsum+=i;
            }else{
                evensum+=i;
            }
        }

        System.out.println("奇数和: "+oddsum);
        System.out.println("偶数和: "+evensum);

    }
}
```

### 用while或for循环输出1-1000之间能被5整除的数,并且每行输出3个

```java
package 流程控制.loop;

public class For03 {
    public static void main(String[] args) {
        //练习2:用while或for循环输出1-1000之间能被5整除的数,并且每行输出3个

        for (int i = 1; i <= 1000; i++) {
            if (i%5==0){
                System.out.print(i+"\t");
            }
            if (i%(5*3)==0){
                //println   输出完会换行
                //print     输出完不会换行
                System.out.println();
                //System.out.print("\n");
            }
        }
    }
}
```

### 打印99乘法表

```java
package 流程控制.loop;

public class For04 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int n = 1; i <= 9; n++){
                if (n>i){
                    System.out.println();
                    break;
                }
                System.out.print(i+"*"+n+"="+i*n+"\t");
            }
        }
    }
}
```

### 增强for循环

```java
package 流程控制.loop;

public class For05 {
    public static void main(String[] args) {
        int[] numbers = {10,20,30,40,50};//定义一个数组

        for (int i = 0; i < 5; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("========");
        //遍历数组的元素
        for (int x:numbers){
            System.out.println(x);
        }
    }
}
```

