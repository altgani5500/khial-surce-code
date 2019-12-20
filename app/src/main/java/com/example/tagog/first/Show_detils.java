package com.example.tagog.first;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class Show_detils extends AppCompatActivity {
    //AQuery aq;

    // LinearLayout ww;
    JSONArray peoples = null;
    TextView a1,b,c1,d,e1,f,g1,all,hh,ii,jj;
    final Context context = this;
    LinearLayout list2;
    JSONObject c;
    AppBarLayout dd;
    Button etUserName2;
    FloatingActionButton fab;
    private ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_detils);


      Button  etUserName23 = (Button) findViewById(R.id.button7);
        etUserName23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

                String dd = getIntent().getStringExtra("g4");
                String ee = getIntent().getStringExtra("g5");
                String ff = getIntent().getStringExtra("g6");


                String gg = getIntent().getStringExtra("g7");
                String hh = getIntent().getStringExtra("g8");
                String ii = getIntent().getStringExtra("g9");


                String aa = getIntent().getStringExtra("g1");
                String bb = getIntent().getStringExtra("g2");
                String cc = getIntent().getStringExtra("g3");

                String phone = getIntent().getStringExtra("phone");
                String name = getIntent().getStringExtra("name");

                Intent alvvwefrerxx = new Intent(Show_detils.this, User_re.class);

                alvvwefrerxx.putExtra("ga", aa); alvvwefrerxx.putExtra("gb", bb); alvvwefrerxx.putExtra("gc", cc);

                alvvwefrerxx.putExtra("gd", dd); alvvwefrerxx.putExtra("ge", ee); alvvwefrerxx.putExtra("gf", ff);
                alvvwefrerxx.putExtra("gg", gg); alvvwefrerxx.putExtra("gh", hh); alvvwefrerxx.putExtra("gi", ii);

                alvvwefrerxx.putExtra("phone", phone);
                alvvwefrerxx.putExtra("name", name);

                startActivity(alvvwefrerxx);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                finish();

            }
        });


        a1 = (TextView ) findViewById(R.id.button);
        b = (TextView ) findViewById(R.id.textView7);
        c1 = (TextView ) findViewById(R.id.textView9);
        d = (TextView ) findViewById(R.id.textView11);
        e1 = (TextView ) findViewById(R.id.textView13);
        f = (TextView ) findViewById(R.id.textView6);


        String dd = getIntent().getStringExtra("g4");
        String ee = getIntent().getStringExtra("g5");
        String ff = getIntent().getStringExtra("g6");


        String gg = getIntent().getStringExtra("g7");
        String hh = getIntent().getStringExtra("g8");
        String ii = getIntent().getStringExtra("g9");

        String strrrt2 = getIntent().getStringExtra("gimage");

        ImageView imageView = (ImageView)findViewById(R.id.imageView11);
        Glide.with(context)
                .load(strrrt2)
                .centerCrop()
                .into(imageView);




        a1.setText(dd);
        b.setText(ee);
        c1.setText(gg);
        d.setText(hh);
        e1.setText(ff);
        f.setText(ii);



        String aa = getIntent().getStringExtra("g1");
        String bb = getIntent().getStringExtra("g2");
        String cc = getIntent().getStringExtra("g3");



        //String jj = getIntent().getStringExtra("g10");
       // String kk = getIntent().getStringExtra("g11");

       // Toast.makeText(Show_detils.this, "Position: " + aa+bb+cc+jj+kk, Toast.LENGTH_LONG).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //   .setAction("Action", null).show();
                onBackPressed();
            }
        });





    }




















    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}
