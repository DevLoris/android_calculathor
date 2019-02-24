package com.a73.hugo.duval.calculator.model.operations;


public enum OperationType {
    OPERATION_ADD("OPERATION_ADD"),
    OPERATION_SUBTRACT("OPERATION_SUBTRACT"),
    OPERATION_MULTIPLY("OPERATION_MULTIPLY"),
    OPERATION_DIVIDE("OPERATION_DIVIDE");

    String name;
    OperationType(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean exist(String key) {
        for (OperationType me : OperationType.values()) {
            if (me.name().equalsIgnoreCase(key))
                return true;
        }
        return false;
    }
}