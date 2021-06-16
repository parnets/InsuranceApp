package com.example.insuranceapp.data;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.insuranceapp.data.model.LoggedInUser;
import com.example.insuranceapp.ui.home.HomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private String url="http://insuranceapp.com";



    public Result<LoggedInUser> login(LoginRepository loginRepository, String username, String password) {

    /* JSONObject postObject=new JSONObject();
        try {
            postObject.put("email",username);
            postObject.put("password",password);
        } catch (JSONException e) {
            System.out.println("login post json object create error");
            e.printStackTrace();

        }
       String loginUrl=url+"/vendor/signin";
        LoggedInUser user = null;
        JsonObjectRequest userObject = new JsonObjectRequest(Request.Method.POST,loginUrl , postObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                     loginRepository.setLoggedInUser( new LoggedInUser(
                           response.get("userId").toString(),
                            response.get("userName").toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        if(user!=null){
            return new Result.Success<>(user);
        }else{
            return new Result.Error(new IOException("Error logging in"));
        }
    }*/
        try{
            // TODO: handle loggedInUser authentication

            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout(Context context, LoggedInUser user) {

        String logoutUrl = url + "/vendor/logout/" + user.getUserId();
        // TODO: revoke authentication
        StringRequest logoutRequest = new StringRequest(Request.Method.GET, logoutUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("success")) {
                 setUserValue(user);
                    Toast.makeText(context,"logout successful",Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"logout unsuccessful",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setUserValue(LoggedInUser userValue){
      userValue=null;
    }

    public void forgotPassword(Context context, String username) {
        String forgotpass = url + "/vendor/forgotpass/" + username;
        // TODO: revoke authentication
        StringRequest logoutRequest = new StringRequest(Request.Method.GET, forgotpass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("success")) {

                    Toast.makeText(context,"password reset sent successful to mobile",Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"unable to send reset",Toast.LENGTH_LONG).show();
            }
        });
    }

}