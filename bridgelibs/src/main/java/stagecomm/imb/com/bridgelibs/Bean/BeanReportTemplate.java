package stagecomm.imb.com.bridgelibs.Bean;

/**
 * Created by marcelsantoso.
 * <p/>
 * 8/29/16
 */
public class BeanReportTemplate {
    String id, message;

    @Override
    public String toString() {
        return message;
    }

    public String getId() {
        return id;
    }

    public BeanReportTemplate setId(String id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BeanReportTemplate setMessage(String message) {
        this.message = message;
        return this;
    }
}
