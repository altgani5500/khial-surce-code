package com.example.tagog.first;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class Req_done extends AppCompatActivity {
    //AQuery aq;

    // LinearLayout ww;
    JSONArray peoples = null;
    TextView a1, b, c1, d, e1, f, g1, all, hh, ii, jj,f12;
    TextView a11, b1, c11, d1, e11, f1;
    final Context context = this;
    LinearLayout list2;
    JSONObject c;
    AppBarLayout dd;
    Button etUserName2;
    FloatingActionButton fab;
    private ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> personList;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.req_done);





        a1 = (TextView) findViewById(R.id.button);
        b = (TextView) findViewById(R.id.textView7);
        c1 = (TextView) findViewById(R.id.textView9);
        d = (TextView) findViewById(R.id.textView11);
        e1 = (TextView) findViewById(R.id.textView13);
        f = (TextView) findViewById(R.id.textView6);
        a11 = (TextView) findViewById(R.id.button1);
        b1 = (TextView) findViewById(R.id.textView71);
        c11 = (TextView) findViewById(R.id.textView91);
        d1 = (TextView) findViewById(R.id.textView111);
        e11 = (TextView) findViewById(R.id.textView131);
        f1 = (TextView) findViewById(R.id.textView61);

        f12 = (TextView) findViewById(R.id.textView59);



        String dd = getIntent().getStringExtra("g10");

      //  Log.d("dd",dd);
        String ee = getIntent().getStringExtra("g11");

       // Log.d("ee",ee);
        String ff = getIntent().getStringExtra("g12");

        Log.d("ff",ff);

        String gg = getIntent().getStringExtra("g13");
       // Log.d("gg",gg);

        String hh = getIntent().getStringExtra("g14");

       // Log.d("hh",hh);
        String ii22 = getIntent().getStringExtra("g15");

      //  Log.d("ii",ii);

     //   Toast.makeText(this, ii22, Toast.LENGTH_SHORT).show();



        String aa = getIntent().getStringExtra("g2");

  //  Log.d("aa",aa);
        String bb = getIntent().getStringExtra("g3");
      // Log.d("bb",bb);//user-name
        final String cc = getIntent().getStringExtra("g4");
      //  Log.d("cc",cc);//user-no

        final String jj = getIntent().getStringExtra("g5");
      // Log.d("jj",jj);//driverno


        String kk0 = getIntent().getStringExtra("g6");
      //  Log.d("6",kk0);
        String kk01 = getIntent().getStringExtra("g9");
      //  Log.d("9",kk01);
        String kk = getIntent().getStringExtra("g7");
      //Log.d("kk",kk);
        String kk1 = getIntent().getStringExtra("g8");
    //  Log.d("kk1",kk1);



        f.setText(hh);



        a1.setText(kk);
        b.setText(kk1);
        c1.setText(dd);
        d.setText(ee);
        e1.setText(ii22);




        a11.setText(bb);
        b1.setText(cc);

        c11.setText(cc);


        d1.setText(ff);
        e11.setText(jj);
        f1.setText(kk0);










        int result = Integer.parseInt(hh);
        int result2 = Integer.parseInt(ii22);



        int    myplance=(result*result2)*5/100;



        String palnces2=Integer.toString(myplance);

        f12.setText(palnces2+"RS");




        Button etUserName234 = (Button) findViewById(R.id.button222);
        etUserName234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                String bb = getIntent().getStringExtra("g3");



                try {


                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + cc));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }

            }
        });


        Button etUserName225 = (Button) findViewById(R.id.button44);
        etUserName225.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                String kk = getIntent().getStringExtra("g7");
                try {


                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + jj));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }

            }
        });
        // Toast.makeText(Showw_detad2.this, "Position: " + e11+b1, Toast.LENGTH_LONG).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //   .setAction("Action", null).show();
                onBackPressed();
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void signupj(View v) {


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


        new SignupActivitydaj(this).execute(aa, bb, cc, jj, kk, dd, ee, ff, gg, hh, ii);

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Showw_detad2 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


    public class SignupActivitydaj extends AsyncTask<String, Void, String> {


        private Context context;


        public SignupActivitydaj(Context context) {
            this.context = context;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(Req_done.this,
                    "جاري ...", "ارسال البيانات", false, false);
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


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.wwe2)
                .setTitle("تم ارسال البيانات بنجاح")
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("هل تريد اعادة المحاولة ؟")
                .setIcon(R.drawable.error)
                .setTitle("فشل الاتصال تاكد من خدمة البيانات")
                .setPositiveButton("اعادة محاولة", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mProgressDialog.dismiss();


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


                        new SignupActivitydaj(getApplicationContext()).execute(aa, bb, cc, jj, kk, dd, ee, ff, gg, hh, ii);


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
