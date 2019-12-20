package com.example.tagog.first;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.os.AsyncTask;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidquery.AQuery;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Driver extends Activity {
    public   Dialog dialog;
    private ProgressDialog mProgressDialog;
    String myJSON;
    private static final String TAG_RESULTS="result";
    private static final int MY_SOCKET_TIMEOUT_MS = 10000;
    private static final String A = "A";
    private static final String B = "B";
    private static final String C ="C";
    private static final String D = "D";
    private static final String E = "E";
    private static final String F ="F";
    private static final String G = "G";
    private static final String H = "H";
    private static final String I ="I";
    String AA;
    String BB;
    String DE;

    String GH;

    String NO;
int vl;
    ProgressBar Pbar;
    // private TextView etFullName;

    private Button etUserName;
    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;

    ListView list;
    AQuery aq;
    String from1;
    Spinner from;

    SharedPreferences settingslogin = null;
    private String mUsername;
    private String mUsername2;

    SwipeRefreshLayout mSwipeRefreshLayout;

    LinearLayout ser;
    Button  etUserName2342;
    int sern=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver);

        dothis();


        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getData();

                new android.os.Handler().postDelayed(new Runnable() {

                    @Override public void run() {

                        //   mSwipeRefreshLayout.setRefreshing(false);

                    }

                }, 5000);

            }

        });




      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);


      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();


                CustomDialog();



            }
        });*/



        ser = (LinearLayout) findViewById(R.id.linearLayout4);

        ser.setVisibility(View.GONE);

        etUserName2342 = (Button) findViewById(R.id.button15);
        etUserName2342.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                if(sern==0) {
                    sern = 1;

                    ser.setVisibility(View.VISIBLE);
                }else if(sern==1) {
                    sern = 0;
                    ser.setVisibility(View.GONE);
                }
            }
        });



        settingslogin = getSharedPreferences("NAMELOGIN", 0);
        mUsername = settingslogin.getString("go1", "");
        mUsername2 = settingslogin.getString("go2", "");


//
//        TextView wwww =(TextView)findViewById(R.id.textView43);
//        wwww.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View vv) {
//                getData();
//            }
//        });



        Button etUserName23 = (Button) findViewById(R.id.button44);
        etUserName23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

//                Intent al = new Intent(Driver.this, New_gi.class);
//                String aa = mUsername;
//                String bb = mUsername2;
//
//                al.putExtra("go3", aa);
//                al.putExtra("go4", bb);
//                startActivity(al);
//                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);



               getData();




            }
        });



        Button etUserName234 = (Button) findViewById(R.id.button222);
        etUserName234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {



               // buclickd();
                Intent alvvwefrerxx = new Intent(Driver.this, Count.class);

            String aa1 = mUsername;
//
           String bb1 = mUsername2;
//
//                String bb2 = "4";
//                String bb3 = "driver";
//
           alvvwefrerxx.putExtra("phone", aa1); alvvwefrerxx.putExtra("loha", bb1);

                startActivity(alvvwefrerxx);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });

        Button etUserName2342 = (Button) findViewById(R.id.button17);
        etUserName2342.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {



                buclickd();
//                Intent alvvwefrerxx = new Intent(Driver.this, Watting_u.class);
//
//                String aa1 = mUsername;
//
//                String bb1 = mUsername2;
//
//                String bb2 = "4";
//                String bb3 = "driver";
//
//                alvvwefrerxx.putExtra("phone", aa1); alvvwefrerxx.putExtra("name", bb1);alvvwefrerxx.putExtra("id", bb2);alvvwefrerxx.putExtra("st", bb3);
//
//                startActivity(alvvwefrerxx);
//                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });





        Button  etUserName225 = (Button) findViewById(R.id.button28);
        etUserName225.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

                Intent alvvwefrerxx = new Intent(Driver.this, Add_j4.class);

                String aa1 = mUsername;
                String bb1 = mUsername2;

                String bb2 = "0";
                String bb3 = "driver";

                alvvwefrerxx.putExtra("g", aa1); alvvwefrerxx.putExtra("h", bb1);alvvwefrerxx.putExtra("i", bb2);alvvwefrerxx.putExtra("j", bb3);
                startActivity(alvvwefrerxx);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

            }
        });




        from = (Spinner) findViewById(R.id.button2);
        from1 = from.getSelectedItem().toString();


        Button etUserName2 = (Button) findViewById(R.id.button4);
        etUserName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

                from1 = from.getSelectedItem().toString();
                getData();
                etUserName.setVisibility(View.GONE);

               /* String aa = getIntent().getStringExtra("go1");
                String bb = getIntent().getStringExtra("go2");


                Intent al = new Intent(Driver.this, Town2.class);
//finish();
                al.putExtra("go3", aa);
                al.putExtra("go4", bb);

                startActivity(al);
                finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
*/



            }
        });

        etUserName2.setBackgroundDrawable(new ColorDrawable(0));

        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub

                // Toast.makeText(getBaseContext(), from.getSelectedItem().toString(),

                // Toast.LENGTH_SHORT).show();

                from1 = from.getSelectedItem().toString();
                //   finish();
                //  startActivity(getIntent());

                from1 = from.getSelectedItem().toString();
                //   finish();
                //  startActivity(getIntent());

                if (!from1.equals("حدد مكان التحرك")) {

                    getData();
                    etUserName.setVisibility(View.GONE);

                } else if (from1.equals("حدد مكان التحرك") ) {

                    Toast.makeText(Driver.this, "قم بتحديد مكان التحرك", Toast.LENGTH_SHORT).show();
                }



            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });



        list = (ListView)findViewById(R.id.listView2);

        personList = new ArrayList<HashMap<String,String>>();

        Pbar = (ProgressBar)findViewById(R.id.progressBar1);

        etUserName = (Button) findViewById(R.id.erorrp);
        etUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                getData();
                etUserName.setVisibility(View.GONE);

            }
        });

        getData();

    }




    protected void showList(){
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);
            // jsonObj  = jsonParse.makeHttpRequest(LOGIN_URL, pairs);
            final String[] anArray;
            final String[] anArray1;
            final String[] anArray2;
            final String[] anArray3;
            final String[] anArray4;
            final String[] anArray5;
            final String[] anArray6;
            final String[] anArray7;
            final String[] anArray8;
            anArray = new String[peoples.length()];
            anArray1 = new String[peoples.length()];
            anArray2 = new String[peoples.length()];
            anArray3 = new String[peoples.length()];
            anArray4 = new String[peoples.length()];
            anArray5 = new String[peoples.length()];
            anArray6 = new String[peoples.length()];
            anArray7 = new String[peoples.length()];
            anArray8 = new String[peoples.length()];

            int ii=0; int ii1=0; int ii2=0; int ii3=0; int ii4=0; int ii5=0; int ii6=0; int ii7=0; int ii8=0;
            personList.clear();
            int v=peoples.length()-1;
            vl=peoples.length();
            for(int i=v;i>=0;i--){
                JSONObject c = peoples.getJSONObject(i);
                 AA =" طلب رقم "+c.getString(A);
                BB = c.getString(B);
                String CC = c.getString(C);
                String DD = c.getString(D);

                        //+"من: ";
                String EE = c.getString(E);
                String FF = " يطلب نقل "+c.getString(F)+"راس";
                String GG = "("+c.getString(G)+")";
                String HH = "ساعة التحرك:"+c.getString(H);
                String II = c.getString(I);


              //  String  DE="من"+DD+"الي"+EE;

              //  String GH=GG+"س:"+HH;

             //   String  NO="راس"+FF;



             // String DD2 ="من"+c.getString(D)+"الي"+c.getString(E);
              // String GG2 ="من"+c.getString(G)+"الي"+c.getString(H);






                HashMap<String,String> persons = new HashMap<String,String>();
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int positiona, long id) {

                       // String listPosition=String.valueOf(parent.getItemIdAtPosition(positiona));


                       String count=anArray[positiona];
                        String count1=anArray1[positiona];
                        String count2=anArray2[positiona];
                        String count3=anArray3[positiona];
                        String count4=anArray4[positiona];
                        String count5=anArray5[positiona];
                        String count6=anArray6[positiona];
                        String count7=anArray7[positiona];
                        String count8=anArray8[positiona];

                        String aa0 = mUsername;
                        String bb0 = mUsername2;

                        //  String listPositiond = String.valueOf(parent.getItemAtPosition(positiona));
                      // Toast.makeText(Driver.this, "Position: " + count, Toast.LENGTH_SHORT).show();
                      Intent alvvwefrerxx = new Intent(Driver.this, Show_requst_ditils.class);
                      alvvwefrerxx.putExtra("g1", count); alvvwefrerxx.putExtra("g2", count1); alvvwefrerxx.putExtra("g3", count2);
                        alvvwefrerxx.putExtra("g4", count3); alvvwefrerxx.putExtra("g5", count4); alvvwefrerxx.putExtra("g6", count5);
                        alvvwefrerxx.putExtra("g7", count6); alvvwefrerxx.putExtra("g8", count7); alvvwefrerxx.putExtra("g9", count8);
                        alvvwefrerxx.putExtra("g10", aa0);alvvwefrerxx.putExtra("g11", bb0);
                      startActivity(alvvwefrerxx);


                        String bb ="1";
                        alvvwefrerxx.putExtra("no1", bb);



                      overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                    }

                });


               persons.put(A,AA);
                persons.put(B,BB);
                persons.put(C,CC);
                persons.put(D,DD);
                persons.put(E,EE);
                persons.put(F,FF);
                persons.put(G,GG);
                persons.put(H,HH);
                persons.put(I,II);


                personList.add(persons);


                anArray[ii] = c.getString(A);
                anArray1[ii1] = c.getString(B);
                anArray2[ii2] = c.getString(C);
                anArray3[ii3] = c.getString(D);
                anArray4[ii4] = c.getString(E);
                anArray5[ii5] = c.getString(F);
                anArray6[ii6] = c.getString(G);
                anArray7[ii7] = c.getString(H);
                anArray8[ii8] = c.getString(I);
                ii++; ii1++; ii2++; ii3++; ii4++; ii5++; ii6++; ii7++; ii8++;



            }


            ListAdapter adapter = new SimpleAdapter(Driver.this, personList, R.layout.list_item2, new String[]{D,E,A,H,F,G},


                    new int[]{R.id.textViewTitle,R.id.textView19,R.id.textView21,R.id.textViewTitle1,R.id.textView23,R.id.textView30


                    }



            );

            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "هنالك خطا ما اعدد المحاولة", Toast.LENGTH_LONG).show();
        }
        //etUserName.setVisibility(View.VISIBLE);

        if(vl>0 )
        {
           // Toast.makeText(Driver.this, "Position: " + vl, Toast.LENGTH_SHORT).show();
            //  etUserName.setVisibility(View.GONE);

            al();
        }else
        {

           // Toast.makeText(Driver.this, "Position: " + vl, Toast.LENGTH_SHORT).show();

            etUserName.setVisibility(View.VISIBLE);

            etUserName.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);

            etUserName.setText("لا توجد مطلوبات");

        }



    }





    public void getData(){
        class GetDataJSON extends AsyncTask<String, Void, String>{
            protected void onPreExecute()
            {
                //etUserName.setTextColor(Color.WHITE);
               list.setVisibility(View.GONE);
               // Pbar.setVisibility(View.VISIBLE);

               etUserName.setVisibility(View.GONE);
                Pbar.setVisibility(View.VISIBLE);
                super.onPreExecute();

            }
            @Override
            protected String doInBackground(String... params) {
                DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());


                HttpGet httppost=new HttpGet("http://sultantec.com/files/ad_show.php");




                //String strrt = getIntent().getStringExtra("sr");

                String strrt= from1;





                // String strrt = getIntent().getStringExtra("sr");



                if (strrt.equals("الكل")) {

                    httppost = new HttpGet("http://sultantec.com/files/ad_show.php");

                }else if (strrt.equals("حدد مكان التحرك")) {

                    httppost = new HttpGet("http://sultantec.com/files/ad_show.php");

                }  else{

                    httppost = new HttpGet("http://sultantec.com/files/ad_show.php?id="+strrt);

                }
                    //    http://motagog.000webhostapp.com/on/adminanswer.php?id="+strrt+"&name="+strrtv
                // Depends on your web service
                httppost.setHeader("Content-type", "application/json");

                InputStream inputStream = null;
                String result = null;
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    inputStream = entity.getContent();
                    // json is UTF-8 by default
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) {
                    // Oops

                }
                finally {
                    try{
                        if(inputStream != null)
                            inputStream.close();
                    }


                    catch(Exception squish){

                    }
                }
                return result;
            }


            @Override
            protected void onPostExecute(String result){
                myJSON = result;
                if (myJSON != null) {
                    mSwipeRefreshLayout.setRefreshing(false);
                    Pbar.setVisibility(View.GONE);
                    list.setVisibility(View.VISIBLE);
                   // etUserName.setVisibility(View.GONE);
                    showList();

                }
                else {
                    mSwipeRefreshLayout.setRefreshing(false);
                    Pbar.setVisibility(View.GONE);
                    etUserName.setVisibility(View.VISIBLE);
                    etUserName.setText("فشل الاتصال اعد المحاولة");
                }
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }




    public void buclickd() {
        final Dialog dialog = new Dialog(Driver.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom2);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);
        Button dialogButtonc = (Button) dialog.findViewById(R.id.al1);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settingslogin = getSharedPreferences("NAMELOGIN", 0);
                SharedPreferences.Editor editor2 = settingslogin.edit();
                editor2.putBoolean("checklogin", false);
                editor2.apply();

                Intent alvvwefrerxx = new Intent(Driver.this, Login.class);
                String a="logout";
                alvvwefrerxx.putExtra("logout", a);
                startActivity(alvvwefrerxx);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                finish();



            }
        });
        dialog.show();


    }












    @Override
    public void onBackPressed() {
   super.onBackPressed();
   overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
      //  buclickd8();
    }




    public void buclickd8() {

        final Dialog dialog = new Dialog(Driver.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom2);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.al1);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                onBackPressed2();
            }
        });
        dialog.show();


    }


    public void onBackPressed2() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

    }

    public void al()
    {
        etUserName.setVisibility(View.GONE);

    }
    public void CustomDialog(){

        dialog = new Dialog(Driver.this);
        // it remove the dialog title
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set the laytout in the dialog
        dialog.setContentView(R.layout.dialogbox_driver);
        // set the background partial transparent
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        //  Window window = dialog.getWindow();
        ///  WindowManager.LayoutParams param = window.getAttributes();
        // set the layout at right bottom
        /// param.gravity = Gravity.NO_GRAVITY | Gravity.RIGHT;
        // it dismiss the dialog when click outside the dialog frame
        //  dialog.setCanceledOnTouchOutside(true);
        // initialize the item of the dialog box, whose id is demo1



        View demodialog =(View) dialog.findViewById(R.id.cross);
        // it call when click on the item whose id is demo1.
        demodialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // diss miss the dialog
                dialog.dismiss();
            }
        });



        View demodialog22 =(View) dialog.findViewById(R.id.demotext4);
        // it call when click on the item whose id is demo1.
        demodialog22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // diss miss the dialog
                dialog.dismiss();
                Intent al = new Intent(Driver.this, Requst_t.class);
                startActivity(al);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });


        View demodialog223 =(View) dialog.findViewById(R.id.demotext5);
        // it call when click on the item whose id is demo1.
        demodialog223.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // diss miss the dialog
                dialog.dismiss();
                Intent al = new Intent(Driver.this, New_gi.class);
               String aa = getIntent().getStringExtra("go1");
                String bb = getIntent().getStringExtra("go2");

                al.putExtra("go3", aa);
                al.putExtra("go4", bb);
                startActivity(al);

                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });






        // it show the dialog box
        dialog.show();

    }



















    public  void  dothis(){


   //     Toast.makeText(this, "im in ", Toast.LENGTH_SHORT).show();



        String url = "http://sultantec.com/files/getcount.php?user="+mUsername+"&pass="+mUsername2;



        //Log.e("url", url);

        // Toast.makeText(mContext, url, Toast.LENGTH_LONG).show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

               // Toast.makeText(Driver.this,"res", Toast.LENGTH_LONG).show();

                try {

//                JSONObject jsonObj = new JSONObject(myJSON);
//                peoples = jsonObj.getJSONArray(TAG_RESULTS);
//

                    JSONObject jsonObject = new JSONObject(s);
                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
                    JSONArray array_2 = jsonObject.getJSONArray("result");

                    JSONObject no = array_2.getJSONObject(0);

                    final String mtlob = no.getString("mtlob");
                    final String plance = no.getString("plance");

                   // Toast.makeText(Driver.this, mtlob+plance, Toast.LENGTH_SHORT).show();
                    int result = Integer.parseInt(mtlob);

                    if(result>=200){
                       Log.e("url", "ok");
                        Intent al = new Intent(Driver.this, Count.class);


                        al.putExtra("nocount","nocount");

                        String aa1 = mUsername;
//
                        String bb1 = mUsername2;
//
//                String bb2 = "4";
//                String bb3 = "driver";
//
                        al.putExtra("phone", aa1); al.putExtra("loha", bb1);
                        finish();
                        startActivity(al);
                        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
}else{
                        Log.e("url", "no");

}

                } catch (JSONException e) {
                    // rdr2.setVisibility(View.GONE);
                    Log.e("url", "ex");

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {


                //     en4();

                // rdr2.setVisibility(View.GONE);
                // Toast.makeText(mContext, "Error vo 1 " + volleyError, Toast.LENGTH_SHORT).show();
                //finish();



                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "تاكد من اتصالك يالانترنت", Snackbar.LENGTH_INDEFINITE)
                        .setAction("اعاة المحاولة", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                dothis();
//                                onBackPressed();

//                                finish();
//                                moveTaskToBack(true);
//                                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                            }
                        })
                        .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                        .show();
            }
        }) {
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);

    }



}
