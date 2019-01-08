package com.a73.hugo.duval.calculator.model;

import com.a73.hugo.duval.calculator.model.operations.Operation;

final class Calculation {

    private Double firstValue  = 0.0;
    private Double secondValue;
    private Operation operation;

    /**
     *
     * @param firstValue double
     */
    void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    /**
     *
     * @param secondValue double
     */
    void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }

    /**
     *
     * @return boolean
     */
    boolean hasSecondValue() {
        return this.secondValue != null;
    }

    /**
     *
     * @param operationType String
     */
    void setOperation(String operationType) {
        this.operation = Operation.createOperation(operationType);
    }

    /**
     *
     * @return boolean
     */
    boolean hasOperation() {
        return this.operation != null;
    }

    /**
     *
     * @return String
     */
    String getOperationLabel() {
        return this.operation.getLabel();
    }

    /**
     *
     * @return Double
     */
    Double processCalculation() {
        return this.operation.calculate(this.firstValue, this.secondValue);
    }

    /**
     *
     */
    void reset() {
        this.firstValue  = 0.0;
        this.operation   = null;
        this.secondValue = null;
    }
}
