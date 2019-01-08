package com.a73.hugo.duval.calculator.calc.operations;

public final class AddOperation extends Operation {

    @Override
    public Double calculate(Double firstValue, Double secondValue) {
        return firstValue + secondValue;
    }
}
