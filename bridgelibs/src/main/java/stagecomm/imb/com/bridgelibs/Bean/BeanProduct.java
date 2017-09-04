package stagecomm.imb.com.bridgelibs.Bean;

import java.io.Serializable;

/**
 * Created by marcelsantoso.
 * <p/>
 * 7/15/16
 */
public class BeanProduct implements Serializable {
    int id, merchantId;
    String codeName, name, img, description, currency, price, comission, priceDiscount;

    public int getId() {
        return id;
    }

    public BeanProduct setId(int id) {
        this.id = id;
        return this;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public BeanProduct setMerchantId(int merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public String getCodeName() {
        return codeName;
    }

    public BeanProduct setCodeName(String codeName) {
        this.codeName = codeName;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanProduct setName(String name) {
        this.name = name;
        return this;
    }

    public String getImg() {
        return img;
    }

    public BeanProduct setImg(String img) {
        this.img = img;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BeanProduct setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public BeanProduct setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public BeanProduct setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getComission() {
        return comission;
    }

    public BeanProduct setComission(String comission) {
        this.comission = comission;
        return this;
    }

    public String getPriceDiscount() {
        return priceDiscount;
    }

    public BeanProduct setPriceDiscount(String priceDiscount) {
        this.priceDiscount = priceDiscount;
        return this;
    }
}
