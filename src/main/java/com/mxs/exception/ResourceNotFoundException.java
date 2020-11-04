package com.mxs.exception;

import com.mxs.factory.type.MessageExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(final MessageExceptionType messageExceptionType) {
        super(messageExceptionType.getCode());
    }
}
