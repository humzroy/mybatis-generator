package me.aaron.util.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StartUpGenerator
 * @Description 启动Mybatis generator
 * @Author wuhengzhen
 * @Date 2019-11-29 18:09
 * @Version 1.0
 */
public class StartUpGenerator {
    /**
     * @description main method
     * @author wuhengzhen
     * @date 2019/11/29 18:11
     **/
    public static void main(String[] args) throws Exception {
        System.out.println("--------------------start generator-------------------");

        StartUpGenerator app = new StartUpGenerator();

        System.out.println(app.getClass().getResource("/").getPath());
        app.generator();
        System.out.println(System.getProperty("user.dir"));

        System.out.println("--------------------end generator-------------------");

    }


    public void generator() throws Exception {

        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(resourceAsStream);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
