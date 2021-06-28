package com.clickpaas.test;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiSnsGetuserinfoBycodeRequest;
import com.dingtalk.api.response.OapiSnsGetuserinfoBycodeResponse;
import com.taobao.api.ApiException;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class DingTest {
    // curl abc/getallmapping ==> a->outa b-->outb
    private static String proxyHost = "172.35.35.62";
//    private static String proxyHost = "172.35.35.63";
    private static int proxyPort = 1111;
//    private static int proxyPort = 8080;
    public static void main(String[] args) throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://vpn.successchannel.tech/vpn");
        OapiSnsGetuserinfoBycodeRequest req = new OapiSnsGetuserinfoBycodeRequest();
        req.setTmpAuthCode("4a2c5695b78738d495f47b5fee9160cd");

        Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        client.setProxy(proxy);

        for (int i = 0; i < 5; i++) {
            long start = System.currentTimeMillis();
            try {
                OapiSnsGetuserinfoBycodeResponse response = client.execute(req,"yourAppId","yourAppSecret");
                System.out.println(JSON.toJSONString(response));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("cost(ms):"+( System.currentTimeMillis()-start));


        }
//        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/getuserinfo_bycode");

    }
}
