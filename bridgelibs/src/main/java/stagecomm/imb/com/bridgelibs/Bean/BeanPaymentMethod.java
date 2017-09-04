package stagecomm.imb.com.bridgelibs.Bean;

/**
 * Created by marcelsantoso.
 * <p/>
 * 7/18/16
 */
public class BeanPaymentMethod {
    String name;
    int    img;
    public BeanPaymentMethod(String name, int img){
        setName(name);
        setImg(img);
    }

    public String getName() {
        return name;
    }

    public BeanPaymentMethod setName(String name) {
        this.name = name;
        return this;
    }

    public int getImg() {
        return img;
    }

    public BeanPaymentMethod setImg(int img) {
        this.img = img;
        return this;
    }
}
