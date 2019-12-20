package com.example.tagog.first;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class User_login extends AppCompatActivity {
    String Name;
    SharedPreferences settings2;
    EditText etPhone;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        settings2 = getSharedPreferences("NAME3", 0);

        Boolean check23 = settings2.getBoolean("check23", true);
        if (check23) {
            Intent i = new Intent(User_login.this,MainActivity.class);
            startActivity(i);
            finish();
        }

        buclickd();

        name=(EditText) findViewById(R.id.editText11);
        etPhone=(EditText) findViewById(R.id.editText9);

        Button wwtke =(Button)findViewById(R.id.button12);
        wwtke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = etPhone.getText().toString();

                String name22 = name.getText().toString();
               if (TextUtils.isEmpty(phoneNumber))
                {
                    etPhone.setError(getString(R.string.error_empty_field));
                    return;
                }else if (TextUtils.isEmpty(name22))
               {
                   name.setError(getString(R.string.error_empty_field));
                   return;
               }else
                buclickd();
            }
        });



    }





    public void buclickd() {

        settings2 = getSharedPreferences("NAME3", 0);
        SharedPreferences.Editor editor2 = settings2.edit();

        String phoneNumber ="altgani";
        String name3 = "phone";

        editor2.putBoolean("check23", true);




        editor2.putString("phone", phoneNumber);
        editor2.putString("name", name3);

        editor2.apply();
        editor2.commit();

        Intent i1 = new Intent(User_login.this,MainActivity.class);
        startActivity(i1);
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        finish();

    }

    public void infor() {

        final Dialog dialog = new Dialog(User_login.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_singup2);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();


    }


}
