package com.a73.hugo.duval.calculator.model;

import android.widget.TextView;

public final class Calculator {

    private Double firstValue;
    private Double secondValue;
    private Double result;

    private String operationValue = "";

    private Boolean shouldDisplay = true;
    private Boolean finishedCalc  = false;

    private TextView textView;

    private Calculation calculation;

    /**
     *
     */
    public Calculator(TextView textView) {
        this.textView    = textView;
        this.calculation = new Calculation();
    }

    /**
     *
     * @param tag String
     */
    public void clickHandler(String tag) {
        if (CalculatorType.NUMBERS.contains(tag)) {
            this.clickNumberHandler(tag);
        }

        if (CalculatorType.OPERATIONS.contains(tag)) {
            this.clickOperationHandler(tag);
        }

        if (CalculatorType.EQUAL.equals(tag)) {
            this.clickEqualHandler();
        }

        if (this.shouldDisplay) this.processDisplay();
        this.shouldDisplay = true;
    }

    /**
     *
     * @param number String
     */
    private void clickNumberHandler(String number) {
        if (!this.calculation.hasOperation()) {

            if (this.finishedCalc) this.firstValue = null;
            this.finishedCalc = false;

            String fVal = "";
            if (this.firstValue != null) fVal = this.formatDouble(this.firstValue);

            this.firstValue = Double.valueOf(fVal + number);
            this.calculation.setFirstValue(this.firstValue);
            return;
        }

        String sVal = "";
        if (this.secondValue != null) sVal = this.formatDouble(this.secondValue);

        this.secondValue = Double.valueOf(sVal + number);
        this.calculation.setSecondValue(this.secondValue);
    }

    /**
     *
     * @param operation String
     */
    private void clickOperationHandler(String operation) {
        this.finishedCalc = false;

        if (this.calculation.hasSecondValue()) return;

        this.calculation.setOperation(operation);
        this.operationValue = calculation.getOperationLabel();
    }

    /**
     *
     */
    private void clickEqualHandler() {
        if (this.calculation.hasSecondValue()) this.processCalculation();
    }

    /**
     *
     */
    private void processDisplay() {
        if (this.result != null) {
            this.textView.setText(this.formatDouble(this.result));
            return;
        }

        String displayValue = this.formatDouble(this.firstValue)
                + (this.operationValue != null ? " " + this.operationValue : "")
                + (this.secondValue != null ? " " + this.formatDouble(this.secondValue) : "");

        this.textView.setText(displayValue);
    }

    /**
     *
     */
    private void processCalculation() {
        this.result = this.calculation.processCalculation();
        calculation.reset();

        this.processDisplay();
        this.reset();

        this.shouldDisplay = false;
        this.finishedCalc  = true;
    }

    /**
     *
     */
    private void reset() {
        this.firstValue     = this.result;
        this.operationValue = null;
        this.result         = null;
        this.secondValue    = null;
        this.calculation.setFirstValue(this.firstValue);
    }

    /**
     *
     * @param value Double
     * @return String
     */
    private String formatDouble(Double value) {
        return Double.toString(value).replaceAll("\\.0$", "");
    }
}
