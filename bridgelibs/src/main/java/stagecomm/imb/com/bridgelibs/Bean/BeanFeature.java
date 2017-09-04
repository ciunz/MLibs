package stagecomm.imb.com.bridgelibs.Bean;

import com.iapps.adapters.BaseBean;

/**
 * Created by marcelsantoso.
 * <p/>
 * 6/21/16
 */
public class BeanFeature extends BaseBean {
    int resIconDefault, type, position = -1, appId, id;
    String inHalt, iconUrl, name, desc;
    boolean isSingleton, isSelected, changeAble = true, isHide;

    //baru 22.03
    private String contentFlag;

    // Child beans
    BeanA      beanA;
    BeanB      beanB;
    BeanSocmed beanSocmed;

    public String getDesc() {
        return desc;
    }

    public BeanFeature setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public BeanB getBeanB() {
        return beanB;
    }

    public BeanFeature setBeanB(BeanB beanB) {
        this.beanB = beanB;
        return this;
    }

    public BeanSocmed getBeanSocmed() {
        return beanSocmed;
    }

    public BeanFeature setBeanSocmed(BeanSocmed beanSocmed) {
        this.beanSocmed = beanSocmed;
        return this;
    }

    public boolean isHide() {
        return isHide;
    }

    public BeanFeature setHide(boolean hide) {
        isHide = hide;
        return this;
    }

    public BeanA getBeanA() {
        return beanA;
    }

    public BeanFeature setBeanA(BeanA beanA) {
        this.beanA = beanA;
        return this;
    }

    public int getId() {
        return id;
    }

    public BeanFeature setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanFeature setName(String name) {
        this.name = name;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public BeanFeature setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public int getAppId() {
        return appId;
    }

    public BeanFeature setAppId(int appId) {
        this.appId = appId;
        return this;
    }

    public String getInHalt() {
        return inHalt;
    }

    public BeanFeature setInHalt(String inHalt) {
        this.inHalt = inHalt;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public BeanFeature setPosition(int position) {
        this.position = position;
        return this;
    }

    public boolean isChangeAble() {
        return changeAble;
    }

    public BeanFeature setChangeAble(boolean changeAble) {
        this.changeAble = changeAble;
        if (!changeAble) {
            setSelected(true);
        }
        return this;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public BeanFeature setSelected(boolean selected) {
        isSelected = selected;
        return this;
    }

    public int getResIconDefault() {
        return resIconDefault;
    }

    public BeanFeature setResIconDefault(int resIconDefault) {
        this.resIconDefault = resIconDefault;
        return this;
    }

    public int getType() {
        return type;
    }

    public BeanFeature setType(int type) {
        this.type = type;
        return this;
    }

    public boolean isSingleton() {
        return isSingleton;
    }

    public BeanFeature setSingleton(boolean singleton) {
        isSingleton = singleton;
        return this;
    }

    public String getContentFlag() {
        return contentFlag;
    }

    public BeanFeature setContentFlag(String contentFlag) {
        this.contentFlag = contentFlag;
        return this;
    }
}
