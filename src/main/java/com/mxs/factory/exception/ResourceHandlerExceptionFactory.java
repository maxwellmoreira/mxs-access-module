package com.mxs.factory.exception;

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
    public ResponseEntity<ResourceExceptionFactory> handlerNotFoundException(
            final ResourceNotFoundException resourceNotFoundException) {
        ResourceExceptionFactory resourceExceptionFactory =
                new ResourceExceptionFactory
                        .Builder()
                        .codeExceptionType(CodeExceptionType.NOT_FOUND.getCode())
                        .messageExceptionType(MessageExceptionType.of(resourceNotFoundException.getMessage()).getCode())
                        .categoryExceptionType(CategoryExceptionType.BUSINESS.getCode())
                        .build();
        return new ResponseEntity<ResourceExceptionFactory>(resourceExceptionFactory, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceExistsException.class)
    public ResponseEntity<ResourceExceptionFactory> handlerExistsException(
            final ResourceExistsException resourceExistsException) {
        ResourceExceptionFactory resourceExceptionFactory =
                new ResourceExceptionFactory
                        .Builder()
                        .codeExceptionType(CodeExceptionType.EXISTS.getCode())
                        .messageExceptionType(MessageExceptionType.of(resourceExistsException.getMessage()).getCode())
                        .categoryExceptionType(CategoryExceptionType.BUSINESS.getCode())
                        .build();
        return new ResponseEntity<ResourceExceptionFactory>(resourceExceptionFactory, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResourceExceptionFactory> handlerIllegalArgumentException(
            final IllegalArgumentException illegalArgumentException) {
        ResourceExceptionFactory resourceExceptionFactory =
                new ResourceExceptionFactory
                        .Builder()
                        .codeExceptionType(CodeExceptionType.ILLEGAL_ARGUMENT.getCode())
                        .messageExceptionType(MessageExceptionType.ILLEGAL_ARGUMENT.getCode())
                        .categoryExceptionType(CategoryExceptionType.INTERNAL_SERVER_ERROR.getCode())
                        .build();
        return new ResponseEntity<ResourceExceptionFactory>(resourceExceptionFactory, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceEmailException.class)
    public ResponseEntity<ResourceExceptionFactory> handlerResourceUnexpectedError(
            final ResourceEmailException resourceUnexpectedError) {
        ResourceExceptionFactory resourceExceptionFactory =
                new ResourceExceptionFactory
                        .Builder()
                        .codeExceptionType(CodeExceptionType.ERROR_SENDING_EMAIL.getCode())
                        .messageExceptionType(MessageExceptionType.ERROR_SENDING_EMAIL.getCode())
                        .categoryExceptionType(CategoryExceptionType.INTERNAL_SERVER_ERROR.getCode())
                        .build();
        return new ResponseEntity<ResourceExceptionFactory>(resourceExceptionFactory, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}