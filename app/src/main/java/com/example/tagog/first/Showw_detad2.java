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

public class Showw_detad2 extends AppCompatActivity {
    //AQuery aq;

    // LinearLayout ww;
    JSONArray peoples = null;
    TextView a1, b, c1, d, e1, f, g1, all, hh, ii, jj;
    TextView a11, b1, c11, d1, e11, f1,f12;
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
        setContentView(R.layout.showw_detad);





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
        String ee = getIntent().getStringExtra("g11");
        String ff = getIntent().getStringExtra("g12");


        String gg = getIntent().getStringExtra("g13");
        String hh = getIntent().getStringExtra("g14");
        String ii = getIntent().getStringExtra("g15");


        a1.setText(dd);
        b.setText(ee);
        c1.setText(gg);
        d.setText(hh);


        e1.setText(ff);
        f.setText(ii);

        int result = Integer.parseInt(ff);
        int result2 = Integer.parseInt(ii);



    int    myplance=(result*result2)*5/100;



        String palnces2=Integer.toString(myplance);



      //  Toast.makeText(this, result+"this o"+result2+"this is plance"+ palnces2, Toast.LENGTH_LONG).show();




        String aa = getIntent().getStringExtra("g2");
        String bb = getIntent().getStringExtra("g3");

        String cc = getIntent().getStringExtra("g4");


        String jj = getIntent().getStringExtra("g5");
        String kk = getIntent().getStringExtra("g7");
        String kk1 = getIntent().getStringExtra("g8");


        a11.setText(aa);
        b1.setText(bb);

        c11.setText(cc);


        d1.setText(jj);
        e11.setText(kk);
        f1.setText(kk1);




        f12.setText(palnces2+"RS");


        Button etUserName234 = (Button) findViewById(R.id.button222);
        etUserName234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                String bb = getIntent().getStringExtra("g3");



                try {


                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + bb));
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
                    callIntent.setData(Uri.parse("tel:" + kk));
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
            mProgressDialog = ProgressDialog.show(Showw_detad2.this,
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
