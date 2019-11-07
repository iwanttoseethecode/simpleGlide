package com.example.simpleglide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.simpleglide.glide.Glide;
import com.example.simpleglide.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView1 = findViewById(R.id.iv1);
        ImageView imageView2 = findViewById(R.id.iv2);
        ImageView imageView3 = findViewById(R.id.iv3);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.error(R.drawable.ic_launcher_background).placeholder(R.mipmap.ic_launcher).override(500,500);

        Glide.with(this).load("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2669567003,3609261574&fm=27&gp=0.jpg22222222asads").apply(requestOptions).into(imageView1);

    }

}
