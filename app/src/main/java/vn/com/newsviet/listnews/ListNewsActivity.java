package vn.com.newsviet.listnews;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;

import vn.com.newsviet.R;
import vn.com.newsviet.Utils.MyLog;
import vn.com.newsviet.Utils.RoundedCornersTransform;
import vn.com.newsviet.adapter.TabRecyclerAdapter;
import vn.com.newsviet.adapter.ViewPagerAdapter;
import vn.com.newsviet.model.News;
import vn.com.newsviet.model.SourceNews;
import vn.com.newsviet.view.FontTextView;

/*create by tusinh on 1/2019*/
public class ListNewsActivity extends AppCompatActivity {
    RecyclerView tabrecyclerview;
    LinearLayout layout_header;
    ImageView imgback, imglogo;
    FontTextView titleheader;
    ViewPager viewpager;
    TabRecyclerAdapter tabRecyclerAdapter;
    ViewPagerAdapter viewPagerAdapter;
    ArrayList<News> arrayListTab = new ArrayList();
    String sourcenews = "";
    SourceNews newsob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        Anhxa();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("sourcenews")) {
                sourcenews = getIntent().getStringExtra("sourcenews");
            }
            if (intent.hasExtra("datanews")) {
                arrayListTab = (ArrayList<News>) intent.getSerializableExtra("datanews");
            }
            if (intent.hasExtra("newsob")) {
                newsob = (SourceNews) intent.getSerializableExtra("newsob");
                arrayListTab = newsob.arrayListNews;
                sourcenews = newsob.title;
                if (newsob.resource != -1) {
//                    imglogo.setImageResource(newsob.resource);
                    imglogo.setBackgroundResource(newsob.resource);

//                    Transformation transformation = new RoundedCornersTransform();
//                    Picasso.with(ListNewsActivity.this).load(newsob.resource).fit().transform(transformation).into(imglogo);
                    imglogo.setVisibility(View.VISIBLE);
                }
            }

        }

        setHeader();
        inittab();
        MyOnClick();

//        tab_layout.setTabsFromPagerAdapter(viewPagerAdapter);


    }

    private void MyOnClick() {
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setHeader() {
        titleheader.setText(sourcenews);
        titleheader.setAllCaps(true);
//        layout_header.setBackgroundResource(R.color.white);
//        imgback.setColorFilter(ContextCompat.getColor(this,
//                R.color.xam));
//        titleheader.setTextColor(getResources().getColor(R.color.xam));

    }

    private void initViewPager() {

        viewpager.setAdapter(viewPagerAdapter);
//        tab_layout.setupWithViewPager(viewpager);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                MyLog.Log("onPageScrolled :" + position);
            }

            @Override
            public void onPageSelected(int position) {
                MyLog.Log("onPageSelected :" + position);
                tabrecyclerview.scrollToPosition(position);
                tabRecyclerAdapter.setSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                MyLog.Log("onPageScrollStateChanged :" + state);
            }
        });
    }

    private void inittab() {

        FragmentManager manager = getSupportFragmentManager();
        viewPagerAdapter = new ViewPagerAdapter(manager);

        tabrecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

//        initDataTab();

        viewPagerAdapter.setDataNews(arrayListTab);
        tabRecyclerAdapter = new TabRecyclerAdapter(ListNewsActivity.this, arrayListTab, new TabRecyclerAdapter.OnMainLayoutClickListener() {
            @Override
            public void OnMainLayoutCLick(int position) {
                tabRecyclerAdapter.setSelected(position);
                viewpager.setCurrentItem(position);
            }
        });
        tabRecyclerAdapter.setSelected(0);
        tabrecyclerview.setAdapter(tabRecyclerAdapter);
        initViewPager();
    }

//    private void initDataTab() {
//        arrayListTab.add(new News("Trang chủ", "https://vnexpress.net/rss/tin-moi-nhat.rss"));
//        arrayListTab.add(new News("Thời sự", "https://vnexpress.net/rss/thoi-su.rss"));
//        arrayListTab.add(new News("Thế giới", "https://vnexpress.net/rss/the-gioi.rss"));
//        arrayListTab.add(new News("Kinh doanh", "https://vnexpress.net/rss/kinh-doanh.rss"));
//        arrayListTab.add(new News("Startup", "https://vnexpress.net/rss/startup.rss"));
//        arrayListTab.add(new News("Giải trí", "https://vnexpress.net/rss/giai-tri.rss"));
//        arrayListTab.add(new News("Thể thao", "https://vnexpress.net/rss/the-thao.rss"));
//        arrayListTab.add(new News("Pháp luật", "https://vnexpress.net/rss/phap-luat.rss"));
//        arrayListTab.add(new News("Giáo dục", "https://vnexpress.net/rss/giao-duc.rss"));
//        arrayListTab.add(new News("Sức khỏe", "https://vnexpress.net/rss/suc-khoe.rss"));
//        arrayListTab.add(new News("Đời sống", "https://vnexpress.net/rss/gia-dinh.rss"));
//        arrayListTab.add(new News("Du lịch", "https://vnexpress.net/rss/du-lich.rss"));
//        arrayListTab.add(new News("Khoa học", "https://vnexpress.net/rss/khoa-hoc.rss"));
//        arrayListTab.add(new News("Số hóa", "https://vnexpress.net/rss/so-hoa.rss"));
//        arrayListTab.add(new News("Xe", "https://vnexpress.net/rss/oto-xe-may.rss"));
//        arrayListTab.add(new News("Cộng đồng", "https://vnexpress.net/rss/cong-dong.rss"));
//        arrayListTab.add(new News("Tâm sự", "https://vnexpress.net/rss/tam-su.rss"));
//        arrayListTab.add(new News("Cười", "https://vnexpress.net/rss/cuoi.rss"));
//    }

    private void Anhxa() {
        tabrecyclerview = findViewById(R.id.tabrecyclerview);
        viewpager = findViewById(R.id.viewpager);
        titleheader = findViewById(R.id.titleheader);
        imgback = findViewById(R.id.imgback);
        imglogo = findViewById(R.id.imglogo);
        layout_header = findViewById(R.id.layout_header);

    }


}
