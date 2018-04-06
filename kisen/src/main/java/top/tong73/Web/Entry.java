package top.tong73.Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 项目启动入口，配置包根路径,删掉官方示例给出的SampleController.java
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.song")
public class Entry {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Entry.class, args);
    }
}