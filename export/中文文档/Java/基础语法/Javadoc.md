# JavaDoc

javadoc命令是用来生成自己的文档的



#### 参数信息

- @author	作者名
- @version   版本号
- @since       指明需要最早使用的jdk版本
- @param    参数名
- @return    返回值情况
- @throws   异常抛出情况

```java
package 基础语法.base;

/**
 * @author Jokay
 * @version 1.0
 * @since 1.8
 */

public class Doc {

    String name;

    /**
     * 
     * @param name
     * @return
     * @throws Exception
     */
    public String test(String name) throws Exception{
        return name;
    }
}
```

