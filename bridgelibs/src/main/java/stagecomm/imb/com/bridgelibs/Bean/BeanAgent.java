package stagecomm.imb.com.bridgelibs.Bean;

/**
 * Created by marcelsantoso.
 * <p/>
 * 7/15/16
 */
public class BeanAgent {
    int    id;
    String username, email, phone, hash, name, img, rank, rankImg;

    public String getRank() {
        return rank;
    }

    public BeanAgent setRank(String rank) {
        this.rank = rank;
        return this;
    }

    public String getRankImg() {
        return rankImg;
    }

    public BeanAgent setRankImg(String rankImg) {
        this.rankImg = rankImg;
        return this;
    }

    public int getId() {
        return id;
    }

    public BeanAgent setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public BeanAgent setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BeanAgent setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public BeanAgent setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getHash() {
        return hash;
    }

    public BeanAgent setHash(String hash) {
        this.hash = hash;
        return this;
    }

    public String getName() {
        return name;
    }

    public BeanAgent setName(String name) {
        this.name = name;
        return this;
    }

    public String getImg() {
        return img;
    }

    public BeanAgent setImg(String img) {
        this.img = img;
        return this;
    }
}
