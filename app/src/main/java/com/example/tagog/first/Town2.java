package com.example.tagog.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Town2 extends AppCompatActivity {




    ListView listView;

    // Define string array.
    String[] listValue = new String[] {
  "الرياض",
   "مكة",
    "المدينة",
          "بريدة",
   "تبوك",
   "الدمام",
  "الاحساء",
  "القطيف",
   "خميس مشيط",
    "الطائف",
    " نجران",
   "حفر الباطن",
 "الجبيل ",
    "ضباء",
    "الخرج",
    "الثقبة",
    "ينبع البحر",
    "الخبر",
   "عرعر",
   "الحوية",
"عنيزة",
  "سكاكا",
   "جيزان",
   "القريات",
    "الظهران ",
  "الباحة ",
    "نجران",
   "الزلفي ",
    "الرس ",
   "وادي الدواسر",
   "بيشة",
  "سيهات",
 "شرورة",
 "بحرة",
    "تاروت",
   "الدوادمي",
 "صبياء",
   "بيش ",
    "احد رفيدة",
   "الفريش",
   " بارق ",
          "الحوطة",
" الافلاج"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.town2);



        listView = (ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1, listValue);

        listView.setAdapter(adapter);

        // ListView on item selected listener.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
               // Toast.makeText(Town2.this, listValue[position], Toast.LENGTH_SHORT).show();
                String a=listValue[position];

                String aa = getIntent().getStringExtra("go3");
                String bb = getIntent().getStringExtra("go4");

                Intent mIntent = new Intent(Town2.this, Driver.class);
                mIntent.putExtra("sr", a);

                mIntent.putExtra("go1", aa);
                mIntent.putExtra("go2", bb);
                startActivity(mIntent);
                finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}
