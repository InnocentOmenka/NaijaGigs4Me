package com.naijagis4me.v1.exceptions;


import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionErrorManager {

    private String DebugMsg;
    private String message;
    private HttpStatus status;
}
