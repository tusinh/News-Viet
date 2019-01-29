package vn.com.newsviet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import vn.com.newsviet.Utils.SourceData;
import vn.com.newsviet.adapter.ListSourceNewsAdapter;
import vn.com.newsviet.model.News;
import vn.com.newsviet.model.SourceNews;
import vn.com.newsviet.view.FontTextView;

/*create by tusinh on 1/2019*/
public class ListSourceNewsActivity extends AppCompatActivity {
    ImageView imgback, img1;
    FontTextView titleheader;
    LinearLayout layout_header;
    RecyclerView recyclerview_listsourcenews;
    ArrayList<SourceNews> arrayListSourceNews = new ArrayList();
    ListSourceNewsAdapter listSourceNewsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_source_news);
        Anhxa();
        titleheader.setText("Trang báo");

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightscreen = displayMetrics.heightPixels;
        int widthscreen = displayMetrics.widthPixels;

        layout_header.measure(0, 0);
        int height_header = layout_header.getMeasuredHeight();


        recyclerview_listsourcenews.setLayoutManager(new GridLayoutManager(ListSourceNewsActivity.this, 2));
        initDataSourceNews();
        listSourceNewsAdapter = new ListSourceNewsAdapter(ListSourceNewsActivity.this, arrayListSourceNews);
        listSourceNewsAdapter.setHeight((heightscreen - height_header));
        recyclerview_listsourcenews.setAdapter(listSourceNewsAdapter);
        MyOnClick();
    }

    private void initDataSourceNews() {
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo24h, "24h", SourceData.getDataTab24h()));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_express, "Express", SourceData.getDataTabExpress()));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_dantri, "Dân trí", SourceData.getDataTabDantri()));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_thanhnien, "Thanh niên", SourceData.getDataTabThanhnien()));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_tuoitre, "Tuổi trẻ", SourceData.getDataTabTuoitre()));
//        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_vietnamnet, "Việt nam net", null));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_nld, "Người lao động", SourceData.getDataTabNLD()));
//        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_kenh14, "Kênh 14", null));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_dspl, "Đời sống pháp luật", SourceData.getDataTabDSPL()));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_nguoiduatin, "Người đưa tin", SourceData.getDataTabNDT()));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_ngoisao, "Ngôi sao", SourceData.getDataTabNgoisao()));
//        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_genk, "Genk", null));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_soha, "Soha", SourceData.getDataTabSoha()));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_vtcnews, "VTCNews", SourceData.getDataTabVTCNew()));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_vov, "VOV", SourceData.getDataTabVOV()));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_thethao247, "Thể thao 247", SourceData.getDataTabTT247()));
        arrayListSourceNews.add(new SourceNews(R.mipmap.logo_itcnews, "ITCNews", SourceData.getDataTabITCNews()));


    }


    private void MyOnClick() {
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Anhxa() {
        layout_header = findViewById(R.id.layout_header);
        imgback = findViewById(R.id.imgback);
        img1 = findViewById(R.id.img1);
        titleheader = findViewById(R.id.titleheader);
        recyclerview_listsourcenews = findViewById(R.id.recyclerview_listsourcenews);
    }
}
