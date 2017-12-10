package com.vimfox.utils;

import com.worldunion.prophesy.utils.httputils.common.HttpConfig;
import com.worldunion.prophesy.utils.httputils.exception.HttpProcessException;
import com.worldunion.prophesy.utils.httputils.httpclient.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 0141434 on 2016-07-19.
 */
public class AreaCodeTest {


    @Test
    public void test01() throws HttpProcessException {
        String url = "http://www.8684.cn/code";
        HttpConfig config = HttpConfig.custom();
        config.encoding("utf-8");
        //简单调用
        String result = HttpClientUtil.get(config.url(url));
        Elements elements = Jsoup.parse(result).select(".index_ad_top a");
        Map<String, String> data = new HashMap<>();

        for (Element element : elements) {
            String txt = element.text();
            if (StringUtils.isNotBlank(txt) && txt.contains("(")) {
             String[] arr =   txt.split("\\(");
                data.put(arr[0],arr[1].replace(")",""));

            }
        }
        System.out.println(data);
    }
}
