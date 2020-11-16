       package com.example.hybrid_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

       public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView main = findViewById(R.id.main);
        // 允许 JS
        main.getSettings().setJavaScriptEnabled(true);
        // 防止调用手机默认浏览器打开
        main.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        String ip = "172.17.197.221";

        // 打开网页
        main.loadUrl("http://" + ip + ":8085");
    }
}