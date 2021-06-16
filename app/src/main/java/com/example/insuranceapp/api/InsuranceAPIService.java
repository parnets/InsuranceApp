package com.example.insuranceapp.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.insuranceapp.data.model.InsurancePlan;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

class InsuranceAPIService {
    private String url="http://insuranceapp.com";

    public List<InsurancePlan> getInsuranceDetails(){

        String loginUrl=url+"/vendor/getinsuranceplan";

        JSONArray userObject = new JSONArray(Request.Method.POST,loginUrl,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        return  null;
    }
}
