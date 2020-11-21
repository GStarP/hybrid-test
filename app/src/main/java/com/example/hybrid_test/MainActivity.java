package com.example.hybrid_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.main);
        // 允许 JS
        webView.getSettings().setJavaScriptEnabled(true);
        // 防止调用手机默认浏览器打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        String ip = "172.17.197.221";

        // 打开网页
        webView.loadUrl("http://" + ip + ":8085");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 返回键不会直接退出 WebView 而是绑定到网页的回退
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}