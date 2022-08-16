package com.dyne.viid.common.enums;


public enum InfoKind {
    /**
     * 其他
     */
    OTHER(0),
    /**
     * 自动采集
     */
    AUTO(1),
    /**
     * 人工采集
     */
    MANUAL(2);

    private final Integer value;

    InfoKind(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static InfoKind getByValue(int value) {
        for (InfoKind infoKind : values()) {
            if (infoKind.getValue() == value) {
                return infoKind;
            }
        }
        return null;
    }
}
