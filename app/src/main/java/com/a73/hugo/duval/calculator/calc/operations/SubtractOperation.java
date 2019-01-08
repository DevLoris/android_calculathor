package com.a73.hugo.duval.calculator.calc.operations;

public final class SubtractOperation extends Operation {

    /**
     *
     */
    SubtractOperation() {
        this.label = "-";
    }

    @Override
    public Double calculate(Double firstValue, Double secondValue) {
        return firstValue - secondValue;
    }
}
