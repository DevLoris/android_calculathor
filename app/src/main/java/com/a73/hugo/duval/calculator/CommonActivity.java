package com.a73.hugo.duval.calculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import java.util.Locale;

class CommonActivity extends Activity {
    private boolean isNightModeEnabled = false;
    private final String night_key = "NIGHT_KEY";
    private SharedPreferences preferences;

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        this.recreate();
    }

    /**
     * Get preferences of user
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.preferences =  PreferenceManager.getDefaultSharedPreferences(this);
        this.isNightModeEnabled = preferences.getBoolean(night_key, false);

        setTheme((this.isNightModeEnabled) ? R.style.WinterMode : R.style.SummerMode);

        super.onCreate(savedInstanceState);
    }

    /**
     * Assign menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.scientific, menu);
        this.setLocale("en");
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Get click to enable or disable night mode
     * @param v View
     */
    public void clickNightHandler(View v) {
        SharedPreferences.Editor editor  = preferences.edit();
        editor.putBoolean(night_key, !this.isNightModeEnabled);
        editor.apply();

        this.isNightModeEnabled = !this.isNightModeEnabled;

        this.recreate();
    }

    /**
     * Get click to open Android Native Options Menu
     * @param v
     */
    public void clickMenuHandler(View v){
        this.openOptionsMenu();
    }
}
