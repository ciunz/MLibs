package stagecomm.imb.com.bridgelibs.Bean;

import java.util.ArrayList;

/**
 * Created by marcelsantoso.
 * <p/>
 * 6/30/16
 */
public class BeanE {
    String title = "", content = "";
    ArrayList<BeanTable> alTable = new ArrayList<>();

    public ArrayList<BeanTable> getAlTable() {
        return alTable;
    }

    public BeanE setAlTable(ArrayList<BeanTable> alTable) {
        this.alTable = alTable;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BeanE setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public BeanE setContent(String content) {
        this.content = content;
        return this;
    }
}
