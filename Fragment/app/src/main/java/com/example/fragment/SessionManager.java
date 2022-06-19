package com.example.fragment;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    public static final String KEY_LOGIN = "isLogin";

    private Context context;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences("Session", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void createLoginSession() {
        editor.putBoolean(KEY_LOGIN, true)
            .commit();
    }

    public void logout() {
        editor.clear();
        editor.commit();
    }

    public Boolean isUserLogin() {
        return pref.getBoolean(KEY_LOGIN, false);
    }
}
