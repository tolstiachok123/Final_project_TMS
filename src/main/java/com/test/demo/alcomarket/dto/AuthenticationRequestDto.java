package com.test.demo.alcomarket.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {

  private String password;
  private String username;

}
