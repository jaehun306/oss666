package com.project.oss6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WeatherActivity extends AppCompatActivity {
    private WebView weatherView;
    private String weatherUrl = "https://m.kma.go.kr/m/index.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherView = (WebView)findViewById(R.id.weatherView);
        weatherView.getSettings().setJavaScriptEnabled(true);
        weatherView.loadUrl(weatherUrl);
        weatherView.setWebChromeClient(new WebChromeClient());
        weatherView.setWebViewClient(new WebViewClientClass());
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && weatherView.canGoBack()){
            weatherView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(weatherUrl);
            return true;
        }
    }
}
