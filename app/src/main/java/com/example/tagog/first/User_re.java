package com.example.tagog.first;

import android.app.ProgressDialog;
import android.content.Context;
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

import org.json.JSONException;
import org.json.JSONObject;

public class User_re extends AppCompatActivity {
    EditText name;
    EditText pass;
    private ProgressDialog mProgressDialog;
    private static final int MY_SOCKET_TIMEOUT_MS = 10000;
    SharedPreferences settings = null;
    private String mUsername;
    private String mUsername2;
    SharedPreferences settings2;
    Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_re);


        pass = (EditText) findViewById(R.id.editText6);
        name = (EditText) findViewById(R.id.editText5);

        settings2 = getSharedPreferences("NAME33", 0);
        Boolean check2 = settings2.getBoolean("check33", false);




        String aa = getIntent().getStringExtra("ga");







        if (check2 &&  aa !=null) {

            String aa8 = getIntent().getStringExtra("ga");
            String bb = getIntent().getStringExtra("gb");
            String cc = getIntent().getStringExtra("gc");


            String dd = getIntent().getStringExtra("gd");

            String ee = getIntent().getStringExtra("ge");


            String ff = getIntent().getStringExtra("gf");

            String gg = getIntent().getStringExtra("gg");
            String hh = getIntent().getStringExtra("gh");
            String ii = getIntent().getStringExtra("gi");


            Intent alvvwefrerxx = new Intent(User_re.this,Bey.class);

            alvvwefrerxx.putExtra("ga", aa); alvvwefrerxx.putExtra("gb", bb); alvvwefrerxx.putExtra("gc", cc);

            alvvwefrerxx.putExtra("gd", dd); alvvwefrerxx.putExtra("ge", ee); alvvwefrerxx.putExtra("gf", ff);
            alvvwefrerxx.putExtra("gg", gg); alvvwefrerxx.putExtra("gh", hh); alvvwefrerxx.putExtra("gi", ii);

//            alvvwefrerxx.putExtra("phone", phone);
//            alvvwefrerxx.putExtra("name", name);

            startActivity(alvvwefrerxx);
            finish();
        }else if (check2 && aa ==null ){
            Intent i = new Intent(User_re.this,Requst_t.class);
            startActivity(i);
            finish();

        }
        Button etUserName234 = (Button) findViewById(R.id.button6);
        etUserName234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                String bb1 = name.getText().toString();
                String bb2 = pass.getText().toString();
                if(TextUtils.isEmpty(bb1)) {
                    name.setError("الرجاء مل الحقل");
                }else if(TextUtils.isEmpty(bb2)) {
                    pass.setError("الرجاء مل الحقل");
                }else{

                    dothis();

                }





            }
        });
    }




























    public  void  dothis(){

        mProgressDialog = ProgressDialog.show(User_re.this,
                "جاري ...", "تنفيذ عملية التسجيل", false, false);

        //  String aa1 = getIntent().getStringExtra("phone");
        //String bb1 = getIntent().getStringExtra("loha");

        String bb1 = name.getText().toString();
       // String aa12 = getIntent().getStringExtra("phone");
        String aa12 = pass.getText().toString();


        String url = "http://sultantec.com/files/insert_num.php?phone="+aa12 ;

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

                    if(!mtlob.equals("FAILURE")){

                        mProgressDialog.dismiss();

                 //  Bashir.notifcate(mContext, User_re.class, getResources().getString(R.string.app_name), " ", "" +  " رمز التفعيل هو  "+mtlob);

//                        AlertDialog.Builder builder =new AlertDialog.Builder(User_re.this);
//                        builder.setIcon(R.drawable.wwe2)
//                                .setTitle("تمت العملية بنجاح سيتم تفعيل حسابك خلال 24 ساعة او اقل")
//                                .setCancelable(false)
//                                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int id) {
//                                        mProgressDialog.dismiss();
//                                        onBackPressed();
//
//                                    }
//                                }).show();


                        String aa = getIntent().getStringExtra("ga");
                        String bb = getIntent().getStringExtra("gb");
                        String cc = getIntent().getStringExtra("gc");
                        String dd = getIntent().getStringExtra("gd");
                        String ee = getIntent().getStringExtra("ge");
                        String ff = getIntent().getStringExtra("gf");
                        String gg = getIntent().getStringExtra("gg");
                        String hh = getIntent().getStringExtra("gh");
                        String ii = getIntent().getStringExtra("gi");






                        Intent alvvwefrerxx = new Intent(User_re.this, Vcode_user.class);
                        // String bb = getIntent().getStringExtra("go2");
                        String bb1 = name.getText().toString();
                        // String aa12 = getIntent().getStringExtra("phone");
                        String aa12 = pass.getText().toString();

                        alvvwefrerxx.putExtra("phone", aa12);
                        alvvwefrerxx.putExtra("name", bb1);

                        alvvwefrerxx.putExtra("ga", aa); alvvwefrerxx.putExtra("gb", bb); alvvwefrerxx.putExtra("gc", cc);

                        alvvwefrerxx.putExtra("gd", dd); alvvwefrerxx.putExtra("ge", ee); alvvwefrerxx.putExtra("gf", ff);
                        alvvwefrerxx.putExtra("gg", gg); alvvwefrerxx.putExtra("gh", hh); alvvwefrerxx.putExtra("gi", ii);

//                        alvvwefrerxx.putExtra("phone", phone);
//                        alvvwefrerxx.putExtra("name", name);

                        startActivity(alvvwefrerxx);
                        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                        finish();
                    }else {
                        mProgressDialog.dismiss();
                        Toast.makeText(User_re.this, "حدث خطا ما اعد المحاولة", Toast.LENGTH_LONG).show();

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
