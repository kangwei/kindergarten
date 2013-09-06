/**
 * ClassName: ServiceException
 * CopyRight: TalkWeb
 * Date: 12-11-21
 * Version: 1.0
 */
package com.titian.cms.exception;

import com.titian.cms.common.ErrorCode;

/**
 * Description : 服务异常
 * User : 康维
 */
public class ServiceException extends RuntimeException {
    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(ErrorCode code) {
        super();
        setErrorCode(code);
    }

    public ServiceException(ErrorCode code, String message) {
        super(message);
        setErrorCode(code);
    }

    public ServiceException(ErrorCode code, Throwable cause) {
        super(cause);
        setErrorCode(code);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
