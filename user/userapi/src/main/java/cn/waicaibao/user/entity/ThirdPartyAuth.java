package cn.waicaibao.user.entity;


import cn.waicaibao.user.entity.base.BaseThirdPartyAuth;

public class ThirdPartyAuth extends BaseThirdPartyAuth {
    private int hashCode = Integer.MIN_VALUE;

    // ----------------重写方法-------------------------
    @Override
    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (this.getId() == null) {
                return super.hashCode();
            }else {
                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
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

        if (!(obj instanceof ThirdPartyAuth)) {
            return false;
        } else {
            ThirdPartyAuth thirdPartyAuth = (ThirdPartyAuth) obj;
            if (this.getId() == null || thirdPartyAuth.getId() == null) {
                return false;
            }else {
                return (this.getId().equals(thirdPartyAuth.getId()));
            }
        }
    }
}
