package com.dyne.viid.common.enums;


public enum ImageFrom {
    /**
     * 人形
     */
    PERSON(1),
    /**
     * 人脸
     */
    FACE(2),
    /**
     * 机动车
     */
    MOTOR_VEHICLES(3),
    /**
     * 非机动车
     */
    NON_MOTOR_VEHICLES(4);

    private final Integer value;

    ImageFrom(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static ImageFrom getByValue(int value) {
        for (ImageFrom imageFrom : values()) {
            if (imageFrom.getValue() == value) {
                return imageFrom;
            }
        }
        return null;
    }
}
