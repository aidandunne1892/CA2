package com.example.premierleagueinfo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.*;

public class MainActivity extends AppCompatActivity {
    private String url = "https://applicationbackendapi.azurewebsites.net/api/";
    private String TAG = "premierleagueinfo";


    ListView thelistview;


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


        thelistview = (ListView) findViewById(R.id.listview);

       CustomListAdapter whatever = new CustomListAdapter(this, images, teams);

       thelistview.setAdapter(whatever);
    }




   // public void premierLeagueCall(View v, String team){
     //   final TextView onClickText = findViewById(R.id.onClickEventText);
        //  onClickText.setText(team+" was selected");

       // try
        //{
            // make a string request (JSON request an alternative)
          //  RequestQueue queue = Volley.newRequestQueue(this);
            //Log.d(TAG, "Making request");
            //try
            //{
              //  StringRequest strObjRequest = new StringRequest(Request.Method.GET, url+"club/"+team,
                //        new Response.Listener<String>()
                  //      {
                      //      @Override
                    //        public void onResponse(String response)
                        //    {
                          //      // parse resulting string containing JSON to Greeting object
                            //    premierLeagueClass greeting = new Gson().fromJson(response, premierLeagueClass.class);
                              //  onClickText.setText(greeting.toString());
                                //Log.d(TAG, "Displaying data" + greeting.toString());
                            //}
                        //},
                        //new Response.ErrorListener()
                        //{
                         //   @Override
                           // public void onErrorResponse(VolleyError error)
                          //  {
                             //   onClickText.setText(error.toString());
                               // Log.d(TAG, "Error" + error.toString());
                            //}
                        //});
                //queue.add(strObjRequest);           // can have multiple in a queue, and can cancel
            //}
            //catch (Exception e1)
            //{
              //  Log.d(TAG, e1.toString());
               // onClickText.setText(e1.toString());
            //}
        //}
        //catch (Exception e2)
        //{
          //  Log.d(TAG, e2.toString());
            //onClickText.setText(e2.toString());
        //}
    //}
}
