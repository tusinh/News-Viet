package vn.com.newsviet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import vn.com.newsviet.Utils.MyLog;
import vn.com.newsviet.Utils.ShowPopup;
import vn.com.newsviet.Utils.Utils;

/*create by tusinh on 1/2019*/
public class DetailNewsActivity extends AppCompatActivity {
    WebView webView;
    LinearLayout layout_loading;
    //    FloatingActionButton fab;
    ImageView imgback, imgshare;
    String link = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        Anhxa();
        if (getIntent() != null && getIntent().hasExtra("link")) {
            link = getIntent().getStringExtra("link");
            if (!Utils.isNetworkConnected(DetailNewsActivity.this)) {
                new ShowPopup(DetailNewsActivity.this).info(getString(R.string.no_internet), getString(R.string.title_notify)).show();
            } else {
                webView.loadUrl(link);
            }
        }
        webView.getSettings().setAppCacheEnabled(true); //
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                MyLog.Log("shouldOverrideUrlLoading: " + url);
                return super.shouldOverrideUrlLoading(view, url);

            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
                MyLog.Log("onPageStarted");
                MyShowLoadingLayout();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
                MyLog.Log("onPageFinished");
                MyShowWebview();
            }
        });
        final WebSettings settings = webView.getSettings();
        settings.setSupportZoom(true);
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
//        settings.setDisplayZoomControls(true);
//        settings.setBuiltInZoomControls(true);

        MyOnClick();
    }

    private void MyOnClick() {
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        imgshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntentFacebook = new Intent();
                mIntentFacebook.setAction(Intent.ACTION_SEND);
                mIntentFacebook.setType("text/plain");
                mIntentFacebook.putExtra(Intent.EXTRA_TEXT, link);
                startActivity(mIntentFacebook);
            }
        });
    }

    private void MyShowLoadingLayout() {
        layout_loading.setVisibility(View.VISIBLE);
        webView.setVisibility(View.GONE);
    }

    private void MyShowWebview() {
        layout_loading.setVisibility(View.GONE);
        webView.setVisibility(View.VISIBLE);
    }

    private void Anhxa() {
        webView = findViewById(R.id.webview);
        imgback = findViewById(R.id.imgback);
        imgshare = findViewById(R.id.imgshare);
        layout_loading = findViewById(R.id.layout_loading);
    }
}
