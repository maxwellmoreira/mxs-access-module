package com.mxs.factory.exception;

import com.mxs.exception.ResourceExistsException;
import com.mxs.exception.ResourceNotFoundException;
import com.mxs.factory.type.CategoryExceptionType;
import com.mxs.factory.type.CodeExceptionType;
import com.mxs.factory.type.MessageExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public final class ResourceHandlerExceptionFactory {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerNotFoundException(final MessageExceptionType messageExceptionType) {
        ResourceExceptionFactory resourceException =
                new ResourceExceptionFactory
                        .Builder()
                        .codeExceptionType(CodeExceptionType.NOT_FOUND)
                        .messageExceptionType(messageExceptionType)
                        .categoryExceptionType(CategoryExceptionType.BUSINESS)
                        .build();
        return new ResponseEntity<>(resourceException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceExistsException.class)
    public ResponseEntity<?> handlerExistsException(final MessageExceptionType messageExceptionType) {
        ResourceExceptionFactory resourceException =
                new ResourceExceptionFactory
                        .Builder()
                        .codeExceptionType(CodeExceptionType.EXISTS)
                        .messageExceptionType(messageExceptionType)
                        .categoryExceptionType(CategoryExceptionType.BUSINESS)
                        .build();
        return new ResponseEntity<>(resourceException, HttpStatus.BAD_REQUEST);
    }
}