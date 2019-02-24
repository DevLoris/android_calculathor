package com.a73.hugo.duval.calculator.model.operations;

public abstract class Operation {
    String label;

    /**
     *
     * @param operationType String
     * @return Operation
     */
    public static Operation createOperation(OperationType operationType) {
        switch (operationType) {
            case OPERATION_ADD:
                return new AddOperation();
            case OPERATION_SUBTRACT:
                return new SubtractOperation();
            case OPERATION_MULTIPLY:
                return new MultiplyOperation();
            case OPERATION_DIVIDE:
                return new DivideOperation();
            default:
                throw new Error("Wrong Operation Type");
        }
    }

    /**
     *
     * @return String
     */
    public String getLabel() {
        return this.label;
    }

    /**
     *
     * @param firstValue Double
     * @param secondValue Double
     * @return Double
     */
    public abstract Double calculate(Double firstValue, Double secondValue);
}
