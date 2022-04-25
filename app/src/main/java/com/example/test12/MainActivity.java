package com.example.test12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.web_view);
        Button button =(Button) findViewById(R.id.send_request);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //让webView支持JavaScript脚本
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        // 表示当前WebView可以处理打开新网页的请求，不用借助系统浏览器
                        return true;
                    }
                });
                webView.loadUrl("http://www.gdpu.edu.cn");
            }
        });
    }
}