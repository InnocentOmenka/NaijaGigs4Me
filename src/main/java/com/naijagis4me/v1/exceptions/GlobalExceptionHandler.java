package com.naijagis4me.v1.exceptions;

import com.naijagis4me.v1.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;


@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = CustomerNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public @ResponseBody ErrorResponse handleException(CustomerNotFoundException ex) {
//        return ErrorResponse.builder()
//                .timestamp(new Timestamp(System.currentTimeMillis()))
//                .statusCode(HttpStatus.NOT_FOUND.value())
//                .errorMessage(ex.getMessage()).build();
//    }
//
//    @ExceptionHandler(value = SessionIdNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public @ResponseBody ErrorResponse handleException(SessionIdNotFoundException ex) {
//        return ErrorResponse.builder()
//                .timestamp(new Timestamp(System.currentTimeMillis()))
//                .statusCode(HttpStatus.NOT_FOUND.value())
//                .errorMessage(ex.getMessage()).build();
//    }


    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<Object> handleInvalidEmailException(InvalidEmailException ex){
        ExceptionErrorManager errorManager = ExceptionErrorManager.builder()
                .message(ex.getMessage())
                .DebugMsg("Email entered is not a valid email address")
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(errorManager, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<?> customValidationExceptionHandler(MethodArgumentNotValidException ex){
        ExceptionErrorManager errorMessage = new ExceptionErrorManager(
                "Validation Failed",
                Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage(),
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFound(UserNotFoundException ne) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(ne.getMessage());
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
