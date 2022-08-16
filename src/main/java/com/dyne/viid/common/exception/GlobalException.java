package com.dyne.viid.common.exception;


import com.dyne.viid.common.result.ConfirmStatusType;
import lombok.Data;

/**
 * 自定义全局异常
 */
@Data
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    public GlobalException(ConfirmStatusType confirmStatusType) {
        this.code = confirmStatusType.getCode();
        this.msg = confirmStatusType.getMsg();
    }


    public GlobalException(ConfirmStatusType confirmStatusType, Throwable e) {
        super(e);
        this.code = confirmStatusType.getCode();
        this.msg = confirmStatusType.getMsg();
    }


    public GlobalException(String msg) {
        super(msg);
        this.code = ConfirmStatusType.OtherError.getCode();
        this.msg = msg;
    }

    public GlobalException(String msg, Throwable e) {
        super(msg, e);
        this.code = ConfirmStatusType.OtherError.getCode();
        this.msg = msg;
    }

}
