package com.spatalabz.choco.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordDto {

    @NotNull(message = "Password Length must between 6 to 10 characters!")
    @Pattern(message = "Please Enter Valid  Password!",
            regexp = "^[a-zA-Z0-9]{6,10}$")
    public String password;

    @NotNull(message = "Password Length must between 6 to 10 characters!")
    @Pattern(message = "Please Enter Valid  Password!",
            regexp = "^[a-zA-Z0-9]{6,10}$")
    public String confirm_password;

}
