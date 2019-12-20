package com.example.tagog.first;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

////altgani motsim altgani yosif naser

public class Bey extends AppCompatActivity {
    private EditText name, phone, kh_no,tips;
    private ProgressDialog mProgressDialog;
    SharedPreferences settings = null;
    private String mUsername;
    private String mUsername2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bey);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        settings = getSharedPreferences("BISC", 0);

        mUsername=settings.getString("phone", "44");
        mUsername2=settings.getString("name", "44");






        Button wwww2 =(Button)findViewById(R.id.button8);
        wwww2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                info2();
            }
        });

        name = (EditText) findViewById(R.id.editText5);
        phone = (EditText) findViewById(R.id.editText6);
        kh_no = (EditText) findViewById(R.id.editText7);
        tips = (EditText) findViewById(R.id.editText8);


        String phone2 = name.getText().toString();
        String name23 = phone.getText().toString();


        name.setText(name23);


        phone.setText(phone2);


        name.setVisibility(View.GONE);
        phone.setVisibility(View.GONE);
       // Toast.makeText(this, mUsername+mUsername2, Toast.LENGTH_SHORT).show();


        if (mUsername=="44" || mUsername2=="44") {


            name.setVisibility(View.VISIBLE);
            phone.setVisibility(View.VISIBLE);

        }else {

          name.setText(mUsername2);
            phone.setText(mUsername);


        }


//        if (phone3.equals("phone") && name3.equals("name"))
//        {
//
//          name.setVisibility(View.VISIBLE);
//            phone.setVisibility(View.VISIBLE);
//        }

//        TextView e1 = (TextView) findViewById(R.id.button);
//        TextView f = (TextView) findViewById(R.id.button5);
//
//        e1.setText("المستخدم :"+name);
//        f.setText("الهاتف :"+phone);

    }



    public void signup(View v) {

        String phone2 = name.getText().toString();
        String name4 = phone.getText().toString();


        String name1 = phone2;
        String phone1 = name4;

        // String passWord = etPassword.toString();

        String kh_no1 = kh_no.getText().toString();
        String tips1 = tips.getText().toString();
        String kh_no12 = kh_no.getText().toString();



        String a = getIntent().getStringExtra("ga");
        String b = getIntent().getStringExtra("gb");
        String c = getIntent().getStringExtra("gc");


        String d = getIntent().getStringExtra("gd");

        String e = getIntent().getStringExtra("ge");


        String f = getIntent().getStringExtra("gf");

        String g = getIntent().getStringExtra("gg");
        String h = getIntent().getStringExtra("gh");
        String i = getIntent().getStringExtra("gi");




       // Toast.makeText(Bey.this, "Position: " + ah+"gggg"+ah2, Toast.LENGTH_SHORT).show();
int aa=1;

        if (TextUtils.isEmpty(kh_no12))
        {
            kh_no.setError(getString(R.string.error_empty_field));
            aa=0;
            return;
        }
       else if (!TextUtils.isEmpty(kh_no12)) {

           int ah=Integer.parseInt(f);

           int ah2=Integer.parseInt(kh_no1);

           if (ah2 > ah) {
                kh_no.setError("عذرا الناقلة لا تسع هذا العدد");
               aa=0;
                return;
            }

           else if (TextUtils.isEmpty(tips1))
           {
               tips.setError(getString(R.string.error_empty_field));
               aa=0;
               return;
           }else if (TextUtils.isEmpty(phone2))
           {
               name.setError(getString(R.string.error_empty_field));
               aa=0;
               return;
           }else if (TextUtils.isEmpty(name4))
           {
               phone.setError(getString(R.string.error_empty_field));
               aa=0;
               return;
           }

           else

//
//           MainActivity.phone_temp=phone1;
//            MainActivity.name_temp=name1;
//
//

 new Bey.SignupActivityda(this).execute(name1, phone1, kh_no1, tips1, a, b, c, d, e, f, g, h, i);


        }




    }



    public class SignupActivityda extends AsyncTask<String, Void, String> {


        private Context context;


        public SignupActivityda(Context context) {
            this.context = context;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(Bey.this,
                    "جاري ...","ارسال البيانات", false, false);
        }

        @Override
        protected String doInBackground(String... arg0) {
            String name = arg0[0];
            String phone = arg0[1];

            String kh_no = arg0[2];
            String tips = arg0[3];
            String s1= arg0[4];
            String s2 = arg0[5];
            String s3 = arg0[6];
            String s4 = arg0[7];

            String s5 = arg0[8];
            String s6 = arg0[9];
            String s7= arg0[10];
            String s8 = arg0[11];
            String s9 = arg0[12];

            String link;
            String data;
            BufferedReader bufferedReader;
            String result;

            try {
                data = "?a=" + URLEncoder.encode(name, "UTF-8");
                data += "&b=" + URLEncoder.encode(phone, "UTF-8");
                data += "&c=" + URLEncoder.encode(kh_no, "UTF-8");
                data += "&d=" + URLEncoder.encode(tips, "UTF-8");
                data += "&e=" + URLEncoder.encode(s1, "UTF-8");
                data += "&f=" + URLEncoder.encode(s2, "UTF-8");
                data += "&g=" + URLEncoder.encode(s3, "UTF-8");
                data += "&h=" + URLEncoder.encode(s4, "UTF-8");
                data += "&i=" + URLEncoder.encode(s5, "UTF-8");
                data += "&j=" + URLEncoder.encode(s6, "UTF-8");
                data += "&k=" + URLEncoder.encode(s7, "UTF-8");
                data += "&l=" + URLEncoder.encode(s8, "UTF-8");
                data += "&m=" + URLEncoder.encode(s9, "UTF-8");




                link = "http://sultantec.com/files/adv_ok.php" + data;

                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            String jsonStr = result;
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    String query_result = jsonObj.getString("query_result");
                    if (query_result.equals("SUCCESS")) {

                        buclickd();





                    } else if (query_result.equals("FAILURE")) {
                        buclickdd();
                    } else {
                        buclickdd();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    buclickdd();
                }
            } else {


                buclickdd();
            }

        }

    }





    public void buclickd() {
        mProgressDialog.dismiss();
//        name.setText(null);
//        phone.setText(null);
        if (mUsername=="44" || mUsername2=="44") {

            settings = getSharedPreferences("BISC", 0);

            SharedPreferences.Editor editor2 = settings.edit();

            mUsername2=name.getText().toString();

            mUsername=phone.getText().toString();

            //   editor2.putBoolean("check23", true);

            editor2.putString("phone", mUsername);
            editor2.putString("name", mUsername2);




            editor2.apply();
            editor2.commit();;

        }

        kh_no.setText(null);
        tips.setText(null);



        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.wwe2)
                .setTitle("تم ارسال البيانات بنجاح")
                .setCancelable(false)
                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mProgressDialog.dismiss();
                        //onBackPressed();

                        Intent al = new Intent(Bey.this, MainActivity.class);

                        startActivity(al);
                        finish();
                        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

                    }
                }).setNegativeButton("خروج", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                mProgressDialog.dismiss();
                Intent al = new Intent(Bey.this, MainActivity.class);

                startActivity(al);
                finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }

        }).show();
    }

    public void buclickdd() {

        mProgressDialog.dismiss();
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setMessage("هل تريد اعادة المحاولة ؟")
                .setIcon(R.drawable.error)
                .setTitle("فشل الاتصال تاكد من خدمة البيانات")
                .setPositiveButton("اعادة محاولة", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mProgressDialog.dismiss();


                        String phone2 = name.getText().toString();
                        String name = phone.getText().toString();

                        String name1 = name;
                        String phone1 = phone2;

                        String kh_no1 = kh_no.getText().toString();
                        String tips1 = tips.getText().toString();

                        String a = getIntent().getStringExtra("ga");
                        String b = getIntent().getStringExtra("gb");
                        String c = getIntent().getStringExtra("gc");





                        String d = getIntent().getStringExtra("gd");
                        String e = getIntent().getStringExtra("ge");
                        String f = getIntent().getStringExtra("gf");

                        String g = getIntent().getStringExtra("gg");
                        String h = getIntent().getStringExtra("gh");
                        String i = getIntent().getStringExtra("gi");




                        if (TextUtils.isEmpty(kh_no1))
                        {
                            kh_no.setError(getString(R.string.error_empty_field));
                            return;
                        }


                        else if (TextUtils.isEmpty(tips1))
                        {
                            tips.setError(getString(R.string.error_empty_field));
                            return;
                        }



                        else



                            new Bey.SignupActivityda(getApplicationContext()).execute(name1, phone1,kh_no1,tips1,a,b,c,d,e,f,g,h,i);



                    }
                }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                mProgressDialog.dismiss();
                name.setText(null);
                phone.setText(null);

                kh_no.setText(null);
                tips.setText(null);

            }

        }).show();

    }

    public void info2() {

        final Dialog dialog = new Dialog(Bey.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_adv);
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


    @Override
    public void onBackPressed() {
        super.onBackPressed();



        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}
