package com.dyne.viid.common.enums;

/**
 * 操作状态枚举
 */
public enum OperationStatus {
    /**
     * 失败
     */
    FAIL(0),
    /**
     * 成功
     */
    SUCCESS(1);

    private final int value;

    OperationStatus(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
