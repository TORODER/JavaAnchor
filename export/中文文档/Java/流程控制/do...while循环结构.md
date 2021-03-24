# do...while循环

- 对于while语句而言,如果不满足条件,则不能进入循环.但有时候我们需要及时不满足条件,也至少执行一次

- do...while循环和while循环相似,不同的是,do...while循环至少执行一次

- ```java
  do {
      //代码
  }while(布尔表达式);
  ```

  ```java
  package 流程控制.loop;
  
  public class DoWhile01 {
      public static void main(String[] args) {
          int i = 0;
          int sum = 0;
  
          do {
              i++;
             sum = sum + i;
          }while (i<100);
          System.out.println(sum);
      }
  }
  ```

- While和do...While的区别:

  - while先判断后执行.dowhile是限制性后排段
  - Do...while总是保证循环体会至少被执行一次!这是他的主要差别

  ```java
  package 流程控制.loop;
  
  public class DoWhile02 {
      public static void main(String[] args) {
          int a = 0;
          while (a<0){
              System.out.println(a);
              a++;
          }
          System.out.println("============");
          do {
              System.out.println(a);
              a++;
          }while (a<0);
      }
  }
  ```