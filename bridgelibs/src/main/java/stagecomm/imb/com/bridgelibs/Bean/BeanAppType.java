package stagecomm.imb.com.bridgelibs.Bean;

/**
 * Created by marcelsantoso.
 * <p/>
 * 8/10/16
 */
public class BeanAppType {
    String id, name, description;

    public String getId() {
        return id;
    }

    public BeanAppType setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanAppType setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BeanAppType setDescription(String description) {
        this.description = description;
        return this;
    }
}
