package com.example.tagog.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Ehtmamat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ehtmamat);


        GridView gridview = (GridView) findViewById(R.id.gridview);

        List<ItemObject> allItems = getAllItemObject();
        CustomAdapter customAdapter = new CustomAdapter(Ehtmamat.this, allItems);
        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Ehtmamat.this, "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });


    }




    private List<ItemObject> getAllItemObject(){
        ItemObject itemObject = null;
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));
        items.add(new ItemObject("Image One", "user_ic"));



        return items;
    }


}
