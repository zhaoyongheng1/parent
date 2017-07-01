package cn.com.myproject.api.im.VO.account;

import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;
import java.util.*;

/**
 * Created by liyang-macbook on 2017/6/28.
 */
public class IMCreateVO  implements Serializable {
    private String accid;
    private String name;
    private String props;
    private String icon;
    private String token;

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MultiValueMap<String,String> toMap(){
        Map<String, List<String>> map = new HashMap<>();
        List<String> list;
        if(null != accid){
            list = new LinkedList<>();
            list.add(accid);
            map.put("accid",list);
        }

        if(null != name){
            list = new LinkedList<>();
            list.add(name);
            map.put("name",list);
        }

        if(null != props){
            list = new LinkedList<>();
            list.add(props);
            map.put("props",list);
        }

        if(null != icon){
            list = new LinkedList<>();
            list.add(icon);
            map.put("icon",list);
        }

        if(null != token){
            list = new LinkedList<>();
            list.add(token);
            map.put("token",list);
        }

        return CollectionUtils.toMultiValueMap(map);
    }
}
