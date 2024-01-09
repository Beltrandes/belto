package com.beltrandes.belto.domain.enums;

public enum TaskStatus {
    IN_PROGRESS(1),
    DONE(2),
    PENDING(3);

    private int code;

    private TaskStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TaskStatus valueOf(int code) {
        for (TaskStatus value : TaskStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TaskStatus code");
    }
}
