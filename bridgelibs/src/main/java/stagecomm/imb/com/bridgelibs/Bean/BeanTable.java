package stagecomm.imb.com.bridgelibs.Bean;

import com.iapps.adapters.BaseBean;

import java.util.ArrayList;

/**
 * Created by marcelsantoso.
 * <p/>
 * 6/22/16
 */
public class BeanTable extends BaseBean {
    ArrayList<BeanTableItem> al;

    public ArrayList<BeanTableItem> getAl() {
        return al;
    }

    public BeanTable setAl(ArrayList<BeanTableItem> al) {
        this.al = al;
        return this;
    }
}
