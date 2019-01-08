package com.a73.hugo.duval.calculator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.a73.hugo.duval.calculator.calc.Calculator;

public class MainActivity extends Activity {

    private Calculator calculator;

    private boolean isNightModeEnabled = false;
    private final String night_key = "NIGHT_KEY";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.preferences =  PreferenceManager.getDefaultSharedPreferences(this);
        this.isNightModeEnabled = preferences.getBoolean(night_key, false);

        setTheme((this.isNightModeEnabled) ? R.style.WinterMode : R.style.SummerMode);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.calculator = new Calculator();
    }

    /**
     *
     * @param v View
     */
    public void clickNightHandler(View v) {
        SharedPreferences.Editor editor  = preferences.edit();
        editor.putBoolean(night_key, !this.isNightModeEnabled);
        editor.apply();

        this.isNightModeEnabled = !this.isNightModeEnabled;

        MainActivity.this.recreate();
    }
    /**
     *
     * @param v View
     */
    public void clickHandler(View v) {
        if (Calculator.NUMBERS.contains(v.getTag())) {
            System.out.println("NUMBER");
        }
        if (Calculator.OPERATIONS.contains(v.getTag())) {
            System.out.println("OPERATION");
        }
    }
}
