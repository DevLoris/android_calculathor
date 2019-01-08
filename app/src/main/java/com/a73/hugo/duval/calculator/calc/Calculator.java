package com.a73.hugo.duval.calculator.calc;

import android.view.View;

import com.a73.hugo.duval.calculator.calc.operations.Operation;

import java.util.ArrayList;
import java.util.List;

public final class Calculator {

    public static final List<String> NUMBERS = new ArrayList<String>(){{
        add("0");
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
        add("6");
        add("7");
        add("8");
        add("9");
    }};

    public static final List<String> OPERATIONS = new ArrayList<String>(){{
        add(Operation.ADD);
        add(Operation.SUBTRACT);
        add(Operation.MULTIPLY);
        add(Operation.DIVIDE);
    }};

    private Double currentValue;
    private Double result;
    private String displayValue;

    /**
     *
     * @param v View
     */
    public void clickNumberHandler(View v) {

    }

    /**
     *
     * @param v View
     */
    public void clickOperationHandler(View v) {

    }
}
