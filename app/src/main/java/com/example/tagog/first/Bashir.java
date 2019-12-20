package com.example.tagog.first;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.microedition.khronos.opengles.GL;



import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by BASHIR on cv/14/2018.
 */

public class Bashir {

    Context mContext;
    public Bashir() {
     this.mContext = mContext ;
    }

    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 10000;
    private static ProgressDialog progressDialog;
    private static AlertDialog alertDialog;


    public static  String getIP()
    {
       return "http://192.168.173.1:3000";
    }


    public static  boolean isConnect(Context mContext)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)mContext.getSystemService(mContext.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected())
            {
                return  true ;
            }
        }
        return false ;
    }



    public static boolean isGooglePlayServicesAvailable(Context mContext) {

        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(mContext);
        if(result == ConnectionResult.SUCCESS)
        {
            if(googleAPI.isUserResolvableError(result)) {
                googleAPI.getErrorDialog((Activity) mContext, result, 0).show();
            }
            return true;
        }else {
            return false;
        }
    }

    public static void ProgressDialog(Context context, String title, String message) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public static void ProgressDialogDismiss() {
        progressDialog.dismiss();
    }



    public static void buildDialog(Context context, String message)
    {

        //  int classes[] = {R.anim.up_fom_buttom, R.anim.from_bottom_to_up, R.anim.bounce_interpolator};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("");
        builder.setMessage(message);
        builder.setNegativeButton("OK", null);
        alertDialog = builder.create();
        // alertDialog.getWindow().getAttributes().windowAnimations = classes[1];
        alertDialog.show();

    }

    public void downloadURL2(final TextView textView , double lat1 , double lon1 , double lat2 , double lon2)
    {

        String url = "http://maps.googleapis.com/maps/api/directions/json?origin=" + lat1 + "," + lon1 + "&destination=" + lat2 + "," + lon2 + "&sensor=false&units=metric&mode=driving";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response) {
                //  Toast.makeText(mContext, "JSON " + s, Toast.LENGTH_LONG).show();

                JSONObject jsonObject = null;
                try
                {
                    jsonObject = new JSONObject(response);

                    JSONArray array = jsonObject.getJSONArray("routes");
                    JSONObject routes = array.getJSONObject(0);

                    JSONArray legs = routes.getJSONArray("legs");
                    JSONObject steps = legs.getJSONObject(0);
                    JSONObject distance = steps.getJSONObject("distance");
                    //       JSONObject timeOb = steps.getJSONObject("duration");


                    textView.setText("Distance is :"+distance.getString("text"));

                } catch (JSONException e) {
                    Toast.makeText(mContext, "JSONException " + e, Toast.LENGTH_LONG).show();                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(mContext, "Error " + volleyError, Toast.LENGTH_SHORT).show();

            }
        });


        Volley.newRequestQueue(mContext).add(stringRequest);


    }


    public static void notifcate(Context from,Class aClass,String Ticker,String Title,String ContentText) {
        NotificationManager manager = (NotificationManager)from.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(from);
        builder.setSmallIcon(android.R.drawable.ic_notification_overlay);
        builder.setContentTitle(Title);
        builder.setSmallIcon(R.drawable.common_google_signin_btn_icon_dark);
        builder.setAutoCancel(true);
        builder.setTicker(Ticker);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setContentText(ContentText);






//        Intent intent = new Intent(from,aClass);
//        PendingIntent pendingIntent = PendingIntent.getActivity(from, 0, intent, 0);
//        builder.setContentIntent(pendingIntent);



        Notification n = builder.build();
        manager.notify(0, n);
    }



    public  void setRun(Context mContext , boolean run) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("App",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isRun",run);
        editor.commit();
    }

    public boolean getRun(Context mContext) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("App",MODE_PRIVATE);
        boolean s = sharedPreferences.getBoolean("isRun",false);
        return s ;
    }

}
