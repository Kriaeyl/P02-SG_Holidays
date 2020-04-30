package com.example.p02_sg_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday>{

    private ArrayList<Holiday> holidays;
    private Context context;
    private TextView tv1, tv2;
    private ImageView iv1;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tv1 = rowView.findViewById(R.id.textView2);
        tv2 = rowView.findViewById(R.id.textView3);
        // Get the ImageView object
        iv1 = rowView.findViewById(R.id.imageView);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday now = holidays.get(position);
        // Set the TextView to show the food

        tv1.setText(now.getName());
        tv2.setText(now.getDate());
        iv1.setImageResource(now.getImageId());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
