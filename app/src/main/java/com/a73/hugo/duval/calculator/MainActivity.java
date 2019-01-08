package com.a73.hugo.duval.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.a73.hugo.duval.calculator.calc.Calculator;

public class MainActivity extends AppCompatActivity {

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
