package com.dyne.viid.common.result;

/**
 * 系统错误编码
 */
public enum ConfirmStatusType {

    /**
     * 错误编码
     */
    OK(0, "正常"),
    OtherError(1, "其他未知错误"),
    Device_Busy(2, "设备忙"),
    Device_Error(3, "设备错"),
    Invalid_Operation(4, "无效操作"),
    Invalid_XML_Format(5, "XML 格式无效"),
    Invalid_XML_Content(6, "XML 内容无效"),
    Invalid_JSON_Format(7, "JSON 格式无效"),
    Invalid_JSON_Content(8, "JSON 内容无效"),
    Reboot(9, "系统重启中"),
    Validate_Error(10, "参数校验异常");

    private Integer code;
    private String msg;

    ConfirmStatusType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public static String getMsg(Integer code) {
        ConfirmStatusType[] confirmStatusTypes = values();
        for (ConfirmStatusType confirmStatusType : confirmStatusTypes) {
            if (confirmStatusType.getCode().equals(code)) {
                return confirmStatusType.getMsg();
            }
        }
        return null;
    }
}

