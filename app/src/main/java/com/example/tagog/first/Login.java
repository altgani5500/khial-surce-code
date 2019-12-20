package com.example.tagog.first;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class Login extends AppCompatActivity {

    private EditText mUsernameET;
    private EditText mPasswordET;

    private Button mSigninBtn;
    private Button mRegisterBtn;

    private JSONParse jsonParse = new JSONParse();

    private String LOGIN_URL =
            "http://sultantec.com/files/login.php";
    private String REGISTER_URL =
            "http://sultantec.com/files/login.php";

    SharedPreferences settingslogin;
    CheckBox simpleCheckBox;
   static Boolean check23;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
      //  buclick();

        settingslogin = getSharedPreferences("NAMELOGIN", 0);

        check23 = settingslogin.getBoolean("checklogin", false);

        String bb0 = getIntent().getStringExtra("logout");

if(bb0!=null && bb0.equals("logout"))
{

  // buclickdlogout();

    ///settingslogin = getSharedPreferences("NAMELOGIN", 0);
    SharedPreferences.Editor editor2 = settingslogin.edit();


    editor2.putBoolean("checklogin", false);


    editor2.apply();

}







        if (check23) {
            Intent i = new Intent(Login.this,Driver.class);
            startActivity(i);
            finish();
        }



        simpleCheckBox = (CheckBox) findViewById(R.id.checkBox2);

        mUsernameET = (EditText) findViewById(R.id.editText5);
        mUsernameET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent)
            {
                if (i == EditorInfo.IME_ACTION_NEXT || i == EditorInfo.IME_ACTION_DONE)
                {
                    mPasswordET.requestFocus();
                }
                return false;
            }
        });

        mPasswordET = (EditText) findViewById(R.id.editText6);
        mPasswordET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_NEXT || i == EditorInfo.IME_ACTION_DONE) {
                    attempLogin(0);
                }
                return false;
            }
        });

        mSigninBtn = (Button) findViewById(R.id.button6);
        mSigninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                attempLogin(0);
            }
        });



        TextView wwww =(TextView)findViewById(R.id.textView3);
        wwww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Intent mIntent = new Intent(Login.this, Singup.class);
                startActivity(mIntent);
               // finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });

        TextView wwww22 =(TextView)findViewById(R.id.textView2);
        wwww22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
             /*   Intent mIntent = new Intent(Login.this, Driver.class);
                startActivity(mIntent);
              finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);*/
                try {


                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + "0507772800"));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }
            }
        });

       Button wwww2 =(Button)findViewById(R.id.button88);
        wwww2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                info2();
            }
        });
    }

    private void attempLogin(int btn)
    {
        String Username = mUsernameET.getText().toString();
        String Password = mPasswordET.getText().toString();

        if (TextUtils.isEmpty(Username))
        {
            mUsernameET.setError(getString(R.string.error_empty_field));
            return;
        }
        else if (TextUtils.isEmpty(Password))
        {
            mPasswordET.setError(getString(R.string.error_empty_field));
            return;
        }

        if (btn == 0)
            new LoginUserTask(Username, Password).execute();
        else
            new RegisterUserTask(Username, Password).execute();
    }

    private class LoginUserTask extends AsyncTask<Void, Void, Boolean>
    {
        private ProgressDialog mProgressDialog;

        private JSONObject jsonObjectResult = null;

        private String Username;
        private String Password;

        private String error;

        private LoginUserTask(String username, String password)
        {
            Username = username;
            Password = password;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(Login.this,
                    "جاري ...", "التحقق من اسم المستخدم وكلمة المرور", false, false);
        }

        @Override
        protected Boolean doInBackground(Void... params)
        {
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            pairs.add(new BasicNameValuePair("username", Username));
            pairs.add(new BasicNameValuePair("password", Password));

            jsonObjectResult = jsonParse.makeHttpRequest(LOGIN_URL, pairs);
            if (jsonObjectResult == null)
            {
                error = "لايوجد اتصال بالانترنت";
                return false;
            }

            try
            {
                if (jsonObjectResult.getInt("success") == 1)
                    return true;
                else
                    error = jsonObjectResult.getString("message");

            }
            catch (Exception ex)
            {

            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean)
        {
            super.onPostExecute(aBoolean);
            mProgressDialog.dismiss();

            if(aBoolean && simpleCheckBox.isChecked() )
            {
                buclickdl();
            }else
            if (aBoolean)
            {
                buclickdl2();

            }
            else
               // Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
            if(error.equals("noactive")){
                info2a();
            }
            else if(error.equals("admin")) {
                Intent al = new Intent(Login.this, Admin2.class);

                startActivity(al);
                finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);


            }  else if(error.equals("news")) {
                Intent al = new Intent(Login.this,Add_news.class);

                startActivity(al);
                finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);


            }

            else if(error !="noactive" && error !="admin") {
                Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
                 //info2a();
            }


        }
    }

    private class RegisterUserTask extends AsyncTask<Void, Void, Boolean>
    {
        private ProgressDialog mProgressDialog;

        private JSONObject jsonObjectResult = null;

        private String Username;
        private String Password;

        private String error;

        private RegisterUserTask(String username, String password)
        {
            Username = username;
            Password = password;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(Login.this,
                    "Processing...", "Creating new user", false, false);
        }

        @Override
        protected Boolean doInBackground(Void... params)
        {
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            pairs.add(new BasicNameValuePair("username", Username));
            pairs.add(new BasicNameValuePair("password", Password));

            jsonObjectResult = jsonParse.makeHttpRequest(REGISTER_URL, pairs);
            if (jsonObjectResult == null)
            {
                error = "Error int the connection";
                return false;
            }

            try
            {
                if (jsonObjectResult.getInt("success") == 1)
                    return true;
                else
                    error = jsonObjectResult.getString("message");

            }
            catch (Exception ex)
            {

            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean)
        {
            super.onPostExecute(aBoolean);
            mProgressDialog.dismiss();
            if (aBoolean)
            {
                Intent mIntent = new Intent(Login.this, Driver.class);

                String Username1 = mUsernameET.getText().toString();
                String Password2 = mPasswordET.getText().toString();

                mIntent.putExtra("go1", Username1);
                mIntent.putExtra("go2", Password2);
                startActivity(mIntent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
            else
            //game here :-)
            if(error=="noactive"){
info2a();
            }
            else if(error=="admin") {
                Intent al = new Intent(Login.this, Admin2.class);

                startActivity(al);
                finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);


            }

            else if(error!="noactive" && error!="admin") {
                Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
               // info2a();
            }
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }



    public void info2() {

        final Dialog dialog = new Dialog(Login.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_singup3);
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


    public void info2a() {

        final Dialog dialog = new Dialog(Login.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_abouac);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.me);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();


    }

    public void buclickdl2() {

        settingslogin = getSharedPreferences("NAMELOGIN", 0);
        SharedPreferences.Editor editor2 = settingslogin.edit();



        String phoneNumber = mUsernameET.getText().toString();
        String name3 = mPasswordET.getText().toString();

        editor2.putBoolean("checklogin", false);

        editor2.putString("go1", phoneNumber);
        editor2.putString("go2", name3);

        editor2.apply();

        Intent i1 = new Intent(Login.this,Driver.class);
        startActivity(i1);
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        finish();


    }

    public void buclickdl() {

        settingslogin = getSharedPreferences("NAMELOGIN", 0);
        SharedPreferences.Editor editor2 = settingslogin.edit();



        String phoneNumber = mUsernameET.getText().toString();
        String name3 = mPasswordET.getText().toString();

        editor2.putBoolean("checklogin", true);

        editor2.putString("go1", phoneNumber);
        editor2.putString("go2", name3);

        editor2.apply();
        Intent i1 = new Intent(Login.this,Driver.class);
        startActivity(i1);
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        finish();

    }




    public void buclickdlogout() {

        settingslogin = getSharedPreferences("NAMELOGIN", 0);
        SharedPreferences.Editor editor2 = settingslogin.edit();



        String phoneNumber = mUsernameET.getText().toString();
        String name3 = mPasswordET.getText().toString();

        editor2.putBoolean("checklogin", false);

        editor2.putString("go1", phoneNumber);
        editor2.putString("go2", name3);

        editor2.apply();


    }
}




