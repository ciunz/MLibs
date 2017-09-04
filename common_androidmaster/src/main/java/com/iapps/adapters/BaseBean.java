package com.iapps.adapters;

/**
 * Created by marcelsantoso.
 * <p/>
 * 6/22/16
 */
public abstract class BaseBean extends Object{
    int id, position;
    String name, imgUrl;

    public int getPosition() {
        return position;
    }

    public BaseBean setPosition(int position) {
        this.position = position;
        return this;
    }

    public String getName() {
        return name;
    }

    public BaseBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public BaseBean setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public int getId() {
        return id;
    }

    public BaseBean setId(int id) {
        this.id = id;
        return this;
    }
}
