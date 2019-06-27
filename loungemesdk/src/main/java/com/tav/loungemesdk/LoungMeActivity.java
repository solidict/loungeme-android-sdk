package com.tav.loungemesdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class LoungMeActivity extends AppCompatActivity {
    WebView wv;
    ImageView ivForward;
    ImageView ivBack;
    ImageView ivRefresh;
    public static void newIntent(Context context){

        Intent intent =new Intent(context,LoungMeActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loung_me);
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }


        wv = findViewById(R.id.wv_lounge_me);

        ivForward = findViewById(R.id.iv_forward);

        ivBack = findViewById(R.id.iv_back);

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




        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://slowfoodtime.com/tr/secure-home");

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


        });


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
