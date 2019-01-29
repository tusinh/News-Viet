package vn.com.newsviet.listnews;//package vn.com.newsviet.listnews;
//
//
//import android.os.Bundle;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.ImageView;
//
//import java.util.ArrayList;
//
//import vn.com.newsviet.R;
//import vn.com.newsviet.Utils.MyLog;
//import vn.com.newsviet.adapter.TabRecyclerAdapter;
//import vn.com.newsviet.adapter.ViewPagerAdapter;
//import vn.com.newsviet.model.News;
//import vn.com.newsviet.view.FontTextView;
//
//
//public class ListNews24hActivity extends AppCompatActivity {
//    RecyclerView tabrecyclerview;
//    FontTextView titleheader;
//    ImageView imgback;
//    ViewPager viewpager;
//    TabRecyclerAdapter tabRecyclerAdapter;
//    ViewPagerAdapter viewPagerAdapter;
//    ArrayList<News> arrayListTab = new ArrayList();
//    String sourcenews = "";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_news);
//        Anhxa();
//        if (getIntent() != null && getIntent().hasExtra("sourcenews")) {
//            sourcenews = getIntent().getStringExtra("sourcenews");
//        }
//        setHeader();
//        inittab();
//
//        MyOnClick();
////        tab_layout.setTabsFromPagerAdapter(viewPagerAdapter);
//
//
//    }
//
//    private void MyOnClick() {
//        imgback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//    }
//
//    private void setHeader() {
//        titleheader.setText(sourcenews);
//        titleheader.setAllCaps(true);
//
//    }
//
//    private void initViewPager() {
//
//        viewpager.setAdapter(viewPagerAdapter);
////        tab_layout.setupWithViewPager(viewpager);
//        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
////                MyLog.Log("onPageScrolled :" + position);
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                MyLog.Log("onPageSelected :" + position);
//                tabrecyclerview.scrollToPosition(position);
//                tabRecyclerAdapter.setSelected(position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
////                MyLog.Log("onPageScrollStateChanged :" + state);
//            }
//        });
//    }
//
//    private void inittab() {
//
//        FragmentManager manager = getSupportFragmentManager();
//        viewPagerAdapter = new ViewPagerAdapter(manager);
//
//        tabrecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//
//        initDataTab();
//        viewPagerAdapter.setDataNews(arrayListTab);
//        tabRecyclerAdapter = new TabRecyclerAdapter(ListNews24hActivity.this, arrayListTab, new TabRecyclerAdapter.OnMainLayoutClickListener() {
//            @Override
//            public void OnMainLayoutCLick(int position) {
//                tabRecyclerAdapter.setSelected(position);
//                viewpager.setCurrentItem(position);
//            }
//        });
//        tabRecyclerAdapter.setSelected(0);
//        tabrecyclerview.setAdapter(tabRecyclerAdapter);
//        initViewPager();
//    }
//
//    private void initDataTab() {
//        arrayListTab.add(new News("Trang chủ", "https://www.24h.com.vn/upload/rss/trangchu24h.rss"));
//        arrayListTab.add(new News("Tin tức trong ngày", "https://www.24h.com.vn/upload/rss/tintuctrongngay.rss"));
//        arrayListTab.add(new News("Bóng đá", "https://www.24h.com.vn/upload/rss/bongda.rss"));
//        arrayListTab.add(new News("ASIAN CUP 2019", "https://www.24h.com.vn/upload/rss/asiancup2019.rss"));
//        arrayListTab.add(new News("An ninh - Hình sự", "https://www.24h.com.vn/upload/rss/anninhhinhsu.rss"));
//        arrayListTab.add(new News("Thời trang", "https://www.24h.com.vn/upload/rss/thoitrang.rss"));
//        arrayListTab.add(new News("Thời trang Hi-tech", "https://www.24h.com.vn/upload/rss/thoitranghitech.rss"));
//        arrayListTab.add(new News("Tài chính – Bất động sản", "https://www.24h.com.vn/upload/rss/taichinhbatdongsan.rss"));
//        arrayListTab.add(new News("Ẩm thực", "https://www.24h.com.vn/upload/rss/amthuc.rss"));
//        arrayListTab.add(new News("Làm đẹp", "https://www.24h.com.vn/upload/rss/lamdep.rss"));
////        arrayListTab.add(new News("Đời sống", "https://vnexpress.net/rss/gia-dinh.rss"));
////        arrayListTab.add(new News("Du lịch", "https://vnexpress.net/rss/du-lich.rss"));
////        arrayListTab.add(new News("Khoa học", "https://vnexpress.net/rss/khoa-hoc.rss"));
////        arrayListTab.add(new News("Số hóa", "https://vnexpress.net/rss/so-hoa.rss"));
////        arrayListTab.add(new News("Xe", "https://vnexpress.net/rss/oto-xe-may.rss"));
////        arrayListTab.add(new News("Cộng đồng", "https://vnexpress.net/rss/cong-dong.rss"));
////        arrayListTab.add(new News("Tâm sự", "https://vnexpress.net/rss/tam-su.rss"));
////        arrayListTab.add(new News("Cười", "https://vnexpress.net/rss/cuoi.rss"));
//    }
//
//    private void Anhxa() {
//        tabrecyclerview = findViewById(R.id.tabrecyclerview);
//        viewpager = findViewById(R.id.viewpager);
//        titleheader = findViewById(R.id.titleheader);
//        imgback = findViewById(R.id.imgback);
//
//    }
//
//
//}
