package com.mxs.exception;

import com.mxs.factory.type.CodeExceptionType;
import com.mxs.factory.type.MessageExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceExistsException extends RuntimeException {
    public ResourceExistsException(
            final CodeExceptionType codeExceptionType,
            final MessageExceptionType messageExceptionType) {
        super(messageExceptionType.getCode());
    }
}