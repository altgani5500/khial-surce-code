package com.example.tagog.first;

import android.app.Dialog;
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
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

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

public class Show_requst_ditils extends AppCompatActivity {
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
    String name22;
    ArrayList<HashMap<String, String>> personList;
    EditText g;
   Dialog  dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_requst_ditils);







        Button al = (Button) findViewById(R.id.button7);
        // if button is clicked, close the custom dialog
        al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buclickd2();


            }
        });

      //  al.setVisibility(View.GONE);




      String no1 = getIntent().getStringExtra("no1");

        String no2 = getIntent().getStringExtra("no2");

        if (no1!=null)
        {
            al.setVisibility(View.VISIBLE);

        }

        if (no2!=null)
        {
           // al.setVisibility(View.VISIBLE);
           //Toast.makeText(Show_requst_ditils.this, "ok", Toast.LENGTH_SHORT).show();
            al.setVisibility(View.GONE);
        }

        a1 = (TextView) findViewById(R.id.button);
        b = (TextView) findViewById(R.id.textView7);
        c1 = (TextView) findViewById(R.id.textView9);
        d = (TextView) findViewById(R.id.textView11);
        e1 = (TextView) findViewById(R.id.textView13);
        f = (TextView) findViewById(R.id.textView6);


        String dd = getIntent().getStringExtra("g4");
        String ee = getIntent().getStringExtra("g5");
        String ff = getIntent().getStringExtra("g6");


        String gg = getIntent().getStringExtra("g7");
        String hh = getIntent().getStringExtra("g8");
        String ii = getIntent().getStringExtra("g9");


        a1.setText(dd);
        b.setText(ee);
        c1.setText(gg);
        d.setText(hh);
        e1.setText(ff);
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



    public void buclickd2() {

        dialog = new Dialog(Show_requst_ditils.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_price);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);
         g= (EditText) dialog.findViewById(R.id.editText12);


        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             name22 = g.getText().toString();
                if (TextUtils.isEmpty(name22))
                {
                    g.setError(getString(R.string.error_empty_field));
                    return;
                }else
                    signupj();
                dialog.dismiss();


            }
        });
        dialog.show();


    }


    public void s()
    {


        Toast.makeText(Show_requst_ditils.this, "ok:" , Toast.LENGTH_LONG).show();
    }

    public void signupj() {


        String name=name22;
        //Toast.makeText(Show_requst_ditils.this, "Position: " + name, Toast.LENGTH_LONG).show();


        String aa = getIntent().getStringExtra("g1");
        String bb = getIntent().getStringExtra("g2");


        String cc = getIntent().getStringExtra("g3");
        String jj = getIntent().getStringExtra("g10");
        String kk = getIntent().getStringExtra("g11");

        String dd = getIntent().getStringExtra("g4");
        String ee = getIntent().getStringExtra("g5");
        String ff = getIntent().getStringExtra("g6");


        String gg = getIntent().getStringExtra("g7");
        String hh = getIntent().getStringExtra("g8");
        String ii = getIntent().getStringExtra("g9");




        new Show_requst_ditils.SignupActivitydaj(this).execute(aa, bb, cc,jj,kk,dd,ee,ff,gg,hh,ii,name);

    }




    public class SignupActivitydaj extends AsyncTask<String, Void, String> {


        private Context context;


        public SignupActivitydaj(Context context) {
            this.context = context;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(Show_requst_ditils.this,
                    "جاري ...","ارسال البيانات", false, false);
        }

        @Override
        protected String doInBackground(String... arg0) {
            String name = arg0[0];
            String phone = arg0[1];
            String from = arg0[2];
            String to = arg0[3];
            String to2 = arg0[4];
            String a = arg0[5];
            String b = arg0[6];
            String c = arg0[7];
            String d = arg0[8];
            String ee = arg0[9];
            String f = arg0[10];
            String g = arg0[11];


            String link;
            String data;
            BufferedReader bufferedReader;
            String result;

            try {

                data = "?a=" + URLEncoder.encode(name, "UTF-8");
                data += "&b=" + URLEncoder.encode(phone, "UTF-8");
                data += "&c=" + URLEncoder.encode(from, "UTF-8");
                data += "&d=" + URLEncoder.encode(to, "UTF-8");
                data += "&e=" + URLEncoder.encode(to2, "UTF-8");
                data += "&f=" + URLEncoder.encode(a, "UTF-8");
                data += "&g=" + URLEncoder.encode(b, "UTF-8");
                data += "&h=" + URLEncoder.encode(c, "UTF-8");
                data += "&i=" + URLEncoder.encode(d, "UTF-8");
                data += "&j=" + URLEncoder.encode(ee, "UTF-8");
                data += "&k=" + URLEncoder.encode(f, "UTF-8");
                data += "&l=" + URLEncoder.encode(g, "UTF-8");
              ////ltgani motsim altgani yosif

                link = "http://sultantec.com/files/req_ok.php" + data;

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
                .setTitle("تم ارسال البيانات بنجاح")
                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        mProgressDialog.dismiss();
dialog.dismiss();

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

                        String name=name22;
                        //Toast.makeText(Show_requst_ditils.this, "Position: " + name, Toast.LENGTH_LONG).show();

                        String aa = getIntent().getStringExtra("g1");
                        String bb = getIntent().getStringExtra("g2");
                        String cc = getIntent().getStringExtra("g3");
                        String jj = getIntent().getStringExtra("g10");
                        String kk = getIntent().getStringExtra("g11");

                        String dd = getIntent().getStringExtra("g4");
                        String ee = getIntent().getStringExtra("g5");
                        String ff = getIntent().getStringExtra("g6");


                        String gg = getIntent().getStringExtra("g7");
                        String hh = getIntent().getStringExtra("g8");
                        String ii = getIntent().getStringExtra("g9");


                        new Show_requst_ditils.SignupActivitydaj(getApplicationContext()).execute(aa, bb, cc,jj,kk,dd,ee,ff,gg,hh,ii,name);



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
