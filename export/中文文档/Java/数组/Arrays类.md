# Arrays类

- 数组的工具类java.util.Arrays
- 由数组对象本身并没有什么方法可以供我们调用,但API中提供了一个工具类Arrays供我们使用,从而可以对数据对象进行一些基本的操作.
- Arrays类中的方法都是static修饰的静态方法,在使用的时候可以直接使用类名进行调用,而"不用"使用对象来调用(注意:是"不用"而不是"不能")
- 具有以下常用功能:
  - 给数组赋值:通过fill方法
  - 对数组排序:通过sort方法,按升序
  - 比较数组:通过equals方法比较数组汇总元素值是否相等.
  - 查找数组元素:通过binarySearch方法能对排序好的数组进行二分查找法操作

```java
package array;

import java.util.Arrays;

public class Array06 {
    public static void main(String[] args) {
        int[] a = {1,2,6,4,7,3,9,8,5};

        System.out.println(a);
        //打印数组元素:Arrays.toString
        System.out.println(Arrays.toString(a));

        //数组进行排序
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        //数组填充
        Arrays.fill(a,2,4,0);
        System.out.println(Arrays.toString(a));
    }
}
```

