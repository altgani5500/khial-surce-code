package com.example.tagog.first;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.androidquery.util.Progress;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Count extends AppCompatActivity {
    private static final int MY_SOCKET_TIMEOUT_MS = 10000;
RelativeLayout count;
    Button pro;
    ProgressBar prog;

    TextView plancet;
    TextView mtlobt;
EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count);
        TextView txt = (TextView) findViewById(R.id.textView56);


        txt.setVisibility(View.GONE);

        pass = (EditText) findViewById(R.id.editText14);

        String aa12 = getIntent().getStringExtra("nocount");


        Button etUserName234 = (Button) findViewById(R.id.button18);
        etUserName234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                String bb1 = pass.getText().toString();
                String bb2 = getIntent().getStringExtra("loha");

if(TextUtils.isEmpty(bb1)) {
    pass.setError("الرجاء مل الحقل");
}else if(bb2.equals(bb1)){

    pass.setError("لم تدخل كلمة المرور الجديدة");

}else{

    dothis2();

}





            }
        });

        if(aa12==null){
           // Toast.makeText(this, aa12, Toast.LENGTH_SHORT).show();
            txt.setVisibility(View.GONE);

        }else  if(aa12!=null){

          //  Toast.makeText(this, aa12, Toast.LENGTH_SHORT).show();
            txt.setVisibility(View.VISIBLE);
            blink();
        }

        dothis();

        count = (RelativeLayout) findViewById(R.id.count25);

        count.setVisibility(View.GONE);

        plancet= (TextView) findViewById(R.id.button222);
        mtlobt= (TextView) findViewById(R.id.button44);


        pro= (Button) findViewById(R.id.etUserNamee);
        prog= (ProgressBar) findViewById(R.id.progressBar1);
        pro.setBackgroundDrawable(new ColorDrawable(0));
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                dothis();
            }
        });

    }



    public  void  dothis2(){



        count.setVisibility(View.GONE);

        String aa1 = getIntent().getStringExtra("phone");
        String bb1 = pass.getText().toString();

        String url = "http://sultantec.com/files/editpass.php?user="+aa1+"&new_pass="+bb1 ;

        //Log.e("url", url);


        // Toast.makeText(mContext, url, Toast.LENGTH_LONG).show();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {


                count.setVisibility(View.VISIBLE);
                pro.setVisibility(View.GONE);
                prog.setVisibility(View.GONE);


                try {




//                JSONObject jsonObj = new JSONObject(myJSON);
//                peoples = jsonObj.getJSONArray(TAG_RESULTS);
//



                    JSONObject jsonObject = new JSONObject(s);
                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
                    JSONArray array_2 = jsonObject.getJSONArray("result");

                    JSONObject no = array_2.getJSONObject(0);

                    final String mtlob = no.getString("query_result");

                    if(mtlob.equals("SUCCESS")){

                        Toast.makeText(getApplicationContext(), "تمت عملية التعديل بنجاح", Toast.LENGTH_LONG).show();

                        dothis();
                    }else {

                        Toast.makeText(Count.this, "nooooooo", Toast.LENGTH_SHORT).show();

                    }


                    // Toast.makeText(Count.this, mtlob+plance, Toast.LENGTH_SHORT).show();
//



//                Log.e("order_id",or);
//

                } catch (JSONException e) {
                    // rdr2.setVisibility(View.GONE);
                    pro.setVisibility(View.VISIBLE);
                    pro.setText("يوجدخطا اعد المحاولة ");




                 Toast.makeText(getApplicationContext(), "يوجد خطا ما اعد المحاولة", Toast.LENGTH_LONG).show();


                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {


                //     en4();

                // rdr2.setVisibility(View.GONE);
         //   Toast.makeText(Count.this, "فشل الاتصال بالشبكة " + volleyError, Toast.LENGTH_SHORT).show();
                //finish();

                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "تاكد من اتصالك يالانترنت", Snackbar.LENGTH_INDEFINITE)
                        .setAction("اعاة المحاولة", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                dothis2();
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























public  void  dothis(){

    String aa1 = getIntent().getStringExtra("phone");
    String bb1 = getIntent().getStringExtra("loha");

    String url = "http://sultantec.com/files/getcount.php?user="+aa1+"&pass="+bb1 ;

    //Log.e("url", url);


    // Toast.makeText(mContext, url, Toast.LENGTH_LONG).show();


    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String s) {

            //Toast.makeText(mContext, "Reponse : " + s, Toast.LENGTH_SHORT).show();
            count.setVisibility(View.VISIBLE);
            pro.setVisibility(View.GONE);
            prog.setVisibility(View.GONE);


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
                final String pass2 = no.getString("pass");




                 pass.setText(pass2);


               // Toast.makeText(Count.this, mtlob+plance, Toast.LENGTH_SHORT).show();
//


                plancet.setText(plance+"RS");

                mtlobt.setText(mtlob+"RS");



//                Log.e("order_id",or);
//

            } catch (JSONException e) {
                // rdr2.setVisibility(View.GONE);

            //    Toast.makeText(getApplicationContext(), "exption1", Toast.LENGTH_SHORT).show();
                pro.setVisibility(View.VISIBLE);
                pro.setText("يوجدخطا اعد المحاولة ");

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




            pro.setText("فشل الاتصال اععد المحاولة");
            prog.setVisibility(View.GONE);

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




    private void blink(){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 500;    //in milissegunds
                try{Thread.sleep(timeToBlink);}catch (Exception e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView txt = (TextView) findViewById(R.id.textView56);
                        if(txt.getVisibility() == View.VISIBLE){
                            txt.setVisibility(View.INVISIBLE);
                        }else{
                            txt.setVisibility(View.VISIBLE);
                        }
                        blink();
                    }
                });
            }
        }).start();
    }




    @Override
    public void onBackPressed() {
         super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

    }
}
