package com.example.tagog.first;

        import android.app.Dialog;
        import android.app.ProgressDialog;
        import android.content.ActivityNotFoundException;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.graphics.drawable.ColorDrawable;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v4.widget.SwipeRefreshLayout;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.util.Log;
        import android.view.View;
        import android.view.Window;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.ProgressBar;
        import android.os.AsyncTask;
        import android.widget.AdapterView;
        import android.widget.ListAdapter;

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

public class Watting extends AppCompatActivity {
    public Dialog dialog;
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
    private static final String N ="N";
    private static final String O ="O";

    String nnu;
    String nnd;
String II;



   String AA21, AA2,AA22,AA211,pand;

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

    String aa00;
    String aa11;
    String aa22;
    String aa223;

    String count;
    SwipeRefreshLayout     mSwipeRefreshLayout;


    String watting ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watting);



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

        aa00 = getIntent().getStringExtra("g");
        aa11 = getIntent().getStringExtra("h");



        aa22 = getIntent().getStringExtra("i");

        aa223 = getIntent().getStringExtra("j");



        TextView a=(TextView)findViewById(R.id.textView44);


        a.setText("كل الرحلات:");




        Button  etUserName225 = (Button) findViewById(R.id.button222);
        etUserName225.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

                TextView a=(TextView)findViewById(R.id.textView44);

                a.setText("رحلات قيد الاتفاق:");
                aa00 = getIntent().getStringExtra("g");
                aa11 = getIntent().getStringExtra("h");
                aa223 = getIntent().getStringExtra("j");

                aa22 = "0";

getData();

            }
        });




        Button  etUserName2255 = (Button) findViewById(R.id.button44);
        etUserName2255.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

TextView a=(TextView)findViewById(R.id.textView44);

                a.setText("رحلات اكتملت:");

                aa00 = getIntent().getStringExtra("g");
                aa11 = getIntent().getStringExtra("h");
                aa223 = getIntent().getStringExtra("j");

                aa22 = "1";

getData();

            }
        });





        Button  etUserName22551 = (Button) findViewById(R.id.button441);
        etUserName22551.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

                TextView a=(TextView)findViewById(R.id.textView44);

                a.setText("كل الرحلات:");

                aa00 = getIntent().getStringExtra("g");
                aa11 = getIntent().getStringExtra("h");
                aa223 = getIntent().getStringExtra("j");

                aa22 = "4";

                getData();

            }
        });






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                ///.setAction("Action", null).show();
//                onBackPressed();
//            }
//        });




        String aa0 = getIntent().getStringExtra("g");
        String aa1 = getIntent().getStringExtra("h");
        String aa2 = getIntent().getStringExtra("i");


       // String aa0 = getIntent().getStringExtra("g");
       // String aa1 = getIntent().getStringExtra("h");
     // Toast.makeText(Watting.this, "Position: " + aa0+aa1+aa2,Toast.LENGTH_SHORT).show();








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


            final String[] anArray66;
            final String[] anArray77;

            final String[] anArray6;
            final String[] anArray7;
            final String[] anArray8;
            anArray = new String[peoples.length()];
            anArray1 = new String[peoples.length()];
            anArray2 = new String[peoples.length()];
            anArray3 = new String[peoples.length()];
            anArray4 = new String[peoples.length()];
            anArray5 = new String[peoples.length()];


            anArray66 = new String[peoples.length()];
            anArray77 = new String[peoples.length()];




            anArray6 = new String[peoples.length()];
            anArray7 = new String[peoples.length()];
            anArray8 = new String[peoples.length()];

            int ii=0; int ii1=0; int ii2=0; int ii3=0; int ii4=0; int ii5=0;int ii77=0;int ii66=0;
            personList.clear();
            int v=peoples.length()-1;
            vl=peoples.length();
            for(int i=v;i>=0;i--){
                JSONObject c = peoples.getJSONObject(i);
                String AA = c.getString(A);
                String BB = c.getString(B);
              String CC = c.getString(C);
                String DD="خن";

                if(aa223.equals("user")) {
                  DD = " طلبت نقل " + c.getString(D) + " راس ";
                } else if (aa223.equals("driver")) {
                  DD = " مطلوب منك نقل " + c.getString(D) + " راس ";
                }
                //+"من: ";



                String EE = c.getString(E);
                String FF = c.getString(F);
                String  GG = c.getString(G);
                String HH= c.getString(H);
              II= c.getString(I);
                String JJ = c.getString(J);
                String KK = c.getString(K);
                String LL="سعة الناقله"+ c.getString(L)+" راس";
                String MM="التحرك:"+c.getString(M);
                String NN = c.getString(N);
                String OO = c.getString(O);






                anArray5[ii5]=II;

                anArray1[ii4]=FF;



                anArray66[ii66]=CC;

                anArray77[ii77]=GG;


                watting="مرفوضة";

               // Toast.makeText(Watting.this, "Position: " +  II+aa223, Toast.LENGTH_SHORT).show();


                if( anArray5[ii5].equals("0") && aa223.equals("user")){


                    EE="في انتظار الرد";
                    watting="";

                }else if(( anArray5[ii5].equals("0") && aa223.equals("driver")))
                {
                    //  Toast.makeText(Watting_u.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
                    EE="في انتظار ردك";
                    watting="";
                    // h21="";
                }
                else if(( anArray5[ii5].equals("3") && aa223.equals("user")))
                {
               //   Toast.makeText(Watting.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
                 //   NN = "تم رفض :"+c.getString(N)+" ريال للراس الواحد ";
                    // h2=LL;
               // EE="";

                    EE="* تم رفض حجزك";
                }

                else if((anArray5[ii5].equals("3") && aa223.equals("driver")))
                {
                    //  Toast.makeText(Watting_u.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
                 //   NN = "تم رفض :"+c.getString(N)+" ريال للراس الواحد ";
                   // EE="";
                    EE="* مرفوضة";
                    // h21="";
                }
                else if(( anArray5[ii5].equals("1") && aa223.equals("user")))
                {
                    //  Toast.makeText(Watting_u.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
                    // h21="تم الاتفاق";
                    watting="";
                    EE="تمت الموافقة";
                }

                else if((anArray5[ii5].equals("1") && aa223.equals("driver")))
                {
                    watting="";
                    //  Toast.makeText(Watting_u.this, "Position: " + MM, Toast.LENGTH_SHORT).show();
                    EE="تم الاتفاق";


                }






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






                HashMap<String,String> persons = new HashMap<String,String>();
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int positiona, long id) {

                        // String listPosition=String.valueOf(parent.getItemIdAtPosition(positiona));





                        AA21=anArray[positiona];


                        AA22=anArray1[positiona];



//                        String count2=anArray2[positiona];


                    pand=anArray3[positiona];


//                        String count4=anArray4[positiona];
                          AA211=anArray5[positiona];




                        nnu=anArray66[positiona];

                        nnd=anArray77[positiona];


                        // count=anArray[positiona];


//                        String count1=anArray1[positiona];
//                        String count2=anArray2[positiona];
//                        String count3=anArray3[positiona];
//                        String count4=anArray4[positiona];
//                        String count5=anArray5[positiona];
//                        String count6=anArray6[positiona];
//                        String count7=anArray7[positiona];
//                        String count8=anArray8[positiona];

                        String aa0 = getIntent().getStringExtra("go1");
                        String bb0 = getIntent().getStringExtra("go2");



                     //   Toast.makeText(Watting.this,  AA211, Toast.LENGTH_LONG).show();



                        if( AA211.equals("0") && aa223.equals("user")){

                            Toast.makeText(Watting.this, "هذة الرحلة في انتظار رد صاحبها", Toast.LENGTH_LONG).show();

                        }else if( AA211.equals("0") && aa223.equals("driver"))
                        {
                            CustomDialog2();
                        }

                        else if( AA211.equals("1") && aa223.equals("user"))
                        {
                       //    Toast.makeText(Watting.this,nnd, Toast.LENGTH_LONG).show();
                            driver_call();
                        }
                        else if( AA211.equals("1") && aa223.equals("driver"))
                        {
                  //      Toast.makeText(Watting.this, nnu, Toast.LENGTH_LONG).show();

                            user_call();
                        }

                        else if( AA211.equals("3") && aa223.equals("user"))
                        {
                           user_reg();
                        }
                        else if( AA211.equals("3") && aa223.equals("driver"))
                        {
                            driver_reg();
                        }

                        //  String listPositiond = String.valueOf(parent.getItemAtPosition(positiona));
                        // Toast.makeText(Driver.this, "Position: " + count, Toast.LENGTH_SHORT).show();
                       /* Intent alvvwefrerxx = new Intent(Watting.this, Show_requst_ditils.class);
                        alvvwefrerxx.putExtra("g1", count); alvvwefrerxx.putExtra("g2", count1); alvvwefrerxx.putExtra("g3", count2);
                        alvvwefrerxx.putExtra("g4", count3); alvvwefrerxx.putExtra("g5", count4); alvvwefrerxx.putExtra("g6", count5);
                        alvvwefrerxx.putExtra("g7", count6); alvvwefrerxx.putExtra("g8", count7); alvvwefrerxx.putExtra("g9", count8);
                        alvvwefrerxx.putExtra("g10", aa0);alvvwefrerxx.putExtra("g11", bb0);
                        startActivity(alvvwefrerxx);
                        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);*/
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
              persons.put(O,OO);
          persons.put(watting,watting);



                personList.add(persons);


                anArray[ii] = c.getString(A);
                anArray1[ii1] = c.getString(F);
                anArray2[ii2] = c.getString(C);

                anArray3[ii3] = c.getString(D);


                anArray4[ii4] = c.getString(E);
                anArray5[ii5] = c.getString(I);
//
                anArray66[ii66] = c.getString(C);

                anArray77[ii77] = c.getString(G);
//

                ii++; ii1++; ii2++; ii3++; ii4++; ii5++; ii66++; ii77++;



            }


            ListAdapter adapter = new SimpleAdapter(Watting.this, personList, R.layout.list_item5, new String[]{J,K,N,M,L,D,E,watting},


                    new int[]{R.id.textViewTitle,R.id.textView19,R.id.textView21,R.id.textViewTitle1,R.id.textView23,R.id.textView33,R.id.textView47,
                            R.id.textView45

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

                if(aa223.equals("user")){

                    httppost = new HttpGet("http://sultantec.com/files/adv_ok_show.php?id="+aa00+"&id2="+aa11+"&id3="+aa22+"&id4="+aa223);

                }else if(aa223.equals("driver"))
                {

                    httppost =  new HttpGet("http://sultantec.com/files/adv_ok_show.php?id="+aa00+"&id2="+aa11+"&id3="+aa22+"&id4="+ aa223);

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

        dialog = new Dialog(Watting.this);
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
                Intent al = new Intent(Watting.this, Requst_t.class);
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
                Intent al = new Intent(Watting.this, New_gi.class);
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

        dialog = new Dialog(Watting.this);
        // it remove the dialog title
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set the laytout in the dialog
        dialog.setContentView(R.layout.dialogboxdell);
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
             //  Toast.makeText(Watting.this,"driver: "+AA21+AA22, Toast.LENGTH_SHORT).show();


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
                signupj();

                //Toast.makeText(Watting.this,"driver: "+AA21+AA22, Toast.LENGTH_SHORT).show();







            }
        });


        // it show the dialog box
        dialog.show();

    }



    public void user_call() {

        final Dialog dialog = new Dialog(Watting.this);
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
                AA2="deld";
                //Toast.makeText(Watting_u.this,"driver: "+AA22, Toast.LENGTH_SHORT).show();

                signupj();
            }
        });

        // it show the dialog box
        dialog.show();

    }





    public void driver_call() {

        final Dialog dialog = new Dialog(Watting.this);
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
                AA2="delu";
                //Toast.makeText(Watting_u.this,"driver: "+AA22, Toast.LENGTH_SHORT).show();

                signupj();
            }
        });

        // it show the dialog box
        dialog.show();

    }













    public void driver_reg() {

        final Dialog dialog = new Dialog(Watting.this);
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




                signupj();
            }
        });



        dialog.show();


    }








    public void user_reg() {

        final Dialog dialog = new Dialog(Watting.this);
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




                signupj();
            }
        });



        dialog.show();


    }



    public void signupj() {


        ///aa = getIntent().getStringExtra("g1");
        // aa = etUserName23.getText().toString();

     // Toast.makeText(Watting.this, AA21+"..."+AA2+"..."+AA22+"..."+pand, Toast.LENGTH_SHORT).show();



       new Watting.SignupActivitydaj(this).execute(AA21,AA2,AA22,pand);

        

    }




    public class SignupActivitydaj extends AsyncTask<String, Void, String> {


        private Context context;


        public SignupActivitydaj(Context context) {
            this.context = context;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(Watting.this,
                    "جاري ...", "ارسال البيانات", false, false);
        }

        @Override
        protected String doInBackground(String... arg0) {
            String name = arg0[0];
            String phone = arg0[1];
            String phone2 = arg0[2];
            String phone3= arg0[3];

            String link = null;
            String data;
            BufferedReader bufferedReader;
            String result;

            try {

                data = "?a=" + URLEncoder.encode(name, "UTF-8");
                data += "&b=" + URLEncoder.encode(phone, "UTF-8");
                data += "&c=" + URLEncoder.encode(phone2, "UTF-8");
                data += "&d=" + URLEncoder.encode(phone3, "UTF-8");
                ////ltgani motsim altgani yosif


                String bb0 = getIntent().getStringExtra("d");

                String url2= "http://sultantec.com/files/dell2.php";

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
                .setTitle("تمت العملية بنجاح")
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


                       // aa = getIntent().getStringExtra("g1");


                        new Watting.SignupActivitydaj(getApplicationContext()).execute(AA21, AA2,AA22,pand);


                    }
                }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                mProgressDialog.dismiss();


            }

        }).show();

    }





//
//    public void driver_call() {
//
//        final Dialog dialog = new Dialog(Watting.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.custom_driver_no);
//        // dialog.setTitle("خروج من التطبيق");
//        // set the custom dialog components - text, image and button
//        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
//        //  image.setImageResource(R.drawable.ic_launcher);
//
//
//        TextView dialogButtonct = (TextView) dialog.findViewById(R.id.name2);
//
//
//        dialogButtonct.setText(nnd);
//
//
//
//
//
//        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
//        // if button is clicked, close the custom dialog
//        dialogButtonc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//
//                try {
//
//
//                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
//                    callIntent.setData(Uri.parse("tel:" + nnd));
//                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(callIntent);
//                } catch (ActivityNotFoundException activityException) {
//                    Log.e("Calling a Phone Number", "Call failed", activityException);
//                }
//            }
//        });
//        dialog.show();
//
//
//    }




//    public void user_call() {
//
//        final Dialog dialog = new Dialog(Watting.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.custom_aoutapp);
//        // dialog.setTitle("خروج من التطبيق");
//        // set the custom dialog components - text, image and button
//        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
//        //  image.setImageResource(R.drawable.ic_launcher);
//
//
//
//        TextView dialogButtonct = (TextView) dialog.findViewById(R.id.name2);
//
//
//        dialogButtonct.setText(nnu);
//
//        Button dialogButtonc = (Button) dialog.findViewById(R.id.app);
//        // if button is clicked, close the custom dialog
//        dialogButtonc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//
//
//                try {
//
//
//                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
//                    callIntent.setData(Uri.parse("tel:" + nnu));
//                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(callIntent);
//                } catch (ActivityNotFoundException activityException) {
//                    Log.e("Calling a Phone Number", "Call failed", activityException);
//                }
//            }
//        });
//        dialog.show();
//
//
//    }

}
