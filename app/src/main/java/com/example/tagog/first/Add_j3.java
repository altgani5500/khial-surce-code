package com.example.tagog.first;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

public class Add_j3 extends Activity {
    public   Dialog dialog;
    private ProgressDialog mProgressDialog;
    String myJSON;
    private static final String TAG_RESULTS="result";
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

static String on="0";

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
    SwipeRefreshLayout  mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_j2);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getData();

//                new android.os.Handler().postDelayed(new Runnable() {
//
//                    @Override public void run() {
//
//                        //   mSwipeRefreshLayout.setRefreshing(false);
//
//                    }
//
//                }, 5000);

            }

        });


        TextView wwww =(TextView)findViewById(R.id.textView41);
        wwww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                getData();
            }
        });


        String aa1 = getIntent().getStringExtra("phone");
        String bb1 = getIntent().getStringExtra("name");


       // Toast.makeText(this, aa1+bb1+"", Toast.LENGTH_SHORT).show();




        Button etUserName234 = (Button) findViewById(R.id.button28);
        etUserName234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {


                Intent alvvwefrerxx = new Intent(Add_j3.this, Watting_u.class);

                String aa1 = getIntent().getStringExtra("phone");
                String bb1 = getIntent().getStringExtra("name");


                String bb2 = "4";
                String bb3 = "user";


                alvvwefrerxx.putExtra("phone", aa1); alvvwefrerxx.putExtra("name", bb1);alvvwefrerxx.putExtra("id", bb2);alvvwefrerxx.putExtra("st", bb3);

                startActivity(alvvwefrerxx);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

            }
        });



        Button  etUserName225 = (Button) findViewById(R.id.button222);
        etUserName225.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {


                Intent alvvwefrerxx = new Intent(Add_j3.this, Watting.class);

                String aa1 = getIntent().getStringExtra("phone");
                String bb1 ="ok";

                        //getIntent().getStringExtra("name");
                String bb2 = "4";
                String bb3 = "user";




                alvvwefrerxx.putExtra("g", aa1); alvvwefrerxx.putExtra("h", bb1);alvvwefrerxx.putExtra("i", bb2);alvvwefrerxx.putExtra("j", bb3);
                startActivity(alvvwefrerxx);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

            }
        });


        Button  etUserName2251 = (Button) findViewById(R.id.button282);
        etUserName2251.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {


                Intent al = new Intent(Add_j3.this, User_re.class);
                String aa = getIntent().getStringExtra("phone");
                String aa2 = getIntent().getStringExtra("name");


                // String bb = getIntent().getStringExtra("go2");

                al.putExtra("phone", aa);
                al.putExtra("name", aa2);

                startActivity(al);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                finish();


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





        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub

                // Toast.makeText(getBaseContext(), from.getSelectedItem().toString(),

                // Toast.LENGTH_SHORT).show();

                from1 = from.getSelectedItem().toString();
                //   finish();
                //  startActivity(getIntent());




                getData();
                etUserName.setVisibility(View.GONE);

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

        etUserName.setBackgroundDrawable(new ColorDrawable(0));

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
                 AA = c.getString(A);
                BB = c.getString(B);
                String CC = c.getString(C);
                String DD = c.getString(D);

                        //+"من: ";
                String EE = c.getString(E);
                String FF = "طلبت نقل:"+c.getString(F)+" راس";

                String GG ="("+ c.getString(G)+")";

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

                        String aa0 = getIntent().getStringExtra("go1");
                        String bb0 = getIntent().getStringExtra("go2");

                        //  String listPositiond = String.valueOf(parent.getItemAtPosition(positiona));
                      // Toast.makeText(Driver.this, "Position: " + count, Toast.LENGTH_SHORT).show();


                      Intent alvvwefrerxx = new Intent(Add_j3.this, Users_info2.class);
                      alvvwefrerxx.putExtra("g1", count); alvvwefrerxx.putExtra("g2", count1); alvvwefrerxx.putExtra("g3", count2);
                        alvvwefrerxx.putExtra("g4", count3); alvvwefrerxx.putExtra("g5", count4); alvvwefrerxx.putExtra("g6", count5);
                        alvvwefrerxx.putExtra("g7", count6); alvvwefrerxx.putExtra("g8", count7); alvvwefrerxx.putExtra("g9", count8);
                        alvvwefrerxx.putExtra("g10", aa0);alvvwefrerxx.putExtra("g11", bb0);


                        String c="user";



                        alvvwefrerxx.putExtra("d1", c);

                     String bb="1";

                     alvvwefrerxx.putExtra("no2", bb);

                      startActivity(alvvwefrerxx);
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


            ListAdapter adapter = new SimpleAdapter(Add_j3.this, personList, R.layout.list_item22, new String[]{D,E,H,F,G},


                    new int[]{R.id.textViewTitle,R.id.textView19,R.id.textViewTitle1,R.id.textView23,R.id.textView30


                    }



            );

            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "حدث خطا ما", Toast.LENGTH_LONG).show();
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
            etUserName.setText("لا توجد لديك طلبات معروضة");

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

                String strrt= getIntent().getStringExtra("phone");;


//                String aa1 = getIntent().getStringExtra("phone");
//                String bb1 = getIntent().getStringExtra("name");

                HttpGet httppost = new HttpGet("http://sultantec.com/files/ad_show_me.php?id="+strrt);



                //String strrt = getIntent().getStringExtra("sr");





                // String strrt = getIntent().getStringExtra("sr");

                if(!strrt.equals("حدد مكان التحرك")){

                    httppost = new HttpGet("http://sultantec.com/files/ad_show_me.php?id="+strrt);


                }else if(strrt.equals("حدد مكان التحرك")){

                    httppost = new HttpGet("http://sultantec.com/files/ad_show_me.php?id="+strrt);

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
    @Override
    public void onBackPressed() {
      super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
       // buclickd();
    }

    public void al()
    {
        etUserName.setVisibility(View.GONE);

    }
    public void CustomDialog(){

        dialog = new Dialog(Add_j3.this);
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
                Intent al = new Intent(Add_j3.this, Requst_t.class);
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
                Intent al = new Intent(Add_j3.this, New_gi.class);
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


    public void buclickd() {

        final Dialog dialog = new Dialog(Add_j3.this);
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
                Intent alvvwefrerxx = new Intent(Add_j3.this, Login.class);
                startActivity(alvvwefrerxx);
                finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });
        dialog.show();


    }





}
