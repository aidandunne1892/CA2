package com.example.premierleagueinfo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.google.gson.*;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import android.util.Log;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.*;

import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText searchBar;
    private  CustomListAdapter myAdaptor;
    private  CustomListAdapter myAdaptor2;
    private ArrayList<Integer> crests2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This hides the keyboard from the user when the this page is opened
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_main);
        searchBar = findViewById(R.id.editText);

        Resources res = getResources();
        //creates an List of string gathered from the resource folder
       final ArrayList<String> teams = new ArrayList<>(Arrays.asList(res.getStringArray(R.array.Teams)));



       //Hides the keyboard when the user selects the enter/done button
        searchBar.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(searchBar.getWindowToken(), 0);
                }
                return false;
            }
        });



        //creates a list of all the teams crests
      final   ArrayList<Integer> Crests = new ArrayList<Integer>() {
            {
                add(R.drawable.arsenal);
                add(R.drawable.bournmath);
                add(R.drawable.brighton);
                add(R.drawable.burnley);
                add(R.drawable.cardiff);
                add(R.drawable.chelsea);
                add(R.drawable.crystal);
                add(R.drawable.everton);
                add(R.drawable.fulham);
                add(R.drawable.huddelsfield);
                add(R.drawable.leicester);
                add(R.drawable.liverpool);
                add(R.drawable.mancity);
                add(R.drawable.manu);
                add(R.drawable.newcastle);
                add(R.drawable.southhampton);
                add(R.drawable.spurs);
                add(R.drawable.watford);
                add(R.drawable.westham);
                add(R.drawable.wolves);
            }
        };

        listView = findViewById(R.id.listview);

        myAdaptor = new CustomListAdapter(this, Crests, teams);

        listView.setAdapter(myAdaptor);

        //listens for when text is added to the search box
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //must be here to use TextWatcher
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //looks at the characters coming from the text box
                //get the list of all teams that matches along with the crests that
                //correspond to the team and sets it as a new adaptor

                ArrayList<String> temp = new ArrayList<String>();
                ArrayList<Integer> tempImages = new ArrayList<Integer>();
                int textlength = searchBar.getText().length();
                temp.clear();
                tempImages.clear();
                for (int i = 0; i < teams.size(); i++) {
                    if (textlength <= teams.get(i).length()) {
                        if (searchBar.getText().toString().equalsIgnoreCase(
                                (String)
                                        teams.get(i).subSequence(0,
                                                textlength))) {
                            temp.add(teams.get(i));
                            tempImages.add(Crests.get(i));
                        }
                    }
                }
                myAdaptor2=new CustomListAdapter(MainActivity.this, tempImages,temp);
                crests2=tempImages;
                listView.setAdapter(myAdaptor2);


            }

            @Override
            public void afterTextChanged(Editable s) {
                //must be here to use TextWatcher
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    String test = myAdaptor2.getItem(position).toString();

                    String team = test.replaceAll("\\s+", "");


                    Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);

                    Bundle bundle = new Bundle();

                    bundle.putInt("imageValue", crests2.get(position));

                    myIntent.putExtras(bundle);

                    myIntent.putExtra("testValue", team);


                    startActivity(myIntent);
                }
                catch(Exception ex){
                    String test = myAdaptor.getItem(position).toString();

                    String team = test.replaceAll("\\s+", "");


                    Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);

                    Bundle bundle = new Bundle();

                    bundle.putInt("imageValue", Crests.get(position));

                    myIntent.putExtras(bundle);

                    myIntent.putExtra("testValue", team);


                    startActivity(myIntent);
                }


            }
        });


    }


}



