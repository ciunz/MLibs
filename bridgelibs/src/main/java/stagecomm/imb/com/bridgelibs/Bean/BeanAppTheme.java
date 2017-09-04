package stagecomm.imb.com.bridgelibs.Bean;

import android.support.annotation.NonNull;

/**
 * Created by korneliussendy on 1/24/17.
 */

public class BeanAppTheme {
    private String id;
    private String name;
    private String description;
    private String active;
    private String order;
    private String sharingan_id;
    private String screenshot;
    private boolean selected;

    public BeanAppTheme() {
    }

    public BeanAppTheme(@NonNull String themeName, String image) {
        this.name = themeName;
        this.screenshot = image;
        this.selected = false;
    }

    public BeanAppTheme(@NonNull String themeName, String image, boolean selected) {
        this.name = themeName;
        this.screenshot = image;
        this.selected = selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSharingan_id() {
        return sharingan_id;
    }

    public void setSharingan_id(String sharingan_id) {
        this.sharingan_id = sharingan_id;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
