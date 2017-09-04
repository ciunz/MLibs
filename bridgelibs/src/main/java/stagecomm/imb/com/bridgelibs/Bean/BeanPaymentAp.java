package stagecomm.imb.com.bridgelibs.Bean;

/**
 * Created by marcelsantoso.
 * <p>
 * 8/4/16
 */
public class BeanPaymentAp {
    String id, name;
    double price;

    public String getId() {
        return id;
    }

    public BeanPaymentAp setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanPaymentAp setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public BeanPaymentAp setPrice(double price) {
        this.price = price;
        return this;
    }
}
