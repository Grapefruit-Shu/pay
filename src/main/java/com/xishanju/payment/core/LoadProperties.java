package com.xishanju.payment.core;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 14:26 2018/5/17
 */
@Component("propertiesInit")
public class LoadProperties {

    private static Logger logger = Logger.getLogger(LoadProperties.class);

    private static String filePath;
    /**
     * 加载原生支付的配置信息
     */
    private static Properties nativeinfo = new Properties();

    public void init() {
        try {
            System.out.println("开始加载配置信息");
            InputStream is = LoadProperties.class.getClassLoader().getResourceAsStream(filePath);
            nativeinfo.load(is);
            is.close();
        } catch (Exception e) {
            logger.error("加载配置信息失败:",e);
        }
    }

    /**
     * 根据key读取value
     * @param keyWord
     * @return String
     * @throws
     */
    public static String getProperties(String keyWord){
        return nativeinfo.getProperty(keyWord);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
