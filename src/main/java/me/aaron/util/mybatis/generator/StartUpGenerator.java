package me.aaron.util.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
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
    public static void main(String[] args) {
        try {
            System.out.println("--------------------start generator-------------------");
            List<String> warnings = new ArrayList<>();
            boolean overwrite = true;
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(is);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("--------------------end generator-------------------");
        } catch (SQLException | IOException | InterruptedException | InvalidConfigurationException | XMLParserException e) {
            e.printStackTrace();
        }
    }
}
