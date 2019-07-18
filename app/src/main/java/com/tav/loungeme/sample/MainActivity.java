package com.tav.loungeme.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.tav.loungemesdk.LoungMeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView loungeMe = findViewById(R.id.iv_loungeme);
        loungeMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoungMeActivity.newIntent(MainActivity.this);
            }
        });

    }
}
