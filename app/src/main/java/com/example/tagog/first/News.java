package com.example.tagog.first;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class News extends Activity {

    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work
    private static final String URL_PRODUCTS = "http://sultantec.com/files/api.php";

    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    ProgressBar Pbar;
    private Button etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                ///.setAction("Action", null).show();
//                onBackPressed();
//
//            }
//        });




        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recylcerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Pbar = (ProgressBar)findViewById(R.id.progressBar1);

        etUserName = (Button) findViewById(R.id.erorrp);
        etUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vvv) {
                loadProducts();
                etUserName.setVisibility(View.GONE);

            }
        });



        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts();
    }

    private void loadProducts() {

        /*
        * Creating a String Request
        * The request type is GET defined by first parameter
        * The URL is defined in the second parameter
        * Then we have a Response Listener and a Error Listener
        * In response listener we will get the JSON response as a String
        * */
       // recyclerView.setVisibility(View.GONE);
        Pbar.setVisibility(View.VISIBLE);
        etUserName.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {


                           // Pbar.setVisibility(View.VISIBLE);


                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i =array.length()-1 ; i >=0; i--) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                productList.add(new Product(
                                        product.getInt("id"),
                                        product.getString("title"),
                                        product.getString("shortdesc"),
                                        product.getString("rating"),
                                        product.getString("price"),
                                        product.getString("image")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            ProductsAdapter adapter = new ProductsAdapter(News.this, productList);


                            recyclerView.setAdapter(adapter);




                           // recyclerView.setVisibility(View.VISIBLE);

                            Pbar.setVisibility(View.GONE);


                          //  etUserName.setVisibility(View.GONE);





                        } catch (JSONException e) {
                            e.printStackTrace();


                            //etUserName.setVisibility(View.GONE);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Pbar.setVisibility(View.GONE);
                        etUserName.setVisibility(View.VISIBLE);
                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}