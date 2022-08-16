package com.dyne.viid.common.exception;

import com.dyne.viid.common.result.ConfirmStatusType;
import lombok.Data;

/**
 * ValidateException
 */
@Data
public class ValidateException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    public ValidateException(String msg) {
        super(msg);
        this.code = ConfirmStatusType.OtherError.getCode();
        this.msg = msg;
    }
}
