package com.example.tagog.first;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class News_content extends AppCompatActivity {
    final Context context = this;
    TextView b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



       b = (TextView) findViewById(R.id.content);
        c = (TextView) findViewById(R.id.textView60);
        d = (TextView) findViewById(R.id.textView57);

     String ii = getIntent().getStringExtra("g1");
        String mm = getIntent().getStringExtra("g2");

        String date = getIntent().getStringExtra("g3");
        String adress = getIntent().getStringExtra("g4");

      //  Toast.makeText(News_content.this, "Position: " +mm, Toast.LENGTH_LONG).show();

        b.setText(ii);

        c.setText(date);
        d.setText(adress);


       // String strrrt2 = getIntent().getStringExtra("gimage");
        ImageView imageView = (ImageView)findViewById(R.id.imageView11);
        Glide.with(context)
                .load(mm)
                .centerCrop()

                .into(imageView);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}
