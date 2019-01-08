package com.a73.hugo.duval.calculator.calc;

import com.a73.hugo.duval.calculator.calc.operations.Operation;

public final class Calculation {

    private Double firstValue  = 0.0;
    private Double secondValue;
    private Operation operation;


    /**
     *
     * @param firstValue double
     */
    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    /**
     *
     * @param secondValue double
     */
    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }

    /**
     *
     * @return boolean
     */
    public boolean hasSecondValue() {
        return this.secondValue != null;
    }

    /**
     *
     * @param operationType String
     */
    public void setOperation(String operationType) {
        this.operation = Operation.createOperation(operationType);
    }

    /**
     *
     * @return boolean
     */
    public boolean hasOperation() {
        return this.operation != null;
    }

    /**
     *
     * @return Double
     */
    public Double processCalculation() {
        return 0.0;
    }
}
