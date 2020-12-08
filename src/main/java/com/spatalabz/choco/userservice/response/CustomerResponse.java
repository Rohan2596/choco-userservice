package com.spatalabz.choco.userservice.response;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class CustomerResponse {

    String message;
    Object data;

    public CustomerResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
