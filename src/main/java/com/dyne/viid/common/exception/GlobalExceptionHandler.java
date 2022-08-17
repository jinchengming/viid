package com.dyne.viid.common.exception;

import com.dyne.viid.common.result.ConfirmStatusType;
import com.dyne.viid.common.result.ResponseStatusObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidateException.class)
    public ResponseStatusObject handleRenException(ValidateException ex) {
        return ResponseStatusObject.create(null, ConfirmStatusType.Validate_Error.getCode(), ex.getMsg());
    }

    @ExceptionHandler(GlobalException.class)
    public ResponseStatusObject handleRenException(GlobalException ex) {
        return ResponseStatusObject.create(ConfirmStatusType.OtherError);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseStatusObject handHttpMessageConversionException(HttpMessageConversionException ex) {
        ex.printStackTrace();
        return ResponseStatusObject.create(ConfirmStatusType.Invalid_JSON_Format);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseStatusObject handDuplicateKeyException(DuplicateKeyException ex) {
        ex.printStackTrace();
        ResponseStatusObject responseStatusObject = ResponseStatusObject.create(ConfirmStatusType.Invalid_JSON_Content);
        responseStatusObject.setStatusString("数据已存在");
        return responseStatusObject;
    }

    @ExceptionHandler(Exception.class)
    public ResponseStatusObject handleException(Exception ex) {
        log.error(ex.getMessage(), ex);

        saveLog(ex);

        return ResponseStatusObject.create(ConfirmStatusType.OtherError);
    }

    /**
     * 保存异常日志
     */
    private void saveLog(Exception ex) {

    }
}
