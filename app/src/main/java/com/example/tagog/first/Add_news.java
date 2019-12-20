package com.example.tagog.first;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import android.widget.Gallery;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.io.OutputStream;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import javax.net.ssl.HttpsURLConnection;
import java.io.UnsupportedEncodingException;
import android.util.Base64;

public class Add_news extends AppCompatActivity {

    Bitmap bitmap;

    boolean check = true;

    Button SelectImageGallery, UploadImageServer;

    ImageView imageView;

    EditText imageName;
    String name1;
    String phone1;


    TextView al,al2;
    ProgressDialog progressDialog ;

    String GetImageNameEditText;

    String ImageName = "image_name" ;

    String ImagePath = "image_path" ;

    String ServerUploadPath ="https://sultantec.com/news/add_news.php" ;
    private EditText name, phone, kh_no,tips,tips2;
    private ProgressDialog mProgressDialog;
    RelativeLayout r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_news);
        // r = (RelativeLayout) findViewById(R.id.w);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //     .setAction("Action", null).show();
                onBackPressed();
            }
        });











        name = (EditText) findViewById(R.id.editText5);
        phone = (EditText) findViewById(R.id.editText6);



        al=(TextView)findViewById(R.id.textView4);

       // al2=(TextView)findViewById(R.id.textView5);



        imageView = (ImageView)findViewById(R.id.imageView12);

        //imageName = (EditText)findViewById(R.id.editTextImageName);

        SelectImageGallery = (Button)findViewById(R.id.imageView3);

        UploadImageServer = (Button)findViewById(R.id.button6);







        SelectImageGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                intent.setType("image/*");

                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "اختر صورة الناقلة  "), 1);

            }
        });


        UploadImageServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetImageNameEditText = "image nmae";

                // imageName.getText().toString();


                name1 = name.getText().toString();
                phone1 = phone.getText().toString();
                // String passWord = etPassword.toString();





                if (TextUtils.isEmpty(name1))
                {
                    name.setError(getString(R.string.error_empty_field));
                    return;
                }
                else if (TextUtils.isEmpty(phone1))
                {
                    phone.setError(getString(R.string.error_empty_field));
                    return;
                }

                else if (imageView.getDrawable()==null)
                {
                    al.setError("الرجاء اختيار صورة للناقلة");

                    al.setTextColor(0xffcc0000);

                    return;

                }
                else


                    // int a=120;
                    // int b=120;
                    //r.setLayoutParams(new RelativeLayout.LayoutParams(a,b));

                    ImageUploadToServerFunction();
            }
        });

        //info();
    }

    @Override
    protected void onActivityResult(int RC, int RQC, Intent I) {

        super.onActivityResult(RC, RQC, I);

        if (RC == 1 && RQC == RESULT_OK && I != null && I.getData() != null) {

            Uri uri = I.getData();

            try {

                imageView.getLayoutParams().height=200;
                imageView.getLayoutParams().width=200;


                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    public void ImageUploadToServerFunction(){


        ByteArrayOutputStream byteArrayOutputStreamObject ;

        byteArrayOutputStreamObject = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject);

        byte[] byteArrayVar = byteArrayOutputStreamObject.toByteArray();

        final String ConvertImage = Base64.encodeToString(byteArrayVar, Base64.DEFAULT);




        class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {

                super.onPreExecute();

                progressDialog = ProgressDialog.show(Add_news.this," جاري ارسال البيانات  "," الرجاء الانتظار",false,false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                // Dismiss the progress dialog after done uploading.
                progressDialog.dismiss();

                name.setText(null);
                phone.setText(null);
                // String passWord = etPassword.toString();

                imageView.setImageDrawable(null);

                // Printing uploading success message coming from server on android app.
                Toast.makeText(Add_news.this,string1,Toast.LENGTH_LONG).show();

                // Setting image as transparent after done uploading.
                //  imageView.setImageResource(android.R.color.transparent);


            }
            @Override
            protected String doInBackground(Void... params) {

                ImageProcessClass imageProcessClass = new ImageProcessClass();

                HashMap<String,String> HashMapParams = new HashMap<String,String>();

                HashMapParams.put(ImageName, GetImageNameEditText);

                HashMapParams.put(ImagePath, ConvertImage);
                //////////////////////////////////////////////

                HashMapParams.put("name", name1);

                HashMapParams.put("phone", phone1);






                String FinalData = imageProcessClass.ImageHttpRequest(ServerUploadPath, HashMapParams);

                return FinalData;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();

        AsyncTaskUploadClassOBJ.execute();
    }

    public class ImageProcessClass{

        public String ImageHttpRequest(String requestURL,HashMap<String, String> PData) {

            StringBuilder stringBuilder = new StringBuilder();

            try {

                URL url;
                HttpURLConnection httpURLConnectionObject ;
                OutputStream OutPutStream;
                BufferedWriter bufferedWriterObject ;
                BufferedReader bufferedReaderObject ;
                int RC ;

                url = new URL(requestURL);

                httpURLConnectionObject = (HttpURLConnection) url.openConnection();

                httpURLConnectionObject.setReadTimeout(19000);

                httpURLConnectionObject.setConnectTimeout(19000);

                httpURLConnectionObject.setRequestMethod("POST");

                httpURLConnectionObject.setDoInput(true);

                httpURLConnectionObject.setDoOutput(true);

                OutPutStream = httpURLConnectionObject.getOutputStream();

                bufferedWriterObject = new BufferedWriter(

                        new OutputStreamWriter(OutPutStream, "UTF-8"));

                bufferedWriterObject.write(bufferedWriterDataFN(PData));

                bufferedWriterObject.flush();

                bufferedWriterObject.close();

                OutPutStream.close();

                RC = httpURLConnectionObject.getResponseCode();

                if (RC == HttpsURLConnection.HTTP_OK) {

                    bufferedReaderObject = new BufferedReader(new InputStreamReader(httpURLConnectionObject.getInputStream()));

                    stringBuilder = new StringBuilder();

                    String RC2;

                    while ((RC2 = bufferedReaderObject.readLine()) != null){

                        stringBuilder.append(RC2);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();



                // Toast.makeText(Singup.this,"ddd"+e,Toast.LENGTH_LONG).show();



            }
            return stringBuilder.toString();
        }

        private String bufferedWriterDataFN(HashMap<String, String> HashMapParams) throws UnsupportedEncodingException {

            StringBuilder stringBuilderObject;

            stringBuilderObject = new StringBuilder();

            for (Map.Entry<String, String> KEY : HashMapParams.entrySet()) {

                if (check)

                    check = false;
                else
                    stringBuilderObject.append("&");

                stringBuilderObject.append(URLEncoder.encode(KEY.getKey(), "UTF-8"));

                stringBuilderObject.append("=");

                stringBuilderObject.append(URLEncoder.encode(KEY.getValue(), "UTF-8"));
            }

            return stringBuilderObject.toString();
        }

    }


    public void info() {

        final Dialog dialog = new Dialog(Add_news.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_singup);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}