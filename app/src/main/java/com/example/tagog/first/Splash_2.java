package com.example.tagog.first;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Splash_2 extends AppCompatActivity {
    String Name;
    SharedPreferences settings2;
    CheckBox simpleCheckBox;
    TextView al2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                      //  .setAction("Action", null).show();
                finish();
                moveTaskToBack(true);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });


        simpleCheckBox = (CheckBox) findViewById(R.id.checkBox3);



        settings2 = getSharedPreferences("NAME2", 0);
        Boolean check2 = settings2.getBoolean("check2", false);
        if (check2) {
            Intent i = new Intent(Splash_2.this,MainActivity.class);
            startActivity(i);
            finish();
        }

        al2=(TextView)findViewById(R.id.textView28);


        Button wwtke =(Button)findViewById(R.id.button11);
        wwtke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!simpleCheckBox.isChecked())
                {
                    al2.setText("الرجاء الموافقه علي الشروط");
                    return;
                }else
                buclickd();
            }
        });

    }




    public void buclickd() {

        settings2 = getSharedPreferences("NAME2", 0);
        SharedPreferences.Editor editor2 = settings2.edit();
        editor2.putBoolean("check2", true);
     //   editor2.putString("name2", "altgani");
        editor2.apply();
        Intent i1 = new Intent(Splash_2.this,User_login.class);
        startActivity(i1);
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        finish();

    }
}
