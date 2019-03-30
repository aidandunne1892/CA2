package com.example.premierleagueinfo;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter implements Filterable {

    //to reference the Activity
    private final Activity context;
    private List<String>filteredData = null;
    //to store the team images
    private final ArrayList<Integer> imageIDarray;

    //to store the list of teams
    private final ArrayList<String> nameArray;
    private String[] origData;

    public CustomListAdapter(Activity context, ArrayList<Integer> imageIDarray, ArrayList<String> nameArray) {
        super(context, R.layout.listview_row, nameArray);

        this.context = context;
        this.imageIDarray = imageIDarray;
        this.nameArray = nameArray;


    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        TextView nameTextField = (TextView) rowView.findViewById(R.id.textView4);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView2);

        nameTextField.setText(nameArray.get(position));
        imageView.setImageResource(imageIDarray.get(position));

        return rowView;

    }




}