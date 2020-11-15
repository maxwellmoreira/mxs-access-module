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
        ResourceExceptionFactory resourceException =
                new ResourceExceptionFactory
                        .Builder()
                        .codeExceptionType(CodeExceptionType.NOT_FOUND.getCode())
                        .messageExceptionType(MessageExceptionType.of(resourceNotFoundException.getMessage()).getCode())
                        .categoryExceptionType(CategoryExceptionType.BUSINESS.getCode())
                        .build();
        return new ResponseEntity<ResourceExceptionFactory>(resourceException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceExistsException.class)
    public ResponseEntity<ResourceExceptionFactory> handlerExistsException(
            final ResourceExistsException resourceExistsException) {
        ResourceExceptionFactory resourceException =
                new ResourceExceptionFactory
                        .Builder()
                        .codeExceptionType(CodeExceptionType.EXISTS.getCode())
                        .messageExceptionType(MessageExceptionType.of(resourceExistsException.getMessage()).getCode())
                        .categoryExceptionType(CategoryExceptionType.BUSINESS.getCode())
                        .build();
        return new ResponseEntity<ResourceExceptionFactory>(resourceException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResourceExceptionFactory> handlerIllegalArgumentException(
            final IllegalArgumentException illegalArgumentException) {
        ResourceExceptionFactory resourceException =
                new ResourceExceptionFactory
                        .Builder()
                        .codeExceptionType(CodeExceptionType.ILLEGAL_ARGUMENT.getCode())
                        .messageExceptionType(MessageExceptionType.ILLEGAL_ARGUMENT.getCode())
                        .categoryExceptionType(CategoryExceptionType.ILLEGAL.getCode())
                        .build();
        return new ResponseEntity<ResourceExceptionFactory>(resourceException, HttpStatus.BAD_REQUEST);
    }
}