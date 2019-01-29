package vn.com.newsviet;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import vn.com.newsviet.Utils.MyLog;
import vn.com.newsviet.Utils.ShowPopup;
import vn.com.newsviet.Utils.Utils;
import vn.com.newsviet.adapter.ListNewsAdapter;
import vn.com.newsviet.adapter.Main1Adapter;
import vn.com.newsviet.adapter.TabRecyclerAdapter;
import vn.com.newsviet.model.News;
import vn.com.newsviet.view.FontTextView;

/*create by tusinh on 1/2019*/
public class MainActivity extends AppCompatActivity {
    ImageView imgback, img1, img_newsfirst;
    FontTextView titleheader, ftv_categ_firstnews, ftv_source_firstnews, title_newsfirst, des_newsfirst,
            title1, title2, title3, title4,
            select, share_app, feedback, version_app;
    RecyclerView recyclerview1, recyclerview2, recyclerview3, recyclerview4;
    LinearLayout layout_loading;
    ScrollView scrollview;
    private DrawerLayout drawerLayout;

    ArrayList<News> datanews1 = new ArrayList();
    ArrayList<News> datanews2 = new ArrayList();
    ArrayList<News> datanews3 = new ArrayList();
    ArrayList<News> datanews4 = new ArrayList();
    String URL1 = "https://www.24h.com.vn/upload/rss/bongda.rss";
    String URL2 = "https://vnexpress.net/rss/thoi-su.rss";
    String URL3 = "http://soha.vn/quoc-te.rss";
    String URL4 = "https://ngoisao.net/rss/showbiz-viet.rss";
    Main1Adapter main1Adapter;
    ListNewsAdapter listNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        setHeader();
        String versionName = BuildConfig.VERSION_NAME;
        version_app.setText(versionName);
        initDataMain();
        MyOnClick();
    }

    private void initDataMain() {
        loadData();
    }

    private void intitDataReyclerView(ArrayList<News> data, String url) {
        if (url.equals(URL1)) {
            title1.setText(data.get(0).source + " / " + data.get(0).categ);
            recyclerview1.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
            main1Adapter = new Main1Adapter(MainActivity.this, data);
            recyclerview1.setAdapter(main1Adapter);
            recyclerview1.setNestedScrollingEnabled(false);
        } else if (url.equals(URL2)) {
            title2.setText(data.get(0).source + " / " + data.get(0).categ);
            recyclerview2.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
            main1Adapter = new Main1Adapter(MainActivity.this, data);
            recyclerview2.setAdapter(main1Adapter);
            recyclerview2.setNestedScrollingEnabled(false);
        } else if (url.equals(URL3)) {
            title3.setText(data.get(0).source + " / " + data.get(0).categ);
            recyclerview3.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
            listNewsAdapter = new ListNewsAdapter(MainActivity.this, data);
            recyclerview3.setAdapter(listNewsAdapter);
            recyclerview3.setNestedScrollingEnabled(false);
        } else if (url.equals(URL4)) {
            title4.setText(data.get(0).source + " / " + data.get(0).categ);
            recyclerview4.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
            listNewsAdapter = new ListNewsAdapter(MainActivity.this, data);
            recyclerview4.setAdapter(listNewsAdapter);
            recyclerview4.setNestedScrollingEnabled(false);
        }

    }

    private void loadData() {
        if (!Utils.isNetworkConnected(MainActivity.this)) {
            new ShowPopup(MainActivity.this).info(getString(R.string.no_internet), getString(R.string.title_notify)).show();
        } else {
            new ReaddataFirst().execute(URL1, URL2, URL3, URL4);
        }

    }

    private void MyOnClick() {
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(Gravity.LEFT); //CLOSE Nav Drawer!
                } else {
                    drawerLayout.openDrawer(Gravity.LEFT); //OPEN Nav Drawer!
                }
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListSourceNewsActivity.class));
            }
        });
        img_newsfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (datanews1.size() > 0 && datanews1.get(0) != null) {
                    Intent intent = new Intent(MainActivity.this, DetailNewsActivity.class);
                    intent.putExtra("link", datanews1.get(0).link);
                    startActivity(intent);
                }
            }
        });
        title_newsfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (datanews1.size() > 0 && datanews1.get(0) != null) {
                    Intent intent = new Intent(MainActivity.this, DetailNewsActivity.class);
                    intent.putExtra("link", datanews1.get(0).link);
                    startActivity(intent);
                }
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListSourceNewsActivity.class));
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
        share_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "share link intall app for friends", Toast.LENGTH_LONG).show();
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "intent action.new", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void setHeader() {
        imgback.setImageResource(R.mipmap.ic_menu);
        img1.setImageResource(R.mipmap.ic_a);
        img1.setVisibility(View.VISIBLE);
        titleheader.setText("News Việt");
        titleheader.setTypeface(titleheader.getTypeface(), Typeface.BOLD);

    }

    private void MyShowLayoutLoading() {
        layout_loading.setVisibility(View.VISIBLE);
        scrollview.setVisibility(View.GONE);
    }

    public void MyShowData() {
        layout_loading.setVisibility(View.GONE);
        scrollview.setVisibility(View.VISIBLE);
    }

    private void Anhxa() {
        imgback = findViewById(R.id.imgback);
        img1 = findViewById(R.id.img1);
        titleheader = findViewById(R.id.titleheader);
        title_newsfirst = findViewById(R.id.title_newsfirst);
        img_newsfirst = findViewById(R.id.img_newsfirst);
        ftv_source_firstnews = findViewById(R.id.ftv_source_firstnews);
        title_newsfirst = findViewById(R.id.title_newsfirst);
        des_newsfirst = findViewById(R.id.des_newsfirst);
        ftv_categ_firstnews = findViewById(R.id.ftv_categ_firstnews);
        recyclerview1 = findViewById(R.id.recyclerview1);
        recyclerview2 = findViewById(R.id.recyclerview2);
        recyclerview3 = findViewById(R.id.recyclerview3);
        recyclerview4 = findViewById(R.id.recyclerview4);
        title1 = findViewById(R.id.title1);
        title2 = findViewById(R.id.title2);
        title3 = findViewById(R.id.title3);
        title4 = findViewById(R.id.title4);
        select = findViewById(R.id.select);
        share_app = findViewById(R.id.share_app);
        feedback = findViewById(R.id.feedback);
        version_app = findViewById(R.id.version_app);

        scrollview = findViewById(R.id.scrollview);
        layout_loading = findViewById(R.id.layout_loading);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    class ReaddataFirst extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
//            super.onPreExecute();
            MyShowLayoutLoading();
//            MyLog.Log("onloading");
        }

        @Override
        protected String doInBackground(String... params) {
//            return Utils.docNoiDung_Tu_URL(params[0]);
            try {
                for (int i = 0; i < params.length; i++) {
                    Document document = Jsoup.connect(params[i]).get();
//                Document document = Jsoup.parse(s);
                    Elements item_eles = document.getElementsByTag("item");
                    String title = "";
                    String link = "";
                    String img = "";
                    String guid = "";
                    String description_short = "";
                    String pubDate = "";
//                ArrayList<News> datanewstemp = new ArrayList();
                    int count = 0;
                    for (Element item_ele : item_eles) {
//                    for(int j=0;j<item_eles.size();j++){
                        count++;
                        if (count > 10) break;

                        Element title_ele = item_ele.getElementsByTag("title").first();
                        Element link_ele = item_ele.getElementsByTag("link").first();
                        Element guid_ele = item_ele.getElementsByTag("guid").first();
                        Element pubDate_ele = item_ele.getElementsByTag("pubDate").first();
                        if (title_ele != null) {
                            title = title_ele.text().replace("&amp;#34;", "'\'").replaceAll("&#34;", "\'")
                                    .replaceAll("&#39;", "\'");
                        }
                        if (link_ele != null) {
                            link = link_ele.text();
                        }
                        if (guid_ele != null) {
                            guid = guid_ele.text();
                        }
                        if (pubDate != null) {
                            pubDate = pubDate_ele.text();
                        }
                        Element elementDes = item_ele.getElementsByTag("description").first();

                        if (elementDes != null) {
                            img = Utils.extractImageUrl(elementDes.text());
                            description_short = Jsoup.parse(elementDes.text()).text().replace("&amp;#34;", "'").replaceAll("&#34;", "'")
                                    .replaceAll("&#39;", "'");
                        }

//                    MyLog.Log("title: " + title);
//                    MyLog.Log("link: " + link);
//                    MyLog.Log("guid: " + guid);
//                    MyLog.Log("img: " + img);
//                    MyLog.Log("description_short: " + description_short);
//                    MyLog.Log("pubDate: " + pubDate);
//                    MyLog.Log("------------");
//                    if (!img.isEmpty()) {

                        News news = new News(title, link, img, description_short, guid, pubDate);
                        if (params[i].equals(URL1)) {
                            news.source = "24h";
                            news.categ = "thể thao";
//                            MyLog.Log("img: " + news.img);
                            datanews1.add(news);
                        } else if (params[i].equals(URL2)) {
                            news.source = "Vnexpress";
                            news.categ = "thời sự";
                            datanews2.add(news);
                        } else if (params[i].equals(URL3)) {
                            news.source = "Soha";
                            news.categ = "quốc tế";
                            datanews3.add(news);
                        } else if (params[i].equals(URL4)) {
                            news.source = "Ngôi sao";
                            news.categ = "showbiz việt";
                            datanews4.add(news);
                        }


//                    }

                    }
                    publishProgress(params[i]);
                }
//                if(datanewstemp.size()>0){
//
//                }
            } catch (IOException e) {
                e.printStackTrace();
                MyLog.Log("ex: " + e.toString());
            }
            return "successfully";
        }

        @Override
        protected void onPostExecute(String msg) {
            super.onPostExecute(msg);
//            MyLog.Log(msg);
//            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            MyShowData();
//            MyLog.Log("arrayListNew.size: " + ob.size());
//            setDataFirstNews(ob.get(0));

        }

        @Override
        protected void onProgressUpdate(String... values) {
//            MyLog.Log("value: " + values[0]);
            if (values[0].equals(URL1)) {
                setDataFirstNews(datanews1.get(0));
                intitDataReyclerView(datanews1, URL1);
            } else if (values[0].equals(URL2)) {
                intitDataReyclerView(datanews2, URL2);

            } else if (values[0].equals(URL3)) {
                intitDataReyclerView(datanews3, URL3);
            } else if (values[0].equals(URL4)) {
                intitDataReyclerView(datanews4, URL4);
            }

        }
    }

    private void setDataFirstNews(News news) {
        title_newsfirst.setText(news.title);
        des_newsfirst.setText(news.description_short);
        ftv_source_firstnews.setText(news.source);
        ftv_categ_firstnews.setText(news.categ);
        if (!news.img.isEmpty()) {
            Picasso.with(MainActivity.this).load(news.img).fit().into(img_newsfirst);
        } else {
            img_newsfirst.setImageResource(R.mipmap.logo1);
        }

    }

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        showToastExit();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void showToastExit() {
        Toast toast = Toast.makeText(this, getResources().getString(R.string.double_tap_to_exits), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 150);
        toast.show();
    }


}
