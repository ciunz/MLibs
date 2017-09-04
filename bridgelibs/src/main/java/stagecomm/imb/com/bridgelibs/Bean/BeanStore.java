package stagecomm.imb.com.bridgelibs.Bean;

/**
 * Created by marcelsantoso.
 * <p/>
 * 6/24/16
 */
public class BeanStore extends BeanContact {
    int contentId, appId;
    String name, latitude, longitude, openingHour;
    boolean active;
    double  distance;

    public double getDistance() {
        return distance;
    }

    public BeanStore setDistance(double distance) {
        this.distance = distance;
        return this;
    }

    public int getContentId() {
        return contentId;
    }

    public BeanStore setContentId(int contentId) {
        this.contentId = contentId;
        return this;
    }

    public int getAppId() {
        return appId;
    }

    public BeanStore setAppId(int appId) {
        this.appId = appId;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanStore setName(String name) {
        this.name = name;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public BeanStore setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public BeanStore setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public BeanStore setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public BeanStore setActive(boolean active) {
        this.active = active;
        return this;
    }
}
