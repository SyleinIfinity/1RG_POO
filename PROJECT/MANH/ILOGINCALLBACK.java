package com.example;
// package com.example;

public interface ILOGINCALLBACK {
    void onLoginSuccess(String role,String stk, boolean stt);
    void onLoginFailure(String message);
}