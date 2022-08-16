package com.dyne.viid.common.enums;

/**
 * 描述:
 *
 * @author cm_fighting
 * @create 2022-07-07 上午11:36
 */
public enum ImageType {

    /**
     * 场景图
     */
    SCENE("14"),

    /**
     * 人脸图
     */
    FACE("11"),

    /**
     * 人员图
     */
    PERSON("10"),

    /**
     * 非机动车
     */
    NON_MOTOR_VEHICLES("12"),

    /**
     * 车牌彩色小图
     */
    LICENCE_PLATE("02"),

    /**
     * 车辆大图
     */
    CAR_BIG("01");

    private final String value;

    ImageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
