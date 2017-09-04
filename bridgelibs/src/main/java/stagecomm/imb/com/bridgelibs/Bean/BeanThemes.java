package stagecomm.imb.com.bridgelibs.Bean;

import java.io.Serializable;

/**
 * Created by marcelsantoso.
 * <p/>
 * 6/21/16
 */
public class BeanThemes implements Serializable{
    int id, order, minversion;
    String name, group, header = "#ffffff", warnaText = "#4b4b4b", warna1 = "#ffffff", warna2 = "#ffffff", warna3 = "#ffffff", warna4 = "#ffffff", warnaGrid = "#ffffff", price, style;
    boolean isFree, bought, equiped, active, selected, inverse;

    public boolean isInverse() {
        return inverse;
    }

    public BeanThemes setInverse(boolean inverse) {
        this.inverse = inverse;
        return this;
    }

    public String getWarnaGrid() {
        return warnaGrid;
    }

    public BeanThemes setWarnaGrid(String warnaGrid) {
        this.warnaGrid = warnaGrid;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public BeanThemes setStyle(String style) {
        this.style = style;
        return this;
    }

    public String getWarnaText() {
        return warnaText;
    }

    public BeanThemes setWarnaText(String warnaText) {
        this.warnaText = warnaText;
        return this;
    }

    public boolean isSelected() {
        return selected;
    }

    public BeanThemes setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }

    public int getId() {
        return id;
    }

    public BeanThemes setId(int id) {
        this.id = id;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public BeanThemes setOrder(int order) {
        this.order = order;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanThemes setName(String name) {
        this.name = name;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public BeanThemes setGroup(String group) {
        this.group = group;
        return this;
    }

    public String getHeader() {
        return header;
    }

    public BeanThemes setHeader(String header) {
        this.header = header;
        return this;
    }

    public String getWarna1() {
        return warna1;
    }

    public BeanThemes setWarna1(String warna1) {
        this.warna1 = warna1;
        return this;
    }

    public String getWarna2() {
        return warna2;
    }

    public BeanThemes setWarna2(String warna2) {
        this.warna2 = warna2;
        return this;
    }

    public String getWarna3() {
        return warna3;
    }

    public BeanThemes setWarna3(String warna3) {
        this.warna3 = warna3;
        return this;
    }

    public String getWarna4() {
        return warna4;
    }

    public BeanThemes setWarna4(String warna4) {
        this.warna4 = warna4;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public BeanThemes setPrice(String price) {
        this.price = price;
        return this;
    }

    public int getMinversion() {
        return minversion;
    }

    public BeanThemes setMinversion(int minversion) {
        this.minversion = minversion;
        return this;
    }

    public boolean isFree() {
        return isFree;
    }

    public BeanThemes setFree(boolean free) {
        isFree = free;
        return this;
    }

    public boolean isBought() {
        return bought;
    }

    public BeanThemes setBought(boolean bought) {
        this.bought = bought;
        return this;
    }

    public boolean isEquiped() {
        return equiped;
    }

    public BeanThemes setEquiped(boolean equiped) {
        this.equiped = equiped;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public BeanThemes setActive(boolean active) {
        this.active = active;
        return this;
    }
}
