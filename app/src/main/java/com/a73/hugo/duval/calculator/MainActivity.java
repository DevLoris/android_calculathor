package com.a73.hugo.duval.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.a73.hugo.duval.calculator.calc.Calculator;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.calculator = new Calculator();
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
