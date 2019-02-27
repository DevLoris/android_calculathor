package com.a73.hugo.duval.calculator.model;

import com.a73.hugo.duval.calculator.model.operations.OperationType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorType {
    /**
     * list of numbers
     */
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

    /*
    list of operations
     */
    public static final List<OperationType> OPERATIONS = Arrays.asList(OperationType.values());

    public static final String COMMA = ",";

    public static final String EQUAL = "=";

    public static final String REMOVE = "DEL";

    public static final String CLEAR = "C";
}
