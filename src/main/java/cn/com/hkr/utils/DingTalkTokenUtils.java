package cn.com.hkr.utils;

import cn.com.hkr.test.DingTest;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author jason
 * @date 2021/12/18-14:30
 */
public class DingTalkTokenUtils {
    private static final Properties pro = new Properties();

    static {
        InputStream inputStream = DingTest.class.getClassLoader().getResourceAsStream("dingtalk.properties");
        try {
            pro.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 钉钉的获取全局access的token工具类
     * @return
     */
    public static  String getAppToken(){
        try {
            DingTalkClient client  = new DefaultDingTalkClient(pro.getProperty("getTokenurl"));

            OapiGettokenRequest request = new OapiGettokenRequest();
            request.setAppkey(pro.getProperty("appkey"));
            request.setAppsecret(pro.getProperty("appsecret"));

            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);


            //获取响应体
            String accessToken = response.getAccessToken();
            return accessToken;
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }
    }







}
