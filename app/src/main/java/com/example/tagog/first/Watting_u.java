package com.example.tagog.first;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class Watting_u extends AppCompatActivity {

    public Dialog dialog;
    String  AA2r;
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
    private static final String J = "J";
    private static final String K = "K";
    private static final String L ="L";
    private static final String M = "M";
    private static String N = "N";
    String AA;
    String AA2;
    String AA21; String AA211;String AA22;
    //private static final String O= "O";

    String MM;
    String nnu;
    String nnd;
    String h="قيد التنفيذ";
    String h2;
    String h21;
    String h22;

    String aa, bb;


   // private static final String G = "G";
   /// private static final String H = "H";
    //private static final String I ="I";

    String DE;
int vl;
    String GH;

    String NO;

    ProgressBar Pbar;
    // private TextView etFullName;

    private Button etUserName;
    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;

    ListView list;
    AQuery aq;
    String from1;
    Spinner from;

    String aa2;
    String aa0;
    String aa1;
    String aa3;
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watting_u);

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

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                ///.setAction("Action", null).show();
//                onBackPressed();
//            }
//        });


//        String aa0 = getIntent().getStringExtra("g");
//        String aa1 = getIntent().getStringExtra("h");
//        String aa2 = getIntent().getStringExtra("i");
//


       // String aa0 = getIntent().getStringExtra("g");
       // String aa1 = getIntent().getStringExtra("h");
   //   Toast.makeText(Watting_u.this, "Position: " + aa0+aa1+aa2,Toast.LENGTH_SHORT).show();








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





        aa0 = getIntent().getStringExtra("phone");

   aa1 = getIntent().getStringExtra("name");


      aa2 = getIntent().getStringExtra("id");

        aa3 = getIntent().getStringExtra("st");






        //Toast.makeText(Watting_u.this, "Position: " + aa0+aa1, Toast.LENGTH_SHORT).show();

        Button  etUserName2253 = (Button) findViewById(R.id.button2224);
        etUserName2253.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

                TextView a=(TextView)findViewById(R.id.textView44);

                a.setText("كل الطلبات:");


                aa0 = getIntent().getStringExtra("phone");
                aa1 = getIntent().getStringExtra("name");


                aa2 = "4";

                aa3 = getIntent().getStringExtra("st");


                getData();

            }
        });



        Button  etUserName225 = (Button) findViewById(R.id.button222);
        etUserName225.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

                TextView a=(TextView)findViewById(R.id.textView44);

                a.setText("طلبات اكتملت:");


                aa0 = getIntent().getStringExtra("phone");
                aa1 = getIntent().getStringExtra("name");


                aa2 = "1";

                aa3 = getIntent().getStringExtra("st");


           getData();
                
            }
        });


        Button  etUserName2256 = (Button) findViewById(R.id.button44);
        etUserName2256.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {


                // Intent alvvwefrerxx = new Intent(Watting_u.this, Watting_u.class);
                TextView a=(TextView)findViewById(R.id.textView44);

                a.setText("طلبات قيد الاتفاق:");

                aa0 = getIntent().getStringExtra("phone");
                aa1 = getIntent().getStringExtra("name");


                aa2 = "0";

                aa3 = getIntent().getStringExtra("st");





                getData();

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

            final String[] anArray9;
            final String[] anArray10;
            final String[] anArray66;
            final String[] anArray77;

            anArray = new String[peoples.length()];
            anArray1 = new String[peoples.length()];
            anArray2 = new String[peoples.length()];
            anArray3 = new String[peoples.length()];
            anArray4 = new String[peoples.length()];
            anArray5 = new String[peoples.length()];
            anArray6 = new String[peoples.length()];
            anArray7 = new String[peoples.length()];
            anArray8 = new String[peoples.length()];

            anArray66 = new String[peoples.length()];
            anArray77 = new String[peoples.length()];

            anArray9 = new String[peoples.length()];
            anArray10 = new String[peoples.length()];

            int ii=0; int ii1=0; int ii2=0; int ii3=0; int ii4=0; int ii5=0;int ii77=0; int ii66=0;
            personList.clear();
            int v=peoples.length()-1;
            vl=peoples.length();
            for(int i=v;i>=0;i--){
                JSONObject c = peoples.getJSONObject(i);
              AA = c.getString(A);
                String BB = c.getString(B);
                String CC = c.getString(C);
                String DD = c.getString(D);

                //+"من: ";
                String EE = c.getString(E);
                String FF = c.getString(F);
                String GG = c.getString(G);
                String HH= c.getString(H);
                String II= c.getString(I);
                String JJ ="("+ c.getString(J)+")";
                String KK = c.getString(K);


                String LL= c.getString(L)+" راس";

               MM=c.getString(M);









               String  NN = "تم الاتفاق علي :"+c.getString(N)+" ريال للراس الواحد ";


                if(MM.equals("0")&& aa3.equals("user")){
                    NN = "السعر المعروض للراس الواحد هو:"+c.getString(N)+" ريال ";

                }else if((MM.equals("0") && aa3.equals("driver")))
                {

                    NN = "لقد عرضت:"+c.getString(N)+"ريال للراس الواحد";

                }

              // String OO = c.getString(O);

                //+"من: ";
               // String EE = c.getString(E);
         //  String FF = c.getString(F)+" راس";








              //  String GG = c.getString(D);
              //String HH = "س:"+c.getString(C);
               // String II = c.getString(E);



                //  String  DE="من"+DD+"الي"+EE;

                //  String GH=GG+"س:"+HH;

                //   String  NO="راس"+FF;



                // String DD2 ="من"+c.getString(D)+"الي"+c.getString(E);
                // String GG2 ="من"+c.getString(G)+"الي"+c.getString(H);


                h21="";
                h22="";
                h2="تم عقد الاتفاق";
                anArray5[ii5]=MM;

                anArray66[ii66]=DD;
                anArray77[ii77]=EE;







                if( anArray5[ii5].equals("0") && aa3.equals("user")){
                    LL="في انتظار ردك";
                    h21="في انتظار ردك";
                    h22="";

                }else if(( anArray5[ii5].equals("0") && aa3.equals("driver")))
                {
                    //  Toast.makeText(Watting_u.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
                  //  LL="في انتظار الرد";

                    LL="في انتظار الرد";
                    h21="في انتظار الرد";
                    h22="";
                   // h21="";
                }
                else if(( anArray5[ii5].equals("3") && aa3.equals("user")))
                {
                    //  Toast.makeText(Watting_u.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
                    NN = "تم رفض :"+c.getString(N)+" ريال للراس الواحد ";
                   // h2=LL;
//                    LL="مرفوضة";

                    LL="";
                    h21="";
                    h22="مرفوضة";
                }

                else if((anArray5[ii5].equals("3") && aa3.equals("driver")))
                {
                    //  Toast.makeText(Watting_u.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
                    NN = "تم رفض :"+c.getString(N)+" ريال للراس الواحد ";
                  //  LL="تم رفض عرضك";

                    LL="";
                    h21="";
                    h22="تم رفض عرضك";
                   // h21="";
                }
                else if(( anArray5[ii5].equals("1") && aa3.equals("user")))
                {
                    //  Toast.makeText(Watting_u.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
                   // h21="تم الاتفاق";
                    LL="تم الاتفاق";
                    h21="";
                    h22="";

                }

                else if((anArray5[ii5].equals("1") && aa3.equals("driver")))
                {

                    //  Toast.makeText(Watting_u.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
                    LL="تمت الموافقة";
                    h21="";
                    h22="";

                }

                HashMap<String,String> persons = new HashMap<String,String>();
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int positiona, long id) {

                        // String listPosition=String.valueOf(parent.getItemIdAtPosition(positiona));












                        nnu=anArray66[positiona];
                        nnd=anArray77[positiona];




                        AA21=anArray[positiona];


                    AA22=anArray1[positiona];



//                        String count2=anArray2[positiona];
//                        String count3=anArray3[positiona];
//                        String count4=anArray4[positiona];
                        AA211=anArray5[positiona];
//                        String count6=anArray6[positiona];
//                        String count7=anArray7[positiona];
//                        String count8=anArray8[positiona];
//
//                        String count9=anArray9[positiona];
//                        String count10=anArray10[positiona];
//
//                        String aa0 = getIntent().getStringExtra("go1");
//                        String bb0 = getIntent().getStringExtra("go2");
//
//                        //  String listPositiond = String.valueOf(parent.getItemAtPosition(positiona));
//                        // Toast.makeText(Driver.this, "Position: " + count, Toast.LENGTH_SHORT).show();
//                       /* Intent alvvwefrerxx = new Intent(Watting.this, Show_requst_ditils.class);
//                        alvvwefrerxx.putExtra("g1", count); alvvwefrerxx.putExtra("g2", count1); alvvwefrerxx.putExtra("g3", count2);
//                        alvvwefrerxx.putExtra("g4", count3); alvvwefrerxx.putExtra("g5", count4); alvvwefrerxx.putExtra("g6", count5);
//                        alvvwefrerxx.putExtra("g7", count6); alvvwefrerxx.putExtra("g8", count7); alvvwefrerxx.putExtra("g9", count8);
//                        alvvwefrerxx.putExtra("g10", aa0);alvvwefrerxx.putExtra("g11", bb0);
//                        startActivity(alvvwefrerxx);
//                        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);*/





                        if( AA211.equals("0") && aa3.equals("user")){
                            CustomDialog2();

                        }else if( AA211.equals("0") && aa3.equals("driver"))
                        {
                            Toast.makeText(Watting_u.this, "هذة الرحلة في انتظار رد صاحبها", Toast.LENGTH_LONG).show();
                        }





                        else if( AA211.equals("1") && aa3.equals("user"))
                        {
//                            Toast.makeText(Watting_u.this, "هذة الرحلة تمت"+MM, Toast.LENGTH_LONG).show();

                         driver_call();
                        }
                        else if( AA211.equals("1") && aa3.equals("driver"))
                        {
                           // Toast.makeText(Watting_u.this, "هذة الرحلة تمت"+MM, Toast.LENGTH_LONG).show();
                            user_call();
                        }

                        else if( AA211.equals("3") && aa3.equals("user"))
                        {
                            //Toast.makeText(Watting_u.this, "هذة الرحلة لم يتفق عليها", Toast.LENGTH_LONG).show();
                            driver_reg();
                        }
                        else if( AA211.equals("3") && aa3.equals("driver"))
                        {
               user_reg();
                        }







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
                persons.put(J,JJ);
                persons.put(K,KK);
                persons.put(L,LL);
                persons.put(M,MM);
               persons.put(N,NN);
                persons.put(L,LL);

                persons.put(h21,h21);

                persons.put(h22,h22);



               // persons.put(O,OO);

                personList.add(persons);


                anArray[ii] = c.getString(A);


                anArray1[ii1] = c.getString(B);


                anArray2[ii2] = c.getString(C);
                anArray3[ii3] = c.getString(D);
                anArray4[ii4] = c.getString(E);


                anArray5[ii5] = c.getString(M);







                ii++; ii1++; ii2++; ii3++; ii4++; ii5++;ii77++;ii66++;



            }



//            if(MM.equals("0")){
//              // Toast.makeText(Watting_u.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
//                h="قيد التنفيذ";
//
//            }else if(MM!="0")
//            {
//              // Toast.makeText(Watting_u.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
//                h=N;
//            }

            //Toast.makeText(Watting_u.this, "Position: " + M, Toast.LENGTH_SHORT).show();









            ListAdapter adapter = new SimpleAdapter(Watting_u.this, personList, R.layout.list_item4, new String[]{G,H,K,L,N,J,h21,h22},


                    new int[]{R.id.textViewTitle,R.id.textView19,R.id.textView21,R.id.textViewTitle1,R.id.textView23,R.id.textView30,R.id.textView53,
                            R.id.textView18


                    }


            );



            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        if(vl>0 )
        {
            // Toast.makeText(Driver.this, "Position: " + vl, Toast.LENGTH_SHORT).show();
            //  etUserName.setVisibility(View.GONE);

            al();
        }else
        {

            // Toast.makeText(Driver.this, "Position: " + vl, Toast.LENGTH_SHORT).show();

            etUserName.setVisibility(View.VISIBLE);
            etUserName.setText("لا توجد حتي الان ");

        }

    }


    public void getData(){
        class GetDataJSON extends AsyncTask<String, Void, String> {
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

            //  HttpGet httppost=new HttpGet("http://tagogx.000webhostapp.com/files/adv_ok_show.php");




                HttpGet  httppost=null;

if(aa3.equals("user")){

    httppost = new HttpGet("http://sultantec.com/files/req_ok_show.php?id="+aa0+"&id2="+aa2+"&id3="+"go"+"&id4="+aa3);

}else if(aa3.equals("driver"))
{

    httppost = new HttpGet("http://sultantec.com/files/req_ok_show.php?id="+aa0+"&id2="+aa2+"&id3="+aa1+"&id4="+aa3);

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
                    showList();
                   // etUserName.setVisibility(View.GONE);
                }
                else {
                    mSwipeRefreshLayout.setRefreshing(false);
                    Pbar.setVisibility(View.GONE);
                    etUserName.setVisibility(View.VISIBLE);
                }
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }


    public void al()
    {
        etUserName.setVisibility(View.GONE);

    }
















    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }


    public void CustomDialog(){

        dialog = new Dialog(Watting_u.this);
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
                Intent al = new Intent(Watting_u.this, Requst_t.class);
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
                Intent al = new Intent(Watting_u.this, New_gi.class);
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




    public void CustomDialog2() {

        dialog = new Dialog(Watting_u.this);
        // it remove the dialog title
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set the laytout in the dialog
        dialog.setContentView(R.layout.dialogbox);
        // set the background partial transparent
       // dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        //  Window window = dialog.getWindow();
        ///  WindowManager.LayoutParams param = window.getAttributes();
        // set the layout at right bottom
        /// param.gravity = Gravity.NO_GRAVITY | Gravity.RIGHT;
        // it dismiss the dialog when click outside the dialog frame
        //  dialog.setCanceledOnTouchOutside(true);
        // initialize the item of the dialog box, whose id is demo1


        View demodialog = (View) dialog.findViewById(R.id.cross);
        // it call when click on the item whose id is demo1.
        demodialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // diss miss the dialog
                dialog.dismiss();
            }
        });


        View demodialog22 = (View) dialog.findViewById(R.id.demotext4);
        // it call when click on the item whose id is demo1.
        demodialog22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // diss miss the dialog
                dialog.dismiss();
AA2="no";
            //Toast.makeText(Watting_u.this,"driver: "+AA22, Toast.LENGTH_SHORT).show();

                AA2r="no";


              signupj();
            }
        });


        View demodialog223 = (View) dialog.findViewById(R.id.demotext5);
        // it call when click on the item whose id is demo1.
        demodialog223.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                AA2="yes";
              // Toast.makeText(Watting_u.this,"driver: "+AA22, Toast.LENGTH_SHORT).show();
                AA2r="yes";


               signupj();







            }
        });


        // it show the dialog box
        dialog.show();

    }










    public void user_call() {

        final Dialog dialog = new Dialog(Watting_u.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogbox2);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);



        //  TextView dialogButtonct = (TextView) dialog.findViewById(R.id.name2);


        // dialogButtonct.setText(nnu);


        Button dialogButtonc = (Button) dialog.findViewById(R.id.demotext5);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


                try {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + nnu));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }
            }
        });


        Button dialogButtonc2 = (Button) dialog.findViewById(R.id.demotext4);
        // if button is clicked, close the custom dialog
        dialogButtonc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


                dialog.dismiss();
                AA2="delu";
                //Toast.makeText(Watting_u.this,"driver: "+AA22, Toast.LENGTH_SHORT).show();

                AA2r="no";


                signupj();
            }
        });

        // it show the dialog box
        dialog.show();

    }














    public void driver_call() {

        final Dialog dialog = new Dialog(Watting_u.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogbox3);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);



        //  TextView dialogButtonct = (TextView) dialog.findViewById(R.id.name2);


        // dialogButtonct.setText(nnu);


        Button dialogButtonc = (Button) dialog.findViewById(R.id.demotext5);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


                try {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + nnd));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }
            }
        });


        Button dialogButtonc2 = (Button) dialog.findViewById(R.id.demotext4);
        // if button is clicked, close the custom dialog
        dialogButtonc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


                dialog.dismiss();
                AA2="deld";
                //Toast.makeText(Watting_u.this,"driver: "+AA22, Toast.LENGTH_SHORT).show();

                AA2r="no";


                signupj();
            }
        });



        dialog.show();


    }



















    public void driver_reg() {

        final Dialog dialog = new Dialog(Watting_u.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogbox4);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);



        //  TextView dialogButtonct = (TextView) dialog.findViewById(R.id.name2);


        // dialogButtonct.setText(nnu);


        Button dialogButtonc = (Button) dialog.findViewById(R.id.demotext4);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


            }
        });


        Button dialogButtonc2 = (Button) dialog.findViewById(R.id.demotext5);
        // if button is clicked, close the custom dialog
        dialogButtonc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


                dialog.dismiss();
                AA2="deld";
                //Toast.makeText(Watting_u.this,"driver: "+AA22, Toast.LENGTH_SHORT).show();

                AA2r="no";


                signupj();
            }
        });



        dialog.show();


    }








    public void user_reg() {

        final Dialog dialog = new Dialog(Watting_u.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogbox4);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);



        //  TextView dialogButtonct = (TextView) dialog.findViewById(R.id.name2);


        // dialogButtonct.setText(nnu);


        Button dialogButtonc = (Button) dialog.findViewById(R.id.demotext4);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();


            }
        });


        Button dialogButtonc2 = (Button) dialog.findViewById(R.id.demotext5);
        // if button is clicked, close the custom dialog
        dialogButtonc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


                dialog.dismiss();
                AA2="delu";
                //Toast.makeText(Watting_u.this,"driver: "+AA22, Toast.LENGTH_SHORT).show();

                AA2r="no";


                signupj();
            }
        });



        dialog.show();


    }



    public void signupj() {


        ///aa = getIntent().getStringExtra("g1");
        // aa = etUserName23.getText().toString();

        //  Toast.makeText(Users_info.this, "Position: " + aa, Toast.LENGTH_SHORT).show();


        new Watting_u.SignupActivitydaj(this).execute(AA21, AA2,AA22);

    }




    public class SignupActivitydaj extends AsyncTask<String, Void, String> {


        private Context context;


        public SignupActivitydaj(Context context) {
            this.context = context;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(Watting_u.this,
                    "جاري ...", "ارسال البيانات", false, false);
        }

        @Override
        protected String doInBackground(String... arg0) {
            String name = arg0[0];
            String phone = arg0[1];
            String phone2 = arg0[2];

            String link = null;
            String data;
            BufferedReader bufferedReader;
            String result;

            try {

                data = "?a=" + URLEncoder.encode(name, "UTF-8");
                data += "&b=" + URLEncoder.encode(phone, "UTF-8");
                data += "&c=" + URLEncoder.encode(phone2, "UTF-8");
                ////ltgani motsim altgani yosif


                String bb0 = getIntent().getStringExtra("d");

                String url2= "http://sultantec.com/files/dell.php";

                link =url2+data;


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



                        if(AA2r.equals("yes"))
                        {
                            buclickd();

                        }else if(AA2r.equals("no")){


                            buclickd2();

                        }



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
                .setCancelable(false)
                .setMessage("تمت العملية بنجاح")
                .setTitle("تمت العملية ")
                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mProgressDialog.dismiss();


                    }



                }).setNegativeButton("", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                mProgressDialog.dismiss();
            }

        }).show();
    }





    public void buclickd2() {
        mProgressDialog.dismiss();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.wwe2)
                .setCancelable(false)

                .setTitle("تمت العملية ")
                .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mProgressDialog.dismiss();


                    }



                }).setNegativeButton("", new DialogInterface.OnClickListener() {
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


                        aa = getIntent().getStringExtra("g1");


                        new Watting_u.SignupActivitydaj(getApplicationContext()).execute(AA21, AA2,AA22);


                    }
                }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                mProgressDialog.dismiss();


            }

        }).show();

    }




    public void driver_call2() {

        final Dialog dialog = new Dialog(Watting_u.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_driver_no);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);


        TextView dialogButtonct = (TextView) dialog.findViewById(R.id.name2);


        dialogButtonct.setText(nnd);





        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                try {


                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + nnd));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }
            }
        });
        dialog.show();


    }





}
