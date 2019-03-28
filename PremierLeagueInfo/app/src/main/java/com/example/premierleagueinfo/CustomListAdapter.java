package com.example.premierleagueinfo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the team images
    private final Integer[] imageIDarray;

    //to store the list of teams
    private final String[] nameArray;

    public CustomListAdapter(Activity context, Integer[] imageIDarray, String[] nameArray) {
        super(context, R.layout.listview_row, nameArray);

        this.context = context;
        this.imageIDarray = imageIDarray;
        this.nameArray = nameArray;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        TextView nameTextField = (TextView) rowView.findViewById(R.id.lblListHeader);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView2);

        nameTextField.setText(nameArray[position]);
        imageView.setImageResource(imageIDarray[position]);

        return rowView;

    };
}
