package com.scf.bankomat.service;

public class ClientNotFoundException extends Throwable {
    public ClientNotFoundException(String message) {
        super(message);
    }
}
