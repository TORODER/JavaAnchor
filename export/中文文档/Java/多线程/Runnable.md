# 实现Runnable接口

- 实现接口Runnable具有多线程能力
- 启动现场:传入目标对象+Thread对象.start()
- 推荐使用:避免单继承局限性,灵活方便,方便同一个对象被多个线程使用

```java
//实现runnable接口,重写run方法,执行线程需要丢入runnable接口的实现类
public class TestThread03 implements Runnable{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码--"+i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        TestThread03 testThread03 = new TestThread03() ;
        //创建线程对象,通过线程对象来开启我们的线程,代理
        new Thread(testThread03).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程--"+i);
        }
    }
}
```

下载网图

```java
//联系Thread,实现多线程同步下载图片

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread02 implements Runnable{

    private String url; //网络图片地址
    private String name; //保存的文件名

    public TestThread02(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片的线程执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载完成"+name);
    }

    public static void main(String[] args){
        TestThread02 t1 = new TestThread02("https://pic2.zhimg.com/80/v2-533642ec124d7130b5c32c31b6ac6ad3_720w.jpg?source=1940ef5c","1.jpg");
        TestThread02 t2 = new TestThread02("https://pic1.zhimg.com/80/v2-09fe17d317a988dfd30d0d933feb315f_720w.jpg?source=1940ef5c","2.jpg");
        TestThread02 t3 = new TestThread02("https://pic2.zhimg.com/80/v2-d54bf445679fc1d0f4d1f684a653dac5_720w.jpg?source=1940ef5c","3.jpg");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }

}

class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常,downloader方法出现问题");
        }
    }
}
```

