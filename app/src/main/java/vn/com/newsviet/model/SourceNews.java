package vn.com.newsviet.model;

import android.content.Intent;

import java.io.Serializable;
import java.util.ArrayList;

public class SourceNews  implements Serializable {
    public int resource=-1;
    public String title;
//    public Intent intent;
    public ArrayList<News> arrayListNews;

    public SourceNews(int resource, String title, ArrayList<News> arrayListNews) {
        this.resource = resource;
        this.title = title;
        this.arrayListNews = arrayListNews;
    }
}
