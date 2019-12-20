package com.example.tagog.first;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Vcode_user extends AppCompatActivity {
    private static final int MY_SOCKET_TIMEOUT_MS = 10000;
    EditText pass;
    private ProgressDialog mProgressDialog;

    SharedPreferences settings = null;
    private String mUsername;
    private String mUsername2;
    SharedPreferences settings2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vcode_user);

        settings = getSharedPreferences("BISC", 0);

        mUsername=settings.getString("phone", "44");
        mUsername2=settings.getString("name", "44");


        pass = (EditText) findViewById(R.id.editText20);


        Button etUserName234 = (Button) findViewById(R.id.button16);
        etUserName234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {


                String bb1 = pass.getText().toString();


                if(TextUtils.isEmpty(bb1)) {
                    pass.setError("الرجاء مل الحقل");
                }else{

                    dothis();

                }





            }
        });


    }

    public  void  dothis(){

        mProgressDialog = ProgressDialog.show(Vcode_user.this,
                "جاري ...", "التحقق من رقم التفعيل", false, false);

        //  String aa1 = getIntent().getStringExtra("phone");
        //String bb1 = getIntent().getStringExtra("loha");

        String bb1 = pass.getText().toString();
        String aa12 = getIntent().getStringExtra("phone");





        String url = "http://sultantec.com/files/vcode_user.php?code="+bb1+"&phone="+aa12 ;

//        Log.e("url", aa12);
//        Log.e("url", bb1);

        // Toast.makeText(mContext, url, Toast.LENGTH_LONG).show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {




                try {
//                JSONObject jsonObj = new JSONObject(myJSON);
//                peoples = jsonObj.getJSONArray(TAG_RESULTS);
//


//
//                    JSONObject jsonObject = new JSONObject(s);
//                    //JSONArray array_1 = jsonObject.getJSONArray("locations");
//                    JSONArray array_2 = jsonObject.getJSONArray("result");
//
//                    JSONObject no = array_2.getJSONObject(0);
//
//                    final String mtlob = no.getString("query_result");
//
//
                    JSONObject jsonObj = new JSONObject(s);
                    String mtlob = jsonObj.getString("query_result");

                    if(mtlob.equals("SUCCESS")){
                        mProgressDialog.dismiss();
                        // Toast.makeText(getApplicationContext(), "تمت عملية التعديل بنجاح", Toast.LENGTH_LONG).show();


//                        AlertDialog.Builder builder =new AlertDialog.Builder(Vcode_user.this);
//                        builder.setIcon(R.drawable.wwe2)
//                                .setTitle("تمت العملية بنجاح ")
//                                .setCancelable(false)
//                                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int id) {
//                                        mProgressDialog.dismiss();
//                                        onBackPressed();
//
//                                    }
//                                }).show();


                        settings = getSharedPreferences("BISC", 0);

                        SharedPreferences.Editor editor2 = settings.edit();

                        mUsername2  =getIntent().getStringExtra("name");
                        mUsername =getIntent().getStringExtra("phone");

                        //   editor2.putBoolean("check23", true);

                        editor2.putString("phone", mUsername);
                        editor2.putString("name", mUsername2);
                        editor2.apply();
                        editor2.commit();

                        settings2 = getSharedPreferences("NAME33", 0);
                        SharedPreferences.Editor editor23 = settings2.edit();
                        editor23.putBoolean("check33", true);
                        //   editor2.putString("name2", "altgani");
                        editor23.apply();
                        editor23.commit();



                        String aa1 = getIntent().getStringExtra("ga");
                        String bb1 = getIntent().getStringExtra("gb");
                        String cc1 = getIntent().getStringExtra("gc");


                        String dd = getIntent().getStringExtra("gd");

                        String ee = getIntent().getStringExtra("ge");


                        String ff = getIntent().getStringExtra("gf");

                        String gg = getIntent().getStringExtra("gg");
                        String hh = getIntent().getStringExtra("gh");
                        String ii = getIntent().getStringExtra("gi");


if(aa1=="null" || aa1==null ) {

    Intent al = new Intent(Vcode_user.this, Requst_t.class);

    String aa = getIntent().getStringExtra("phone");
    String aa2 = getIntent().getStringExtra("name");
    // String bb = getIntent().getStringExtra("go2");

    al.putExtra("phone", aa);
    al.putExtra("name", aa2);

    startActivity(al);
    overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    finish();

}else if(aa1!="null"){

    Intent alvvwefrerxx = new Intent(Vcode_user.this, Bey.class);

    String aa = getIntent().getStringExtra("phone");
    String aa2 = getIntent().getStringExtra("name");
    // String bb = getIntent().getStringExtra("go2");

    alvvwefrerxx.putExtra("phone", aa);
    alvvwefrerxx.putExtra("name", aa2);

    alvvwefrerxx.putExtra("ga", aa); alvvwefrerxx.putExtra("gb", bb1); alvvwefrerxx.putExtra("gc", cc1);
    alvvwefrerxx.putExtra("gd", dd); alvvwefrerxx.putExtra("ge", ee); alvvwefrerxx.putExtra("gf", ff);
    alvvwefrerxx.putExtra("gg", gg); alvvwefrerxx.putExtra("gh", hh); alvvwefrerxx.putExtra("gi", ii);

    startActivity(alvvwefrerxx);
    overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    finish();


}





                    }else {
                        mProgressDialog.dismiss();
                        Toast.makeText(Vcode_user.this, "تاكد من صحة الكود المدخل", Toast.LENGTH_LONG).show();

                    }
                    // Toast.makeText(Count.this, mtlob+plance, Toast.LENGTH_SHORT).show();
//




//                Log.e("order_id",or);
//

                } catch (JSONException e) {
                    // rdr2.setVisibility(View.GONE);
                    mProgressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "حدث خطاء ما اعد الحاولة", Toast.LENGTH_SHORT).show();

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {


                //     en4();
                mProgressDialog.dismiss();
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
