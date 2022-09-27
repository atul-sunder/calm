package com.sunder.calm001.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomerCreationResp {

    private String name;
    private String message;
    private int code;
}
