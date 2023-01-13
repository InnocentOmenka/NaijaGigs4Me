package com.naijagis4me.v1.controller;

import com.naijagis4me.v1.dtos.RequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/client")
public class ClientController {
    public ResponseEntity<RequestDto> requestService(@PathVariable Long clientId){
        return  null;
    }

}
//api/v1/user/client/request-service