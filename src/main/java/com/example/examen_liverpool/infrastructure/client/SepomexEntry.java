package com.example.examen_liverpool.infrastructure.client;

import lombok.Data;

@Data
public class SepomexEntry {
    private boolean error;
    private int code_error;
    private String error_message;
    private SepomexResponse response;
}