package stagecomm.imb.com.bridgelibs.Bean;

import com.iapps.adapters.BaseBean;

/**
 * Created by marcelsantoso.
 * <p/>
 * 5/27/16
 */
public class BeanAContent extends BaseBean {
    String tabTitle, contentTitle, contentText;

    public String getTabTitle() {
        return tabTitle;
    }

    public BeanAContent setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
        return this;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public BeanAContent setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
        return this;
    }

    public String getContentText() {
        return contentText;
    }

    public BeanAContent setContentText(String contentText) {
        this.contentText = contentText;
        return this;
    }
}
