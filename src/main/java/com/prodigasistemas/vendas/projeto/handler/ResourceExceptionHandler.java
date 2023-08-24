package com.prodigasistemas.vendas.projeto.handler;

import com.prodigasistemas.vendas.projeto.exceptions.ResourceNotFoundException;
import com.prodigasistemas.vendas.projeto.exceptions.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

import java.io.IOException;
import java.time.Instant;

import static com.prodigasistemas.vendas.projeto.utils.Constants.*;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<StandardError> multipartException(MultipartException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = StandardError.builder()
                .error(FILE_NOT_EXISTS)
                .timeStamp(Instant.now())
                .status(status.value())
                .path(request.getRequestURI())
                .message(VALUE_FILE_TXT).build();

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<StandardError> FileNotFoundOrNullOrEmpty(IOException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = StandardError.builder()
                .error(exception.getMessage())
                .timeStamp(Instant.now())
                .status(status.value())
                .path(request.getRequestURI())
                .message(VERIFY_THE_FILE).build();

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<StandardError> arrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = StandardError.builder()
                .error(exception.getMessage())
                .timeStamp(Instant.now())
                .status(status.value())
                .path(request.getRequestURI())
                .message(FILE_ROW_COLUMN).build();

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<StandardError> indexOutOfBoundsException(IndexOutOfBoundsException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = StandardError.builder()
                .error(FILE_NOT_VALID)
                .timeStamp(Instant.now())
                .status(status.value())
                .path(request.getRequestURI())
                .message(VERIFY_THE_FILE).build();

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = StandardError.builder()
                .error(RESOURCE_NOT_FOUND)
                .timeStamp(Instant.now())
                .status(status.value())
                .path(request.getRequestURI())
                .message(exception.getMessage()).build();

        return ResponseEntity.status(status).body(standardError);
    }


}

