package cn.com.myproject.sysuser.entity.PO;


import cn.com.myproject.util.BasePO;

/**
 * Created by liyang-macbook on 2017/6/21.
 */
public class SysResource extends BasePO {
    private String resourceId;
    private String resourceName;
    /**
     * 资源值
     * type=1,url
     * type=2,字符串
     * */
    private String value;

    private Short type;

    private String parentId;

    private String icon;


    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
