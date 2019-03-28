package com.example.premierleagueinfo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String url = "https://applicationbackend.azurewebsites.net/api/";
    private String TAG = "premierleagueinfo";


    ListView thelistview;
    ExpndableListAdaptor listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] teams = res.getStringArray(R.array.Teams);

        Integer[] images = {R.drawable.arsenal, R.drawable.bournmath, R.drawable.brighton, R.drawable.burnley, R.drawable.cardiff,
                R.drawable.chelsea, R.drawable.crystal, R.drawable.everton, R.drawable.fulham, R.drawable.huddelsfield,
                R.drawable.leicester, R.drawable.liverpool, R.drawable.mancity, R.drawable.manu, R.drawable.newcastle,
                R.drawable.southhampton, R.drawable.spurs, R.drawable.watford, R.drawable.westham, R.drawable.wolves};



        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpndableListAdaptor(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                setChild(groupPosition);
            }
        });
    }






    public void setChild(int groupPostion){
        final List<String> ClubInfo = new ArrayList<String>();
        Toast.makeText(getApplicationContext(),
                listDataHeader.get(groupPostion) + " Expanded",
                Toast.LENGTH_SHORT).show();

        try
        {
            // make a string request (JSON request an alternative)
            RequestQueue queue = Volley.newRequestQueue(this);
            Log.d(TAG, "Making request");
            try
            {
                StringRequest strObjRequest = new StringRequest(Request.Method.GET, url+"club/"+listDataHeader.get(groupPostion),
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                // parse resulting string containing JSON to Greeting object
                                premierLeagueClass info = new Gson().fromJson(response, premierLeagueClass.class);
                                ClubInfo.add(info.toString());

                                Toast.makeText(getApplicationContext(),
                                        info.toString() + " Expanded",
                                        Toast.LENGTH_SHORT).show();
                                Log.d(TAG, "Displaying data" + info.toString());
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                ClubInfo.add((error.toString()));
                                Log.d(TAG, "Error" + error.toString());
                            }
                        });
                queue.add(strObjRequest);           // can have multiple in a queue, and can cancel
            }
            catch (Exception e1)
            {
                Log.d(TAG, e1.toString());
                ClubInfo.add((e1.toString()));
            }
        }
        catch (Exception e2)
        {
            Log.d(TAG, e2.toString());
            ClubInfo.add((e2.toString()));
        }



       // listDataChild.put(listDataHeader.get(groupPostion), ClubInfo);
    }





    private void prepareListData() {
        listDataHeader = Arrays.asList(getResources().getStringArray(R.array.Teams));
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data


        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }



   /* public void premierLeagueCall(View v, String team){
        final TextView onClickText = findViewById(R.id.onClickEventText);
          onClickText.setText(team+" was selected");

        try
        {
            // make a string request (JSON request an alternative)
           RequestQueue queue = Volley.newRequestQueue(this);
            Log.d(TAG, "Making request");
            try
            {
               StringRequest strObjRequest = new StringRequest(Request.Method.GET, url+"club/"+team,
                        new Response.Listener<String>()
                        {
                            @Override
                           public void onResponse(String response)
                            {
                                // parse resulting string containing JSON to Greeting object
                               premierLeagueClass greeting = new Gson().fromJson(response, premierLeagueClass.class);
                                onClickText.setText(greeting.toString());
                                Log.d(TAG, "Displaying data" + greeting.toString());
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                onClickText.setText(error.toString());
                                Log.d(TAG, "Error" + error.toString());
                            }
                        });
                queue.add(strObjRequest);           // can have multiple in a queue, and can cancel
            }
            catch (Exception e1)
            {
                Log.d(TAG, e1.toString());
                onClickText.setText(e1.toString());
            }
        }
        catch (Exception e2)
        {
            Log.d(TAG, e2.toString());
            onClickText.setText(e2.toString());
        }
    }*/
}
