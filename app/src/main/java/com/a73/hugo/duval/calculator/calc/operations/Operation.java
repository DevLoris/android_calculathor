package com.a73.hugo.duval.calculator.calc.operations;

public abstract class Operation {
    public static final String ADD      = "OPERATION_ADD";
    public static final String SUBTRACT = "OPERATION_SUBTRACT";
    public static final String MULTIPLY = "OPERATION_MULTIPLY";
    public static final String DIVIDE   = "OPERATION_DIVIDE";

    /**
     *
     * @param operationType String
     * @return Operation
     */
    public static Operation createOperation(String operationType) {
        switch (operationType) {
            case ADD:
                return new AddOperation();
            case SUBTRACT:
                return new SubtractOperation();
            case MULTIPLY:
                return new MultiplyOperation();
            case DIVIDE:
                return new DivideOperation();
            default:
                throw new Error("Wrong Operation Type");
        }
    }

    /**
     *
     * @param firstValue Double
     * @param secondValue Double
     * @return Double
     */
    public abstract Double calculate(Double firstValue, Double secondValue);
}
