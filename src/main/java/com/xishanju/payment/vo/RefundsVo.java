package com.xishanju.payment.vo;

import java.util.List;

/**
 * @Author:shuyong
 * @Description:
 * @Date: Create in 10:43 2018/5/18
 */
public class RefundsVo {

    private String object;

    private String url;

    private boolean has_more;

    private List data;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
