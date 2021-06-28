package com.clickpaas.test;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.taobao.api.ApiException;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class DingTest1 {
    // curl abc/getallmapping ==> a->outa b-->outb
    private static String proxyHost = "172.35.35.62";
//    private static String proxyHost = "172.35.35.63";
    private static int proxyPort = 1111;

    public static void main(String[] args) throws ApiException {

//    public static String getUserId(String requestAuthCode, String accessToken, SystemAccessBO systemAccessBO) throws ApiException {
//        DefaultDingTalkClient client = new DefaultDingTalkClient(GET_USER_INFO);
//        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
//        request.setCode(requestAuthCode);
//        request.setHttpMethod(GET);
//        Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(systemAccessBO.getIp(), systemAccessBO.getPort()));
//        client.setProxy(proxy);
//        OapiUserGetuserinfoResponse response = client.execute(request, accessToken);
//        if (!response.isSuccess()) {
//            LOGGER.error("requestAuthCode={},accessToken={}", requestAuthCode, accessToken);
//            LOGGER.error("获取钉钉服务商免登用户ID失败，result={}", response);
//            return null;
//        }
//        return response.getUserid();
//        DefaultDingTalkClient client = new DefaultDingTalkClient("https://app.clickpaas.com");
        DefaultDingTalkClient client = new DefaultDingTalkClient("http://dingding.console.clickpaas.com/ip");
        OapiUserGetuserinfoRequest req = new OapiUserGetuserinfoRequest();
//        OapiSnsGetuserinfoBycodeRequest req = new OapiSnsGetuserinfoBycodeRequest();
//        req.setTmpAuthCode("4a2c5695b78738d495f47b5fee9160cd");

        Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        client.setProxy(proxy);

        OapiUserGetuserinfoResponse response = client.execute(req,"token");
        System.out.println(JSON.toJSONString(response));
    }
}
