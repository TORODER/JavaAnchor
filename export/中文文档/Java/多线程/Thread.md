# Thread线程

- 子类继承Thread类具备多线程能力
- 启动线程:子类对象.start()
- 不建议使用:避免OOP单继承局限性

```java
//创建线程方式一:继承thread类,重写run()方法,调用start开启线程

//总结:线程开启不一定立即执行,由CPU调度

public class TestThread1 extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码--"+i);
        }
    }

    public static void main(String[] args) {
        //main线程,主方法

        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();

        //调用start()方法开启线程,start()同时,run()要等待执行完成
        testThread1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程--"+i);
        }
    }
}
```

### 下载图片

```java
//联系Thread,实现多线程同步下载图片

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread02 extends Thread{

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
        t1.start();
        t2.start();
        t3.start();
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