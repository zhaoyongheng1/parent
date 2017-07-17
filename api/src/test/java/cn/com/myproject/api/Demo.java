package cn.com.myproject.api;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.util.CollectionUtils;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by liyang-macbook on 2017/7/10.
 */
public class Demo  {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        String secret = "5502cfcf4546f0ce23931d9f71408dc658a65b87";
        Map<String,String> map = new LinkedHashMap<>();
        map.put("app_id","2016100001");
        map.put("nonce_str","a");
        map.put("version","1.0");
        String s = Calendar.getInstance().getTimeInMillis()/1000+"";
        System.out.println(s);
        map.put("timestamp", s);
        map.put("channel","pay.weixin.native");
        map.put("mch_id","2317");
        String id = UUID.randomUUID().toString().replace("-","");
        System.out.println(id);
        map.put("out_trade_no", id);
        map.put("title","ceshidingdan");
        map.put("total_fee","1");
      //  map.put("openid","18600890788");


        map = Demo.sign(map);

        DefaultHttpClient httpClient = new DefaultHttpClient();
        String url = "https://pay.vyicoo.com/v2/pay/gateway";
        HttpPost httpPost = new HttpPost(url);

        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for(String str : map.keySet()) {
            nvps.add(new BasicNameValuePair(str, map.get(str)));
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            // 执行请求
            HttpResponse response = httpClient.execute(httpPost);

            // 打印执行结果
            System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Map<String, String> sign( Map<String,String> map) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Map<String, String> _map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {

                        return obj1.compareTo(obj2);
                    }
                });
        _map.putAll(map);



        StringBuilder sb = new StringBuilder();
        for(String s : _map.keySet()) {
            sb.append(s).append("=").append(_map.get(s)).append("&");
        }
        sb.append("key=").append("5502cfcf4546f0ce23931d9f71408dc658a65b87");

        System.out.println(sb.toString());

        String sign =   DigestUtils.md5Hex(sb.toString());
        System.out.println(sign);
        _map.put("sign",sign.toUpperCase());

        return _map;
    }
}
