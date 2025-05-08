package com.example.chatTogether.exceptions;

public class ApiCode {
    private ApiCode(){}
    public static final String SUCCESS = "200";
    public static final String CREATED = "201";
    public static final String BAD_REQUEST = "400";
    public static final String UNAUTHORIZED = "401";
    public static final String FORBIDDEN = "403";
    public static final String NOT_FOUND = "404";
    public static final String CONFLICT = "409";
    public static final String SERVER_ERROR = "500";

    public static final String USER_ALREADY_EXISTS = "4091";
    public static final String INVALID_CREDENTIALS = "4011";
    public static final String VALIDATION_FAILED = "4001";
}
