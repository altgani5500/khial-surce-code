package com.example.tagog.first;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;

public class Requst_ted extends AppCompatActivity implements
        View.OnClickListener {
    Button btnDatePicker, btnTimePicker;
    TextView txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private ProgressDialog mProgressDialog;
    private EditText name, phone, kh_no,tips;
    private  Spinner from,to;
    private TextView date,time;
    SharedPreferences settings2;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.requst_ted);



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
       // settings2 = getSharedPreferences("NAME2", 0);jj
       // SharedPreferences.Editor editor2 = settings2.edit();

        //String phoneNumber = etPhone.getText().toString();
      //  editor2.putBoolean("check23", true);

      //  editor2.putString("phone", phoneNumber);
      //  editor2.apply();

//ALTGANI MOTSIM ALTGANI ;



        name = (EditText) findViewById(R.id.from1);
        phone = (EditText) findViewById(R.id.to1);
        from = (Spinner) findViewById(R.id.from2);
        to = (Spinner) findViewById(R.id.to2);

        date = (TextView) findViewById(R.id.from);
        time = (TextView) findViewById(R.id.to);

        kh_no = (EditText) findViewById(R.id.editText3);
        tips = (EditText) findViewById(R.id.editText4);



        String dd = getIntent().getStringExtra("g1");
        String ee = getIntent().getStringExtra("g2");

        String ff = getIntent().getStringExtra("g3");

        String gg = getIntent().getStringExtra("g4");
        String hh = getIntent().getStringExtra("g5");
        String ii = getIntent().getStringExtra("g6");

        String jj = getIntent().getStringExtra("g7");

//        a1.setText(dd);
//        b.setText(ee);
        //Toast.makeText(Requst_ted.this, "Position: " + jj, Toast.LENGTH_SHORT).show();



        date.setText(gg);
       time.setText(hh);
        kh_no.setText(ff);
        tips.setText(ii);


        //btnDatePicker=(Button)findViewById(R.id.btn_date);
        //btnTimePicker=(Button)findViewById(R.id.btn_time);
       /// txtDate=(TextView)findViewById(R.id.from);
        txtTime=(TextView)findViewById(R.id.to);

      ///  txtDate.setOnClickListener(this);
        txtTime.setOnClickListener(this);


        String bb = getIntent().getStringExtra("phone");
        String bb2 = getIntent().getStringExtra("name");


//        TextView  e1 = (TextView) findViewById(R.id.button);
//        TextView f = (TextView) findViewById(R.id.button5);
//
//e1.setText("المستخدم :"+bb2);
//f.setText("الهاتف :"+bb);



        String bb0 = getIntent().getStringExtra("d");
        String bb1 = getIntent().getStringExtra("d1");


        if(bb0!=null)
        {
            // Toast.makeText(Users_info2.this,"driver: ", Toast.LENGTH_SHORT).show();


    EditText b = (EditText ) findViewById(R.id.from);
            EditText c = (EditText ) findViewById(R.id.editText4);
           // TextView d = (TextView ) findViewById(R.id.textView14);

            b.setHint("تاريخ الرحلة");
            c.setHint("سعر نقل الراس بالريال");


           // d.setText("سعة الناقلة");

            url= "http://sultantec.com/files/req_edit2.php";

        }

        if(bb1!=null) {
            //Toast.makeText(Users_info2.this,"user: ", Toast.LENGTH_SHORT).show();
            url = "http://sultantec.com/files/req_edit.php";

        }

       // Toast.makeText(Requst_t.this, "Position: " +bb+bb2, Toast.LENGTH_SHORT).show();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    //    .setAction("Action", null).show();

                onBackPressed();
            }
        });



      //  info();


    }


    public void signup(View v) {

        String bb =  getIntent().getStringExtra("g7");
        String bb2 = getIntent().getStringExtra("g7");;


        String name1 =bb2;
                //name.getText().toString();
        String phone1 = bb;
        // String passWord = etPassword.toString();

        String from1 = from.getSelectedItem().toString();
        String to1 = to.getSelectedItem().toString();

        String date1 = date.getText().toString();
        String time1 = time.getText().toString();



        String kh_no1 = kh_no.getText().toString();
        String tips1 = tips.getText().toString();



              TextView v2=(TextView)findViewById(R.id.textView48);

        if (!from1.equals("حدد مكان التحرك"))
        {
            v2.setText("");

        }
        if (!to1.equals("حدد مكان الوجهة"))
        {
            v2.setText("");

        }


        if (from1.equals("حدد مكان التحرك"))
        {
            v2.setText("الرجاء تحديد مكان التحرك");
            return;
        }
        else if (to1.equals("حدد مكان الوجهة"))
        {
            v2.setText("الرجاء تحديد الوجهة");
            return;
        }

        else if (TextUtils.isEmpty(kh_no1))
        {
            kh_no.setError(getString(R.string.error_empty_field));
            return;
        }
        else if (TextUtils.isEmpty(tips1))
        {
            tips.setError(getString(R.string.error_empty_field));
            return;
        }
        else if (TextUtils.isEmpty(date1))
        {
             date.setError(getString(R.string.error_empty_field));
            return;
        }
        else if (TextUtils.isEmpty(time1))
        {
           time.setError(getString(R.string.error_empty_field));
            return;
        }
        else


v2.setText("");
            new SignupActivityda(this).execute(name1, phone1, from1, to1, date1,time1,kh_no1,tips1);



    }




    public class SignupActivityda extends AsyncTask<String, Void, String> {


        private Context context;


        public SignupActivityda(Context context) {
            this.context = context;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(Requst_ted.this,
                    "جاري ...","ارسال البيانات", false, false);
        }

        @Override
        protected String doInBackground(String... arg0) {
            String name = arg0[0];
            String phone = arg0[1];
            String from = arg0[2];
            String to = arg0[3];
            String date = arg0[4];
            String time = arg0[5];
            String kh_no = arg0[6];
            String tips = arg0[7];


            String link;
            String data;
            BufferedReader bufferedReader;
            String result;

            try {
                data = "?a=" + URLEncoder.encode(name, "UTF-8");
                data += "&b=" + URLEncoder.encode(phone, "UTF-8");
                data += "&c=" + URLEncoder.encode(from, "UTF-8");
                data += "&d=" + URLEncoder.encode(to, "UTF-8");
                data += "&e=" + URLEncoder.encode(date, "UTF-8");
                data += "&f=" + URLEncoder.encode(time, "UTF-8");
                data += "&g=" + URLEncoder.encode(kh_no, "UTF-8");
                data += "&h=" + URLEncoder.encode(tips, "UTF-8");

                link = url+data;

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
        name.setText(null);
        phone.setText(null);
        date.setText(null);
        time.setText(null);
        kh_no.setText(null);
        tips.setText(null);


        AlertDialog.Builder builder =new AlertDialog.Builder(this);
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
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setMessage("هل تريد اعادة المحاولة ؟")
                .setIcon(R.drawable.error)
                .setTitle("فشل الاتصال تاكد من خدمة البيانات")
                .setPositiveButton("اعادة محاولة", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mProgressDialog.dismiss();


                        String bb =  getIntent().getStringExtra("g7");
                        String bb2 = getIntent().getStringExtra("g7");;


                        String name1 =bb2;
                        //name.getText().toString();
                        String phone1 = bb;
                        String from1 = from.getSelectedItem().toString();
                        String to1 = to.getSelectedItem().toString();

                        String date1 = date.getText().toString();
                        String time1 = time.getText().toString();



                        String kh_no1 = kh_no.getText().toString();
                        String tips1 = tips.getText().toString();




                        if (TextUtils.isEmpty(kh_no1))
                        {
                            kh_no.setError(getString(R.string.error_empty_field));
                            return;
                        }


                       /* else if (TextUtils.isEmpty(tips1))
                        {
                            tips.setError(getString(R.string.error_empty_field));
                            return;
                        }*/


                        else if (TextUtils.isEmpty(date1))
                        {
                            date.setError(getString(R.string.error_empty_field));
                            return;
                        }
                        else if (TextUtils.isEmpty(time1))
                        {
                            time.setError(getString(R.string.error_empty_field));
                            return;
                        }
                        else



                            new SignupActivityda(getApplicationContext()).execute(name1, phone1, from1, to1, date1,time1,kh_no1,tips1);



                    }
                }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                mProgressDialog.dismiss();
                name.setText(null);
                phone.setText(null);
                date.setText(null);
                time.setText(null);
                kh_no.setText(null);
                tips.setText(null);

            }

        }).show();

    }










    public void onClick(View v) {

      /*  if (v == txtDate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }*/

        if (v == txtTime) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }


    public void info() {

        final Dialog dialog = new Dialog(Requst_ted.this);
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

}
