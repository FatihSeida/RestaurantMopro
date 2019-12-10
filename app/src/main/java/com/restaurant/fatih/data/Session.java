package com.restaurant.fatih.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.restaurant.fatih.DashboardActivity;
import com.restaurant.fatih.auth.LoginActivity;

public class Session {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "restoMobpro";
    private static final String IS_LOGIN = "IsLoged";
    private static final String IS_NOT_ALARMT = "IsAlarm";

    public Session(Context context){
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void checkLogin(){
        if (isLoggedIn()){
            Intent i = new Intent(context, DashboardActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();
        editor.putBoolean(IS_LOGIN, false);
        editor.putBoolean(IS_NOT_ALARMT, true);
        setIsLogin(false);

        Intent i = new Intent(context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ((Activity) context).finish();
        context.startActivity(i);
    }

    public void clearSession() {
        editor.clear();
        editor.commit();
        editor.putBoolean(IS_LOGIN, false);
        editor.putBoolean(IS_NOT_ALARMT, true);
    }
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
    public void setIsLogin(Boolean v) {
        editor.putBoolean(IS_LOGIN, v);
        editor.commit();
    }
}
