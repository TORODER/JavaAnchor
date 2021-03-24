# Lamda表达式

- 为什么要用lambda表达式
  - 避免匿名内部类定义过多
  - 可以让你的代码看起来很简洁
  - 去掉一堆没有意义的代码,只留下核心的逻辑

### 函数式接口的定义:

- 任何接口,如果包含唯一一个抽象方法,那么他就是一个函数式接口
- 对于函数式接口,我们可以通过lambda表达式来创建该接口的对象

```java
package lambda;

public class TestLambda01 {
    //静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like1();
        like.lambda();

        like = new Like2();
        like.lambda();

        //局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }

        like = new Like3();
        like.lambda();

        //匿名内部类,没有类名称,必须借助接口或者父类
        like =new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like.lambda();

        //用lambda简化
        like = ()-> {
            System.out.println("i like lambda5");
        };
        like.lambda();
    }
}

//定义一个函数接口
interface ILike{
    void lambda();
}

//实现类
class Like1 implements ILike{
    @Override
    public void lambda() {
        System.out.println("i like lambda1");
    }
}
```

lambda简化

- lambda表达式只有一行代码的情况下才能简化成为一行,如果有多行,那么就用代码块包裹

- 前提是接口为函数式接口
- 多个参数也可以去掉参数类型,要去掉都去掉,但是必须要加上括号

```java
package lambda;

public class TestLambda02 {
    public static void main(String[] args) {
        Ilove love = (int a)-> {
            System.out.println("I love you "+a);
        };

        //简化lambda
        love = a-> System.out.println("I love you " + a);
        love.love(520);
    }
}

interface Ilove{
    void love(int a);
}
```

