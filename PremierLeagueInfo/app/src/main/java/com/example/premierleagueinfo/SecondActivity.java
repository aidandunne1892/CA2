package com.example.premierleagueinfo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class SecondActivity extends AppCompatActivity {

    private String url ="https://applicationbackend.azurewebsites.net/api/";
    private String TAG ="premierleagueinfo";
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        textView = (TextView) findViewById(R.id.txtItem);

        String temp = getIntent().getStringExtra("testValue");



        premierLeagueCall(temp);

        //textView.setText(temp);
    }


    public void premierLeagueCall(String team){
        final TextView onClickText = findViewById(R.id.txtItem);

        try
        {
            // make a string request (JSON request an alternative)
            RequestQueue queue = Volley.newRequestQueue(this);
            Log.d(TAG, "Making request");
            try
            {
                team.replaceAll("\\s+","");
                Log.d(TAG,team);
                StringRequest strObjRequest = new StringRequest(Request.Method.GET, url+"club/"+team,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                // parse resulting string containing JSON to Greeting object
                                premierLeagueClass greeting = new Gson().fromJson(response, premierLeagueClass.class);
                                onClickText.setText(greeting.toString());
                                Log.d(TAG, "Displaying data " + greeting);
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
