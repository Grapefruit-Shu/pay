package com.xishanju.payment.remoting.wechat.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 11:26 2018/5/24
 */
public class MyConfig implements WXPayConfig {

    private byte[] certData;

    public MyConfig() throws Exception {
//        String certPath = "/path/to/apiclient_cert.p12";
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
    }

    public String getAppID() {
        return "wxab8acb865bb1637e";
    }

    public String getMchID() {
        return "11473623";
    }

    public String getKey() {
        return "2ab9071b06b9f739b950ddb41db2690d";
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}
