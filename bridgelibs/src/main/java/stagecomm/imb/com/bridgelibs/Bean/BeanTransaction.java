package stagecomm.imb.com.bridgelibs.Bean;

import com.iapps.adapters.BaseBean;

import org.joda.time.DateTime;

/**
 * Created by marcelsantoso.
 * <p/>
 * 6/20/16
 */
public class BeanTransaction extends BaseBean {
    //1 settlement //2 success //3 challenge //4 pending //5 deny // 6 cancel
    String status, id, value, name, paket, type;
    DateTime date;

    public String getStatus() {
        return status;
    }

    public BeanTransaction setStatus(String status) {
        this.status = status;
        return this;
    }

    public BeanTransaction setId(String id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public BeanTransaction setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BeanTransaction setName(String name) {
        this.name = name;
        return this;
    }

    public String getPaket() {
        return paket;
    }

    public BeanTransaction setPaket(String paket) {
        this.paket = paket;
        return this;
    }

    public String getType() {
        return type;
    }

    public BeanTransaction setType(String type) {
        this.type = type;
        return this;
    }

    public DateTime getDate() {
        return date;
    }

    public BeanTransaction setDate(DateTime date) {
        this.date = date;
        return this;
    }
}
