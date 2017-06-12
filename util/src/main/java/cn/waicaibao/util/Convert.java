package cn.waicaibao.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by liyang-macbook on 2016/11/21.
 */
public class Convert {
    /**
     * 隐藏手机号中间四位
     *
     * @param mobilePhone
     * @return
     */
    public static String toHiddenPhone(String mobilePhone) {
        if (StringUtils.isBlank(mobilePhone)) {
            return "";
        }
        if (!StringUtils.isNumeric(mobilePhone) || mobilePhone.length() != 11) {
            return mobilePhone.substring(0, 1) + "**";
        }
        return mobilePhone.substring(0, 3) + "****" + mobilePhone.substring(7);
    }
}
