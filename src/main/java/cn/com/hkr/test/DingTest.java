package cn.com.hkr.test;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiAttendanceListRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiSsoGettokenRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiAttendanceListResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiSsoGettokenResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author jason
 * @date 2021/12/18-10:21
 */
public class DingTest {
    private static final Properties pro = new Properties();

    static {
        InputStream inputStream = DingTest.class.getClassLoader().getResourceAsStream("dingtalk.properties");
        try {
            pro.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws ApiException {
        System.out.println("------------------------------1-----------------------------");
        ///////获取应用的令牌token
        DingTalkClient client  = new DefaultDingTalkClient(pro.getProperty("getTokenurl"));

        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(pro.getProperty("appkey"));
        request.setAppsecret(pro.getProperty("appsecret"));

        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);


        //获取响应体
        String accessToken = response.getAccessToken();

        System.out.println("accessToken:" + accessToken);
        System.out.println("body:" + response.getBody());
        /////////////////////////////////获取免密登陆token
        System.out.println("------------------------------2-----------------------------");
        DefaultDingTalkClient client2 = new DefaultDingTalkClient(pro.getProperty("getSsotokenurl"));
        OapiSsoGettokenRequest ssoGettokenRequest = new OapiSsoGettokenRequest();
        ssoGettokenRequest.setCorpid(pro.getProperty("manager_gorpid"));
        ssoGettokenRequest.setCorpsecret(pro.getProperty("manager_sso_secret"));
        OapiSsoGettokenResponse response2 = client2.execute(ssoGettokenRequest, accessToken);

        String body1 = response2.getBody();
        System.out.println(body1);
        String accessToken1 = response2.getAccessToken();
        System.out.println(accessToken1);


        /////////////////////////////////通过accesstoken获取用户id
        System.out.println("------------------------------3-----------------------------");
        DefaultDingTalkClient client1 = new DefaultDingTalkClient(pro.getProperty("getUserinfourl"));
        OapiUserGetuserinfoRequest request1 = new OapiUserGetuserinfoRequest();

        request1.setCode(pro.getProperty("manager_userid"));
        request1.setHttpMethod("GET");


        OapiUserGetuserinfoResponse response1 = client1.execute(request1, accessToken1);
        String body = response1.getBody();
        String userid =  response1.getCode();
        System.out.println("body:" + body);
        System.out.println("userid :" + userid);


        ////////////////////////获取用户的考勤打卡记录
        System.out.println("------------------------------4-----------------------------");
        DefaultDingTalkClient client3 = new DefaultDingTalkClient(pro.getProperty("getattendanceurl"));

        OapiAttendanceListRequest oapiAttendanceListRequest = new OapiAttendanceListRequest();

        oapiAttendanceListRequest.setWorkDateFrom("2021-12-05 00:00:00");
        oapiAttendanceListRequest.setWorkDateTo("2021-12-12 00:00:00");
        oapiAttendanceListRequest.setUserIdList(Arrays.asList("424006432533031526"));
        oapiAttendanceListRequest.setOffset(0L);
        //50条
        oapiAttendanceListRequest.setLimit(1L);

        OapiAttendanceListResponse respo = client3.execute(oapiAttendanceListRequest, accessToken);

        System.out.println(respo.getBody());




    }


}
