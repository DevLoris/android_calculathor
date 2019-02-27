package com.a73.hugo.duval.calculator.model;

import android.util.Log;
import android.widget.TextView;

import com.a73.hugo.duval.calculator.model.operations.OperationType;

import java.util.Arrays;

public final class Calculator {

    private Double firstValue;
    private Double secondValue;
    private Double result;
    private boolean comma = false;

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
     * Get click and define action
     * @param tag String
     */
    public void clickHandler(String tag) {
        if (CalculatorType.NUMBERS.contains(tag)) {
            this.clickNumberHandler(tag);
        }

        if (OperationType.exist(tag) && CalculatorType.OPERATIONS.contains(OperationType.valueOf(tag))) {
            this.clickOperationHandler(OperationType.valueOf(tag));
        }

        if (CalculatorType.REMOVE.equalsIgnoreCase(tag)) {
            this.clickRemoveHandler(tag);
        }

        if (CalculatorType.CLEAR.equalsIgnoreCase(tag)) {
            this.clickClearHandler(tag);
        }

        if (CalculatorType.COMMA.equalsIgnoreCase(tag)) {
            this.clickCommaHandler();
        }

        if (CalculatorType.EQUAL.equalsIgnoreCase(tag)) {
            this.clickEqualHandler();
        }

        if (this.shouldDisplay) this.processDisplay();
        this.shouldDisplay = true;
    }

    /**
     * Number click
     * @param number String
     */
    private void clickNumberHandler(String number) {
        if (!this.calculation.hasOperation()) {
            Double firstValue =  (this.calculation.getFirstValue() == null) ? 0 : this.calculation.getFirstValue();
            String first = this.formatDouble(firstValue);
            if (comma && firstValue % 1 == 0) {
                first += ".";
                comma = false;
            }
            first += number;

            this.calculation.setFirstValue(Double.valueOf(first));
            return;
        }

        Double secondValue =  (this.calculation.getSecondValue() == null) ? 0 : this.calculation.getSecondValue();
        String second = this.formatDouble(secondValue);
        if (comma && secondValue % 1 == 0) {
            second += ".";
            comma = false;
        }
        second += number;

        this.calculation.setSecondValue(Double.valueOf(second));

    }

    /**
     * Operation click
     * @param operation String
     */
    private void clickOperationHandler(OperationType operation) {
        this.finishedCalc = false;

        if (this.calculation.hasSecondValue()) {
            this.processCalculation();
        };

        this.calculation.setOperation(operation);
    }

    /**
     * DEL button click
     * @param operation String
     */
    private void clickRemoveHandler(String operation) {
        if(this.calculation.hasSecondValue()) {
            this.calculation.setSecondValue(this.removeLastNumberOfDouble(this.calculation.getSecondValue()));
            this.secondValue = this.calculation.getSecondValue();
        }
        else  if(this.calculation.hasOperation()) {
            this.calculation.setOperation(null);
        }
        else if(this.calculation.hasFirstValue()) {
            this.calculation.setFirstValue(this.removeLastNumberOfDouble(this.calculation.getFirstValue()));
        }
        this.processDisplay();
    }

    /**
     * CL button click
     * @param operation String
     */
    private void clickClearHandler(String operation) {
        if(this.calculation.hasSecondValue()) {
            this.calculation.setSecondValue(null);
            this.secondValue = null;
        }
        else  if(this.calculation.hasOperation()) {
            this.calculation.setOperation(null);
        }
        else if(this.calculation.hasFirstValue()) {
            this.calculation.setFirstValue(null);
            this.firstValue = null;
            
        }
        this.processDisplay();
    }


    /**
     * inverse la comma de virgule
     */
    private void clickCommaHandler() {
        this.comma = true;
    }

    /**
     * click on equal button
     */
    private void clickEqualHandler() {
        if (this.calculation.hasSecondValue()) this.processCalculation();
    }

    /**
     * process the rendering of result
     */
    private void processDisplay() {
        if (this.result != null) {
            this.textView.setText(this.formatDouble(this.result));
            return;
        }

        String displayValue = "";

        //si la virgule est activée, et que la valeur est encore vide, on affiche en placeholder un "0."
        if(this.calculation.getFirstValue() == null && this.comma)
            displayValue += "0.";

        if(this.calculation.getFirstValue() != null) {
            displayValue += this.formatDouble(this.calculation.getFirstValue());
            if(this.calculation.getOperationLabel() == null && this.comma && this.calculation.getFirstValue() % 1 == 0)
                displayValue += ".";
        }

        if(this.calculation.getOperationLabel() != null) {
            displayValue += (this.calculation.getOperationLabel());

            if (this.calculation.getSecondValue() != null) {
                displayValue += this.formatDouble(this.calculation.getSecondValue());
                if (this.comma && this.calculation.getSecondValue() % 1 == 0)
                    displayValue += ".";
            }
            else if(this.comma)
                displayValue += "0.";
        }

        this.textView.setText(displayValue);
    }

    /**
     * process calculation
     */
    private void processCalculation() {
        this.result = this.calculation.processCalculation();

        try {
        HistorySingleton.getInstance().addCalculation((Calculation) this.calculation.clone());
        }
        catch (Exception e) {
            Log.e("HISTORY", "processCalculation: ", e);
        }

        calculation.reset();

        this.processDisplay();
        this.reset();

        this.shouldDisplay = false;
        this.finishedCalc  = true;
    }

    /**
     * clean values
     */
    private void reset() {
        this.firstValue     = this.result;
        this.result         = null;
        this.secondValue    = null;
        this.calculation.setFirstValue(this.firstValue);
    }

    private Double removeLastNumberOfDouble(Double number) {
        String second = formatDouble(number);
        if(second.length() > 1) {
            second = second.substring(0, second.length() - 1);
            return (Double.parseDouble(second));
        }
        else
            return null;
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
