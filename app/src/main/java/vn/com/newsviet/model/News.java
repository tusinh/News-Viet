package vn.com.newsviet.model;

import java.io.Serializable;

public class News implements Serializable {

    public String title = "";
    public String link = "";
    public String img = "";
    public String description_short = "";
    public String guid = "";
    public String pubDate = "";
    public boolean isSelected = false;
    public String source = "";
    public String categ = "";

    public News(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public News(String title, String link, String img, String description_short, String guid, String pubDate) {
        this.title = title;
        this.link = link;
        this.img = img;
        this.description_short = description_short;
        this.guid = guid;
        this.pubDate = pubDate;
    }

}
