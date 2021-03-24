# callable

- 可以定义返回值
- 可以抛出异常

```java
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    //实现callable接口
    private String url; //网络图片地址
    private String name; //保存的文件名

    public TestCallable(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片的线程执行体
    @Override
    public Boolean call(){
        Downloader downloader = new Downloader();
        downloader.downloader(url,name);
        System.out.println("下载完成"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://pic2.zhimg.com/80/v2-533642ec124d7130b5c32c31b6ac6ad3_720w.jpg?source=1940ef5c","1.jpg");
        TestCallable t2 = new TestCallable("https://pic1.zhimg.com/80/v2-09fe17d317a988dfd30d0d933feb315f_720w.jpg?source=1940ef5c","2.jpg");
        TestCallable t3 = new TestCallable("https://pic2.zhimg.com/80/v2-d54bf445679fc1d0f4d1f684a653dac5_720w.jpg?source=1940ef5c","3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        ser.shutdownNow();
    }

}

class Downloader {
    //下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader方法出现问题");
        }
    }
}
```

