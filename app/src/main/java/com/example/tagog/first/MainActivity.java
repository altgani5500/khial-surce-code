package com.example.tagog.first;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.GridView;
import android.widget.LinearLayout;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;

import android.view.Gravity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

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
import java.util.List;
import java.util.Locale;

import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.tagog.first.R.id.linearLayout;

public class MainActivity extends Activity
        implements NavigationView.OnNavigationItemSelectedListener {

    // FrameLayout simpleFrameLayout;
//boolean flag to know if main FAB is in open or closed state.
    private boolean fabExpanded = false;
    private FloatingActionButton fabSettings;

    int vl;
    private static final int MY_SOCKET_TIMEOUT_MS = 10000;
    private Button etUserName2;
    private Button etUserName22;
    Spinner a;
    public Dialog dialog;
    private ProgressDialog mProgressDialog;
    String myJSON;
    private static final String TAG_RESULTS = "result";
    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";
    private static final String D = "D";
    private static final String E = "E";
    private static final String F = "F";
    private static final String G = "G";
    private static final String H = "H";
    private static final String I = "I";
    private static final String J = "J";

    private static final String K = "K";
    String DE;

    String GH;

    String NO;

    ProgressBar Pbar;
    // private TextView etFullName;

    private Button etUserName;
    private Button etUserName23;
    private Button etUserName234;
    private Button etUserName225;
    Spinner from;
    JSONArray peoples = null;





    ArrayList<HashMap<String, String>> personList;

    ListView list;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    String from1;
    SharedPreferences settings = null;
    private String mUsername;
    private String mUsername2;
    SwipeRefreshLayout mSwipeRefreshLayout;
    EditText editsearch;
    SearchView sv;
public  static String name_temp;
    public  static String phone_temp;
  LinearLayout ser;
    Button  etUserName2342;
    int sern=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
dothis();

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


        settings = getSharedPreferences("BISC", 0);


        mUsername = settings.getString("phone", "44");
        mUsername2 = settings.getString("name", "44");


        // Toast.makeText(this, mUsername+mUsername2, Toast.LENGTH_SHORT).show();

//        TextView wwww = (TextView) findViewById(R.id.textView18);
//        wwww.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View vv) {
//                getData();
//            }
//        });


        // Toast.makeText(MainActivity.this, "Position: " +mUsername+mUsername2, Toast.LENGTH_SHORT).show();


        from = (Spinner) findViewById(R.id.button2);

        from1 = from.getSelectedItem().toString();

        etUserName2 = (Button) findViewById(R.id.button4);
        etUserName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                from1 = from.getSelectedItem().toString();
                //   finish();
                //  startActivity(getIntent());


                getData();
                etUserName.setVisibility(View.GONE);


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

                if (!from1.equals("حدد مكان التحرك")) {

                    getData();
                    etUserName.setVisibility(View.GONE);

                } else if (from1.equals("حدد مكان التحرك") ) {

                    Toast.makeText(MainActivity.this, "قم بتحديد مكان التحرك", Toast.LENGTH_SHORT).show();
                }


            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


        etUserName23 = (Button) findViewById(R.id.button44);
        etUserName23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

                Intent al = new Intent(MainActivity.this, Add_j3.class);
                //  String bb = getIntent().getStringExtra("go2");

//                al.putExtra("phone", mUsername);
//                al.putExtra("name", mUsername2);

//                String aa1 = getIntent().getStringExtra("phone");
//                String bb1 = getIntent().getStringExtra("name");


                String bb2 = "0";
                String bb3 = "user";




                String name_go="";
                String phone_go="";



               // Toast.makeText(MainActivity.this,name_temp+phone_temp, Toast.LENGTH_SHORT).show();


//
//                if(mUsername=="44" && mUsername2=="44"){
//      name_go =name_temp;
//     phone_go = phone_temp;
//}else if(mUsername!="44" && mUsername2!="44"){
//
//                    name_go =mUsername;
//                    phone_go = mUsername2;
//
//                }


                al.putExtra("phone", mUsername);
                al.putExtra("name", mUsername2);
                al.putExtra("id", bb2);
                al.putExtra("st", bb3);

                startActivity(al);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

            }
        });


        etUserName234 = (Button) findViewById(R.id.button222);
        etUserName234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {

                Intent al = new Intent(MainActivity.this, News.class);
                startActivity(al);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

            }
        });


        list = (ListView) findViewById(R.id.listView2);

        personList = new ArrayList<HashMap<String, String>>();

        Pbar = (ProgressBar) findViewById(R.id.progressBar1);

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


     Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

      /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        // set Click listener
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // creating custom Floating Action button
                CustomDialog();
            }
        });*/










       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent al = new Intent(MainActivity.this, Requst_t.class);
                startActivity(al);


              //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       // .setAction("Action", null).show();
                         });
            }*/


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // drawer.openDrawer(GravityCompat.START);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


        etUserName225 = (Button) findViewById(R.id.button28);
        etUserName225.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                //    getData();
                //   etUserName.setVisibility(View.GONE);

                //  drawer.openDrawer(GravityCompat.START);
                getData();
            }
        });
    }

    protected void showList() {
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
            int ii = 0;
            int ii1 = 0;
            int ii2 = 0;
            int ii3 = 0;
            int ii4 = 0;
            int ii5 = 0;
            int ii6 = 0;
            int ii7 = 0;
            int ii8 = 0;
            int ii9 = 0;
            personList.clear();
            int v = peoples.length() - 1;
            vl = peoples.length();

            for (int i = v; i >= 0; i--) {
                JSONObject c = peoples.getJSONObject(i);
                String AA = "  #رحلة رقم " + c.getString(A);
                String BB = c.getString(B);
                String CC = c.getString(C);
                String DD = c.getString(D);

                //+"من: ";
                String EE = c.getString(E);
                String FF = "سعة الناقله:" + c.getString(F) + " راس";
                String GG =  c.getString(G);
                String HH = "ساعة التحرك:" + c.getString(H);
                String II = c.getString(I);
                String JJ = c.getString(J);

                String KK = c.getString(K);


                //  String  DE="من"+DD+"الي"+EE;

                //  String GH=GG+"س:"+HH;

                //   String  NO="راس"+FF;


                // String DD2 ="من"+c.getString(D)+"الي"+c.getString(E);
                // String GG2 ="من"+c.getString(G)+"الي"+c.getString(H);


                HashMap<String, String> persons = new HashMap<String, String>();
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int positiona, long id) {

                        // String listPosition=String.valueOf(parent.getItemIdAtPosition(positiona));


                        String count = anArray[positiona];
                        String count1 = anArray1[positiona];
                        String count2 = anArray2[positiona];
                        String count3 = anArray3[positiona];
                        String count4 = anArray4[positiona];
                        String count5 = anArray5[positiona];
                        String count6 = anArray6[positiona];
                        String count7 = anArray7[positiona];
                        String count8 = anArray8[positiona];
                        String count9 = anArray9[positiona];

                        String aa0 = getIntent().getStringExtra("go1");
                        String bb0 = getIntent().getStringExtra("go2");

                        //  String listPositiond = String.valueOf(parent.getItemAtPosition(positiona));
                        // Toast.makeText(Driver.this, "Position: " + count, Toast.LENGTH_SHORT).show();
                        Intent alvvwefrerxx = new Intent(MainActivity.this, Show_detils.class);
                        alvvwefrerxx.putExtra("g1", count);
                        alvvwefrerxx.putExtra("g2", count1);
                        alvvwefrerxx.putExtra("g3", count2);
                        alvvwefrerxx.putExtra("g4", count3);
                        alvvwefrerxx.putExtra("g5", count4);
                        alvvwefrerxx.putExtra("g6", count5);
                        alvvwefrerxx.putExtra("g7", count6);
                        alvvwefrerxx.putExtra("g8", count7);
                        alvvwefrerxx.putExtra("g9", count8);
                        alvvwefrerxx.putExtra("gimage", count9);

                        alvvwefrerxx.putExtra("g10", aa0);
                        alvvwefrerxx.putExtra("g11", bb0);

                        alvvwefrerxx.putExtra("phone", mUsername);
                        alvvwefrerxx.putExtra("name", mUsername2);
                        startActivity(alvvwefrerxx);
                        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                    }

                });


                persons.put(A, AA);
                persons.put(B, BB);
                persons.put(C, CC);
                persons.put(D, DD);
                persons.put(E, EE);
                persons.put(F, FF);
                persons.put(G, GG);
                persons.put(H, HH);
                persons.put(I, II);
                persons.put(J, JJ);
                persons.put(K, KK);

                //
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
                ii++;
                ii1++;
                ii2++;
                ii3++;
                ii4++;
                ii5++;
                ii6++;
                ii7++;
                ii8++;
                ii9++;


            }

            final ListAdapter adapter = new SimpleAdapter(MainActivity.this, personList, R.layout.list_item3, new String[]{D, E, G, H, F, I, A},


                    new int[]{R.id.textViewTitle, R.id.textView19, R.id.textView2w, R.id.textView34, R.id.textView23, R.id.textView22, R.id.textView37


                    }


            );

            list.setAdapter(adapter);

            if (vl > 0) {
                // Toast.makeText(MainActivity.this, "Position: " + vl, Toast.LENGTH_SHORT).show();
                //  etUserName.setVisibility(View.GONE);

                al();
            } else {

                // Toast.makeText(MainActivity.this, "Position: " + vl, Toast.LENGTH_SHORT).show();

                etUserName.setVisibility(View.VISIBLE);

                etUserName.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

                etUserName.setText("لا توجد رحلات من هذة المنطقة");

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void getData() {
        class GetDataJSON extends AsyncTask<String, Void, String> {
            protected void onPreExecute() {


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


                HttpGet httppost = new HttpGet("http://sultantec.com/files/req_show.php");


                String strrt = from1;

                // String strrt = getIntent().getStringExtra("sr");
              if (strrt.equals("الكل")) {

                    httppost = new HttpGet("http://sultantec.com/files/req_show.php");

                }else if (strrt.equals("حدد مكان التحرك")) {

                    httppost = new HttpGet("http://sultantec.com/files/req_show.php");

                }  else{

                    httppost = new HttpGet("http://sultantec.com/files/req_show.php?id=" + strrt);

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
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (Exception e) {
                    // Oops

                } finally {
                    try {
                        if (inputStream != null)
                            inputStream.close();
                    } catch (Exception squish) {

                    }
                }
                return result;
            }


            @Override
            protected void onPostExecute(String result) {
                myJSON = result;
                if (myJSON != null) {
                    mSwipeRefreshLayout.setRefreshing(false);
                    Pbar.setVisibility(View.GONE);
                    list.setVisibility(View.VISIBLE);
                    showList();

                    // etUserName.setVisibility(View.VISIBLE);
                } else {
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            // super.onBackPressed();
            buclickd();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.login) {
            Intent al = new Intent(MainActivity.this, Login.class);
            startActivity(al);
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
        } else if (id == R.id.singup) {
            Intent al = new Intent(MainActivity.this, Singup.class);
            startActivity(al);
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

        } else if (id == R.id.pro) {

            try {


                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + "0507772800"));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            } catch (ActivityNotFoundException activityException) {
                Log.e("Calling a Phone Number", "Call failed", activityException);
            }


        } else if (id == R.id.aboutapp) {
            app();
        } else if (id == R.id.aboutme) {
            me();
        } else if (id == R.id.aboutme2) {
            me2();
        } else if (id == R.id.exit) {

            buclickd();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void buclickd() {

        final Dialog dialog = new Dialog(MainActivity.this);
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

                finish();
                moveTaskToBack(true);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        dialog.show();


    }


    public void me() {

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_aboutme);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.me);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();


    }




    public void me2() {

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_aboutme2);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.me);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


                try {


                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + "0507772800"));
                    callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Log.e("Calling a Phone Number", "Call failed", activityException);
                }
            }
        });
        dialog.show();


    }


    public void app() {

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_aoutapp);
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


    //
    public void CustomDialog() {

        dialog = new Dialog(MainActivity.this);
        // it remove the dialog title
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set the laytout in the dialog
        dialog.setContentView(R.layout.dialogbox);
        // set the background partial transparent
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
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
                Intent al = new Intent(MainActivity.this, Requst_t.class);
                startActivity(al);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });


        View demodialog223 = (View) dialog.findViewById(R.id.demotext5);
        // it call when click on the item whose id is demo1.
        demodialog223.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // diss miss the dialog
                dialog.dismiss();
                Intent al = new Intent(MainActivity.this, Login.class);
                startActivity(al);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });


        // it show the dialog box
        dialog.show();

    }

    public void al() {
        etUserName.setVisibility(View.GONE);

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
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




































    public  void  dothis(){


        //     Toast.makeText(this, "im in ", Toast.LENGTH_SHORT).show();



        String url = "http://sultantec.com/files/new_v.php";



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

                    final String mtlob = no.getString("new_v");
                 //   final String plance = no.getString("plance");

                    // Toast.makeText(Driver.this, mtlob+plance, Toast.LENGTH_SHORT).show();
                    int result = Integer.parseInt(mtlob);

                    if(result>=2){
                        Log.e("url", "ok");
                        new_v();

//                        Intent al = new Intent(MainActivity.this, Count.class);
//
//
//                        al.putExtra("nocount","nocount");
//
//                        String aa1 = mUsername;
////
//                        String bb1 = mUsername2;
////
////                String bb2 = "4";
////                String bb3 = "driver";
////
//                        al.putExtra("phone", aa1); al.putExtra("loha", bb1);
//                        finish();
//                        startActivity(al);
//                        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
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







    public void new_v() {
        //    mProgressDialog.dismiss();
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.new_v);
        // dialog.setTitle("خروج من التطبيق");
        // set the custom dialog components - text, image and button
        //  ImageView image = (ImageView) dialog.findViewById(R.id.image);
        //  image.setImageResource(R.drawable.ic_launcher);

        Button dialogButtonc = (Button) dialog.findViewById(R.id.editText7);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent browserIntent = new Intent(
//                        Intent.ACTION_VIEW,
//                        Uri.parse("http://android.okhelp.cz/category/software/"));
//                startActivity(browserIntent);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.khialtransport.tagog.first"));
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.khialtransport.tagog.first"));
                }

            }
        });
        Button dialogButtonc2 = (Button) dialog.findViewById(R.id.editText10);
        // if button is clicked, close the custom dialog
        dialogButtonc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();

    }





}
