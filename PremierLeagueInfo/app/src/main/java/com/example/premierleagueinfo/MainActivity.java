package com.example.premierleagueinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.*;

public class MainActivity extends AppCompatActivity {
private String url ="https://applicationbackendapi.azurewebsites.net/api/";
private String TAG ="premierleagueinfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        start of block for the drop down menu with list of teams
        final Spinner mySpinner = findViewById(R.id.SpinnerTeams);
        ArrayAdapter<String> myAdaptor = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Teams));


        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdaptor);


//        end of block for the drop down menu with list of teams


//        start of button block

        Button btn = findViewById(R.id.SendToApi);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected_text = mySpinner.getSelectedItem().toString();
                premierLeagueCall(v,selected_text);



            }
        });

//        End of button block


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void premierLeagueCall(View v, String team){
        final TextView onClickText = findViewById(R.id.onClickEventText);
      //  onClickText.setText(team+" was selected");





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
    }


}
