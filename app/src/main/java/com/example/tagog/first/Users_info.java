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

import com.androidquery.AQuery;
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

public class Users_info extends AppCompatActivity {
    //AQuery aq;

    // LinearLayout ww;
    JSONArray peoples = null;
    TextView a1,b,c1,d,e1,f,g1,all,hh,ii,jj;
    final Context context = this;
    LinearLayout list2;
    JSONObject c;
    AppBarLayout dd;
    Button etUserName2,etUserName23,etUserName234;
    FloatingActionButton fab;
    AQuery aq;
    String aa,bb;
    private ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users);







        etUserName23 = (Button) findViewById(R.id.button44);
        etUserName23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

              bb="active";
              //  Toast.makeText(Users_info.this, "Position: " + bb, Toast.LENGTH_SHORT).show();
                signupj();
            }
        });


        etUserName234 = (Button) findViewById(R.id.button222);

        etUserName234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

                bb="del";

                signupj();
            }
        });




        a1 = (TextView ) findViewById(R.id.button);
        b = (TextView ) findViewById(R.id.textView7);
        c1 = (TextView ) findViewById(R.id.textView9);
        d = (TextView ) findViewById(R.id.textView11);
        e1 = (TextView ) findViewById(R.id.textView13);
        f = (TextView ) findViewById(R.id.textView6);



        String dd = getIntent().getStringExtra("g2");
        String ee = getIntent().getStringExtra("g3");
        String ff = getIntent().getStringExtra("g4");


        String gg = getIntent().getStringExtra("g5");
        String hh = getIntent().getStringExtra("g6");




        String ii = getIntent().getStringExtra("g8");

        String strrrt2 = getIntent().getStringExtra("g7");



        if(ii.equals("0"))
{

     ii="الحساب غير مفعل" ;

}else if(ii.equals("1"))
{
    ii=" تم تفعيل الحساب" ;
    f.setTextColor(0xff669900);

}
        ImageView imageView = (ImageView)findViewById(R.id.imageView11);
        Glide.with(context)
                .load(strrrt2)
                .centerCrop()
                .into(imageView);


        a1.setText(dd);
        b.setText(ee);
        c1.setText(ff);
        d.setText(gg);
        e1.setText(hh);
        f.setText(ii);


        String aa = getIntent().getStringExtra("g1");
        String bb = getIntent().getStringExtra("g2");
        String cc = getIntent().getStringExtra("g3");
        String jj = getIntent().getStringExtra("g10");
        String kk = getIntent().getStringExtra("g11");

        // Toast.makeText(Show_requst_ditils.this, "Position: " + aa+bb+cc+jj+kk, Toast.LENGTH_LONG).show();

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


    public void signupj() {









       aa = getIntent().getStringExtra("g1");
       // aa = etUserName23.getText().toString();

      //  Toast.makeText(Users_info.this, "Position: " + aa, Toast.LENGTH_SHORT).show();


        new Users_info.SignupActivitydaj(this).execute(aa, bb);

    }




    public class SignupActivitydaj extends AsyncTask<String, Void, String> {


        private Context context;


        public SignupActivitydaj(Context context) {
            this.context = context;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(Users_info.this,
                    "جاري ...","ارسال البيانات", false, false);
        }

        @Override
        protected String doInBackground(String... arg0) {
            String name = arg0[0];
            String phone = arg0[1];



            String link;
            String data;
            BufferedReader bufferedReader;
            String result;

            try {

                data = "?a=" + URLEncoder.encode(name, "UTF-8");
                data += "&b=" + URLEncoder.encode(phone, "UTF-8");

                ////ltgani motsim altgani yosif

                link = "http://sultantec.com/files/user_edit.php" + data;

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


        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.wwe2)
                .setTitle("تمت العملية بنجاح")
                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mProgressDialog.dismiss();


                    }
                }).setNegativeButton("خروج", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                mProgressDialog.dismiss();
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


                        aa = getIntent().getStringExtra("g1");


                        new Users_info.SignupActivitydaj(getApplicationContext()).execute(aa, bb);



                    }
                }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                mProgressDialog.dismiss();


            }

        }).show();

    }







    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}

