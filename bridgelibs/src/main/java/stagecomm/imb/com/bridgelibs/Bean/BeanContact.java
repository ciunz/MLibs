package stagecomm.imb.com.bridgelibs.Bean;

import com.iapps.adapters.BaseBean;

/**
 * Created by marcelsantoso.
 * <p/>
 * 6/30/16
 */
public class BeanContact extends BaseBean {
    String phone, email, address, additional, latitude, longitude, whatsapp, line, bbm, telegram;

    public String getWhatsapp() {
        return whatsapp;
    }

    public BeanContact setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
        return this;
    }

    public String getLine() {
        return line;
    }

    public BeanContact setLine(String line) {
        this.line = line;
        return this;
    }

    public String getBbm() {
        return bbm;
    }

    public BeanContact setBbm(String bbm) {
        this.bbm = bbm;
        return this;
    }

    public String getTelegram() {
        return telegram;
    }

    public BeanContact setTelegram(String telegram) {
        this.telegram = telegram;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public BeanContact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BeanContact setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public BeanContact setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAdditional() {
        return additional;
    }

    public BeanContact setAdditional(String additional) {
        this.additional = additional;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public BeanContact setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public BeanContact setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }
}
