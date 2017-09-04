package stagecomm.imb.com.bridgelibs.Bean;

import android.support.v7.widget.AppCompatEditText;

import com.iapps.adapters.BaseBean;

/**
 * Created by marcelsantoso.
 * <p/>
 * 6/22/16
 */
public class BeanTableItem extends BaseBean {
    String            value;
    AppCompatEditText edtValue, edtName;

    public AppCompatEditText getEdtName() {
        return edtName;
    }

    public BeanTableItem setEdtName(AppCompatEditText edtName) {
        this.edtName = edtName;
        return this;
    }

    public AppCompatEditText getEdtValue() {
        return edtValue;
    }

    public BeanTableItem setEdtValue(AppCompatEditText edtValue) {
        this.edtValue = edtValue;
        return this;
    }

    public String getValue() {
        return value;
    }

    public BeanTableItem setValue(String value) {
        this.value = value;
        return this;
    }
}
