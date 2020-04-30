package com.example.p02_sg_holidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {
    ArrayList<Holiday> secular, relig, holidays;
    ListView lv;
    ArrayAdapter aa;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = this.findViewById(R.id.ListView2);

        // Create a few food objects in Food array
        secular = new ArrayList<>(Arrays.asList(new Holiday("New Years Day", "1 Jan 2017", R.drawable.newyear), new Holiday("Labour Day", "1 May 2017", R.drawable.labourday)));
        relig = new ArrayList<>(Arrays.asList(new Holiday("Chinese New Year", "28-29 Jan 2017", R.drawable.cny), new Holiday("Good Friday", "14 April 2017", R.drawable.goodfriday)));
        tv1 = findViewById(R.id.textView);
        Intent intent = getIntent();
        String cat = intent.getStringExtra("thing");
        tv1.setText(cat);
        if (cat.equalsIgnoreCase("Secular")) {
            holidays = secular;
        }
        else {
            holidays = relig;
        }

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa = new HolidayAdapter(this, R.layout.row, holidays);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHol = holidays.get(position);

                Toast.makeText(SecondActivity.this, selectedHol.getName()
                                + " Date: " + selectedHol.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
