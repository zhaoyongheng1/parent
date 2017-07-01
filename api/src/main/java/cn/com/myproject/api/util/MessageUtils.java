package cn.com.myproject.api.util;

/**
 * Created by liyang-macbook on 2017/7/1.
 */
public class MessageUtils {

    public static Message get(int result,String message) {
        return new Message(result,message);
    }

    public static Message getSuccess(String message) {
        return new Message(1,message);
    }

    public static Message getFail(String message) {
        return new Message(0,message);
    }
}
