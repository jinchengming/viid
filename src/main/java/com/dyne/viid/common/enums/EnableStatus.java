package com.dyne.viid.common.enums;

/**
 * 启用状态
 */
public enum EnableStatus {
    /**
     * 启用
     */
    ENABLE(0),
    /**
     * 禁用
     */
    DISABLE(1);

    private final int value;

    EnableStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
