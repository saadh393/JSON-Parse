package com.example.zulkarnine.jsonpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue mRequstQu;
        mRequstQu = Volley.newRequestQueue(MainActivity.this);
        String url = "https://api.myjson.com/bins/xcuq8";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray movie = response.getJSONArray("Movie");

                    for(int i = 0; i < movie.length(); i++){
                        JSONObject item = movie.getJSONObject(i);
                        Log.d("123as123", "Result: \n"
                                +item.getString("Name")+"\n"+
                                item.getInt("Year")+"\n"+
                                item.getDouble("Rating"));
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        mRequstQu.add(request);
    }
}
