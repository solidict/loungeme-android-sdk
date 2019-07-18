package com.tav.loungemesdk;

import android.content.Context;
import android.content.Intent;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import java.util.Locale;

public class LoungMeActivity extends AppCompatActivity {
    WebView wv;
    ImageView ivForward;
    ImageView ivBack;
    ImageView ivRefresh;
    ImageView ivClose;
    public static void newIntent(Context context){

        Intent intent =new Intent(context,LoungMeActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loung_me);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorLoungeMeDark, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorLoungeMeDark));
        }

        wv = findViewById(R.id.wv_lounge_me);

        ivForward = findViewById(R.id.iv_forward);

        ivBack = findViewById(R.id.iv_back);
        ivClose = findViewById(R.id.iv_close);

        ivRefresh = findViewById(R.id.iv_refresh);
        ivForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forward();
            }
        });
        ivRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        ivBack.setImageAlpha(122);
        ivForward.setImageAlpha(122);


        wv.getSettings().setJavaScriptEnabled(true);
        String lang="tr";

        if (!Locale.getDefault().getDisplayLanguage().equalsIgnoreCase("tr")) {
            lang="en";
        }

        wv.loadUrl("https://lounge.me/"+lang+"/secure-home");

        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }
                return false;


            }

            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(url);

                }
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                checkBackAndForwardButton(wv.canGoBack(),wv.canGoForward());

            }
        });


    }

    public void checkBackAndForwardButton(boolean back, boolean forward){


        if (back) {
            ivBack.setImageAlpha(255);
        }
        else{
            ivBack.setImageAlpha(122);

        }

        if (forward) {
            ivForward.setImageAlpha(255);
        }
        else{
            ivForward.setImageAlpha(122);
        }
    }

    public void back() {
        wv.goBack();
    }

    public void forward() {
        wv.goForward();
    }

    public void refresh() {
        wv.reload();
    }
}
