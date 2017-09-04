package stagecomm.imb.com.bridgelibs.Bean;

import com.iapps.adapters.BaseBean;

import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Created by marcelsantoso.
 * <p/>
 * 5/27/16
 */
public class BeanA extends BaseBean {

    String name, video, map = "", price, call, email, callText, emailText, shareText, website, websiteText, inviteText, headerType = "";
    String videoText, mapText;
    ArrayList<String> alCarousel;
    ArrayList<BeanAContent> alContent;
    DateTime dateUpdate, datePost;
    boolean hidden;
    // Addon
    boolean isCall, isEmail, isShare, isPrice, isWeb, isInvite;
    boolean isVideo, isMap;

    public String getHeaderType() {
        return headerType;
    }

    public BeanA setHeaderType(String headerType) {
        this.headerType = headerType;
        return this;
    }

    public boolean isHidden() {
        return hidden;
    }

    public BeanA setHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanA setName(String name) {
        this.name = name;
        return this;
    }

    public DateTime getDateUpdate() {
        return dateUpdate;
    }

    public BeanA setDateUpdate(DateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
        return this;
    }

    public String getCallText() {
        return callText;
    }

    public BeanA setCallText(String callText) {
        this.callText = callText;
        return this;
    }

    public String getEmailText() {
        return emailText;
    }

    public BeanA setEmailText(String emailText) {
        this.emailText = emailText;
        return this;
    }

    public String getShareText() {
        return shareText;
    }

    public BeanA setShareText(String shareText) {
        this.shareText = shareText;
        return this;
    }

    public DateTime getDatePost() {
        return datePost;
    }

    public BeanA setDatePost(DateTime datePost) {
        this.datePost = datePost;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public BeanA setVideo(String video) {
        this.video = video;
        return this;
    }

    public String getMap() {
        return map;
    }

    public BeanA setMap(String map) {
        this.map = map;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public BeanA setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getCall() {
        return call;
    }

    public BeanA setCall(String call) {
        this.call = call;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BeanA setEmail(String email) {
        this.email = email;
        return this;
    }

    public ArrayList<String> getAlCarousel() {
        return alCarousel;
    }

    public BeanA setAlCarousel(ArrayList<String> alCarousel) {
        this.alCarousel = alCarousel;
        return this;
    }

    public ArrayList<BeanAContent> getAlContent() {
        return alContent;
    }

    public BeanA setAlContent(ArrayList<BeanAContent> alContent) {
        this.alContent = alContent;
        return this;
    }

    public boolean isCall() {
        return isCall;
    }

    public BeanA setCall(boolean call) {
        isCall = call;
        return this;
    }

    public boolean isEmail() {
        return isEmail;
    }

    public BeanA setEmail(boolean email) {
        isEmail = email;
        return this;
    }

    public boolean isShare() {
        return isShare;
    }

    public BeanA setShare(boolean share) {
        isShare = share;
        return this;
    }

    public boolean isPrice() {
        return isPrice;
    }

    public BeanA setPrice(boolean price) {
        isPrice = price;
        return this;
    }

    public boolean isWeb() {
        return isWeb;
    }

    public BeanA setWeb(boolean web) {
        isWeb = web;
        return this;
    }

    public boolean isInvite() {
        return isInvite;
    }

    public BeanA setInvite(boolean invite) {
        isInvite = invite;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public BeanA setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getWebsiteText() {
        return websiteText;
    }

    public BeanA setWebsiteText(String websiteText) {
        this.websiteText = websiteText;
        return this;
    }

    public String getInviteText() {
        return inviteText;
    }

    public BeanA setInviteText(String inviteText) {
        this.inviteText = inviteText;
        return this;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public boolean isMap() {
        return isMap;
    }

    public void setMap(boolean map) {
        isMap = map;
    }

    public String getVideoText() {
        return videoText;
    }

    public void setVideoText(String videoText) {
        this.videoText = videoText;
    }

    public String getMapText() {
        return mapText;
    }

    public void setMapText(String mapText) {
        this.mapText = mapText;
    }
}
