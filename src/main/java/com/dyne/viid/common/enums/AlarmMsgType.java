package com.dyne.viid.common.enums;

/**
 * 描述:
 *
 * @author cm_fighting
 * @create 2022-07-07 上午11:00
 */
public enum AlarmMsgType {
    /**
     * 人脸
     */
    FACE("faceDetection"),
    /**
     * 人员
     */
    PERSON("personsDetection"),
    /**
     * 机动车
     */
    MOTOR_VEHICLES("motorVehiclesDetection"),
    /**
     * 非机动车
     */
    NON_MOTOR_VEHICLES("nonMotorVehiclesDetection");

    private final String value;

    AlarmMsgType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AlarmMsgType getByValue(String value) {
        for (AlarmMsgType alarmMsgType : values()) {
            if (alarmMsgType.getValue().equals(value)) {
                return alarmMsgType;
            }
        }
        return null;
    }

}
