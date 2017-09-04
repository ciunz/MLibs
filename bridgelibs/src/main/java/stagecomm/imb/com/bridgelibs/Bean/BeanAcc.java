package stagecomm.imb.com.bridgelibs.Bean;

/**
 * Created by marcelsantoso.
 * <p/>
 * 5/27/16
 */
public class BeanAcc {
    int    id;
    String username, email, hash;

    public int getId() {
        return id;
    }

    public BeanAcc setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public BeanAcc setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BeanAcc setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public BeanAcc setHash(String hash) {
        this.hash = hash;
        return this;
    }
}
