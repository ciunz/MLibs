package stagecomm.imb.com.bridgelibs.Bean;

import org.joda.time.DateTime;

/**
 * Created by marcelsantoso.
 * <p/>
 * 5/27/16
 */
public class BeanApps {
    private String appId, appClientId, appName, appPushname, appShortdes, appFulldes, appKeywords, appIcon, appFeat, appActive, appPulsa, appToken, appAllowedIp, appApiAccessKey, appType, appGooglePlayLink, appGoogleVersion, appIosLink, appIosVersion, appCategory, appFreeData, appOrder, headerType, carousel, homeType;
    private boolean isCreateApps, enableLogin, forceUpdate;
    //    private int      apPoint;
    private DateTime appContractStart, appCreateDate;

    public boolean isForceUpdate() {
        return forceUpdate;
    }

    public BeanApps setForceUpdate(boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
        return this;
    }

    public boolean isEnableLogin() {
        return enableLogin;
    }

    public BeanApps setEnableLogin(boolean enableLogin) {
        this.enableLogin = enableLogin;
        return this;
    }

//    public int getApPoint() {
//        return apPoint;
//    }
//
//    public BeanApps setApPoint(int apPoint) {
//        this.apPoint = apPoint;
//        return this;
//    }

    public DateTime getAppContractStart() {
        return appContractStart;
    }

    public BeanApps setAppContractStart(DateTime appContractStart) {
        this.appContractStart = appContractStart;
        return this;
    }

    public DateTime getAppCreateDate() {
        return appCreateDate;
    }

    public BeanApps setAppCreateDate(DateTime appCreateDate) {
        this.appCreateDate = appCreateDate;
        return this;
    }

    public String getHomeType() {
        return homeType;
    }

    public BeanApps setHomeType(String homeType) {
        this.homeType = homeType;
        return this;
    }

    public String getCarousel() {
        return carousel;
    }

    public BeanApps setCarousel(String carousel) {
        this.carousel = carousel;
        return this;
    }

    public String getHeaderType() {
        return headerType;
    }

    public BeanApps setHeaderType(String headerType) {
        this.headerType = headerType;
        return this;
    }

    public boolean isCreateApps() {
        return isCreateApps;
    }

    public BeanApps setCreateApps(boolean createApps) {
        isCreateApps = createApps;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public BeanApps setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getAppClientId() {
        return appClientId;
    }

    public BeanApps setAppClientId(String appClientId) {
        this.appClientId = appClientId;
        return this;
    }

    public String getAppName() {
        return appName;
    }

    public BeanApps setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public String getAppPushname() {
        return appPushname;
    }

    public BeanApps setAppPushname(String appPushname) {
        this.appPushname = appPushname;
        return this;
    }

    public String getAppShortdes() {
        return appShortdes;
    }

    public BeanApps setAppShortdes(String appShortdes) {
        this.appShortdes = appShortdes;
        return this;
    }

    public String getAppFulldes() {
        return appFulldes;
    }

    public BeanApps setAppFulldes(String appFulldes) {
        this.appFulldes = appFulldes;
        return this;
    }

    public String getAppKeywords() {
        return appKeywords;
    }

    public BeanApps setAppKeywords(String appKeywords) {
        this.appKeywords = appKeywords;
        return this;
    }

    public String getAppIcon() {
        return appIcon;
    }

    public BeanApps setAppIcon(String appIcon) {
        this.appIcon = appIcon;
        return this;
    }

    public String getAppFeat() {
        return appFeat;
    }

    public BeanApps setAppFeat(String appFeat) {
        this.appFeat = appFeat;
        return this;
    }

    public String getAppActive() {
        return appActive;
    }

    public BeanApps setAppActive(String appActive) {
        this.appActive = appActive;
        return this;
    }

    public String getAppPulsa() {
        return appPulsa;
    }

    public BeanApps setAppPulsa(String appPulsa) {
        this.appPulsa = appPulsa;
        return this;
    }

    public String getAppToken() {
        return appToken;
    }

    public BeanApps setAppToken(String appToken) {
        this.appToken = appToken;
        return this;
    }

    public String getAppAllowedIp() {
        return appAllowedIp;
    }

    public BeanApps setAppAllowedIp(String appAllowedIp) {
        this.appAllowedIp = appAllowedIp;
        return this;
    }

    public String getAppApiAccessKey() {
        return appApiAccessKey;
    }

    public BeanApps setAppApiAccessKey(String appApiAccessKey) {
        this.appApiAccessKey = appApiAccessKey;
        return this;
    }

    public String getAppType() {
        return appType;
    }

    public BeanApps setAppType(String appType) {
        this.appType = appType;
        return this;
    }

    public String getAppGooglePlayLink() {
        return appGooglePlayLink;
    }

    public BeanApps setAppGooglePlayLink(String appGooglePlayLink) {
        this.appGooglePlayLink = appGooglePlayLink;
        return this;
    }

    public String getAppGoogleVersion() {
        return appGoogleVersion;
    }

    public BeanApps setAppGoogleVersion(String appGoogleVersion) {
        this.appGoogleVersion = appGoogleVersion;
        return this;
    }

    public String getAppIosLink() {
        return appIosLink;
    }

    public BeanApps setAppIosLink(String appIosLink) {
        this.appIosLink = appIosLink;
        return this;
    }

    public String getAppIosVersion() {
        return appIosVersion;
    }

    public BeanApps setAppIosVersion(String appIosVersion) {
        this.appIosVersion = appIosVersion;
        return this;
    }

    public String getAppCategory() {
        return appCategory;
    }

    public BeanApps setAppCategory(String appCategory) {
        this.appCategory = appCategory;
        return this;
    }

    public String getAppFreeData() {
        return appFreeData;
    }

    public BeanApps setAppFreeData(String appFreeData) {
        this.appFreeData = appFreeData;
        return this;
    }

    public String getAppOrder() {
        return appOrder;
    }

    public BeanApps setAppOrder(String appOrder) {
        this.appOrder = appOrder;
        return this;
    }
}
