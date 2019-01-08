package com.a73.hugo.duval.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.a73.hugo.duval.calculator.model.Calculator;

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

    @Override
    public void clickNightHandler(View v) {
        super.clickNightHandler(v);
    }

    @Override
    public void clickMenuHandler(View v) {
        super.clickMenuHandler(v);
    }

    /**
     *
     * @param v View
     */
    public void clickHandler(View v) {
        calculator.clickHandler(v.getTag().toString());
    }
}
