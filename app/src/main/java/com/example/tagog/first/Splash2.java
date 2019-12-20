package com.example.tagog.first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash2 extends Activity {
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash2);

       // buclick();

        new android.os.Handler().postDelayed(new Runnable()


        {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */



            @Override
            public void run () {

                // This method will be executed once the timer is over
                // Start your app main activity

                Intent i = new Intent(Splash2.this,Splash_2.class);
                startActivity(i);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                // close this activity
                finish();


            }
        }

                ,SPLASH_TIME_OUT);



    }





    }

