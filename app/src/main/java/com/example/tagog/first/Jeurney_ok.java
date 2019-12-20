package com.example.tagog.first;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

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

public class Jeurney_ok extends AppCompatActivity {
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
    private static final String J = "J";
    private static final String K = "K";
    private static final String L ="L";
    private static final String M = "M";
    private static final String N ="N";
//    private static final String O ="O";
    String DE;

    String GH;
    int vl;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeurney_ok);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();


                CustomDialog();



            }
        });*/


















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

            final String[] anArray9;
            final String[] anArray10;
            final String[] anArray11;
            final String[] anArray12;
            final String[] anArray13;
            final String[] anArray14;

            anArray = new String[peoples.length()];
            anArray1 = new String[peoples.length()];
            anArray2 = new String[peoples.length()];
            anArray3 = new String[peoples.length()];
            anArray4 = new String[peoples.length()];
            anArray5 = new String[peoples.length()];
            anArray6 = new String[peoples.length()];
            anArray7 = new String[peoples.length()];
            anArray8 = new String[peoples.length()];

            anArray9 = new String[peoples.length()];
            anArray10 = new String[peoples.length()];
            anArray11 = new String[peoples.length()];
            anArray12 = new String[peoples.length()];
            anArray13 = new String[peoples.length()];
            anArray14 = new String[peoples.length()];

            int ii=0; int ii1=0; int ii2=0; int ii3=0; int ii4=0; int ii5=0; int ii6=0; int ii7=0; int ii8=0; int ii9=0; int ii10=0; int ii11=0; int ii12=0; int ii13=0; int ii14=0;
            personList.clear();
            int v=peoples.length()-1;
            vl=peoples.length();
            for(int i=v;i>=0;i--){
                JSONObject c = peoples.getJSONObject(i);
                String AA = c.getString(A);
                String BB = c.getString(B);
                String CC = c.getString(C);
                String DD = c.getString(D);

                //+"من: ";
                String EE = c.getString(E);
                String FF = c.getString(F);
                String GG = c.getString(G);
                String HH= c.getString(H);
                String II= c.getString(I)+"راس مطلوب نقلها";
                String JJ = c.getString(J);
                String KK = c.getString(K);
                String LL= c.getString(L)+" راس";


                String MM=c.getString(M);
                String NN = "س:"+c.getString(N);
              //  String OO = c.getString(O);



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

                        String count9=anArray9[positiona];
                        String count10=anArray10[positiona];
                        String count11=anArray11[positiona];
                        String count12=anArray12[positiona];
                        String count13=anArray13[positiona];
                        String count14=anArray14[positiona];



                        //  String listPositiond = String.valueOf(parent.getItemAtPosition(positiona));
                        // Toast.makeText(Driver.this, "Position: " + count, Toast.LENGTH_SHORT).show();
                        Intent alvvwefrerxx = new Intent(Jeurney_ok.this, Req_done.class);
                        alvvwefrerxx.putExtra("g1", count); alvvwefrerxx.putExtra("g2", count1); alvvwefrerxx.putExtra("g3", count2);
                        alvvwefrerxx.putExtra("g4", count3); alvvwefrerxx.putExtra("g5", count4); alvvwefrerxx.putExtra("g6", count5);
                        alvvwefrerxx.putExtra("g7", count6); alvvwefrerxx.putExtra("g8", count7); alvvwefrerxx.putExtra("g9", count8);
                        alvvwefrerxx.putExtra("g10", count9); alvvwefrerxx.putExtra("g11", count10); alvvwefrerxx.putExtra("g12", count11);
                        alvvwefrerxx.putExtra("g13", count12); alvvwefrerxx.putExtra("g14", count13);alvvwefrerxx.putExtra("g15", count14);


                        //   alvvwefrerxx.putExtra("g10", aa0);alvvwefrerxx.putExtra("g11", bb0);


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
                persons.put(J,JJ);
                persons.put(K,KK);
                persons.put(L,LL);
                persons.put(M,MM);
                persons.put(N,NN);
              //  persons.put(O,OO);


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

                anArray9[ii9] = c.getString(J);
                anArray10[ii10] = c.getString(K);
                anArray11[ii11] = c.getString(L);
                anArray12[ii12] = c.getString(M);
                anArray13[ii13] = c.getString(N);
                anArray14[ii14] = c.getString(I);
              //  anArray14[ii14] = c.getString(O);

                ii++; ii1++; ii2++; ii3++; ii4++; ii5++; ii6++; ii7++; ii8++; ii9++; ii10++; ii11++; ii12++; ii13++; ii14++;



            }


            ListAdapter adapter = new SimpleAdapter(Jeurney_ok.this, personList, R.layout.list_item44, new String[]{G,H,K,J,I},


                    new int[]{R.id.textViewTitle,R.id.textView19,R.id.textView21,R.id.textViewTitle1,R.id.textView23



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
            etUserName.setText("لا توجد طلبات من هذة المدينة ");

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


                HttpGet httppost=new HttpGet("http://sultantec.com/files/getdonej.php");




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

                    Pbar.setVisibility(View.GONE);
                    list.setVisibility(View.VISIBLE);
                    showList();
                    // etUserName.setVisibility(View.GONE);
                }
                else {

                    Pbar.setVisibility(View.GONE);
                    etUserName.setVisibility(View.VISIBLE);
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

    }



    public void buclickd() {

        final Dialog dialog = new Dialog(Jeurney_ok.this);
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
                Intent alvvwefrerxx = new Intent(Jeurney_ok.this, Login.class);
                startActivity(alvvwefrerxx);
                finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });
        dialog.show();


    }



    public void al()
    {
        etUserName.setVisibility(View.GONE);

    }


    public void CustomDialog(){

        dialog = new Dialog(Jeurney_ok.this);
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
                Intent al = new Intent(Jeurney_ok.this, Requst_t.class);
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
                Intent al = new Intent(Jeurney_ok.this, New_gi.class);
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
}
