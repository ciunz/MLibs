package stagecomm.imb.com.bridgelibs.Bean;

import com.iapps.adapters.BaseBean;

import java.util.ArrayList;

/**
 * Created by marcelsantoso.
 * <p/>
 * 5/28/16
 */
public class BeanB extends BaseBean {
    ArrayList<BeanA> al;
    String desc;
    boolean          hide;

    public String getDesc() {
        return desc;
    }

    public BeanB setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public boolean isHide() {
        return hide;
    }

    public BeanB setHide(boolean hide) {
        this.hide = hide;
        return this;
    }

    public ArrayList<BeanA> getAl() {
        return al;
    }

    public BeanB setAl(ArrayList<BeanA> al) {
        this.al = al;
        return this;
    }
}
