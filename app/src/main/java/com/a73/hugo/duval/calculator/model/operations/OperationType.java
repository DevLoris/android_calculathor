package com.a73.hugo.duval.calculator.model.operations;


public enum OperationType {
    OPERATION_ADD,
    OPERATION_SUBTRACT,
    OPERATION_MULTIPLY,
    OPERATION_DIVIDE;

    public static boolean exist(String key) {
        for (OperationType me : OperationType.values()) {
            if (me.name().equalsIgnoreCase(key))
                return true;
        }
        return false;
    }
}