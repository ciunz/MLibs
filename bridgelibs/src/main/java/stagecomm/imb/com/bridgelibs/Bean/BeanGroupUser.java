package stagecomm.imb.com.bridgelibs.Bean;

import org.joda.time.DateTime;

/**
 * Created by marcelsantoso.
 * <p/>
 * 8/9/16
 */
public class BeanGroupUser {
    String id, appId, email, name, imgUrl, phone, points, status;
    DateTime dob;
    boolean male;

    public String getId() {
        return id;
    }

    public BeanGroupUser setId(String id) {
        this.id = id;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public BeanGroupUser setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BeanGroupUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanGroupUser setName(String name) {
        this.name = name;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public BeanGroupUser setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public BeanGroupUser setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPoints() {
        return points;
    }

    public BeanGroupUser setPoints(String points) {
        this.points = points;
        return this;
    }

    public DateTime getDob() {
        return dob;
    }

    public BeanGroupUser setDob(DateTime dob) {
        this.dob = dob;
        return this;
    }

    public boolean isMale() {
        return male;
    }

    public BeanGroupUser setMale(boolean male) {
        this.male = male;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public BeanGroupUser setStatus(String status) {
        this.status = status;
        return this;
    }
}
