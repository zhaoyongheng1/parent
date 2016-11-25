package cn.waicaibao.user.entity;


import cn.waicaibao.user.entity.base.BasePrivilege;

/**
 * 基于路径的访问权限
 * 
 * @author licl
 *
 */
public class Privilege extends BasePrivilege {

    private int hashCode = Integer.MIN_VALUE;

    /**
     * 默认的权限规则（如果多个，使用换行符间隔）
     */
    public static String defaultPrivilege = "/static/** = anon\n/account/** = anon";


    // ----------------重写方法-------------------------
    @Override
    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (this.getId() == null) {
                return super.hashCode();
            }else {
                String hashStr = this.getClass().getName() + ":"
                        + this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }

        return this.hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Privilege)) {
            return false;
        } else {
            Privilege role = (Privilege) obj;
            if (this.getId() == null || role.getId() == null) {
                return false;
            }else {
                return (this.getId().equals(role.getId()));
            }
        }
    }
}
