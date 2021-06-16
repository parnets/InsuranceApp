package com.example.insuranceapp.data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.insuranceapp.data.model.InsurancePlan;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class BackendApiService {
    private final String url="http://insuranceapp.com";


     public void getPlansList(){
         JsonArrayRequest planObject=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
             @Override
             public void onResponse(JSONArray response) {

             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {

             }
         });
        //return null;
    }


}
