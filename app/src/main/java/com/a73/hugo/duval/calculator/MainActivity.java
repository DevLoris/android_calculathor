package com.a73.hugo.duval.calculator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.a73.hugo.duval.calculator.calc.Calculator;

public class MainActivity extends CommonActivity  {

    TextView textView;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView   = findViewById(R.id.result);
        this.calculator = new Calculator(textView);
    }

    /**
     *
     * @param v View
     */
    public void clickHandler(View v) {
        calculator.clickHandler(v.getTag().toString());
    }
}
