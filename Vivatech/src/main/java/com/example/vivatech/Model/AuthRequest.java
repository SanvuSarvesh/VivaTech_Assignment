package com.example.vivatech.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthRequest implements Serializable {

    private String otp;
    private String phoneNo;

}
