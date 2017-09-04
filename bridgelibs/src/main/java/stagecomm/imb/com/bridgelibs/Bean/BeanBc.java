package stagecomm.imb.com.bridgelibs.Bean;

import org.joda.time.DateTime;

/**
 * Created by marcelsantoso.
 * <p/>
 * 8/4/16
 */
public class BeanBc {
    int apPoint;
    String id, clientId, appId, name, title, img, msg, url;
    boolean active;
    DateTime date, time;

    public int getApPoint() {
        return apPoint;
    }

    public BeanBc setApPoint(int apPoint) {
        this.apPoint = apPoint;
        return this;
    }

    public String getId() {
        return id;
    }

    public BeanBc setId(String id) {
        this.id = id;
        return this;
    }

    public String getClientId() {
        return clientId;
    }

    public BeanBc setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public BeanBc setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanBc setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BeanBc setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImg() {
        return img;
    }

    public BeanBc setImg(String img) {
        this.img = img;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BeanBc setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public BeanBc setUrl(String url) {
        this.url = url;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public BeanBc setActive(boolean active) {
        this.active = active;
        return this;
    }

    public DateTime getDate() {
        return date;
    }

    public BeanBc setDate(DateTime date) {
        this.date = date;
        return this;
    }

    public DateTime getTime() {
        return time;
    }

    public BeanBc setTime(DateTime time) {
        this.time = time;
        return this;
    }
}
