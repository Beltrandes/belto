package com.beltrandes.belto.domain.enums;

public enum TaskCategory {
    WORK(1),
    EDUCATION(2),
    HOME(3),
    HEALTH(4),
    LEISURE(5);


    private int code;

    private TaskCategory(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TaskCategory valueOf(int code) {
        for (TaskCategory value : TaskCategory.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TaskStatus code");
    }
}
